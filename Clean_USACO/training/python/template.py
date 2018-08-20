"""
ID: agentmz1
LANG: PYTHON3
TASK: test
NOTES:
"""
#-- IO
__taskname__ = 'test'
fin = open(__taskname__ + '.in', 'r')
fout = open(__taskname__ + '.out', 'w')

#-- Types
#-- Functions
#-- Var
x,y = map(int, fin.readline().split())
#-- Run
sum = x+y
#-- Exit
fout.write(str(sum) + '\n')
fout.close()