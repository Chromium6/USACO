#include <iostream>
#include <stdlib.h>
#include <algorithm>

using namespace std;
#define LP(name, minVal, maxVal) for(int name = minVal; name < maxVal; name++)

/* var dec */
int lower, higher;
int n;

/* func dec */

int main() {
    /* init */
    cout << "Lower bounds: ";
    cin >> lower;
    cout << "Higher bounds: ";
    cin >> higher;
    cout << "Length: ";
    cin >> n;
    /* run */
    LP(k, 0, n) {
        cout << rand()%(higher-lower+1) + lower << " ";
    }
    /* exit */
    cout << endl;
    return 0;
}
