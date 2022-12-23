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

#define MOD 1000000

typedef long long int lli;

lli N;
lli arr[2][2] = { {1,1},{1,0} }; // ∞Ì¡§
lli arr2[2][2] = { {1,1},{1,0} }; 

void mul(lli a[][2], lli b[][2]) {
	lli tmp[2][2] = { {0,0}, {0,0} };

	for (lli i = 0; i < 2; i++) {
		for (lli j = 0; j < 2; j++) {
			for (lli k = 0; k < 2; k++) {
				tmp[i][j] += a[i][k] * b[k][j];
				tmp[i][j] %= MOD;
			}
		}
	}

	memcpy(arr2, tmp, sizeof(arr2));
}

void f(int k) {
	if (k == 1) return;

	if (k % 2 == 0) {
		f(k / 2);
		mul(arr2, arr2);
	}
	else {
		f(k / 2);
		mul(arr2, arr2);
		mul(arr2, arr);
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N;

	if (N > 1) f(N - 1);

	cout << arr2[0][0];
}