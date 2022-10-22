#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>
using namespace std;

int n;
double  sum;
vector<int> vc;
pair <int, int> arr[8001];

bool compare(pair<int, int> a, pair<int, int> b) {
	if (a.first > b.first) return true;
	else if (a.first == b.first) return a.second < b.second;
	return false;
}

int check(int k) {
	if (k == -0) return 0;
	else return k;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;

	int num;
	for (int i = 0; i < n; i++) {
		cin >> num;
		vc.push_back(num);
		sum += num;

		if (num < 0) {
			arr[4000 + abs(num)].first += 1;
			arr[4000 + abs(num)].second = num;
		}
		else {
			arr[num].first += 1;
			arr[num].second = num;
		}
	}

	sort(vc.begin(), vc.end());
	sort(arr, arr + 8001, compare);

	
	cout << check(round((double)sum / n)) << "\n";
	cout << check(vc[n / 2]) << "\n";
	
	if (n == 1) cout << arr[0].second << "\n";
	else {
		if (arr[0].first > arr[1].first) cout << arr[0].second << "\n";
		else {
			cout << arr[1].second << "\n";
		}
	}
	cout << vc[n - 1] - vc[0] << "\n";

	return 0;
}