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

int n, num, result;
vector<int> graph[101];
bool check[101];

void DFS(int k) {
	check[k] = true;

	for (int i = 0; i < graph[k].size(); i++) {
		int next = graph[k][i];

		if (!check[next]) {
			result++;
			DFS(next);
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> num;

	for (int i = 0; i < num; i++) {
		int u, v;

		cin >> u >> v;
		graph[u].push_back(v);
		graph[v].push_back(u);
	}

	DFS(1);

	cout << result;
}