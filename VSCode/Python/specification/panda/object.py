import pandas as pd 
import numpy as np 
#Series对象
# data = pd.Series([0.25,0.5,0.75],[2,6,8])
# print(data.values)
# print(data.index)
# print(data.items)
# print(data.keys())
population_dict = {'California': 38332521,
'Texas': 26448193,
'New York': 19651127,
'Florida': 19552860,
'Illinois': 12882135}
population = pd.Series(population_dict)
area_dict = {'California': 423967, 'Texas': 695662, 'New York': 141297,
'Florida': 170312, 'Illinois': 149995}
area = pd.Series(area_dict)
states = pd.DataFrame({'population': population,
'area': area})
print(states.values[0])#获取一行用.values

#如果对单个标签取值就选择列，而对多个标签用切片就选择行
print(states['area'])#取的是列
print(states[0:3])#取的是行，最后不取

print(states['area']['California'])#先列再行的顺序进行查看（具体某个值）
