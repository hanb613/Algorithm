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

Dir dir[4] = { {1,0} , {0, -1}, {-1,0} , {0, 1} };

int u, v, result;
int graph[9][9];
bool visit[9][9];
vector<pair<int, int>> way;
int wall = 3, virus;

void BFS(int virus) {
	queue<pair<int, int>> q;

	for (int i = 0; i < u; i++) {
		for (int j = 0; j < v; j++) {
			visit[i][j] = false;
			if (graph[i][j] == 2) q.push({ i,j });
		}
	}

	while (!q.empty()) {
		int x = q.front().first;
		int y = q.front().second;
		q.pop();

		for (int i = 0; i < 4; i++) {
			int new_x = x + dir[i].x;
			int new_y = y + dir[i].y;

			if (new_x < 0 || new_y < 0 || new_x >= u || new_y >= v) continue;
			if (!visit[new_x][new_y] && graph[new_x][new_y] == 0) {
				visit[new_x][new_y] = true;
				q.push({ new_x, new_y });
				virus++;
			}
		}
	}

	result = max((u*v) - wall - virus, result);
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> u >> v;
	for (int i = 0; i < u; i++) {
		for (int j = 0; j < v; j++) {
			cin >> graph[i][j];

			if (graph[i][j] == 0) way.push_back({ i,j });
			else if (graph[i][j] == 1) wall += 1;
			else virus += 1;
		}
	}

	for (int i = 0; i < way.size(); i++) {
		for (int j = i + 1; j < way.size(); j++) {
			for (int k = j + 1; k < way.size(); k++) {
				graph[way[i].first][way[i].second] = 1;
				graph[way[j].first][way[j].second] = 1;
				graph[way[k].first][way[k].second] = 1;

				BFS(virus);

				graph[way[i].first][way[i].second] = 0;
				graph[way[j].first][way[j].second] = 0;
				graph[way[k].first][way[k].second] = 0;
			}
		}
	}

	cout << result;
}