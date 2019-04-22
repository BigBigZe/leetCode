import matplotlib as mpl 
import matplotlib.pyplot as plt 
import numpy as np 
x  = np.linspace(0, 10, 100)
# 创建两个子图中的第一个，设置坐标轴
plt.subplot(2, 1, 1) # (行、列、子图编号)
plt.plot(x, np.sin(x))
# 创建两个子图中的第二个，设置坐标轴
plt.subplot(2, 1, 2)
plt.plot(x, np.cos(x))
plt.show()
