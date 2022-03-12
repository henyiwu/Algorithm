#include<iostream>
#include<string>
#include<map>
using namespace std;

/*
给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: s = "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
*/


class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int result = 0;
        int start = 0;
        map<char, int> cache;
        for (int i = 0; i < s.length(); i++)
        {
            if (cache.count(s[i]))
            {
                start = max(cache[s[i]]+1, start);                
            }
            cache[s[i]] = i;
            result = max(i - start + 1, result);
        }
        return result;
    }
};

int main(int argc, char const *argv[])
{
    Solution* s = new Solution();
    s->lengthOfLongestSubstring("222");
    return 0;
}
