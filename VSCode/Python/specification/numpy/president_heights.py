import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn;seaborn.set()
rainfall = pd.read_csv('Python/numpy/data/Seattle2014.csv')['PRCP'].values
inches = rainfall/254

print(np.sum((inches>0.5)&(inches<1),axis=0))


a=1
b=0
print((a<1)&(b<1))
 