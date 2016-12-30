package heap;

import java.util.*;

public class TheSkylineProblem {

    class Edge {
        int x;
        int h;
        Edge(int x, int h) {
            this.x = x;
            this.h = h;
        }
    }

    private Comparator<Edge> comparator = new Comparator<Edge>() {
        @Override
        public int compare(Edge dot1, Edge dot2) {// x <, h <
            return dot1.x != dot2.x ? dot1.x - dot2.x : dot1.h - dot2.h;
        }
    };

    /** [Li, Ri, Hi]*/
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        if (buildings == null || buildings.length == 0 || buildings[0].length == 0) {
            return result;
        }

        // (1, -2), (2, -3), (3, 2), (4, 3), (5, -2), (6, 2)
        List<Edge> edgeList = new ArrayList<>();
        for (int[] building : buildings) {
            edgeList.add(new Edge(building[0], -building[2]));// left, -height
            edgeList.add(new Edge(building[1], building[2]));// right, height
        }
        Collections.sort(edgeList, comparator);

        /** Ascend: left skyline dot, Descend: right skyline dot. Use prev, curr to find Ascend or Descend */
        PriorityQueue<Integer> pq = new PriorityQueue<>(edgeList.size(), Collections.reverseOrder());// maxheap
        pq.offer(0);
        int prevHeight = 0, currHeight = 0;
        for (Edge edge : edgeList) {
            if (edge.h < 0) {// left
                pq.offer(-edge.h);// [0, 2, 3]
            } else {
                pq.remove(edge.h);// [0]
            }
            currHeight = pq.peek();// 2, 3, 2, 0
            if (currHeight != prevHeight) {// Ascend or Descend
                result.add(new int[] { edge.x, currHeight });// [1, 2], [2, 3]
                prevHeight = currHeight;// 2, 3
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TheSkylineProblem tsp = new TheSkylineProblem();
        int[][] buildings = {
            {1, 3, 2},
            {2, 4, 3},
            {5, 6, 2}
        };
        List<int[]> result = tsp.getSkyline(buildings);
        for (int[] edge : result) {
            System.out.print("[" + edge[0] + ", " + edge[1] + "], ");
        }
    }

    /*
    * (1) 自建一个名为Height的数据结构，保存一个building的index和height。约定，当height为负数时表示这个高度为height的building起始于
    *     index；height为正时表示这个高度为height的building终止于index。

      (2) 对building数组进行处理，每一行[ Li, Ri, Hi ]，根据Height的定义，转换为两个Height的对象，即，Height(Li, -Hi) 和
          Height(Ri, Hi)。 将这两个对象存入heights这个List中。

      (3) 写个Comparator对heights进行升序排序，首先按照index的大小排序，若index相等，则按height大小排序，
          以保证一栋建筑物的起始节点一定在终止节点之前。

      (4) 将heights转换为结果。使用PriorityQueue对高度值进行暂存。遍历heights，遇到高度为负值的对象时，表示建筑物的起始节点，
          此时应将这个高度加入PriorityQueue。遇到高度为正值的对象时，表示建筑物的终止节点，此时应将这个高度从PriorityQueue中除去。
          且在遍历的过程中检查，当前的PriorityQueue的peek()是否与上一个iteration的peek()值（prev）相同，
          若否，则应在结果中加入[当前对象的index, 当前PriorityQueue的peek()]，并更新prev的值。
    * */
}
