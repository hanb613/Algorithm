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
vector<pair<int, string>> vc;

bool cmp(pair<int, string> a, pair<int, string> b) {
	if (a.first == b.first) return a.second < b.second;
	else return a.first > b.first;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	
	string str;
	for (int i = 0; i < n; i++) {
		cin >> str;
		if (vc.size() != 0) {
			for (int j = 0; j < vc.size(); j++) {
				if (vc[j].second == str) {
					vc[j].first++;
					break;
				}
			}
		}
		vc.push_back({ 1, str });
	}

	sort(vc.begin(), vc.end(), cmp);
	
	cout << vc[0].second;
}