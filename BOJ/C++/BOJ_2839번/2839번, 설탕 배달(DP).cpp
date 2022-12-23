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
int dp[5001];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	dp[3] = dp[5] = 1;

	cin >> n;
	
	for (int i = 6; i <= n; i++) {
		if (dp[i - 3]) dp[i] = dp[i - 3] + 1;

		if (dp[i - 5]) {
			int MIN = min(dp[i], dp[i - 5] + 1);

			dp[i] = dp[i] ? MIN : dp[i - 5] + 1;
		}
	}
	
	if (dp[n] == 0) cout << -1;
	else cout << dp[n];

}