#include <string>
#include <algorithm>
#include <iostream>
using namespace std;

class Solution {
public:
    string addBinary(string a, string b) {
        string result = "";
        int carry = 0;
        int num = max(a.size(), b.size());
        for (int i = 0; i < num; i++)
        {
            carry += i < a.size() ? (a.at(a.size() - i - 1) == '1') : 0;
            carry += i < b.size() ? (b.at(b.size() - i - 1) == '1') : 0;
            result.push_back(carry % 2 == 0 ? '0' : '1');
            carry /= 2;
        }
        if (carry > 0)
        {
            result.push_back('1');
        }
        reverse(result.begin(), result.end());
        return result;
    }
};

int main(int argc, char const *argv[])
{
    Solution* s = new Solution();
    string result = s->addBinary("11", "1");
    printf("%s", result.c_str());
    return 0;
}
