/*
ID: agentmz1
PROG: cownomics
LANG: C++
*/

#include <iostream>
#include <fstream>
#include <vector>
#include <map>
#include <algorithm>

using namespace std;
#define LP(name, minVal, maxVal) for(int name = minVal; name < maxVal; name++)

/* var dec */
map<char, int> translate; // convert DNA base to value
int n; // number of cows per group (valid, invalid)
int m; // length of cow genome
string *good; // valid cows
string *bad; // invalid cows
int sure; // number of combinations that are ensured

/* func dec */
int conv(char k) {
    return translate.at(k);
}

bool check(int i, int j, int k) { // check valid spot combo

}

int main() {
    ifstream stdin ("test.in");
    ofstream stdout ("test.out");
    /* init */
    translate.insert(pair<char, int>('A', 0));
    translate.insert(pair<char, int>('T', 1));
    translate.insert(pair<char, int>('C', 2));
    translate.insert(pair<char, int>('G', 3));
    stdin >> n >> m;
    good = new string[n];
    bad = new string[n];
    sure = 0;
    LP(i, 0, n)
        stdin >> good[i];
    LP(j, 0, n)
        stdin >> bad[j];
    /* run */
    /* exit */
    cout << endl;
    stdin.close();
    stdout.close();
    return 0;
}
