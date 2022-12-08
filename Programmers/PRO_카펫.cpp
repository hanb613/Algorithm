#include <string>
#include <vector>
#include <cmath>
#include <algorithm>

using namespace std;

vector<int> solution(int brown, int yellow) {
	vector<int> answer;
	int size = brown + yellow;

	for (int col = 1; col <= sqrt(yellow); col++) {
		int row = 1;
		if (yellow % col == 0) {
			row = yellow / col;
			if ((col + 2) * (row + 2) == size) {
				answer.push_back(row + 2);
				answer.push_back(col + 2);
			}
		}
	}

	return answer;
}