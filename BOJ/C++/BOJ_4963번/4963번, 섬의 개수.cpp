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

struct Direction {
	int x;
	int y;
};

Direction dir[8] = { {1,0},{-1,0}, {0,1},{0,-1},{1,1},{-1,-1} ,{-1,1},{1,-1} };

int w, h;
int graph[51][51];
int check[51][51];
int result;

void DFS(int x, int y) {
	check[x][y] = 1;

	for (int i = 0; i < 8; i++) {
		int new_x = x + dir[i].x;
		int new_y = y + dir[i].y;

		if (new_x >= 0 && new_y >= 0 && new_x < h && new_y < w) {
			if (graph[new_x][new_y] == 1 && check[new_x][new_y] == 0) {
				DFS(new_x, new_y);
			}
		}
	}

}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	while (1) {
		memset(graph, 0, sizeof(graph));
		memset(check, 0, sizeof(check));
		result = 0;

		cin >> w >> h;

		if (w == 0 && h == 0) break;

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				cin >> graph[i][j];
			}
		}

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (graph[i][j] == 1 && check[i][j] == 0) {
					DFS(i, j);
					result++;
				}
			}
		}
		cout << result << "\n";
	}
}