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

#define MOD 1000000

long long N, cnt;
vector<int> v;

void pisano(int m) {
	v.push_back(0);
	v.push_back(1);
	v.push_back(1);
	cnt = 2;

	while (1) {
		v.push_back((v[cnt] + v[cnt - 1]) % m);
		cnt++;

		if (v[cnt] == 0 && v[cnt - 1] == 1) break;
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N;

	pisano(1000000);

	cout << v[N % cnt];
}