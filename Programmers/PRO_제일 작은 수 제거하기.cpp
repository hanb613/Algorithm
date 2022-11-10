#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> arr) {
	vector<int> answer;
	vector<int> tmp = arr;

	if (arr.size() == 1) {
		answer.push_back(-1);
	}
	else {
		sort(tmp.begin(), tmp.end());
		for (int i = 0; i < arr.size(); i++) {
			if (tmp[0] != arr[i])
				answer.push_back(arr[i]);
		}

		/*
		arr.erase(min_element(arr.begin(), arr.end()));
		answer = arr;
		*/
	}

	return answer;
}