package treeOperations.testTree;

import sun.reflect.generics.tree.Tree;
import treeOperations.Node;
import treeOperations.nodeController.TreeNodeMethods;

/**
 * Created by Евгений Дубовой on 19.09.2017.
 */
public class TestTree {
    public static void main(String[] args) {
        Node head = TreeNodeMethods.newTree();
        int sum = TreeNodeMethods.sumAll(head);
        System.out.println(sum);
        System.out.println(TreeNodeMethods.findMin(head).value);
        System.out.println(TreeNodeMethods.findMax(head).value);
        System.out.print(TreeNodeMethods.printTree(head));
        Node newHead = TreeNodeMethods.MinMaxSwap(head);
        System.out.println(TreeNodeMethods.printTree(newHead));
        Node newHead1 = TreeNodeMethods.MinMaxSwap(newHead);
        System.out.println(TreeNodeMethods.printTree(newHead1));
        return;
    }
}
