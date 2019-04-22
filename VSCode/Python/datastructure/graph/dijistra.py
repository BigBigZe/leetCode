finite = 1000
matrix = [[0,1,12,finite,finite,finite],
          [1,0,9,3,finite,finite],
          [12,9,0,4,5,finite],
          [finite,3,4,0,13,15],
          [finite,finite,5,13,0,4],
          [finite,finite,finite,15,4,0]]

state = [0,1,12,finite,finite,finite];
flag = [1,0,0,0,0,0]

for i in range(len(matrix)):
    if flag[i]!=1:
        minp = finite
        index = 0
        for j in range(len(state)):
            if flag[j]!=1 and minp>state[j]:
                index = j
                minp = state[j]
        
        flag[index] = 1

        for j in range(len(state)):
            if flag[j]!=1 and (matrix[index][j]+state[index])<state[j]:
                state[j] = matrix[index][j]+state[index]
                

print(state)
