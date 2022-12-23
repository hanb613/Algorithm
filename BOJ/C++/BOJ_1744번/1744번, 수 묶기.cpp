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

int n, result;
vector<int> pos;
vector<int> neg;
vector<int> zero;
vector<int> res;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	int num;
	for (int i = 0; i < n; i++) {
		cin >> num;
		if (num > 0) {
			if (num == 1) res.push_back(num);
			else pos.push_back(num);
		}
		else if (num == 0) zero.push_back(num);
		else neg.push_back(num);
	}

	sort(neg.begin(), neg.end());
	sort(pos.begin(), pos.end());

	if (pos.size() != 0) {
		if (pos.size() % 2 == 1) { 
			res.push_back(pos[0]);
		}
		for (int i = pos.size() - 1; i >= 1; i -= 2) {
			res.push_back(pos[i] * pos[i - 1]);
		}
	}

	if (neg.size() != 0) {
		if (neg.size() % 2 == 1 && zero.size() == 0) {
			res.push_back(neg[neg.size() - 1]);
		}
		
		for (int i = 0; i < neg.size() - 1; i += 2) {
			res.push_back(neg[i] * neg[i + 1]);
		}
	}
	
	for (int i = 0; i < res.size(); i++) {
		result += res[i];
	}

	cout << result;
}