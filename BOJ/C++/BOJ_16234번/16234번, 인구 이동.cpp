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

struct Dir {
	int x;
	int y;
};

Dir dir[4] = { {1, 0}, {0, -1}, {0, 1}, {-1, 0} };

int n, l, r;
int num, people, result;
int graph[51][51];
bool visit[51][51];
vector<pair<int, int>> vc;

void DFS(int x, int y) {
	visit[x][y] = true;
	people += graph[x][y];
	vc.push_back({ x, y });

	for (int i = 0; i < 4; i++) {
		int new_x = x + dir[i].x;
		int new_y = y + dir[i].y;
		int diff = abs(graph[new_x][new_y] - graph[x][y]);

		if (new_x < 0 || new_y < 0 || new_x >= n || new_y >= n) continue;
		if (diff >= l && diff <= r && !visit[new_x][new_y]) {
			DFS(new_x, new_y);
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> l >> r;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> graph[i][j];
		}
	}

	while (1) {
		memset(visit, false, sizeof(visit));
		vector<pair<pair<int, int>, int>> record;
		int cnt = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visit[i][j]) {
					vc.clear();
					people = 0;
					DFS(i, j);
				}

				if (vc.size() == 1) {
					visit[i][j] = false;
					cnt++;
					continue;
				}

				for (int i = 0; i < vc.size(); i++) {
					record.push_back({ {vc[i].first, vc[i].second}, people / vc.size() });
				}
			}
		}

		if (cnt == n * n) break;

		for (int i = 0; i < record.size(); i++) {
			int x = record[i].first.first;
			int y = record[i].first.second;

			graph[x][y] = record[i].second;
		}

		result++;
	}

	cout << result;
}