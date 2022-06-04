package offer;

/**
 * 替换空格
 * 请实现一个函数，把字符串中的每个空格替换成%20，例如：输入:"We are happy"，输出"We%20are%20happy"
 */
public class Title5 {

    public static void main(String[] args) {

    }
}

class Solution {
    /**
     * 空格：%20
     *
     * @param s
     * @return
     */
    public String replaceSpace(String s) {
        char[] c = new char[s.length() * 3];
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                c[index++] = '%';
                c[index++] = '2';
                c[index++] = '0';
            } else {
                c[index++] = s.charAt(i);
            }
        }
        return new String(c, 0, index);
    }
}