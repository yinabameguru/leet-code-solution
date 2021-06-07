//课程表

//你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。 
//
// 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表
//示如果要学习课程 ai 则 必须 先学习课程 bi 。 
//
// 
// 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。 
// 
//
// 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0]]
//输出：true
//解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。 
//
// 示例 2： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
//输出：false
//解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。 
//
// 
//
// 提示： 
//
// 
// 1 <= numCourses <= 105 
// 0 <= prerequisites.length <= 5000 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// prerequisites[i] 中的所有课程对 互不相同 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 
// 👍 835 👎 0


package cn.com.meguru.leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

public class CourseSchedule {
    public static void main(String[] args) {
        CourseSchedule mainClass = new CourseSchedule();
        Solution solution = mainClass.new Solution();
        solution.canFinish(2, new int[][]{{1, 0}});
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Graph graph = new Graph();
        for (int[] prerequisite : prerequisites) {
            graph.addVector(prerequisite[0]);
            graph.addVector(prerequisite[1]);
        }
        for (int[] prerequisite : prerequisites) {
            graph.addNode(prerequisite[0], prerequisite[1]);
        }
        List<GraphVector> entrances = graph.vectors.values().stream()
                .filter(graphVector -> graphVector.indegree == 0)
                .collect(Collectors.toList());
        while (entrances.size() > 0) {
            GraphVector vector = entrances.remove(0);
            graph.vectors.remove(vector.val);
            GraphNode node = vector.node;
            while (node != null) {
                GraphVector outVector = graph.vectors.get(node.val);
                outVector.indegree = outVector.indegree - 1;
                if (outVector.indegree == 0) {
                    entrances.add(outVector);
                }
                node = node.next;
            }
        }
        return graph.vectors.size() == 0;
    }

    class Graph {
        Map<Integer, GraphVector> vectors = new HashMap<>();
        void addVector(Integer i) {
            GraphVector graphVector = vectors.get(i);
            if (graphVector != null) {
                return;
            }
            vectors.put(i, new GraphVector(i));
        }

        void addNode(int vector, int val) {
            GraphNode graphNode = new GraphNode(val);
            GraphVector graphVector = vectors.get(vector);
            graphNode.next = graphVector.node;
            graphVector.node = graphNode;
            GraphVector outVector = vectors.get(val);
            outVector.indegree = outVector.indegree + 1;
        }
    }

    class GraphVector {
        int val;
        int indegree = 0;
        GraphNode node;

        public GraphVector(int val) {
            this.val = val;
        }
    }

    class GraphNode {
        int val;
        GraphNode next;

        public GraphNode(int val) {
            this.val = val;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}