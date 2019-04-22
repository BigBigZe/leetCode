import matplotlib.pyplot as plt
plt.style.use('seaborn-whitegrid')
import numpy as np
fig = plt.figure()#figure可以被看成是一个能够容纳各种坐标轴、图形、文字和标签的容器
ax = plt.axes()#axes是一个带有刻度和标签的矩形

x = np.linspace(0, 10, 1000)

# plt.plot(x, np.sin(x - 0), color='blue') # 标准颜色名称
# plt.plot(x, np.sin(x - 1), color='g') # 缩写颜色代码（rgbcmyk）
# plt.plot(x, np.sin(x - 2), color='0.75') # 范围在0~1的灰度值
# plt.plot(x, np.sin(x - 3), color='#FFDD44') # 十六进制（RRGGBB， 00~FF）
# plt.plot(x, np.sin(x - 4), color=(1.0,0.2,0.3)) # RGB元组，范围在0~1
# plt.plot(x, np.sin(x - 5), color='chartreuse'); # HTML颜色名称
# plt.plot(x, x + 4, linestyle='-') # 实线
# plt.plot(x, x + 5, linestyle='--') # 虚线
# plt.plot(x, x + 6, linestyle='-.') # 点划线
# plt.plot(x, x + 7, linestyle=':'); # 实点线
# plt.plot(x, x + 0, '-g') # 绿色实线
# plt.plot(x, x + 1, '--c') # 青色虚线200 ｜ 第 4 章
# plt.plot(x, x + 2, '-.k') # 黑色点划线
# plt.plot(x, x + 3, ':r'); # 红色实点线
# plt.xlim(-1, 11)#坐标上下限
# plt.ylim(-1.5, 1.5);
plt.title("A Sine Curve")#标题
plt.xlabel("x")#x轴下标
plt.ylabel("sin(x)");#y轴下标
plt.plot(x, np.sin(x), '-g', label='sin(x)')
plt.plot(x, np.cos(x), ':b', label='cos(x)')
# plt.legend();在轴上放置图例
plt.show()