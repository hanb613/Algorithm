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
int a, b;
int result;
vector<int> graph[101];
bool visit[101];

void DFS(int k, int cnt) {
	visit[k] = true;

	if (k == b) {
		cout << cnt;
		exit(0);
	}

	for (int i = 0; i < graph[k].size(); i++) {
		int next = graph[k][i];
		if (!visit[next]) {
			DFS(next, cnt+1);
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> a >> b >> m;

	int x, y;
	for (int i = 0; i < m; i++) {
		cin >> x >> y;
		graph[x].push_back(y);
		graph[y].push_back(x);
	}

	for (int i = 0; i < n; i++) {
		sort(graph[i].begin(), graph[i].end());
	}

	DFS(a, 0);
	
	if (!visit[b]) cout << -1;
	else cout << result;
}