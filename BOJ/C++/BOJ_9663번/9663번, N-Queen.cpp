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
int arr[15];

bool ispossible(int k) {
	for (int i = 0; i < k; i++) {
		if (arr[i] == arr[k] || k - i == abs(arr[k] - arr[i])) {
			return false;
		}
	}
	return true;
}

void N_Queen(int k) {
	if (k == n) {
		result++;
		return;
	}

	for (int i = 0; i < n; i++) {
		arr[k] = i;
		if (ispossible(k))	N_Queen(k + 1);
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;

	N_Queen(0);

	cout << result;
}