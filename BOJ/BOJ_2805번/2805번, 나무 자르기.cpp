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

lli n, m, result;
lli arr[1000001];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> m;

	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}

	sort(arr, arr + n);

	lli left = 0, right = arr[n - 1];

	while (left <= right) {
		lli mid = (left + right) / 2;
		lli sum = 0;

		for (int i = 0; i < n; i++) {
			if (mid <= arr[i]) {
				sum += (arr[i] - mid);
			}
		}

		if (sum >= m) {
			result = max(result, mid);
			left = mid + 1;
		}
		else {
			right = mid - 1;
		}
	}

	cout << result;
}