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

int n, m;
int a, b, c, d;
int dp[1025][1025];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> m;
	int num;
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			cin >> num;
			dp[i][j] = dp[i][j - 1] + num;
		}
	}

	for (int i = 0; i < m; i++) {
		int result = 0;

		cin >> a >> b >> c >> d;
		for (int j = a; j <= c; j++) {
			result += (dp[j][d] - dp[j][b - 1]);
		}
		cout << result << "\n";
	}

}