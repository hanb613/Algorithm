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

Dir dir[4] = { {1, 0}, {0, -1}, {-1, 0}, {0, 1} };

int u, v;
int result;
string graph[51];
int visit[51][51];
int dist[51][51];

void BFS(int x, int y) {
	memset(visit, 0, sizeof(visit));
	memset(dist, 0, sizeof(dist));
	visit[x][y] = 1;

	queue<pair<int, int>> q;
	q.push({ x,y });

	while (!q.empty()) {
		x = q.front().first;
		y = q.front().second;
		q.pop();

		for (int i = 0; i < 4; i++) {
			int new_x = x + dir[i].x;
			int new_y = y + dir[i].y;

			if (new_x < 0 || new_y < 0 || new_x >= u || new_y >= v) continue;
			if (graph[new_x][new_y] == 'L' && visit[new_x][new_y] == 0) {
				q.push({ new_x, new_y });
				visit[new_x][new_y] = 1;
				dist[new_x][new_y] = dist[x][y] + 1;
			}
			result = max(result, dist[new_x][new_y]);
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> u >> v;
	for (int i = 0; i < u; i++) {
		cin >> graph[i];
	}

	for (int i = 0; i < u; i++) {
		for (int j = 0; j < v; j++) {
			if (graph[i][j] == 'L') {
				BFS(i, j);
			}
		}
	}

	cout << result;
}