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

int n;
int P[10001];
int dp[10001];

int solve(int k) {
	if (k == 0) return 0;

	int &ret = dp[k];
	if (ret != -1) return ret;

	for (int i = 1; i <= k; i++) {
		ret = max(ret, solve(k - i) + P[i]);
	}
	
	return ret;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	memset(dp, -1, sizeof(dp));

	cin >> n;

	for (int i = 1; i <= n; i++) {
		cin >> P[i];
	}

	cout << solve(n);
}