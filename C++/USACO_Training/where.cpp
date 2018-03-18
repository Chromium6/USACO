/*
ID: agentmz1
PROG: where [is bessie]
LANG: C++
*/

#include <iostream>
#include <fstream>
#include <queue>
#include <assert.h>
#include <algorithm>

using namespace std;
#define LP(name, minVal, maxVal) for(int name = minVal; name < maxVal; name++)

/* var dec */
typedef pair<int, int> node;
int n; // n*n square
char **s; // data (0-index)

/* func dec */
void fill(int x, int y, char target, char replace) {
    if (target == replace) return;
    if (s[x][y] != target) return;
    s[x][y] = replace;
    if (x-1 >= 0) fill(x-1, y, target, replace);
    if (x+1 < n) fill(x+1, y, target, replace);
    if (y-1 >= 0) fill(x, y-1, target, replace);
    if (y+1 < n) fill(x, y+1, target, replace);
    return;
}

int main() {
    ifstream stdin ("test.in");
    ofstream stdout ("test.out");
    /* init */
    stdin >> n;
    s = new char*[n];
    LP(x, 0, n) {
        s[x] = new char[n];
        LP(y, 0, n)
            stdin >> s[x][y];
    }
    /* run */
    fill(1, 1, 'B', 'X');
    /* exit */
    LP(a, 0, n) {
        LP(b, 0, n) {
            cout << s[a][b] << " ";
        }
        cout << endl;
    }
    cout << endl;
    stdin.close();
    stdout.close();
    return 0;
}
