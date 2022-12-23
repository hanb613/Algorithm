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

int n;
int arr[130][130];
int blue, white;

void f(int r, int c, int size) {
	for (int i = r; i < r + size; i++) {
		for (int j = c; j < c + size; j++) {
			if (arr[r][c] != arr[i][j]) {
				f(r, c, size / 2);
				f(r, c + size / 2, size / 2);
				f(r + size / 2, c, size / 2);
				f(r + size / 2, c + size / 2, size / 2);
				return;
			}
		}
	}

	if (arr[r][c] == 1) blue++;
	else white++;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> arr[i][j];
		}
	}

	f(0, 0, n);

	cout << white << "\n" << blue;
}