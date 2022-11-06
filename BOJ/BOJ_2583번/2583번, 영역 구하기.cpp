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

Dir dir[4] = { {1, 0}, {0, -1} ,{-1, 0}, {0, 1} };

int n, m, k, cnt;
int graph[101][101];
int visit[101][101];
vector<int> result;

void DFS(int x, int y) {
	visit[x][y] = 1;
	cnt++;

	for (int i = 0; i < 4; i++) {
		int new_x = x + dir[i].x;
		int new_y = y + dir[i].y;

		if (new_x < 0 || new_y < 0 || new_x >= n || new_y >= m) continue;
		if (graph[new_x][new_y] == 0 && visit[new_x][new_y] == 0) {
		
			DFS(new_x, new_y); 
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> m >> k;
	
	int x, y, x1, y1;
	for (int i = 0; i < k; i++) {
		cin >> x >> y >> x1 >> y1;

		for (int i = x; i < x1; i++) {
			for (int j = y; j < y1; j++) {	
				graph[j][i] = 1;
			}
		}
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (visit[i][j] == 0 && graph[i][j] == 0) {
				cnt = 0;
				DFS(i, j);
				result.push_back(cnt);
			}
		}
	}

	sort(result.begin(), result.end());

	cout << result.size() << '\n';
	for (int i = 0; i < result.size(); i++) {
		cout << result[i] << " ";
	}
}