import numpy as np
import matplotlib.pyplot as plt
import seaborn; seaborn.set()
X = np.random.rand(3,2)
print(X[:, np.newaxis, :],X[:, np.newaxis, :].shape)
print(X[np.newaxis, :, :],X[np.newaxis, :, :].shape)
print(X[:, :, np.newaxis],X[:, :, np.newaxis].shape)
#第i个括号里element的个数为第i维的size
# differences = X[:, np.newaxis, :] - X[np.newaxis, :, :]
# print(differences,differences.shape)
# plt.scatter(X[:, 0], X[:, 1], s=100);
# plt.show()

