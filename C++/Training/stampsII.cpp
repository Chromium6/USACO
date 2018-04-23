#include <iostream>
#include <fstream>
#include <map>
#include <algorithm>

using namespace std;
#define LP(name, minVal, maxVal) for(int name = minVal; name < maxVal; name++)

/* var dec */
int k; // max number of stamps
int n; // number of different values
int *v; // stamp values
map<int, int> possible; // record the sums we have obtained so far, and how many coins it took

/* func dec */

// passed
int main() {
    ifstream stdin ("test.in");
    ofstream stdout ("test.out");
    /* init */
    stdin >> k >> n;
    v = new int[n];
    LP(l, 0, n) {
        stdin >> v[l];
        LP(m, 1, k+1) {
            if (possible[v[l]*m] == 0 || m < possible[v[l]*m]) {
                possible[v[l]*m] = m;
            }
        }
    }
    sort(v, v+n);
    /* run */
    bool contigous = true; // if the sequence is ongoing
    int cur = 1;
    while (contigous) {
        if (possible[cur]){ // already possible
            //cout << cur << ": " << possible[cur] << endl;
            cur ++;
            continue;
        }        
        int small = 10000000;
        //cout << "Testing " << cur << ": " << endl;
        LP(test, 0, n) {
            if (possible[cur-v[test]]) small = min(small, possible[cur-v[test]]);
            //cout << "\tSmallest when removed " << v[test] << " is " << small << endl;
        }
        if (small >= k) break;
        possible[cur] = small+1;
    }
    /* exit */
    cur --;
    cout << cur << endl;
    stdin.close();
    stdout.close();
    return 0;
}