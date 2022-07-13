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

#define MOD 10007

int n;
int dp[1001];

int solve(int k) {
	if (k == 1) return 1;
	if (k == 2) return 3;

	int &ret = dp[k];
	if (ret != -1) return ret;

	ret = (solve(k - 1) % MOD + (2 * solve(k - 2)) % MOD) % MOD;

	return ret;
}

int main() {
	
	memset(dp, -1, sizeof(dp));

	scanf("%d", &n);

	printf("%d", solve(n));
}