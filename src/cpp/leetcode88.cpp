#include <vector>
#include <iostream>
using namespace std;



int main(int argc, char const *argv[])
{
    Solution* solution = new Solution();
    vector<int> v1;
    v1.push_back(1);
    v1.push_back(2);
    v1.push_back(3);
    v1.push_back(0);
    v1.push_back(0);
    v1.push_back(0);
    vector<int> v2;
    v2.push_back(2);
    v2.push_back(5);
    v2.push_back(6);
    solution->merge(v1, 3, v2, 3);
    return 0;
}
