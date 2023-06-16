#include <string>
#include <vector>
#include <algorithm>
#include <math.h>
using namespace std;

bool prime(int num) {
	if (num < 2) {
		return false;
	}
	for (int i = 2; i <= sqrt(num); i++) {
		if (num % i == 0) {
			return false;
		}
	}
	return true;
}

int solution(string numbers) {
	int answer = 0;

	vector<char> c;
	vector<int> num;

	for (int i = 0; i < numbers.size(); i++) {
		c.push_back(numbers[i]);
	}

	sort(c.begin(), c.end());

	do {
		string tmp = "";
		for (int i = 0; i < c.size(); i++) {
			tmp += c[i];
			num.push_back(stoi(tmp));
		}
	} while (next_permutation(c.begin(), c.end()));

	sort(num.begin(), num.end());
	num.erase(unique(num.begin(), num.end()), num.end());

	for (int i = 0; i < num.size(); i++) {
		if (prime(num[i])) answer++;
	}

	return answer;
}