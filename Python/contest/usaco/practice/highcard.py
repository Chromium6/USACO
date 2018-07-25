"""
ID: agentmz1
LANG: PYTHON3
TASK: test
"""
# system
test_name = 'test'
stdin = open(test_name+'.in', 'r') # BufferedReader
stdout = open(test_name+'.out', 'w') # PrintWriter
# imports
# functions
def readInt(): # in Python, int has no size limit so int == long
    return map(int, stdin.readline().split())
def readString():
    return stdin.readline().split()
# var dec/init
n = readInt()
elsie = range(1, n+1)
print(elsie)
# run
# exit
stdin.close()
stdout.close()
