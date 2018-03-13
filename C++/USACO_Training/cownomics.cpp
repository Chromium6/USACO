/*
ID: agentmz1
PROG: cownomics
LANG: C++
passed
*/

#include <iostream>
#include <fstream>
#include <vector>
#include <map>
#include <set>

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

int toInt(char a, char b, char c) { // convert a tripet of bases into a number
    return 16*conv(a) + 4*conv(b) + conv(c); // convert it to base-4, then to base-10
}

bool check(int i, int j, int k) { // check valid spot combo
    set<int> found; // record which combos have been found
    LP(g, 0, n)
        found.insert(toInt(good[g][i], good[g][j], good[g][k]));
    LP(b, 0, n) {
        int val = toInt(bad[b][i], bad[b][j], bad[b][k]);
        if (found.count(val) > 0) return false;
    }
    return true;
}

int main() {
    ifstream stdin ("cownomics.in");
    ofstream stdout ("cownomics.out");
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
    LP(i, 0, m) {
        LP(j, i+1, m) {
            LP(k, j+1, m) {
                cout << "(" << i << ", " << j << ", " << k << ")";
                if (check(i, j, k)) {
                    sure ++;
                    cout << " [V]";
                }
                cout << endl;
            }
        }
    }
    /* exit */
    stdout << sure << endl;
    stdin.close();
    stdout.close();
    return 0;
}
