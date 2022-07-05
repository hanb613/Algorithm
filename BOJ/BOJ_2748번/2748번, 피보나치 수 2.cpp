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
int arr[91];

int f(int k) {
	if (arr[k] != 0) return arr[k];

	arr[k] = f(k - 1) + f(k - 2);

	return arr[k];
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	cin >> n;
	
	arr[1] = 1;
	arr[2] = 1;

	cout << f(n);

}