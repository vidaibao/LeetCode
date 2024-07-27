package BreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

public class Bfs {
    public static void main(String[] args) {
        //SameTree_100();
        SymmetricTree_101();


    }

    private static void SymmetricTree_101() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2, new TreeNode(3), new TreeNode(4));
        root.right = new TreeNode(2, new TreeNode(4), new TreeNode(3));
        System.out.println(isSymmetric(root));
    }
    static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        return isMirror(root.left, root.right);
    }

    private static boolean isMirror(TreeNode t1, TreeNode t2) {
        // Base case
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return t1.val == t2.val
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }


    //Given the roots of two binary trees p and q, write a function to check if they are the same or not.
    //
    //Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
    private static void SameTree_100() {
        TreeNode p = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode q = new TreeNode(1, new TreeNode(2), new TreeNode(3));

    }
    static boolean isSameTree(TreeNode p, TreeNode q) {
        // Base case
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        // Compare current node values and recursively compare left and right subtrees
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
/*
* Breadth-First Search (BFS) là một thuật toán tìm kiếm được sử dụng trong đồ thị (graph) và cây (tree).
*  BFS tìm kiếm theo chiều rộng, tức là nó khám phá tất cả các đỉnh (hoặc nút) ở cùng một mức độ
* trước khi chuyển sang các đỉnh ở mức độ tiếp theo.
* Thuật toán này rất hữu ích cho các bài toán tìm đường ngắn nhất trên đồ thị không trọng số.

Cách Hoạt Động của BFS
Khởi Tạo:

Bắt đầu từ một đỉnh gốc (source).
Đặt tất cả các đỉnh vào trạng thái chưa được khám phá (unvisited).

* Hàng Đợi (Queue):
Sử dụng một hàng đợi để theo dõi các đỉnh sẽ được khám phá.
Đỉnh gốc được thêm vào hàng đợi và đánh dấu là đã khám phá (visited).

* Khám Phá:
Lặp lại quá trình sau cho đến khi hàng đợi trống:
Lấy đỉnh đầu tiên ra khỏi hàng đợi.
Khám phá tất cả các đỉnh kề (neighbor) chưa được khám phá của đỉnh này.
Đánh dấu các đỉnh kề này là đã khám phá và thêm chúng vào hàng đợi.

* Kết Thúc:
Khi hàng đợi trống, tức là tất cả các đỉnh có thể tiếp cận từ đỉnh gốc đã được khám phá.

* Đặc Điểm của BFS
BFS đảm bảo tìm thấy đường đi ngắn nhất từ đỉnh gốc đến đỉnh đích trong một đồ thị không trọng số.
BFS có độ phức tạp thời gian là O(V+E), trong đó 𝑉 là số lượng đỉnh và E là số lượng cạnh.
BFS sử dụng không gian bộ nhớ là 𝑂(𝑉), vì cần lưu trữ trạng thái của mỗi đỉnh.

* Ứng Dụng của BFS
Tìm đường đi ngắn nhất trong đồ thị không trọng số.
Kiểm tra tính liên thông của đồ thị.
Tìm tất cả các thành phần liên thông trong đồ thị.
Sử dụng trong nhiều bài toán như xác định chu kỳ, tìm cây bao trùm tối thiểu (minimum spanning tree),
* và nhiều bài toán trên mạng xã hội, bản đồ, vv.
*
* */