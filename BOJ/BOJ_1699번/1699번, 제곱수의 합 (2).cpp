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
int dp[100001];

int solution(int k) {
	if (k == 0) return 0;

	int &ret = dp[k];
	if (ret > 0) return ret;

	ret = solution(k - 1) + 1;

	for (int i = 1; i*i <= k; i++) {
		ret = min(ret, solution(k - i*i) + 1);
	}

	return ret;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;

	cout << solution(n);
}