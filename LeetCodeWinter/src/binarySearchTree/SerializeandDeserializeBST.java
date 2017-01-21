package binarySearchTree;

public class SerializeandDeserializeBST {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            return "";
        }
        preorderSerialize(root, sb);
        return sb.toString();
    }

    private void preorderSerialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("# ");
            return;
        }
        sb.append(root.val).append(" ");
        preorderSerialize(root.left, sb);
        preorderSerialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        String[] num = data.split(" ");
        int[] index = new int[1];
        return preorderDeserialize(num, index);
    }

    private TreeNode preorderDeserialize(String[] num, int[] index) {
        if (num[index[0]].equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(num[index[0]]));
        index[0]++;
        root.left = preorderDeserialize(num, index);
        index[0]++;
        root.right = preorderDeserialize(num, index);
        return root;
    }

    public static void main(String[] args) {
        SerializeandDeserializeBST sdl = new SerializeandDeserializeBST();
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        String encode = sdl.serialize(node1);
        System.out.println(encode);
        TreeNode decode = sdl.deserialize(encode);
        System.out.println(sdl.serialize(decode));
    }
}
