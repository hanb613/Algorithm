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

int solve(int k) {
	queue<pair<ll, int>> temp;
	temp.push({ k,1 });

	while (!temp.empty()) {
		ll num = temp.front().first;
		int cnt = temp.front().second;
		temp.pop();

		if (num == b) return cnt;

		ll mul_two = num * 2;
		ll add_one = (num * 10) + 1;
		if (mul_two <= b) {
			temp.push({ mul_two, cnt + 1 });
		}
		if (add_one <= b) {
			temp.push({ add_one,cnt + 1 });
		}
	}

	return -1;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> a >> b;
	
	cout << solve(a);
}