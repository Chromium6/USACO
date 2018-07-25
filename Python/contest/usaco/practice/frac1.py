"""
ID: agentmz1
LANG: PYTHON3
TASK: frac1
"""
# imports
# functions
def readInt(source): # in Python, int has no size limit so int == long
    return map(int, source.readline().split())
def readString(source):
    return source.readline().split()

class Fraction:
    def __init__(self, n, d):
        self.numerator = n
        self.denominator = d
        self.val = n/d

    def __eq__(self, other):
        return self.val == other.val

# var dec/init
test_name = 'frac1'
prog_dir = 'C:\\Users\\Michael Zhang\\Desktop\\00\\18\\Docs\\USACO\\Python\\contest\\usaco\\practice\\'
stdin = open(test_name+'.in', 'r') # BufferedReader
stdout = open(test_name+'.out', 'w') # PrintWriter
n = eval(readString(stdin)[0])
data = [Fraction(0, 1), Fraction(1, 1)]
for a in range(1, n+1):
    for b in range(1, n+1):
        k = Fraction(a, b)
        if b == 1 or data.__contains__(k) or k.val > 1:
            continue
        data.append(k)
data.sort(key=lambda x: x.val, reverse = False)
for x in data:
    stdout.write("%d/%d\n" % (x.numerator, x.denominator))
    # print("%d/%d=%.3f" % (x.numerator, x.denominator, x.val))
# run
# exit
stdin.close()
stdout.close()
