#include <iostream>

class Solution {
public:
    bool isPalindrome(int x) {
       if (x < 0 || (x % 10 == 0 && x != 0))
       {
           return false;
       }
       int reverse = 0;
       while (x > reverse)
       {
           // 12321
           // 1232
           // 1

           // 123
           // 12

           // 12
           // 123
           reverse = x % 10 + reverse * 10;
           x = x / 10;
       }
       if (reverse == x || reverse / 10 == x)
       {
           return true;
       }
       return false;
    }
};

int main(int argc, char const *argv[])
{
    Solution* s = new Solution();
    std::cout << s->isPalindrome(12321)<< std::endl;
    return 0;
}
