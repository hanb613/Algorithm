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

Direction dir[4] = { {1,0}, {-1,0}, {0,1}, {0,-1} };

int n, cnt;
bool check[26][26];
string graph[26];
vector<int> result;

void DFS(int x, int y) {
	cnt++;
	check[x][y] = true;

	for (int i = 0; i < 4; i++) {
		int next_x = x + dir[i].x;
		int next_y = y + dir[i].y;
		
		if (next_x >= 0 && next_x < n && next_y >= 0 && next_y < n) {
			if (graph[next_x][next_y] == '1' && check[next_x][next_y] == false) {
				DFS(next_x, next_y);
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
		cin >> graph[i];
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (!check[i][j] && graph[i][j] == '1') {
				cnt = 0;
				DFS(i, j);
				result.push_back(cnt);
			}
		}
	}

	sort(result.begin(), result.end());

	cout << result.size() << "\n";
	for (int i = 0; i < result.size(); i++) {
		cout << result[i] << "\n";
	}
}