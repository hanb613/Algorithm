#include <iostream>
#include <queue>
#include <string>
using namespace std;

int main() {
	queue<int> q;
	int n;
	cin >> n;

	for (int i = 0; i < n; i++) {
		string a;
		int x;
		cin >> a;
		if (a == "push") {
			cin >> x;
			q.push(x);
		}
		else if (a == "top") {
			if (q.size() == 0) cout << -1 << "\n";
			else cout << q.front() << "\n";
		}
		else if (a == "size")  cout << q.size() << "\n";
		else if (a == "empty") {
			if (q.empty()) cout << 1 << "\n";
			else cout << 0 << "\n";
		}
		else if (a == "pop") {
			if (q.size() == 0) cout << -1 << "\n";
			else {
				cout << q.front() << "\n";
				q.pop();
			}
		}
		else if (a == "front") {
			if (q.empty()) cout << -1 << "\n";
			else cout << q.front() << "\n";
		}
		else if (a == "back") {
			if (q.empty()) cout << -1 << "\n";
			else cout << q.back() << "\n";
		}
	}
}