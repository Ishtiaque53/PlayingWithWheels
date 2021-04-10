
# PlayingWithWheels
#Problem 10067 of OnineJudge
#Problems: https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8

INPUT:

The first line of the input contains an integer N giving the number of test cases to follow. 
The first line of each test case contains the initial configuration of the wheels specified by 4 digits. 
Two consecutive digits are separated by a space. The next line contains the target configuration. 
The third line contains an integer n giving the number of forbidden configurations. 
Each of the following n lines contains a forbidden configuration. 
There is a blank line between two consecutive input sets.

Sample Input

Number of Problem: 2
Problem 1:
Initial State: 8 0 5 6
Final State: 6 5 0 8
Number of Blocked States: 5
Block State 1:8 0 5 7
Block State 2:8 0 4 7
Block State 3:5 5 0 8
Block State 4:7 5 0 8
Block State 5:6 4 0 8

Problem 2:
Initial State: 0 0 0 0
Final State: 5 3 1 7
Number of Blocked States: 8
Block State 1:0 0 0 1
Block State 2:0 0 0 9
Block State 3:0 0 1 0
Block State 4:0 0 9 0
Block State 5:0 1 0 0
Block State 6:0 9 0 0
Block State 7:1 0 0 0
Block State 8:9 0 0 0


Sample Output

Number of Problem: 2
Problem 1:
Initial State: 8 0 5 6
Final State: 6 5 0 8
Number of Blocked States: 5
Block State 1:8 0 5 7
Block State 2:8 0 4 7
Block State 3:5 5 0 8
Block State 4:7 5 0 8
Block State 5:6 4 0 8

Reached
Solution:
[8,0,5,6]===>>[8,1,5,6]===>>[8,2,5,6]===>>[8,3,5,6]===>>[8,4,5,6]===>>[8,5,5,6]===>>[8,5,5,7]===>>[8,5,5,8]===>>[7,5,5,8]===>>[6,5,5,8]===>>[6,5,4,8]===>>[6,5,3,8]===>>[6,5,2,8]===>>[6,5,1,8]===>>[6,5,0,8]
Shortest distance to solution: 14

Problem 2:
Initial State: 0 0 0 0
Final State: 5 3 1 7
Number of Blocked States: 8
Block State 1:0 0 0 1
Block State 2:0 0 0 9
Block State 3:0 0 1 0
Block State 4:0 0 9 0
Block State 5:0 1 0 0
Block State 6:0 9 0 0
Block State 7:1 0 0 0
Block State 8:9 0 0 0

Unreachable
Solution:

Shortest distance to solution: -1
