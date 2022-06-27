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
int u, v;
vector<int> graph[1001];
bool check[1001];
int result;

void DFS(int k) {
	check[k] = true;

	for (int i = 0; i < graph[k].size(); i++) {
		int next = graph[k][i];

		if (!check[next]) {
			DFS(next);
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> m;

	fill(check, check + 1001, false);

	for (int i = 0; i < m; i++) {
		cin >> u >> v;
		graph[u].push_back(v);
		graph[v].push_back(u);
	}

	for (int i = 1; i <= n; i++) {
		if (!check[i]) {
			DFS(i);
			result++;
		}
	}

	cout << result;
}