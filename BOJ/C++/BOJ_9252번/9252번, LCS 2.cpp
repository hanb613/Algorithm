#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <algorithm>
#include <vector>
#include <string>
#include <string.h>
#include <math.h>
#include <stack>
#include <tuple>
using namespace std;
#pragma warning(disable:4996)

typedef long long int lli;

string str1;
string str2;
int dp[1001][1001];
stack<char>result;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> str1 >> str2;

	for (int i = 1; i <= str1.length(); i++) {
		for (int j = 1; j <= str2.length(); j++) {
			if (str1[i - 1] == str2[j - 1]) {
				dp[i][j] = dp[i - 1][j - 1] + 1;
			}
			else {
				dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
			}
		}
	}
	
	int x = str1.length();
	int y = str2.length();
	
	cout << dp[x][y] << "\n";

	while (dp[x][y] != 0) {
		if (dp[x][y] == dp[x][y - 1]) {
			y--;
		}
		else if (dp[x][y] == dp[x - 1][y]) {
			x--;
		}
		else {
			result.push(str1[x - 1]);
			x--; y--;
		}
	}

	while (!result.empty()) {
		cout << result.top();
		result.pop();
	}
}