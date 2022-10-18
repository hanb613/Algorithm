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

string str;
vector<string> vc;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> str;

	for (int i = 0; i < str.length(); i++) {
		vc.push_back(str.substr(i));
	}

	sort(vc.begin(), vc.end());
	
	for (int i = 0; i < vc.size(); i++) {
		cout << vc[i] << "\n";
	}

}