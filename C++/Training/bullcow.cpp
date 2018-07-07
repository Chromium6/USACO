#include <iostream>
#include <fstream>
#include <vector>
#include <algorithm>

using namespace std;
#define LP(name, minVal, maxVal) for(int name = minVal; name < maxVal; name++)

/* var dec */
int n; // number of slots
int k; // min dist between bulls
int p; // number of valid permutations

/* func dec */

int main() {
    ifstream stdin ("test.in");
    ofstream stdout ("test.out");
    /* init */
    stdin >> n >> k;
    p = n+1; // one blank and n (1-bull) scenarios
    /* run */
    
    /* exit */
    cout << (n+k)/(k-1) << endl;
    stdin.close();
    stdout.close();
    return 0;
}
