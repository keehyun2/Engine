"""
XOIS EUR/USD 곡선 시각화 스크립트
통화 간 OIS 곡선을 시각화합니다.
"""

import pandas as pd
import matplotlib.pyplot as plt
import numpy as np
from pathlib import Path
from io import StringIO

# 한글 폰트 설정
def setup_korean_font():
    system_fonts = [
        ('Malgun Gothic', 'C:/Windows/Fonts/malgun.ttf'),
        ('AppleGothic', '/System/Library/Fonts/AppleGothic.ttf'),
        ('NanumGothic', '/usr/share/fonts/truetype/nanum/NanumGothic.ttf'),
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
    plt.rcParams['axes.unicode_minus'] = False

# CSV 파일 읽기
csv_path = Path(__file__).parent / 'curves.csv'
with open(csv_path, 'r', encoding='utf-8') as f:
    lines = f.readlines()
header = lines[0].replace('#', '').strip()
data_lines = [line for line in lines[1:] if not line.strip().startswith('#')]
csv_content = header + '\n' + ''.join(data_lines)
df = pd.read_csv(StringIO(csv_content))
df['Date'] = pd.to_datetime(df['Date'])
df['Period'] = range(len(df))
df['Years'] = df['Period'] / 12

# 한글 폰트 설정
setup_korean_font()

# 예제 타입 감지 (EUR 또는 USD)
example_type = 'XOIS EUR' if any('EUR-EONIA' in c for c in df.columns) else 'XOIS USD'
print(f"감지된 예제 타입: {example_type}")

# ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
# 그래프 1: 통화 간 할인율 비교
# ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

fig, axes = plt.subplots(2, 2, figsize=(14, 10))
fig.suptitle(f'{example_type} - 통화 간 OIS 곡선 비교', fontsize=16, fontweight='bold')

# XOIS EUR용 곡선
if example_type == 'XOIS EUR':
    curves = {
        'EUR-EONIA': 'EUR-EONIA',
        'USD-FedFunds': 'USD-FedFunds',
        'GBP-SONIA': 'GBP-SONIA',
        'CHF-SARON': 'CHF-SARON',
    }
    ax = axes[0, 0]
    for label, col in curves.items():
        if col in df.columns:
            ax.plot(df['Period'][:120], df[col][:120], label=label, linewidth=2)
    ax.set_title('주요 통화 OIS 할인율 비교', fontsize=12, fontweight='bold')
else:  # XOIS USD
    curves = {
        'USD-FedFunds': 'USD-FedFunds',
        'EUR-EONIA': 'EUR-EONIA',
        'GBP-SONIA': 'GBP-SONIA',
        'CHF-SARON': 'CHF-SARON',
    }
    ax = axes[0, 0]
    for label, col in curves.items():
        if col in df.columns:
            ax.plot(df['Period'][:120], df[col][:120], label=label, linewidth=2)
    ax.set_title('USD 기준 OIS 할인율 비교', fontsize=12, fontweight='bold')

ax.set_xlabel('기간 (월)')
ax.set_ylabel('할인율 (Discount Factor)')
ax.legend(loc='best')
ax.grid(True, alpha=0.3)
ax.invert_yaxis()

# 서브플롯 2: 기준 통화 관련 곡선
ax = axes[0, 1]
if example_type == 'XOIS EUR':
    eur_curves = ['EUR-EONIA', 'EUR-EURIBOR-3M', 'EUR-EURIBOR-6M']
    for col in eur_curves:
        if col in df.columns:
            ax.plot(df['Period'][:60], df[col][:60], label=col, linewidth=2)
    ax.set_title('EUR 관련 곡선 (단기)', fontsize=12, fontweight='bold')
else:
    usd_curves = ['USD-FedFunds', 'USD-LIBOR-3M', 'USD-LIBOR-6M']
    for col in usd_curves:
        if col in df.columns:
            ax.plot(df['Period'][:60], df[col][:60], label=col, linewidth=2)
    ax.set_title('USD 관련 곡선 (단기)', fontsize=12, fontweight='bold')

ax.set_xlabel('기간 (월)')
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
ax.set_title('LIBOR 3M 곡선 비교', fontsize=12, fontweight='bold')
ax.set_xlabel('기간 (월)')
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
ax.set_title('통화별 기본 곡선', fontsize=12, fontweight='bold')
ax.set_xlabel('기간 (월)')
ax.set_ylabel('할인율')
ax.legend(loc='best')
ax.grid(True, alpha=0.3)
ax.invert_yaxis()

plt.tight_layout()
output_path = Path(__file__).parent / 'curves_visualization.png'
plt.savefig(output_path, dpi=150, bbox_inches='tight')
print(f"그래프 저장됨: {output_path}")
plt.close()

# ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
# 그래프 2: Zero Rate 비교
# ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

fig, ax = plt.subplots(figsize=(12, 7))

ois_curves = {
    'EUR-EONIA': 'EUR-EONIA',
    'USD-FedFunds': 'USD-FedFunds',
    'GBP-SONIA': 'GBP-SONIA',
    'CHF-SARON': 'CHF-SARON',
}

for label, col in ois_curves.items():
    if col in df.columns:
        zero_rates = []
        for i, row in df.iterrows():
            if row['Years'] > 0 and row[col] > 0:
                zr = -np.log(row[col]) / row['Years']
                zero_rates.append(zr * 100)
            else:
                zero_rates.append(0)
        df[f'{col}_ZeroRate'] = zero_rates
        ax.plot(df['Period'][:120], df[f'{col}_ZeroRate'][:120],
                label=label, linewidth=2, marker='o', markersize=3)

base_currency = 'EUR' if example_type == 'XOIS EUR' else 'USD'
ax.set_title(f'{example_type} - Zero Rate 비교 (연이율 %)', fontsize=14, fontweight='bold')
ax.set_xlabel('기간 (월)')
ax.set_ylabel('Zero Rate (%)')
ax.legend(loc='best')
ax.grid(True, alpha=0.3)
ax.set_ylim(-1, 3)

plt.tight_layout()
output_path2 = Path(__file__).parent / 'curves_zero_rate.png'
plt.savefig(output_path2, dpi=150, bbox_inches='tight')
print(f"Zero Rate 그래프 저장됨: {output_path2}")
plt.close()

# ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
# 그래프 3: 기준 통화 대비 스프레드
# ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

fig, ax = plt.subplots(figsize=(12, 7))

if base_currency == 'EUR':
    base_col = 'EUR-EONIA'
else:
    base_col = 'USD-FedFunds'

if f'{base_col}_ZeroRate' in df.columns:
    # EUR-USD 스프레드
    if 'USD-FedFunds_ZeroRate' in df.columns:
        spread = df['EUR-EONIA_ZeroRate'] - df['USD-FedFunds_ZeroRate']
        ax.plot(df['Period'][:120], spread[:120],
                label='EUR - USD 스프레드', color='purple', linewidth=2, marker='s', markersize=4)
    # GBP-기준 스프레드
    if 'GBP-SONIA_ZeroRate' in df.columns:
        if base_currency == 'EUR':
            spread = df['GBP-SONIA_ZeroRate'] - df['EUR-EONIA_ZeroRate']
            label = 'GBP - EUR 스프레드'
        else:
            spread = df['GBP-SONIA_ZeroRate'] - df['USD-FedFunds_ZeroRate']
            label = 'GBP - USD 스프레드'
        ax.plot(df['Period'][:120], spread[:120],
                label=label, color='green', linewidth=2, marker='^', markersize=4)
    # CHF-기준 스프레드
    if 'CHF-SARON_ZeroRate' in df.columns:
        if base_currency == 'EUR':
            spread = df['CHF-SARON_ZeroRate'] - df['EUR-EONIA_ZeroRate']
            label = 'CHF - EUR 스프레드'
        else:
            spread = df['CHF-SARON_ZeroRate'] - df['USD-FedFunds_ZeroRate']
            label = 'CHF - USD 스프레드'
        ax.plot(df['Period'][:120], spread[:120],
                label=label, color='red', linewidth=2, marker='d', markersize=4)

ax.axhline(y=0, color='black', linestyle='--', alpha=0.5, label='기준선 (0)')
ax.set_title(f'{base_currency} 기준 통화 간 스프레드', fontsize=14, fontweight='bold')
ax.set_xlabel('기간 (월)')
ax.set_ylabel('스프레드 (% bp)')
ax.legend(loc='best')
ax.grid(True, alpha=0.3)

plt.tight_layout()
output_path3 = Path(__file__).parent / 'curves_spread.png'
plt.savefig(output_path3, dpi=150, bbox_inches='tight')
print(f"스프레드 그래프 저장됨: {output_path3}")
plt.close()

print(f"\n{example_type} 시각화 완료!")
print(f"   - curves_visualization.png: 할인율 곡선 비교")
print(f"   - curves_zero_rate.png: Zero Rate 비교")
print(f"   - curves_spread.png: 통화 간 스프레드")
