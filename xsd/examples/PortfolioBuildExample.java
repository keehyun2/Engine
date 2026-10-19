import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.ibk.gcb.batch.trs.mvmn.ore.BondData;
import com.ibk.gcb.batch.trs.mvmn.ore.Envelope;
import com.ibk.gcb.batch.trs.mvmn.ore.FixedLegData;
import com.ibk.gcb.batch.trs.mvmn.ore.LegData;
import com.ibk.gcb.batch.trs.mvmn.ore.LegType;
import com.ibk.gcb.batch.trs.mvmn.ore.ObjectFactory;
import com.ibk.gcb.batch.trs.mvmn.ore.OreTradeType;
import com.ibk.gcb.batch.trs.mvmn.ore.Portfolio;
import com.ibk.gcb.batch.trs.mvmn.ore.ScheduleData;
import com.ibk.gcb.batch.trs.mvmn.ore.Trade;

/**
 * xsd/generated/ 의 JAXB 클래스로
 * Examples/Bond-VND-government-zero-rt/input/portfolio.xml 과 같은 내용의
 * 포트폴리오 XML을 생성하는 예제.
 *
 * 컴파일/실행 (Git Bash, JDK 8):
 *   cd /c/Users/ibk/dev/Engine/xsd
 *   mkdir -p _build
 *   find generated -name "*.java" > _build/gen_sources.txt
 *   "/c/Program Files/jdk/bin/javac.exe" -encoding UTF-8 -d _build @_build/gen_sources.txt
 *   "/c/Program Files/jdk/bin/javac.exe" -encoding UTF-8 -cp _build -d _build examples/PortfolioBuildExample.java
 *   "/c/Program Files/jdk/bin/java.exe"  -cp _build PortfolioBuildExample _build/portfolio.xml
 *
 * 참고:
 * - JAXB는 XML 주석을 만들지 않으므로 원본 파일 머리글의 한글 주석은 생성 결과에 없다.
 *   (필요하면 마샬 결과에 후처리로 주석을 삽입해야 한다)
 * - 스키마에서 Notional/Rate가 xs:float라 650000000000은 "6.5000001E11"로,
 *   0.0530은 "0.053"으로 출력된다. xs:float 정밀도(약 7자리)의 반올림이며
 *   원본 XML을 언마샬해도 같은 float 값이 나온다.
 * - CreditCurveId 처럼 빈 문자열 요소는 <CreditCurveId/> 형태로 출력된다.
 */
public class PortfolioBuildExample {

    public static void main(String[] args) throws Exception {
        ObjectFactory of = new ObjectFactory();

        Portfolio portfolio = of.createPortfolio();
        portfolio.getTrade().add(vnGovtBond5y());

        JAXBContext ctx = JAXBContext.newInstance("com.ibk.gcb.batch.trs.mvmn.ore");

        File out = new File(args.length > 0 ? args[0] : "portfolio.xml");
        Marshaller m = ctx.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        m.marshal(of.createPortfolio(portfolio), out);
        System.out.println("written: " + out.getAbsolutePath());

        // 언마샬 왕복 검증: 생성한 파일을 다시 읽어 핵심 필드 확인
        Unmarshaller u = ctx.createUnmarshaller();
        JAXBElement<Portfolio> je = (JAXBElement<Portfolio>) u.unmarshal(out);
        Trade t = je.getValue().getTrade().get(0);
        System.out.println("round-trip: id=" + t.getId()
                + ", type=" + t.getTradeType()
                + ", notional=" + t.getBondData().getLegData().get(0).getNotionals()
                        .getNotionalOrFXResetOrExchanges().size() + " notional(s)"
                + ", rate=" + ((FixedLegData) ((JAXBElement<?>) t.getBondData().getLegData().get(0)
                        .getLegDataType()).getValue()).getRates().getRate().get(0).getValue());
    }

    /** <Trade id="VN-GOVT-BOND-5Y"> — 베트남 5Y 국채 1건을 통째로 구성한다. */
    private static Trade vnGovtBond5y() {

        // <ScheduleData><Rules> ... </Rules></ScheduleData>
        ScheduleData.Rules rules = new ScheduleData.Rules();
        rules.setStartDate("2019-01-03");
        rules.setEndDate("2034-01-03");
        rules.setTenor("1Y");
        rules.setCalendar("VND");
        rules.setConvention("MF");
        rules.setTermConvention("MF");
        rules.setRule("Forward");
        rules.setEndOfMonth("false");

        ScheduleData schedule = new ScheduleData();
        // ScheduleData는 Rules/Dates/Derived 중 하나를 JAXBElement로 담는 choice 구조
        schedule.getRulesOrDatesOrDerivedScheduleGroup().add(
                new ObjectFactory().createScheduleDataRules(rules));

        // <FixedLegData><Rates><Rate>0.0530</Rate></Rates></FixedLegData>
        FixedLegData.Rates.Rate rate = new FixedLegData.Rates.Rate();
        rate.setValue(0.0530f);

        FixedLegData.Rates rates = new FixedLegData.Rates();
        rates.getRate().add(rate);

        FixedLegData fixedLeg = new FixedLegData();
        fixedLeg.setRates(rates);

        // <Notionals><Notional>650000000000</Notional></Notionals>
        LegData.Notionals.Notional notional = new LegData.Notionals.Notional();
        notional.setValue(650000000000f);

        LegData.Notionals notionals = new LegData.Notionals();
        notionals.getNotionalOrFXResetOrExchanges().add(notional);

        // <LegData> ... </LegData>
        LegData leg = new LegData();
        leg.setLegType(LegType.FIXED);
        leg.setPayer(false);
        leg.setCurrency("VND");
        leg.setNotionals(notionals);
        leg.setDayCounter("ACT/365");
        leg.setPaymentConvention("MF");
        // FixedLegData/FloatingLegData 등 LegType 상세는 JAXBElement choice로 설정
        leg.setLegDataType(new ObjectFactory().createFixedLegData(fixedLeg));
        leg.setScheduleData(schedule);

        // <BondData> ... </BondData>
        BondData bond = new BondData();
        bond.setIssuerId("GOVT-VN");
        bond.setCreditCurveId("");
        bond.setSecurityId("VN-GOVT-BOND-5Y");
        bond.setReferenceCurveId("VND-GOVT-BOND");
        bond.setSettlementDays("1");
        bond.setCalendar("VND");
        bond.setIssueDate("2019-01-03");
        bond.getLegData().add(leg);

        // <Envelope> ... </Envelope>
        Envelope envelope = new Envelope();
        envelope.setCounterParty("GOVT-VN");
        envelope.setNettingSetGroup(new ObjectFactory().createNettingSetId("")); // 빈 <NettingSetId/>
        envelope.setAdditionalFields(new Envelope.AdditionalFields());           // 빈 <AdditionalFields/>

        // <Trade id="..." >
        Trade trade = new Trade();
        trade.setId("VN-GOVT-BOND-5Y");
        trade.setTradeType(OreTradeType.BOND);
        trade.setEnvelope(envelope);
        trade.setBondData(bond);
        return trade;
    }
}
