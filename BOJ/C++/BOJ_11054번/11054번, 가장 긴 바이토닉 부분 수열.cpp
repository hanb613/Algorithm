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
int arr[1002];
int dp[1002];
int dp2[1002];
int result;

int f(int k) { // 謝難 LIS
	if (k == 0) dp[k] = 1;

	int &ret = dp[k];
	if (ret != -1) return ret;

	ret = 1;
	for (int i = k - 1; i >= 0; i--) {
		int temp = f(i);
		if (arr[i] < arr[k] & ret <= temp) {
			ret = temp + 1;
		}
	}

	return ret;
}

int f2(int k) { // 辦難 LIS
	if (k == n - 1) dp2[k] = 1;

	int &ret = dp2[k];
	if (ret != -1) return ret;

	ret = 1;
	for (int i = k + 1; i < n; i++) {
		int temp = f2(i);
		if (arr[i] < arr[k] & ret <= temp) {
			ret = temp + 1;
		}
	}

	return ret;
}

int main() {
	cin >> n;

	memset(dp, -1, sizeof(dp));
	memset(dp2, -1, sizeof(dp2));

	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}
	f(n - 1); //謝難 LIS
	f2(0); //辦難 LIS

	for (int i = 0; i < n; i++) {
		result = max(result, dp[i] + dp2[i] - 1);
	}
	cout << result;
}