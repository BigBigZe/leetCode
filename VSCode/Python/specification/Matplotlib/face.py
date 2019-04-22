import matplotlib.pyplot as plt
plt.style.use('classic')
# %matplotlib inline
import numpy as np
import pandas as pd
import seaborn as sns
sns.set()
rng = np.random.RandomState(0)
x = np.linspace(0, 10, 500)
y = np.cumsum(rng.randn(500, 6), 0)
plt.figure()
plt.subplot(122)
plt.plot(x, y)
plt.subplot(121)
plt.plot(x,x)
plt.legend('ABCDEF', ncol=2, loc='upper left')
plt.show()