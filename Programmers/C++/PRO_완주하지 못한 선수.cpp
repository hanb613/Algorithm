#include <string>
#include <algorithm>
#include <vector>
#include <map>

using namespace std;

string solution(vector<string> participant, vector<string> completion) {
	string answer = "";
	map<string, int> mp;

	for (int i = 0; i < participant.size(); i++) {
		if (mp.find(participant[i]) != mp.end()) {
			mp[participant[i]]++;
		}
		else mp[participant[i]] = 1;
	}

	for (int i = 0; i < completion.size(); i++) {
		mp[completion[i]]--;
	}

	for (int i = 0; i < participant.size(); i++) {
		if (mp[participant[i]] != 0) {
			return participant[i];
		}
	}

	return answer;
}