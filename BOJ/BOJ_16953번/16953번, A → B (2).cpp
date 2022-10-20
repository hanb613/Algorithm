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

int a, b;
int result = 999999;

void solve(ll k, int cnt) {
	if (k > b) return;
	if (k == b) result = min(result, cnt);

	solve(k * 2, cnt + 1);
	solve((k * 10) + 1, cnt + 1);
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> a >> b;

	solve(a, 0);

	if (result == 999999) cout << -1;
	else cout << result + 1;
}