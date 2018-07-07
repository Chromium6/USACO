#include <iostream>
#include <fstream>
#include <list>
#include <algorithm>
#include <assert.h>
using namespace std;

#define LP(name, minVal, maxVal) for(int name = minVal; name < maxVal; name++)

/* var dec */
int n, m, t, c; // nodes, edges, switch period, flight time
int cost; // track total time taken
int start, target; // path
list<int> *s; // store edges
list<int>::iterator it;

/* func dec */

int main() {
    ifstream stdin("test.in");
    ofstream stdout("test.out");
    /* init */
    stdin >> n >> m >> t >> c;
    cost = 0;
    s = new list<int>[n];
    LP(i, 0, n) {
        int a, b;
        stdin >> a >> b;
        a--;b--;
        s[a].push_back(b);
        s[b].push_back(a);
    }
    /* run */
    LP(i, 0, n) {
        cout << i + 1 << " => ";
        for (it = s[i].begin(); it != s[i].end(); it++){
            cout << *it + 1 << ", ";
        }
        cout << endl;
    }
    /* exit */
    cout <<  endl;
    return 0;
}
