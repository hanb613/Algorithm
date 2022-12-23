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
#include <map>
using namespace std;
#pragma warning(disable:4996)

typedef long long int lli;

int n, m, result;
string str;
map<string, bool> arr;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	cin >> n >> m;

	for (int i = 0; i < n; i++) {
		cin >> str;

		arr[str] = true;
	}
	
	for (int i = 0; i < m; i++) {
		cin >> str;
		
		if (arr[str]) result++;
	}

	cout << result;
}