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

#define MAX 1000000

int n;
int prime[MAX];

void Prime() {
	for (int i = 2; i*i <= MAX; i++) {
		for (int j = i * i; j <= MAX; j += i) {
			if (prime[j] == 1) continue;
			prime[j] = 1;
		}
	}
}

int main() {

	Prime();

	while (1) {
		int check = 0;

		scanf("%d", &n);
		if (n == 0) break;

		for (int i = 3; i <= n; i += 2) {
			if (prime[i] == 0 && prime[n - i] == 0) {
				printf("%d = %d + %d\n", n, i, n - i);
				check = 1; break;
			}
		}

		if (check == 0) printf("Goldbach's conjecture is wrong.\n");
	}
}