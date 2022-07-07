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

int n1, m1;
int n2, m2;
int gcd, A, B;

int GCD(int a, int b) {
	if (b == 0) return a;
	return GCD(b, a%b);
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	cin >> n1 >> m1;
	cin >> n2 >> m2;

	A = (n1 * m2) + (n2 * m1);
	B = (m1 * m2);
	gcd = GCD(A, B);

	cout << A / gcd << " " << B / gcd;
}