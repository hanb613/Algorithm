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

Direction dir[4] = { {1,0},{-1,0},{0,1},{0,-1} };

int n;
int cnt_A, cnt_B;
int check[101][101];
string inp, graph[101];

void DFS_A(int x, int y, char c) {
	check[x][y] = 1;

	for (int i = 0; i < 4; i++) {
		int new_x = x + dir[i].x;
		int new_y = y + dir[i].y;

		if (new_x >= 0 && new_x < n && new_y >= 0 && new_y < n) {
			if (graph[new_x][new_y] == c && check[new_x][new_y] == 0) {
				DFS_A(new_x, new_y, graph[new_x][new_y]);
			}
		}
	}

}

void DFS_B(int x, int y, char c) {
	check[x][y] = 1;

	for (int i = 0; i < 4; i++) {
		int new_x = x + dir[i].x;
		int new_y = y + dir[i].y;

		
		if (new_x >= 0 && new_x < n && new_y >= 0 && new_y < n) {
			if (c == 'R' || c == 'G') {
				if ((graph[new_x][new_y] == 'R' || graph[new_x][new_y]=='G') && check[new_x][new_y] == 0) {
					DFS_B(new_x, new_y, graph[new_x][new_y]);
				}
			}
			else {
				if (graph[new_x][new_y] == c && check[new_x][new_y] == 0) {
					DFS_B(new_x, new_y, graph[new_x][new_y]);
				}
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
		cin >> inp;
		graph[i] = inp;
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (check[i][j] == 0) {
				DFS_A(i, j, graph[i][j]);
				cnt_A++;
			}
		}
	}
	
	memset(check, 0, sizeof(check));

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if ((graph[i][j] == 'R' && check[i][j] == 0) || (graph[i][j] == 'G' && check[i][j] == 0)) {
				DFS_B(i, j, graph[i][j]);
				cnt_B++;
			}
			else if (graph[i][j] == 'B' && check[i][j] == 0) {
				DFS_B(i, j, graph[i][j]);
				cnt_B++;
			}
		}
	}

	cout << cnt_A << " " << cnt_B;
}