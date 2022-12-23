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

typedef long long ll;
#define MOD 10007

int n, result;
ll dp[1001][10];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	
	for (int i = 0; i < 10; i++) {
		dp[1][i] = 1;
	}

	for (int i = 2; i <= n; i++) {
		for (int j = 0; j < 10; j++) {
			if (j == 0) {
				dp[i][0] = 1;
				continue;
			}
			dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]);
			dp[i][j] %= MOD;
		}
	}

	for (int i = 0; i < 10; i++) {
		result += dp[n][i];
	}

	cout << result % MOD;
}