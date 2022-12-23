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

int l, c;
char str[16];
bool visit[16];

void func(int cnt, string tmp) {
	if (cnt == l) {
		bool vowelCheck = false;
		int consonantCheck = 0;

		for (int i = 0; i < l; i++) {
			if (tmp[i] == 'a' || tmp[i] == 'e' ||
				tmp[i] == 'i' || tmp[i] == 'o' ||
				tmp[i] == 'u') vowelCheck = true;
			else consonantCheck++;

			if (vowelCheck && consonantCheck >= 2) {
				cout << tmp << "\n";
				return;
			}
		}
	}

	for (int i = 0; i < c; i++) {
		if (!visit[i]) {
			if (!tmp.empty() && tmp.back() > str[i]) continue;
			visit[i] = true;
			tmp += str[i];
			func(cnt + 1, tmp);
			visit[i] = false;
			tmp.erase(tmp.length() - 1);
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> l >> c;

	for (int i = 0; i < c; i++) {
		cin >> str[i];
	}

	sort(str, str + c);
	
	func(0, "");
}