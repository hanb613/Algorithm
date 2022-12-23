#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <algorithm>
#include <vector>
#include <string>
#include <string.h>
#include <math.h>
#include <stack>
using namespace std;
#pragma warning(disable:4996)

#define MAX 1000000000

typedef long long ll;

ll n, num, check, cnt;
string inp;
vector<string> oper;
vector<ll> nums;
stack <ll> st;

ll NUM(ll x) {
	st.push(x);
	return 0;
}

ll POP() {
	if (st.empty()) return 1;
	st.pop();
	return 0;
}

ll INV() {
	if (st.empty()) return 1;

	ll val = st.top();
	st.pop();
	st.push(-val);
	
	return 0;
}

ll DUP() {
	if (st.empty()) return 1;
	st.push(st.top());
	return 0;
}

ll SWP() {
	if (st.size() < 2) return 1;
	ll val = st.top();
	st.pop();

	ll val2 = st.top();
	st.pop();

	st.push(val);
	st.push(val2);
	return 0;
}

ll ADD() {
	if (st.size() < 2) return 1;
	ll val = st.top();
	st.pop();

	ll val2 = st.top();
	st.pop();

	st.push(val + val2);
	return 0;
}

ll SUB() {
	if (st.size() < 2) return 1;
	ll val = st.top();
	st.pop();

	ll val2 = st.top();
	st.pop();

	st.push(val2 - val);
	return 0;
}

ll MUL() {
	if (st.size() < 2) return 1;
	ll val = st.top();
	st.pop();

	ll val2 = st.top();
	st.pop();

	st.push(val2 * val);
	return 0;
}

ll DIV() {
	if (st.size() < 2) return 1;
	ll val = st.top();
	st.pop();

	ll val2 = st.top();
	st.pop();

	if (!val) return 1;
	ll result = llabs(val2) / llabs(val);
	if (val * val2 < 0) result *= -1;
	st.push(result);
	return 0;
}

ll MOD() {
	if (st.size() < 2) return 1;

	ll val = st.top();
	st.pop();

	ll val2 = st.top();
	st.pop();

	if (!val) return 1;
	ll result = llabs(val2) % llabs(val);
	if (val2 < 0) result *= -1;
	st.push(result);
	return 0;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	while (1) {
		nums.clear();
		oper.clear();
		check = 0;

		while (1) {
			cin >> inp;

			if (inp == "QUIT") return 0;
			if (inp == "END") break;
			if (inp == "NUM") {
				cin >> num;
				nums.push_back(num);
			}
			oper.push_back(inp);
		}

		cin >> n;

		while (n--) {
			cnt = 0;
			cin >> num;
			st.push(num);

			for (ll i = 0; i < oper.size(); ++i) {
				if (oper[i] == "NUM") check = NUM(nums[cnt++]);
				else if (oper[i] == "POP") check = POP();
				else if (oper[i] == "INV") check = INV();
				else if (oper[i] == "DUP") check = DUP();
				else if (oper[i] == "SWP") check = SWP();
				else if (oper[i] == "ADD") check = ADD();
				else if (oper[i] == "SUB") check = SUB();
				else if (oper[i] == "MUL") check = MUL();
				else if (oper[i] == "DIV") check = DIV();
				else if (oper[i] == "MOD") check = MOD();

				if (!st.empty() && (llabs(st.top()) > MAX)) check = 1;
				if (check) break;
			}

			if (check || st.size() != 1) cout << "ERROR\n";
			else cout << st.top() << "\n";

			while (!st.empty()) st.pop();
		}

		cout << "\n";
	}
}