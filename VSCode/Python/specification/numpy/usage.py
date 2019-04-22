import numpy as np
import matplotlib.pyplot as plt
import seaborn; seaborn.set()
X = np.random.rand(10,2)
dist_sq = np.sum((X[:,np.newaxis,:] - X[np.newaxis,:,:]) ** 2, axis=-1)
plt.scatter(X[:, 0], X[:, 1], s=100);
print(dist_sq.diagonal())
plt.show()