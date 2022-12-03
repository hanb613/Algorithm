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

lli n;
lli arr[100001]; // 도로 길이
lli arr2[100001]; // 리터 당 가격
lli result;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	for (int i = 0; i < n - 1; i++) { 
		cin >> arr[i]; 
	} 

	for (int i = 0; i < n; i++) {
		cin >> arr2[i];
	}

	lli temp = arr2[0];
	for (int i = 0; i < n - 1; i++) {
		if (temp > arr2[i]) temp = arr2[i];
		result += (temp * arr[i]);
	}

	cout << result;
}