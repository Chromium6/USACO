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

/* var dec */
const string fileName = "test";
int n, m;
vector<int> b; // bisquares

/* func dec */

int main() {
    ifstream stdin (fileName + ".in");
    ofstream stdout (fileName + ".out");
    /* init */
    /* run */
    /* exit */
    cout << endl;
    stdin.close();
    stdout.close();
    return 0;
}
