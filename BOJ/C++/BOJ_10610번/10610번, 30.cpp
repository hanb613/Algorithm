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

char n[100001];
int sum;
bool check;

bool cmp(char a, char b) {
	return a > b;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;

	int size = strlen(n);
	for (int i = 0; i < size; i++) {
		sum += (n[i] - '0');
		if (n[i] == '0') check = true;
	}

	if (check && sum % 3 == 0) {
		sort(n, n + size, cmp);
		cout << n;
	}
	else cout << -1;
}