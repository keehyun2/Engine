"""
OIS 일관성 검증 예제 - 이자율 곡선 시각화
curves.csv 데이터를 시각화합니다.
"""

import pandas as pd
import matplotlib.pyplot as plt
import matplotlib.font_manager as fm
from pathlib import Path

# 한글 폰트 설정 (윈도우/Mac/Linux 자동 감지)
def setup_korean_font():
    """한글 폰트 자동 설정"""
    system_fonts = [
        ('Malgun Gothic', 'C:/Windows/Fonts/malgun.ttf'),  # 윈도우
        ('AppleGothic', '/System/Library/Fonts/AppleGothic.ttf'),  # Mac
        ('NanumGothic', '/usr/share/fonts/truetype/nanum/NanumGothic.ttf'),  # Linux
    ]

    for name, path in system_fonts:
        try:
            if Path(path).exists():
                plt.rcParams['font.family'] = name
                plt.rcParams['axes.unicode_minus'] = False
                print(f"폰트 설정됨: {name}")
                return
        except:
            continue

    # 폰트를 찾지 못하면 기본값 사용
    plt.rcParams['axes.unicode_minus'] = False

# CSV 파일 읽기
csv_path = Path(__file__).parent / 'curves.csv'

# 헤더(주석 줄)와 데이터 분리
with open(csv_path, 'r', encoding='utf-8') as f:
    lines = f.readlines()

# 첫 줄에서 헤더 추출 (# 제거)
header = lines[0].replace('#', '').strip()

# 나머지 줄 중 주석이 아닌 줄만 추리기
data_lines = [line for line in lines[1:] if not line.strip().startswith('#')]

# 헤더와 데이터 결합
csv_content = header + '\n' + ''.join(data_lines)

# StringIO를 사용하여 파싱
from io import StringIO
df = pd.read_csv(StringIO(csv_content))

# 날짜 변환
df['Date'] = pd.to_datetime(df['Date'])

# 기간(Tenor) 수치 변환 (단순화를 위해 인덱스 사용)
df['Period'] = range(len(df))

# 한글 폰트 설정
setup_korean_font()

# 주요 OIS 곡선 선택
ois_curves = {
    'EUR-EONIA': 'EUR-EONIA',
    'USD-FedFunds': 'USD-FedFunds',
    'GBP-SONIA': 'GBP-SONIA',
    'JPY-TONAR': 'JPY-TONAR',
}

# ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
# 그래프 1: 할인율 곡선 (Discount Factor)
# ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

fig, axes = plt.subplots(2, 2, figsize=(14, 10))
fig.suptitle('OIS 곡선 일관성 검증 - 할인율 비교', fontsize=16, fontweight='bold')

# 서브플롯 1: 주요 통화 OIS 비교
ax = axes[0, 0]
for label, col in ois_curves.items():
    if col in df.columns:
        ax.plot(df['Period'], df[col], label=label, linewidth=2)

ax.set_title('주요 통화 OIS 할인율 곡선', fontsize=12, fontweight='bold')
ax.set_xlabel('기간 (Tenor)')
ax.set_ylabel('할인율 (Discount Factor)')
ax.legend(loc='best')
ax.grid(True, alpha=0.3)
ax.invert_yaxis()  # 할인율은 시간이 지날수록 감소

# 서브플롯 2: EUR 관련 곡선
ax = axes[0, 1]
eur_curves = ['EUR-EONIA', 'EUR-EURIBOR-3M', 'EUR-EURIBOR-6M']
for col in eur_curves:
    if col in df.columns:
        ax.plot(df['Period'][:60], df[col][:60], label=col, linewidth=2)

ax.set_title('EUR 관련 곡선 (단기 60개월)', fontsize=12, fontweight='bold')
ax.set_xlabel('기간 (Tenor)')
ax.set_ylabel('할인율')
ax.legend(loc='best')
ax.grid(True, alpha=0.3)
ax.invert_yaxis()

# 서브플롯 3: LIBOR 곡선 비교
ax = axes[1, 0]
libor_curves = ['USD-LIBOR-3M', 'GBP-LIBOR-3M', 'CHF-LIBOR-3M']
for col in libor_curves:
    if col in df.columns:
        ax.plot(df['Period'][:60], df[col][:60], label=col, linewidth=2)

ax.set_title('LIBOR 3M 곡선 비교 (단기 60개월)', fontsize=12, fontweight='bold')
ax.set_xlabel('기간 (Tenor)')
ax.set_ylabel('할인율')
ax.legend(loc='best')
ax.grid(True, alpha=0.3)
ax.invert_yaxis()

# 서브플롯 4: 통화별 기본 곡선
ax = axes[1, 1]
base_curves = ['CHF', 'EUR', 'GBP', 'USD']
colors = ['red', 'blue', 'green', 'orange']
for col, color in zip(base_curves, colors):
    if col in df.columns:
        ax.plot(df['Period'][:120], df[col][:120], label=col, color=color, linewidth=2)

ax.set_title('통화별 기본 곡선 (120개월)', fontsize=12, fontweight='bold')
ax.set_xlabel('기간 (Tenor)')
ax.set_ylabel('할인율')
ax.legend(loc='best')
ax.grid(True, alpha=0.3)
ax.invert_yaxis()

plt.tight_layout()
output_path = Path(__file__).parent / 'curves_visualization.png'
plt.savefig(output_path, dpi=150, bbox_inches='tight')
print(f"\n그래프 저장됨: {output_path}")
plt.close()

# ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
# 그래프 2: 이자율 (Zero Rate) 변환
# ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

def discount_to_zero_rate(df, t_years):
    """할인율을 zero rate로 변환 (연속 복리)"""
    return -np.log(df) / t_years

import numpy as np

# 시간(년) 계산 (대략적으로 월 단위)
df['Years'] = df['Period'] / 12

fig, ax = plt.subplots(figsize=(12, 7))

# 주요 OIS 곡선의 zero rate 계산
for label, col in ois_curves.items():
    if col in df.columns:
        zero_rates = []
        for i, row in df.iterrows():
            if row['Years'] > 0 and row[col] > 0:
                zr = -np.log(row[col]) / row['Years']
                zero_rates.append(zr * 100)  # %로 변환
            else:
                zero_rates.append(0)
        df[f'{col}_ZeroRate'] = zero_rates
        ax.plot(df['Period'][:120], df[f'{col}_ZeroRate'][:120],
                label=label, linewidth=2, marker='o', markersize=3)

ax.set_title('OIS 곡선 Zero Rate 비교 (연이율 %)', fontsize=14, fontweight='bold')
ax.set_xlabel('기간 (월)')
ax.set_ylabel('Zero Rate (%)')
ax.legend(loc='best')
ax.grid(True, alpha=0.3)

# Y축 범위 설정 (금리가 낮은 구간 확대)
ax.set_ylim(-1, 3)

plt.tight_layout()
output_path2 = Path(__file__).parent / 'curves_zero_rate.png'
plt.savefig(output_path2, dpi=150, bbox_inches='tight')
print(f"Zero Rate 그래프 저장됨: {output_path2}")
plt.close()

# ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
# 그래프 3: 통화 간 스프레드
# ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

fig, ax = plt.subplots(figsize=(12, 7))

# EUR-USD 스프레드 (zero rate 기반)
if 'EUR-EONIA_ZeroRate' in df.columns and 'USD-FedFunds_ZeroRate' in df.columns:
    spread_eur_usd = df['EUR-EONIA_ZeroRate'] - df['USD-FedFunds_ZeroRate']
    ax.plot(df['Period'][:120], spread_eur_usd[:120],
            label='EUR - USD 스프레드', color='purple', linewidth=2, marker='s', markersize=4)

# GBP-USD 스프레드
if 'GBP-SONIA_ZeroRate' in df.columns and 'USD-FedFunds_ZeroRate' in df.columns:
    spread_gbp_usd = df['GBP-SONIA_ZeroRate'] - df['USD-FedFunds_ZeroRate']
    ax.plot(df['Period'][:120], spread_gbp_usd[:120],
            label='GBP - USD 스프레드', color='green', linewidth=2, marker='^', markersize=4)

ax.axhline(y=0, color='red', linestyle='--', alpha=0.5, label='기준선 (0)')
ax.set_title('통화 간 금리 스프레드 (Zero Rate 기반)', fontsize=14, fontweight='bold')
ax.set_xlabel('기간 (월)')
ax.set_ylabel('스프레드 (% bp)')
ax.legend(loc='best')
ax.grid(True, alpha=0.3)

plt.tight_layout()
output_path3 = Path(__file__).parent / 'curves_spread.png'
plt.savefig(output_path3, dpi=150, bbox_inches='tight')
print(f"스프레드 그래프 저장됨: {output_path3}")
plt.close()

print("\n시각화 완료!")
print(f"   - curves_visualization.png: 할인율 곡선 비교")
print(f"   - curves_zero_rate.png: Zero Rate 비교")
print(f"   - curves_spread.png: 통화 간 스프레드")
