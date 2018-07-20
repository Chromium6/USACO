def mergeSort(A):
    if len(A) <= 1:
        return 0, A
    middle = len(A)/2
    left_inversions, left = mergeSort(A[:middle])
    right_inversions, right = mergeSort(A[middle:])
    merge_inversions, merged = merge(left, right)
    inversions = left_inversions + right_inversions + merge_inversions
    return inversions, merged

def merge(left, right):
    result = []
    i, j, inversions = 0, 0, 0
    while i < len(left) and j < len(right):
        if left[i] <= right[j]:
            inversions += j
            result.append(left[i])
            i += 1
        else:
            result.append(right[j])
            j += 1
    inversions += j*(len(left)-i)
    result += left[i:]
    result += right[j:]
    return inversions, result

stdin = open ('sort.in', 'r')
stdout = open ('sort.out', 'w')
n = map(int, stdin.readline().split())[0]
c = []
for i in range(n):
    k = map(int, stdin.readline().split())[0]
    c.append(k)
a, b = mergeSort(c)
stdout.write(str(a) + '\n')
stdout.close()