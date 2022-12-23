#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <algorithm>
#include <vector>
#include <string>
#include <string.h>
#include <math.h>
#include <queue>
#include <map>
using namespace std;
#pragma warning(disable:4996)

typedef long long int lli;

int n, m;
string str;
map<string, int> mp;
vector<string> result;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	cin >> n >> m;

	for (int i = 0; i < n; i++) {
		cin >> str;
		mp.insert({ str, 1 });
	}

	for (int j = 0; j < m; j++) {
		cin >> str;
		
		if (mp.find(str) != mp.end()) {
			mp[str] += 1;
		}
		else mp.insert({ str, 1 });

		if (mp[str] == 2) result.push_back(str);
	}

	sort(result.begin(), result.end());

	cout << result.size() << "\n";
	for (int i = 0; i < result.size(); i++) {
		cout << result[i] << "\n";
	}
}