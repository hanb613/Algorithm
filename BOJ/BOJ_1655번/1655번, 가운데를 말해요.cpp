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

int n, num;
priority_queue<int> A;
priority_queue<int, vector<int>, greater<int>> B;

int main() {
	scanf("%d", &n);
	
	for (int i = 0; i < n; i++) {
		scanf("%d", &num);
		
		if (A.empty() || num < A.top()) {
			A.push(num);
			if (!A.empty() && A.size() > B.size() + 1) {
				B.push(A.top());
				A.pop();
			}
		}
		else if (num >= A.top()) {
			B.push(num);
			if (!B.empty() && A.size() < B.size()) {
				A.push(B.top());
				B.pop();
			}
		}

		cout << A.top() << "\n";
	}
}