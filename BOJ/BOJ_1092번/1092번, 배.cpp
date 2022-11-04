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

int n, m, result;
vector<int> arr;
vector<int> arr2;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int num;

	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> num;
		arr.push_back(num);
	}
	
	cin >> m;
	for (int i = 0; i < m; i++) {
		cin >> num;
		arr2.push_back(num);
	}

	sort(arr.rbegin(), arr.rend());
	sort(arr2.rbegin(), arr2.rend());

	if (arr[0] < arr2[0]) {
		cout << -1;
		return 0;
	}

	while (!arr2.empty()) {
		result++;
		for (int i = 0; i < arr.size(); i++) {
			for (int j = 0; j < arr2.size(); j++) {
				if (arr2[j] <= arr[i]) {
					arr2.erase(arr2.begin() + j);
					break;
				}
			}
		}
	}

	if (result == 0) cout << -1;
	else cout << result;
}