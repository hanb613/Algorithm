#include <iostream>
#include <algorithm>
#include <vector>
#include <cstring>
using namespace std;

int tc, n, num;
pair<int, int> score[101];

bool cmp(pair<int, int> a, pair<int, int> b) {
	if (a.first == b.first) {
		return a.second > b.second;
	}
	
	return a.first > b.first;
	
}

int main() {
	cin >> tc;
	for (int i = 1; i <= tc; i++) {
		memset(score, 0, sizeof(score));

		cin >> n;
		for (int i = 0; i < 1000; i++) {
			cin >> num;
			score[num].first++;
			score[num].second = num;
		}

		sort(score, score + 101, cmp);

		cout << "#" << i << " " << score[0].second << "\n";
	}
}