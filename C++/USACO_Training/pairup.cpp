/*
ID: agentmz1
PROG: pairup
LANG: C++
STRATEGY: 
~~~~~~~~~~~~
Pair the highest valued cows with the lowest valued cows, recording highest sum. That'll be the maximum time
*/

#include <iostream>
#include <fstream>
#include <vector>
#include <list>
#include <algorithm>

using namespace std;
#define LP(name, minVal, maxVal) for(int name = minVal; name < maxVal; name++)

/* var dec */
int n; // number of cows (up to 1,000,000,000, so be careful)
vector<int> s; // cow values
int slow, fast; // slowest and fastest times
int maxTime; // record max time up until now

/* func dec */

int main() {
    ifstream stdin ("pairup.in");
    ofstream stdout ("pairup.out");
    /* init */
    stdin >> n;
    slow = 1000000000;
    fast = 0;
    LP(i, 0, n) {
        int amount, milk;
        stdin >> amount >> milk;
        slow = min(slow, milk);
        fast = max(fast, milk);
    }
    maxTime = abs(fast+slow);
    /* run */
    /*sort(s.begin(), s.begin()+s.size());
    /*LP(m, 0, n/2+1) {
        int sum = s[m] + s[n-m];
        maxTime = max(maxTime, sum);
        //cout << m << ": " << sum << " = " << s[m] << " " << s[n-m] << endl;
    }
    /*LP(p, 0, s.size())
        cout << s[p] << " ";
    cout << endl;*/
    /* exit */
    stdout << maxTime << endl;
    stdin.close();
    stdout.close();
    return 0;
}
