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

#define MOD 10007

typedef long long int lli;

int n;
int dp[1001];

int solve(int k) {
	if (k == 1) return 1;
	if (k == 2) return 2;

	int &ret = dp[k];
	if (ret != -1) return ret;
	
	ret = (solve(k - 1) % MOD + solve(k - 2) % MOD) % MOD;

	return ret;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	memset(dp, -1, sizeof(dp));

	cin >> n;

	cout << solve(n);

}

/*
1 = 1 (1*2: 1개)
1 1 = 2 (1*2: 1개, 2*1: 1개)
2 1 = 3 (1*2: 2개, 2*1: 1개) , (1*2: 0개, 2*1: 3개) -> 각 개수 더해서 N
1 3 1 = 5
3 4 1 = 8
1 6 5 1 = 13

1 2 3 5 8 13 21 34 55

점화식 : f(n) = f(n-1) + f(n-2)
		-> (n-1)| + (n-2)=
		-> 2x(n-1) 크기의 직사각형을 채우는 방법과 
		   2x(n-2) 크기의 직사각형을 채우는 방법을 더하면 된다.

				(n-1)| + (n-2)=
		2*(n-1) 타일의 뒤에 2*1 한 개 붙이는 경우
							+
		2*(n-2) 타일의 뒤에 1*2 두 개 붙이는 경우
*/