#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int a[5] = { 1, 2, 3, 4, 5 };
int b[8] = { 2, 1, 2, 3, 2, 4, 2, 5 };
int c[10] = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

vector<int> solution(vector<int> answers) {
	vector<int> answer;
	int score[3] = { 0,0,0 };
	int maxScore = 0;

	for (int i = 0; i < answers.size(); i++) {
		if (answers[i] == a[i % 5]) score[0] += 1;
		if (answers[i] == b[i % 8]) score[1] += 1;
		if (answers[i] == c[i % 10]) score[2] += 1;
	}

	maxScore = max(max(score[0], score[1]), score[2]);

	for (int i = 0; i < 3; i++) {
		if (score[i] == maxScore) answer.push_back(i + 1);
	}

	return answer;
}