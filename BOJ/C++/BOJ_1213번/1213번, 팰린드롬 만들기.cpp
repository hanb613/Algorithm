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

string str, ans;
int alphabet[26];
int check;
char odd;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> str;
	
	for (int i = 0; i < str.size(); i++) {
		alphabet[str[i] - 'A']++;
	}

	for (int i = 0; i < 26; i++) {
		if (alphabet[i] % 2 == 1) {
			check++;
			odd = i + 'A';
		}
	}
	
	if (check > 1) {
		cout << "I'm Sorry Hansoo";
		return 0;
	}

	for (int i = 0; i < 26; i++) {
		for (int j = 0; j < alphabet[i] / 2; j++) {
			ans += i + 'A';
		}
	}

	cout << ans;

	if (check == 1) cout << odd;
	for (int i = ans.size() - 1; i >= 0; i--) {
		cout << ans[i];
	}

	return 0;
}