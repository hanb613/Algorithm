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

int n, sum;
priority_queue<int, vector<int>, greater<int>> pq;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;

	int num;
	for (int i = 0; i < n; i++) {
		cin >> num;
		pq.push(num);
	}

	while (pq.size() > 1) {
		int num1 = pq.top();
		pq.pop();
		int num2 = pq.top();
		pq.pop();
		sum += (num1 + num2);
		pq.push(num1 + num2);
	}

	cout << sum;
}