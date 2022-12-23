#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#include <string.h>
#include <math.h>
#include <queue>
#include <tuple>
using namespace std;

typedef long long int lli;
int n, m;
int cnt;
vector<lli> arr;
vector<lli> prime;

void primeNumber(int n) {
	for (int i = 2; i <= n; i++) {
		arr[i] = i;
	}

	for (int i = 2; i <= n; i++) {
		if (arr[i] == 0) continue;

		for (int j = 2 * i; j <= n; j += i) {
			arr[j] = 0;
		}
	}
	for (int i = 2; i <= n; i++) {
		if (arr[i] != 0) prime.push_back(arr[i]);
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	arr.assign(n + 2, 0);
	primeNumber(n);

	int start = 0, end = 0;
	lli sum = 0;

	while (1) {
		if (sum >= n) {
			sum -= prime[start++];
		}
		else if (end == prime.size()) break;
		else {
			sum += prime[end++];
		}
		if (sum == n) cnt++;
	}
	cout << cnt;

}