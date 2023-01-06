public class Main {

    /**
     * 17:03
     * wx
     * 要求程序对用户输入的字符串进行处理。具体规则如下：
     * a）把每个单词的首字母变为大写
     * b）把数字与字母之间用下划线字符（_）分开，使得更清晰
     * c）把单词中间有多个空格的调整为1个空格
     * 例如：
     * 用户输入：
     * you and me what    cpp2023program
     * 则程序输出：
     * You And Me What Cpp_2023_program
     *
     * 微派网络面试题
     */
    public static void main(String[] args) {
        Main main = new Main();
        String change = main.change("you and me what    cpp2023program");
        System.out.println(change);
    }

    public String change(String str) {
        boolean isSpace = false; // 是否是空格
        boolean isNumber = false; // 是否是数字
        boolean isChar = false; // 是否是字母
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'a' && c <= 'z') {
                if (i == 0) { // 第一个字母
                    result.append(String.valueOf(c).toUpperCase());
                    isChar = true;
                    isSpace = false;
                    isNumber = false;
                    continue;
                }
                if (str.charAt(i - 1) == ' ') { // 前一个是空格，当前是首字母
                    result.append(String.valueOf(c).toUpperCase());
                    isChar = true;
                    isSpace = false;
                    isNumber = false;
                    continue;
                }
                if (isNumber) { // 如果前一个是数字，加上下划线
                    result.append("_");
                }
                isChar = true;
                isSpace = false;
                isNumber = false;
                result.append(c);
                continue;
            }
            if (c == ' ') {
                if (!isSpace) {
                    result.append(' ');
                }
                isNumber = false;
                isSpace = true;
                isChar = false;
                continue;
            }
            if (c >= '0' && c <= '9') {
                if (isChar) { // 如果前一个是字母，加上下划线
                    result.append("_");
                }
                result.append(c);
                isSpace = false;
                isChar = false;
                isNumber = true;
            }
        }
        return result.toString();
    }
}
