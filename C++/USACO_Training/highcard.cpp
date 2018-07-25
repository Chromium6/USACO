/*
ID: agentmz1
PROG: lcs2
LANG: C++
TASK: given two strings, find the longest common subsequence (not necessarily contigous)
*/

#include <iostream>
#include <fstream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    ifstream stdin(fileName + ".in");
    ofstream stdout(fileName + ".out");
    /* var dec */
    int n;
    stdin >> n;
    vector<int> e = new vector<int>();
    vector<int> b = new vector<int>();
    int num;
    for (int i = 0; i < n; i ++) {
        stdin >> num;
        e.push_back(num);
    }
    for (int i = 1; i <= 2*n; i ++) {
        if (find(e.begin(), e.end(), i) != e.end()) b.push_back(i);
    }
    cout << e << " " << b;
    /* run */
    /* exit */
    return 0;
}
