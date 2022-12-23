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
int arr[100001];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> m;

	for (int i = 1; i <= n; i++) {
		int num;
		cin >> num;

		arr[i] = arr[i - 1] + num;
	}

	for (int i = 0; i < m; i++) {
		int start, end;

		cin >> start >> end;

		cout << arr[end] - arr[start - 1] << '\n';
	}

}
