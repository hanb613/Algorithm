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

int n, result;
int x, y;
vector<pair<int, int>> vc;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> x >> y; 
		vc.push_back({ x,y });
	}

	sort(vc.begin(), vc.end());

	int start = vc[0].first;
	int end = vc[0].second;

	for (int i = 1; i < n; i++) {
		if (vc[i].first <= end) {
			if (end < vc[i].second) end = vc[i].second;
		}
		else {
			result += (end - start);
			start = vc[i].first;
			end = vc[i].second;
		}
	}

	result += (end - start);
	cout << result;
}