#define INT_MAX 2147483647
#define INT_MIN -2147483648

#include <iostream>

class Solution {
public:
    int reverse(int x) {
        int result = 0;
        while (x != 0)
        {
            if (result > INT_MAX / 10 || result < INT_MIN / 10)
            {
                return 0;
            }
            int a = x % 10;
            result = result * 10 + a;
            x = x / 10;
        }
        
        return result;        
    }
};

int main(int argc, char const *argv[])
{
    Solution* s = new Solution();
    int result = s->reverse(-2147483412);
    std::cout << result << std::endl;
    return 0;
}
