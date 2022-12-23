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

int n, k, cnt;
int arr[1001];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> k;

	for (int i = 2; i <= n; i++) {
		arr[i] = i;
	}

	for (int i = 2; i <= n; i++) {
		for (int j = i; j <= n; j += i) {
			if (arr[j] == 0) continue;

			cnt++; arr[j] = 0;
			if (cnt == k) {
				cout << j;
				return 0;
			}
		}
	}
}