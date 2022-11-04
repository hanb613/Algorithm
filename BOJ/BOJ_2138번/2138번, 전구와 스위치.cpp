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
int result = 1, result2;
string original, make;

void turn (int index) {
	if (original[index] == '0') {
		original[index] = '1';
	}
	else original[index] = '0';

	if (index != 0) {
		if (original[index - 1] == '0') {
			original[index - 1] = '1';
		}
		else original[index - 1] = '0';
	}

	if (index != n - 1) {
		if (original[index + 1] == '0') {
			original[index + 1] = '1';
		}
		else original[index + 1] = '0';
	}

}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> original >> make;
	
	string tmp = original;

	// 0번째 스위치 누른 경우
	turn(0);
	for (int i = 1; i < n; i++) {
		if (original[i - 1] != make[i - 1]) {
			turn(i);
			result++;
		}
	}

	if (original != make) result = -1;

	// 0번째 스위치 누르지 않은 경우
	original = tmp;
	for (int i = 1; i < n; i++) {
		if (original[i - 1] != make[i - 1]) {
			turn(i);
			result2++;
		}
	}
	if (original != make) result2 = -1;

	if (result == -1) cout << result2;
	else if (result2 == -1) cout << result;
	else cout << min(result, result2);
}