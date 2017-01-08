package treeRecursive;

public class UniqueBinarySearchTree {

    /* G(n): the number of unique BST for a sequence of length n.
    *   F(i, n), 1 <= i <= n: the number of unique BST, where the number i is the root of BST, and the sequence ranges from 1 to n.
    *  For example, F(3, 7): the number of unique BST tree with number 3 as its root.
    *  To construct an unique BST out of the entire sequence [1, 2, 3, 4, 5, 6, 7] with 3 as the root,
    *  which is to say, we need to construct an unique BST out of its left subsequence [1, 2] and
    *  another BST out of the right subsequence [4, 5, 6, 7], and then combine them together (i.e. cartesian product).
    *  The tricky part is that we could consider the number of unique BST out of sequence [1,2] as G(2),
    *  and the number of of unique BST out of sequence [4, 5, 6, 7] as G(4). Therefore, F(3,7) = G(2) * G(4)
    *
    *  F(i, n) = G(i-1) * G(n-i)	1 <= i <= n
    *  G(n) = G(0) * G(n-1) + G(1) * G(n-2) + … + G(n-1) * G(0) /

    /* n = 2, f[2] = f[0]*f[1] + f[1]*f[0]
    *  n = 3, f[3] = f[0]*f[2] + f[1]*f[1] + f[2]*f[0] */
    public int numTrees(int n) {
        int[] f = new int[n + 1];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= i - 1; j++) {
                f[i] += f[j] * f[i - j - 1];
            }
        }
        return f[n];
    }

    public static void main(String[] args) {
        UniqueBinarySearchTree ubst = new UniqueBinarySearchTree();
        System.out.println(ubst.numTrees(3));
    }
}
