//旋转图像

//给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。 
//
// 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[[7,4,1],[8,5,2],[9,6,3]]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
// 
//
// 示例 3： 
//
// 
//输入：matrix = [[1]]
//输出：[[1]]
// 
//
// 示例 4： 
//
// 
//输入：matrix = [[1,2],[3,4]]
//输出：[[3,1],[4,2]]
// 
//
// 
//
// 提示： 
//
// 
// matrix.length == n 
// matrix[i].length == n 
// 1 <= n <= 20 
// -1000 <= matrix[i][j] <= 1000 
// 
// Related Topics 数组 
// 👍 876 👎 0


package cn.com.meguru.leetcode.editor.cn;

public class RotateImage {
    public static void main(String[] args) {
        RotateImage mainClass = new RotateImage();
        Solution solution = mainClass.new Solution();
        int[][] matrix = {{5,1,9,11}, {2,4,8,10}, {13,3,6,7}, {15,14,12,16}};
        solution.rotate(matrix);
        System.out.println();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void rotate(int[][] matrix) {
        int endIndex = matrix.length - 1;
        if (endIndex == 0) {
            return;
        }

        for (int i = 0; i <= endIndex / 2; i++) {
            int start = i, end = endIndex - i;
            Pair leftUp = new Pair(start, start), rightUp = new Pair(end, start),
                    rightDown = new Pair(end, end), leftDown = new Pair(start, end);
            for (int j = start; j < end; j++) {
                Pair cur = new Pair(j, start);
                int val = matrix[cur.y][cur.x];
                do {
                    val = switchNode(leftUp, rightUp, rightDown, leftDown, cur, matrix, start, end, val);
                } while (cur.x != j || cur.y != start);
            }


        }
    }

    private int switchNode(Pair leftUp, Pair rightUp, Pair rightDown, Pair leftDown, Pair cur, int[][] matrix, int start, int end, int val) {
        if (cur.y == leftUp.y) {
            for (int i = 0; i < end - start; i++) {
                if (cur.x < end) {
                    move(cur, "right");
                } else {
                    move(cur, "down");
                }
            }
        } else if (cur.x == rightUp.x) {
            for (int i = 0; i < end - start; i++) {
                if (cur.y < end) {
                    move(cur, "down");
                } else {
                    move(cur, "left");
                }
            }
        } else if (cur.y == rightDown.y) {
            for (int i = 0; i < end - start; i++) {
                if (cur.x > start) {
                    move(cur, "left");
                } else {
                    move(cur, "up");
                }
            }
        } else if (cur.x == leftDown.x) {
            for (int i = 0; i < end - start; i++) {
                if (cur.y > start) {
                    move(cur, "up");
                } else {
                    move(cur, "right");
                }
            }
        }

        int temp = matrix[cur.y][cur.x];
        matrix[cur.y][cur.x]= val;
        return temp;

    }

    private void move(Pair node, String direction) {
        switch (direction) {
            case "left" : {
                node.x = node.x - 1;
                break;
            }
            case "right" : {
                node.x = node.x + 1;
                break;
            }
            case "up" : {
                node.y = node.y - 1;
                break;
            }
            case "down" : {
                node.y = node.y + 1;
                break;
            }
        }
    }

    class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}