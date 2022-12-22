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
bool visit[10];
int num[10];

void solve(int idx) {
	if (idx == n + 1) {
		for (int i = 1; i <= n; i++) {
			cout << num[i] << " ";
		}
		cout << "\n";
		return;
	}

	for (int i = 1; i <= n; i++) {
		if (visit[i]) continue;
		visit[i] = true;
		num[idx] = i;
		solve(idx + 1);
		visit[i] = false;
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;

	solve(1);
}