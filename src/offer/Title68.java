package offer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *              6
 *           2      8
 *        0   4   7   9
 *      3   5
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * 示例 2:
 * <p>
 * <p>
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 * <p>
 * <p>
 * 说明:
 * <p>
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉搜索树中。
 */
public class Title68 {
    public static void main(String[] args) {
        RealObject real = new RealObject();
        //替换掉了原来的方法
        Interface proxy = (Interface) Proxy.newProxyInstance(
                Interface.class.getClassLoader(), new Class[] {Interface.class},
                new DynamicProxyHandler(real));

        proxy.doSomething();
        proxy.somethingElse("luoxn28");
        proxy.walk();
    }


    public interface Interface {
        void doSomething();
        void somethingElse(String arg);
        void walk();
    }

    static class RealObject implements Interface {
        public void doSomething() {
            System.out.println("doSomething.");
        }
        public void somethingElse(String arg) {
            System.out.println("somethingElse " + arg);
        }

        @Override
        public void walk() {
            System.out.println("walkkk");
        }
    }

    static class DynamicProxyHandler implements InvocationHandler {
        private Object proxyed;

        public DynamicProxyHandler(Object proxyed) {
            this.proxyed = proxyed;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            System.out.println("代理工作了.");
            return method.invoke(proxyed, args);
        }
    }





    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        /**
         * p和q的公共根节点，一定比q大比p小，或比p大比q小
         * 如果p和q都小于根节点，遍历左子树
         * 如果p和q都大于根节点，遍历右子树
         */
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (p.val < root.val && q.val < root.val) {
                return lowestCommonAncestor(root.left, p, q);
            }
            if (p.val > root.val && q.val > root.val) {
                return lowestCommonAncestor(root.right, p, q);
            }
            return root;
        }
    }
}
