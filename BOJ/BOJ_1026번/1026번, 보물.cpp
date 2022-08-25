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
int A[51];
int B[51];
int result;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> A[i];
	}

	for (int i = 0; i < n; i++) {
		cin >> B[i];
	}
	
	/*
		sort(A, A + n);
		sort(B, B + n);

		for (int i = 0, k = n - 1; i < n, k >= 0; i++, k--) {
			result += (A[i] * B[k]);
		}
	*/

	sort(A, A + n, greater<>());
	sort(B, B + n);

	for (int i = 0; i < n; i++) {
		result += (A[i] * B[i]);
	}

	cout << result;
}