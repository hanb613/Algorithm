#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <algorithm>
#include <vector>
#include <string>
#include <string.h>
#include <math.h>
#include <queue>
#include <tuple>
using namespace std;
#pragma warning(disable:4996)

typedef long long int lli;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int e, s, m;
	int k = 1;

	cin >> e >> s >> m;

	while (1) {
		if ((k - e) % 15 == 0 && (k - s) % 28 == 0 && (k - m) % 19 == 0) {
			break;
		}
		k++;
	}
	cout << k;
}