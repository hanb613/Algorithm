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
int T[16], P[16];
int dp[16];

void solve() {
	
	for (int i = n; i > 0; i--) {
		int deadline = i + T[i];

		if (deadline > n + 1) dp[i] = dp[i + 1];
		else dp[i] = max(dp[i + 1], dp[deadline] + P[i]);
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	for (int i = 1; i <= n; i++) {
		cin >> T[i] >> P[i];
	}

	solve();

	cout << dp[1];
}
