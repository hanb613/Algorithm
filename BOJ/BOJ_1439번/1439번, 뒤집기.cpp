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

string str;
int zero, one;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> str;

	int temp = 0;
	for (int i = 0; i < str.length(); i++) {
		if (str[i] != str[i + 1]) {
			if (str[i] == '0') one++;
			else zero++;
		}
	}

	cout << min(zero, one);
}