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
int arr[301];
int dp[301];
int dp2[301];

int solve(int k) {
	if (k < 0) return 0;
	if (dp2[k] != 0) return dp2[k];

	dp2[k] = max(arr[k] + solve(k - 2), arr[k] + arr[k - 1] + solve(k - 3));
	
	return dp2[k];
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}

	dp[0] = arr[0];
	dp[1] = arr[0] + arr[1];
	dp[2] = max(dp[0] + arr[2], arr[1] + arr[2]);

	for (int i = 3; i < n; i++) {
		dp[i] = max(arr[i] + dp[i - 2], arr[i] + arr[i - 1] + dp[i - 3]);
	}

	cout << dp[n - 1];
	cout << solve(n - 1);
}