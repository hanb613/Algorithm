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
int arr[14];
bool visit[14];
vector<int> result;

void solve(int m, int k) {
	if (k == 6) {
		for (int i = 0; i < result.size(); i++) {
			cout << result[i] << " ";
		}
		cout << "\n";
		return;
	}

	for (int i = m; i < n; i++) {
		if (visit[i]) continue;
		visit[i] = true;
		result.push_back(arr[i]);
		solve(i, k + 1);
		result.pop_back();
		visit[i] = false;
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	while (1) {
		cin >> n;
		
		if (n == 0) break;
		for (int i = 0; i < n; i++) {
			cin >> arr[i];
		}

		solve(0, 0);
		cout << "\n";
	}
}