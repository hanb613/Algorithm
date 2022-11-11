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

typedef long long int lli;
#define Max 100001

int n;
bool visited[Max];
int parent[Max];
vector<int> tree[Max];

void DFS(int num) {
	visited[num] = true;

	for (int i = 0; i < tree[num].size(); i++) {
		int next = tree[num][i];

		if (!visited[next]) {
			parent[next] = num;
			DFS(next);
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	for (int i = 0; i < n - 1; i++) {
		int node1, node2;
		cin >> node1 >> node2;

		tree[node1].push_back(node2);
		tree[node2].push_back(node1);
	}

	DFS(1);

	for (int i = 2; i <= n; i++) {
		cout << parent[i] << "\n";
	}

}