#include <string>
#include <vector>
#include <algorithm>
#include <map>
using namespace std;

bool solution(vector<string> phone_book) {
	bool answer = true;
	map<string, int> m;

	for (int i = 0; i < phone_book.size(); i++) {
		m[phone_book[i]] = 1;
	}

	for (int i = 0; i < phone_book.size(); i++) {
		string str = "";

		for (int j = 0; j < phone_book[i].size() - 1; j++) {
			str += phone_book[i][j];

			if (m.find(str) != m.end()) {
				return false;
			}
		}
	}

	return answer;
}