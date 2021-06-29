//打开转盘锁

//你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
// 。每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。 
//
// 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。 
//
// 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。 
//
// 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。 
//
// 
//
// 示例 1: 
//
// 
//输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
//输出：6
//解释：
//可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
//注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
//因为当拨动到 "0102" 时这个锁就会被锁定。
// 
//
// 示例 2: 
//
// 
//输入: deadends = ["8888"], target = "0009"
//输出：1
//解释：
//把最后一位反向旋转一次即可 "0000" -> "0009"。
// 
//
// 示例 3: 
//
// 
//输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], targ
//et = "8888"
//输出：-1
//解释：
//无法旋转到目标数字且不被锁定。
// 
//
// 示例 4: 
//
// 
//输入: deadends = ["0000"], target = "8888"
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= deadends.length <= 500 
// deadends[i].length == 4 
// target.length == 4 
// target 不在 deadends 之中 
// target 和 deadends[i] 仅由若干位数字组成 
// 
// Related Topics 广度优先搜索 数组 哈希表 字符串 
// 👍 301 👎 0


package cn.com.meguru.leetcode.editor.cn;

import java.util.*;

public class OpenTheLock {
    public static void main(String[] args) {
        OpenTheLock mainClass = new OpenTheLock();
        Solution solution = mainClass.new Solution();
        char c = Character.highSurrogate(4);
        System.out.println(c);

        solution.openLock(new String[]{"2111","2202","2210","0201","2210"}, "2201");
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int openLock(String[] deadends, String target) {
        this.target = target;
        this.deadends = new HashSet<>(List.of(deadends));
        if (this.deadends.contains("0000")) {
            return -1;
        }
        int time = 0;
        dq.add("0000");
        map.put("0000", 0);
        while (!dq.isEmpty()) {
            String head = dq.removeFirst();
            if (target.equals(head)) {
                return time;
            }
            char c1 = head.charAt(0), c2 = head.charAt(1), c3 = head.charAt(2), c4 = head.charAt(3);
            String s = null;
            if (open(map.get(head) + 1, s = String.valueOf(turnDown(c1)) + c2 + c3 + c4)) return map.get(s);
            if (open(map.get(head) + 1, s = String.valueOf(c1) + turnDown(c2) + c3 + c4)) return map.get(s);
            if (open(map.get(head) + 1, s = String.valueOf(c1) + c2 + turnDown(c3) + c4)) return map.get(s);
            if (open(map.get(head) + 1, s = String.valueOf(c1) + c2 + c3 + turnDown(c4))) return map.get(s);
            if (open(map.get(head) + 1, s = String.valueOf(turnUp(c1)) + c2 + c3 + c4)) return map.get(s);
            if (open(map.get(head) + 1, s = String.valueOf(c1) + turnUp(c2) + c3 + c4)) return map.get(s);
            if (open(map.get(head) + 1, s = String.valueOf(c1) + c2 + turnUp(c3) + c4)) return map.get(s);
            if (open(map.get(head) + 1, s = String.valueOf(c1) + c2 + c3 + turnUp(c4))) return map.get(s);
        }
        return -1;
    }

    private boolean open(Integer time, String s) {
        if (s.equals("0202")) {
            System.out.println();
        }
        if (!map.containsKey(s) && !this.deadends.contains(s)) {
            map.put(s, time);
            dq.addLast(s);
            if (target.equals(s)) {
                return true;
            }
        }
        return false;
    }

    Deque<String> dq = new LinkedList<>();
    Map<String, Integer> map = new HashMap<>();

    public int openLock1(String[] deadends, String target) {
        this.deadends = Set.of(deadends);
        this.target = target;
        openLock(0, 0, 0, 0, 0);
        return memo[Integer.parseInt(String.valueOf(target.charAt(0)))][Integer.parseInt(String.valueOf(target.charAt(1)))][Integer.parseInt(String.valueOf(target.charAt(2)))][Integer.parseInt(String.valueOf(target.charAt(3)))];
    }

    //StackOverflowError 求最小旋转次数，应该用BFS，DFS遍历次数太多
    private void openLock(int i1, int i2, int i3, int i4, int time) {
        if (memo[i1][i2][i3][i4] != null && (memo[i1][i2][i3][i4] == -1 || memo[i1][i2][i3][i4] <= time)) {
            return;
        }
        String s = String.valueOf(i1) + i2 + i3 + i4;
        if (deadends.contains(s)) {
            memo[i1][i2][i3][i4] = -1;
            return;
        }
        memo[i1][i2][i3][i4] = time;

        openLock(turnUp(i1), i2, i3, i4, time + 1);
        openLock(i1, turnUp(i2), i3, i4, time + 1);
        openLock(i1, i2, turnUp(i3), i4, time + 1);
        openLock(i1, i2, i3, turnUp(i4), time + 1);
        openLock(turnDown(i1), i2, i3, i4, time + 1);
        openLock(i1, turnDown(i2), i3, i4, time + 1);
        openLock(i1, i2, turnDown(i3), i4, time + 1);
        openLock(i1, i2, i3, turnDown(i4), time + 1);
    }

    Integer[][][][] memo = new Integer[10][10][10][10];
    Set<String> deadends = null;
    String target = null;

    private char turnUp(char c) {
        int i = Integer.parseInt(String.valueOf(c));
        int i1 = (i + 1) % 10;
        return Character.forDigit(i1, 10);
    }

    private char turnDown(char c) {
        int i = Integer.parseInt(String.valueOf(c));
        int i2 = (i - 1) % 10;
        if (i2 == -1) {
            return Character.forDigit(9, 10);
        }
        return Character.forDigit(i2, 10);
    }

    private int turnUp(int i) {
        return (i + 1) % 10;
    }

    private int turnDown(int i) {
        int i2 = (i - 1) % 10;
        if (i == -1) {
            return 9;
        }
        return i2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}