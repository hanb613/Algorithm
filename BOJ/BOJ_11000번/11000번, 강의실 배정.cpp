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

int n, result;
vector<pair<int, int>> vc;
priority_queue<int, vector<int>, greater<int>> pq;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	cin >> n;

	int start, end;
	for (int i = 0; i < n; i++) {
		cin >> start >> end;
		vc.push_back({ start, end });
	}

	sort(vc.begin(), vc.end());

	pq.push(vc[0].second);
	for (int i = 1; i < n; i++) {
		if (vc[i].first < pq.top()) {
			pq.push(vc[i].second);
		}
		else {
			pq.pop();
			pq.push(vc[i].second);
		}
	}

	cout << pq.size();

}