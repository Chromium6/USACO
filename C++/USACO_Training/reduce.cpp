/*
ID: agentmz1
PROG: reduce 
LANG: C++
*/

#include <iostream>
#include <fstream>
#include <vector>
#include <list>
#include <algorithm>

using namespace std;
#define LP(name, minVal, maxVal) for(int name = minVal; name < maxVal; name++)

/* var dec */
typedef pair<int, int> loc;
int n;
int r; // number of 
loc* s; // cow locations

/* func dec */

int main() {
    ifstream stdin ("test.in");
    ofstream stdout ("test.out");
    /* init */
    stdin >> n;
    r = 0;
    s = new loc[n];
    LP(i, 0, n) {
        int x, y;
        stdin >> x >> y;
        s[i] = loc(x, y);
    }
    /* run */
    sort(s, s+n);
    LP(i, 0, n) {
        cout << s[i].first << " " << s[i].second << endl;
    }
    /* exit */
    cout << endl;
    stdin.close();
    stdout.close();
    return 0;
}
