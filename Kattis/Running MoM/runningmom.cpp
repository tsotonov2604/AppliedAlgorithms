#include <bits/stdc++.h>
using namespace std;

unordered_map<string, vector<string>> AL; 
unordered_map<string, int> status;
bool back_edge;

void dfs(string city) {
  status[city] = 1; 
  for (auto &neighbor : AL[city]) {
    if (status[neighbor] == 0) 
      dfs(neighbor);
    else if (status[neighbor] == 1) { 
      back_edge = true;
    }
  }
  status[city] = 2; 
}

int main() {
  int n;
  string start, finish;
  cin >> n; cin.get(); 
  while (n--) {
    cin >> start >> finish;
    AL[start].push_back(finish); 
  }
  while (cin >> start, !cin.eof()) {
    back_edge = false;
    for (auto &city : AL) 
      status[city.first] = 0; 
    dfs(start);
    cout << start;
    cout << (back_edge ? " safe\n" : " trapped\n"); 
  }
  return 0;
}