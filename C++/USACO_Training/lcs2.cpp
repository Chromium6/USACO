/*
ID: agentmz1
PROG: lcs2
LANG: C++
TASK: given two strings, find the longest common subsequence (not necessarily contigous)
*/

#include <iostream>
#include <fstream>
#include <vector>
#include <list>
#include <algorithm>

using namespace std;
#define LP(name, minVal, maxVal) for(int name = minVal; name < maxVal; name++)

/* var dec */
const string fileName = "test";
string s1, s2;
int **dp;

/* func dec */
int f(int x, int y); // NOTE: 1-indexing

int main() {
    ifstream stdin (fileName + ".in");
    ofstream stdout (fileName + ".out");
    /* init */
    stdin >> s1 >> s2;
    dp = new int*[s1.length() + 1];
    LP(x, 0, s1.length() + 1)
        dp[x] = new int[s2.length() + 1];
    /* run */
    LP(x, 1, s1.length()+1) {
        LP(y, 1, s2.length()+1) {
            dp[x][y] = f(x, y);
            // cout << dp[x][y] << " ";
        }
        // cout << endl;
    }
    /* exit */
    cout << dp[s1.length()][s2.length()] << endl;
    stdin.close();
    stdout.close();
    return 0;
}

int f(int x, int y) {
    // base case
    if (x == 0 || y == 0) return 0;
    // logic
    int raw = max(dp[x-1][y], dp[x][y-1]);
    if (s1[x-1] == s2[y-1]) raw ++;
    return raw;
}