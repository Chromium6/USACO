/*
ID: agentmz1
PROG: test
LANG: C++
*/

#include <iostream>
#include <fstream>
#include <vector>
#include <list>
#include <algorithm>

using namespace std;
#define LP(name, minVal, maxVal) for(int name = minVal; name < maxVal; name++)

struct charm {
    int w, d;
};

/* var dec */
int n; // total charms
int m; // max weight
charm *s; // store charm data

/* func dec */

int main() {
    ifstream stdin ("test.in");
    ofstream stdout ("test.out");
    /* init */
    stdin >> n >> m;
    s = new charm[n];
    LP(i, 0, n)
        stdin >> s[i].w >> s[i].d;
    sort(s, s+n);
    /* run */
    cout << s[0].w << " " << s[0].d << endl;
    /* exit */
    cout << endl;
    stdin.close();
    stdout.close();
    return 0;
}
