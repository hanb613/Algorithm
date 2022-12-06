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

int n, result;
int arr[1001];
int dp[1001];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	cin >> n;
	
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}

	dp[0] = 1;
	for (int i = 1; i < n; i++) {
		for (int j = 0; j < i; j++) {
			if (arr[i] > arr[j]) {
				dp[i] = max(dp[i], dp[j]);
			}
		}
		dp[i]++;
		result = max(result, dp[i]);
	}

	cout << result;
}