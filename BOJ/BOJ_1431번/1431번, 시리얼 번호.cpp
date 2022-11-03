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
string str[51];

int sum(string s) {
	int ret = 0;

	for (int i = 0; i < s.size(); i++) {
		if (s[i]-'0' >= 0 && s[i] - '0' <= 9) {
			ret += s[i] - '0';
		}
	}
	return ret;
}

bool cmp(string a, string b) {
	if (a.size() == b.size()) {
		if (sum(a) == sum(b)) {
			return a < b;
		}
		else return sum(a) < sum(b);
	}
	else return a.size() < b.size();
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> str[i];
	}

	sort(str, str + n, cmp);

	for (int i = 0; i < n; i++) {
		cout << str[i] << "\n";
	}
}