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

string str, temp;
int result;
bool check;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> str;

	for (int i = 0; i <= str.length(); i++) {
		if (str[i] == '+' || str[i] == '-' || i == str.length()) {
			if (check) {
				result -= stoi(temp);	
			}
			else {
				result += stoi(temp);
			}
			temp = "";
		}
		else {
			temp += str[i];
		}
		if (str[i] == '-') {
			check = true;
		}
	}

	cout << result;
}