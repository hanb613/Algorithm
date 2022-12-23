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

int n, m;
int one = 999999;
int package = 999999;
int result = 999999;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> m;

	int x, y;
	for (int i = 0; i < m; i++) {
		cin >> x >> y;

		package = min(package, x);
		one = min(one, y);
	}
	
	result = min(result, one*n);

	if (n > 6) {
		int cnt = n / 6;
		int cnt2 = n % 6;

		if (cnt == 0) {
			result = min(result, cnt*package);
		}
		else {
			result = min(result, (cnt + 1)*package);
			result = min(result, (cnt*package) + (cnt2*one));
		}
	}
	else {
		result = min(result, package);
	}

	cout << result;
}