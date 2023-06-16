#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool cmp(string a, string b) {
	if (a.size() == b.size()) return a > b;
	else return a + b > b + a;
}

string solution(vector<int> numbers) {
	string answer = "";
	vector<string> str[10];

	for (int i = 0; i < numbers.size(); i++) {
		string c = to_string(numbers[i]);
		int index = c.front() - '0';
		str[index].push_back(c);
	}

	for (int i = 0; i < 10; i++) {
		if (str[i].size() != 0) {
			sort(str[i].begin(), str[i].end(), cmp);
		}
	}

	for (int i = 9; i >= 0; i--) {
		if (str[i].size() != 0) {
			for (int j = 0; j < str[i].size(); j++) {
				answer += str[i][j];
			}
		}
	}

	if (answer.front() == '0') answer = "0";

	return answer;
}