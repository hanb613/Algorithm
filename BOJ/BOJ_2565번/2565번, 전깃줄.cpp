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
pair<int, int> arr[502];
int dp[502];
int result, total;

int f(int k) {
	int &ret = dp[k + 1];
	if (ret != -1) return ret;

	ret = 0;
	for (int i = k + 1; i < n; i++) {
		if (k == -1 || arr[k].second < arr[i].second) {
			ret = max(ret, f(i) + 1);
		}
	}

	return ret;
}


int main() {
	cin >> n;

	memset(dp, -1, sizeof(dp));

	for (int i = 0; i < n; i++) {
		cin >> arr[i].first >> arr[i].second;
	}
	sort(arr, arr + n);

	f(-1);


	cout << n - dp[0];
}