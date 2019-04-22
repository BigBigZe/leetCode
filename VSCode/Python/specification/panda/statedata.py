import pandas as pd 
import numpy as np 
pop = pd.read_csv('Python/panda/data/state-population.csv')
areas = pd.read_csv('Python/panda/data/state-areas.csv')
abbrevs = pd.read_csv('Python/panda/data/state-abbrevs.csv')
merged = pd.merge(pop,abbrevs,how='outer',left_on='state/region',right_on='abbreviation')
'''
pd.merge(left, right, how='inner', on=None, left_on=None, right_on=None, left_index=False, 
right_index=False, sort=False, suffixes=('_x', '_y'), copy=True, indicator=False, validate=None)
left和right表示两个dataframe;how决定了连接方式，包括inner、outer已经left、right和数据库连接一样；
on表示连接的列名，若不存在列名相同的列则采用left_on和right_on进行连接；

'''
merged = merged.drop('abbreviation',1)#删除重复的列
merged.loc[merged['state/region'] == 'PR', 'state'] = 'Puerto Rico'
merged.loc[merged['state/region'] == 'USA', 'state'] = 'United States'
final = pd.merge(merged, areas, on='state', how='left')
final.dropna(inplace=True)
# print(final)
data2010 = final.query("year == 2010 & ages == 'total'")
data2010.set_index('state', inplace=True)
density = data2010['population'] / data2010['area (sq. mi)']
density.sort_values(ascending=False, inplace=True)
print(density)
print(final['state'][final['area (sq. mi)'].isnull()].unique())
'''
final['state'][final['area (sq. mi)'].isnull()].unique()
第二个坐标中用的是花哨表示，然后unique是去掉重复
'''
#print(final.isnull().any())#检查数据是否有缺失
# print(final.head())