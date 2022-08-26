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

int n, s;
int result;
int arr[21];

void solve(int idx, int sum) {
	if (idx == n) {
		if (sum == s) result++;

		return;
	}

	solve(idx + 1, sum);
	solve(idx + 1, sum + arr[idx]);
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> s;

	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}

	solve(0, 0);

	if (s == 0) result--;

	cout << result;
}