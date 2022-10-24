#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <algorithm>
#include <vector>
#include <string>
#include <string.h>
#include <math.h>
#include <queue>
using namespace std;
#pragma warning(disable:4996)

typedef long long int lli;

struct Dir {
	int x;
	int y;
};

Dir dir[4] = { {1,0}, {0,-1}, {-1,0}, {0,1} };

int n, maxHeight, cnt, result;
int input[101][101];
int graph[101][101];
bool visit[101][101];

void init() {
	cnt = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			graph[i][j] = 0;
			visit[i][j] = false;
		}
	}
}

void BFS(int x, int y) {
	queue<pair<int, int>> q;
	q.push({ x,y });
	visit[x][y] = true;

	while (!q.empty()) {
		x = q.front().first;
		y = q.front().second;
		q.pop();

		for (int i = 0; i < 4; i++) {
			int new_x = x + dir[i].x;
			int new_y = y + dir[i].y;

			if (new_x < 0 || new_y < 0 || new_x >= n || new_y >= n) continue;
			if (!visit[new_x][new_y] && !graph[new_x][new_y]) {
				q.push({ new_x,new_y });
				visit[new_x][new_y] = true;
			}
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> input[i][j];
			maxHeight = max(maxHeight, input[i][j]);
		}
	}

	for (int h = 1; h <= maxHeight; h++) {
		init();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (input[i][j] <= h) {
					graph[i][j] = 1;
				}
				else graph[i][j] = 0;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visit[i][j] && !graph[i][j]) {
					BFS(i, j);
					cnt++;
				}
			}
		}

		result = max(result, cnt);
	}

	if (result == 0) cout << 1;
	else cout << result;
}