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

int n, result;
int num[30];
string str[11];


bool cmp(int a, int b) {
	if (a > b) return true;
	else return false;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> str[i];

		string s = str[i];
		int pow = 1;
		for (int j = s.length() - 1; j >= 0; j--) {
			int index = s[j] - 'A';
			num[index] += pow;
			pow *= 10;
		}
	}
	sort(num, num + 26, cmp);

	int m = 9;
	for (int i = 0; i < 26; i++) {
		if (num[i] == 0) break;
		result += (num[i] * m);
		m--;
	}

	cout << result;
}