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

int n, m;
int arr[10001];
int result;

int cal(int mid) {
	lli ret = 0;

	for (int i = 0; i < n; i++) {
		if (arr[i] > mid) {
			ret += mid;
		}
		
		else {
			ret += arr[i];
		}
		
	}

	return ret;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}
	cin >> m;

	sort(arr, arr + n);

	int left = 0, right = arr[n - 1];

	while (left <= right) {
		int mid = (left + right) / 2;
		int sum = cal(mid);

		if (sum <= m) {
			result = mid;
			left = mid + 1;
		}
		else {
			right = mid - 1;
		}
	}

	cout << result;
}