There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:

Input: 2, [[1,0]] 
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: 2, [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.


Solution:

就是简单的拓扑排序，以入度为0入队列，每次删去入度为0的节点，如果能够全部删干净，那么就无环，否则有环

这里想到之前的调度机求环的算法，是有问题的，通过不断的判断边两头的节点是否同时已经遍历过来确定有环，实际上这样做是有问题的，比如[0,1],[0,2],[1,2]这三条边很明显是无环的，但是遍历到[1,2]时，1和2很明显都遍历过，这里就会给判定为有环。