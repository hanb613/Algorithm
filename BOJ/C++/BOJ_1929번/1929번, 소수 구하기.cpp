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
int arr[1000001];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> m >> n;

	for (int i = 2; i <= n; i++) {
		arr[i] = i;
	}

	for (int i = 2; i * i <= n; i++) {
		for (int j = 2 * i; j <= n; j += i) {
			if (arr[j] == 0) continue;
			arr[j] = 0;
		}
	}

	for (int i = m; i <= n; i++) {
		if (arr[i] != 0) {
			printf("%d\n", arr[i]);
		}
	}

	return 0;
}