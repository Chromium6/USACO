#include <iostream>
#include <fstream>
#include <vector>
#include <algorithm>

using namespace std;
#define LP(name, minVal, maxVal) for(int name = minVal; name < maxVal; name++)

/* var dec */
int n; // number of cows
int *d; // data
int *dp;
int ascCount, desCount; // ascending order changes, descending order changes

/* func dec */

int main() {
    ifstream stdin ("test.in");
    ofstream stdout ("test.out");
    /* init */
    stdin >> n;
    d = new int[n];
    dp = new int[n];
    ascCount = desCount = 0;
    LP(i, 0, n) {
        stdin >> d[i];
        cout << d[i] << " ";
    }
    cout << endl;
    /* run */
    // count ascending changes
    dp[0] = 0;
    // cout << dp[0] << " ";
    int m = 2;
    LP(i, 1, n) {
        dp[i] = dp[i-1];
        if (d[i] < d[i-1] || d[i] > m) {
            dp[i]++;
            m = max(d[i+1], d[i-1]);
        }
        //cout << dp[i] << " ";
    }
    //cout << endl;
    ascCount = dp[n-1];
    // count descending changes
    dp[n-1] = 0;
    m = 1;
    //cout << dp[n-1] << " ";
    for (int i = n-2; i >= 0; i --) {
        dp[i] = dp[i+1];
        if (d[i] < d[i+1] || d[i] > m) {
            dp[i]++;
            m= max(d[i+1], d[i-1]);
        }
        //cout << dp[i] << " ";
    }
    desCount = dp[0];
    /* exit */
    cout << "Descending changes: " << desCount << endl;
    cout << "Ascending changes: " << ascCount << endl;
    cout << (desCount > ascCount ? ascCount : desCount) << endl;
    stdin.close();
    stdout.close();
    return 0;
}
