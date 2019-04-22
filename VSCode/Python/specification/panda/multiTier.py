import numpy as np 
import pandas as pd 
index = [('California', 2000), ('California', 2010),
('New York', 2000), ('New York', 2010),
('Texas', 2000), ('Texas', 2010)]
populations = [33871648, 37253956,
18976457, 19378102,
20851820, 25145561]
pop = pd.Series(populations, index=index)
index = pd.MultiIndex.from_tuples(index)#构造多级索引
'''
MultiIndex(levels=[['California', 'New York', 'Texas'], [2000, 2010]],
           labels=[[0, 0, 1, 1, 2, 2], [0, 1, 0, 1, 0, 1]])

           llevels表示等级
'''
pop = pop.reindex(index)
print(pop[:,2010])