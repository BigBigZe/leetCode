import seaborn as sns 
import pandas as pd 
import numpy as np 

births = pd.read_csv('Python/panda/data/births.csv')
print(births.pivot_table('births', index='year', columns='gender', aggfunc='sum'))
import matplotlib.pyplot as plt
sns.set() # 使用Seaborn风格
births.pivot_table('births', index='year', columns='gender', aggfunc='sum').plot()
plt.ylabel('total births per year')
plt.show()