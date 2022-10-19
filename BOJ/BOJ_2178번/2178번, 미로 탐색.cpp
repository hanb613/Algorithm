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

Dir dir[4] = { {1,0}, {0, -1}, {0,1}, {-1,0} };

int n, m;
string graph[101];
int visited[101][101];

void BFS(int x, int y) {
	queue<pair<int, int>> q;
	visited[x][y] = 1;
	q.push({ x,y });

	while (!q.empty()) {
		x = q.front().first;
		y = q.front().second;
		q.pop();

		for (int i = 0; i < 4; i++) {
			int new_x = x + dir[i].x;
			int new_y = y + dir[i].y;

			if (new_x >= 0 && new_x < n && new_y >= 0 && new_y < m) {
				if (visited[new_x][new_y] == 0 && graph[new_x][new_y] == '1') {
					q.push({ new_x, new_y });
					visited[new_x][new_y] = visited[x][y] + 1;
				}
			}
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		cin >> graph[i];
	}

	BFS(0, 0);

	cout << visited[n - 1][m - 1];
}