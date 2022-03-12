#include <vector>
#include <iostream>
using namespace std;

class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        for (int i = digits.size()-1; i >= 0; i--)
        {
            digits[i] = (digits[i] + 1) % 10;
            cout<<i<<endl;
            if (digits[i] != 0)
            {
                return digits;
            }
        }
        vector<int> result(digits.size() + 1);
        result[0] = 1;
        return result;
    }
};

int main(int argc, char const *argv[])
{
    Solution* s = new Solution();
    vector<int> vector;
    vector.push_back(1);
    vector.push_back(2);
    vector.push_back(3);
    s->plusOne(vector);
    return 0;
}


