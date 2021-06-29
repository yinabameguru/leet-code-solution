//Excel表列名称

//给定一个正整数，返回它在 Excel 表中相对应的列名称。 
//
// 例如， 
//
//     1 -> A
//    2 -> B
//    3 -> C
//    ...
//    26 -> Z
//    27 -> AA
//    28 -> AB 
//    ...
// 
//
// 示例 1: 
//
// 输入: 1
//输出: "A"
// 
//
// 示例 2: 
//
// 输入: 28
//输出: "AB"
// 
//
// 示例 3: 
//
// 输入: 701
//输出: "ZY"
// 
// Related Topics 数学 字符串 
// 👍 391 👎 0


package cn.com.meguru.leetcode.editor.cn;

public class ExcelSheetColumnTitle {
    public static void main(String[] args) {
        ExcelSheetColumnTitle mainClass = new ExcelSheetColumnTitle();
        Solution solution = mainClass.new Solution();
        System.out.println((int) 'A' + " " + (int) 'Z');

        System.out.println( 65);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        while (columnNumber != 0) {
            int r1 = (columnNumber - 1) % 26;
            String c = String.valueOf((char) (r1 + 65));
            stringBuilder.insert(0, c);
            columnNumber = (columnNumber - 1) / 26;
        }
        return stringBuilder.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}