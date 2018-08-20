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
class Point:
    def __init__(self, x, y, r):
        self.x = x
        self.y = y
        self.range = r
    
    def __str__(self):
        return "(%d, %d) --> %d" % (x, y, self.range)

#-- Functions
def dist(a, b):
    return (a.x-b.x)**2+(a.y-b.y)**2

#-- Var
n = eval(fin.readline())
data = []
for _ in range(4):
    x, y, r = map(int, fin.readline().split())
    data.append(Point(x, y, r))
    print(data[_])
for i in range(len(data)):
    for j in range(len(data)):
        if i==j:
            continue
        print("[%s] -> [%s], Dist %.1f, Can %sreach" % (data[i], data[j], dist(data[i], data[j]), "" if dist(data[i], data[j]) <= data[i].range+data[j].range else "not "))
#-- Run
#-- Exit
