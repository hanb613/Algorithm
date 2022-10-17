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

int tc, n;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> tc;
	while (tc--) {
		vector<pair<int, int>> vc;
		int result = 1;

		cin >> n;
		for (int i = 0; i < n; i++) {
			int paper, interview;
			cin >> paper >> interview;
			vc.push_back({ paper,interview });
		}
		
		sort(vc.begin(), vc.end());

		int minB = vc[0].second;
		
		for (int i = 1; i < n; i++) {
			if (vc[i].second < minB) {
				minB = vc[i].second;
				result++;
			}
		}
		cout << result << "\n";

	}
}