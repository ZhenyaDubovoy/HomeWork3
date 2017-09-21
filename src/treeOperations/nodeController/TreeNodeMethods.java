package treeOperations.nodeController;

import treeOperations.Node;

import java.util.List;


/**
 * Created by Евгений Дубовой on 19.09.2017.
 */
public class TreeNodeMethods {

    public static Node newTree(){
        Node head = new Node(7);
        Node node1 = new Node(6, head);
        Node node2 = new Node(8, head);
        Node node3 = new Node(10, head);

        head.children.add(node1);
        head.children.add(node2);
        head.children.add(node3);

        Node node4 = new Node(7, node1);
        Node node5 = new Node(9, node1);

        node1.children.add(node4);
        node1.children.add(node5);

        Node node6 = new Node(4, node2);
        Node node7 = new Node(8, node2);
        Node node8 = new Node(9, node2);

        node2.children.add(node6);
        node2.children.add(node7);
        node2.children.add(node8);

        Node node9 = new Node(9, node3);
        Node node10 = new Node(8, node3);
        Node node11 = new Node(7, node3);

        node3.children.add(node9);
        node3.children.add(node10);
        node3.children.add(node11);

        return head;

    }

    public static int sumAll(Node head){
        if (head.children.isEmpty()){
            return head.value;
        }
        int sum = 0;
        for (Node child:head.children) {
            sum += sumAll(child);
        }
        return head.value + sum;
    }

    public static Node findMin(Node head){
        if(head.children.isEmpty()){
            return head;
        }
        int min = head.value;
        Node res = head;
        for (Node child: head.children) {
            if (findMin(child).value< min){
                min = findMin(child).value;
                res = findMin(child);
            }
        }
        return res;
    }

    public static Node findMax(Node head){
        if(head.children.isEmpty()){
            return head;
        }
        int max = head.value;
        Node res = head;
        for (Node child: head.children) {
            if (findMax(child).value> max){
                max = findMax(child).value;
                res = findMax(child);
            }
        }
        return res;
    }

    public static String printTree(Node head){
        if(head.children.isEmpty()){
            return Integer.toString(head.value);
        }
        String res = Integer.toString(head.value) ;
        for (Node child: head.children) {
            res+="\t"+printTree(child);
        }
        System.out.println();
        return res;
    }

    public static Node MinMaxSwap(Node head){
        Node min = findMin(head);
        Node max = findMax(head);

        if (min.father!=null && max.father!=null){
            min.father.children.set(min.father.children.indexOf(min), max);
        }
        else if (min.father == null){
            Node maxClone = new Node(max);
            head = maxClone;
            head.father = null;
            head.children = min.children;
            for (Node child : head.children) {
                child.father = head;
            }
            max.father.children.set(max.father.children.indexOf(max), min);
            min.children = max.children;
            return head;
        }

        if (max.father!=null){
            max.father.children.set(max.father.children.indexOf(max), min);
        }
        else{
            Node minClone = new Node(min);
            head = minClone;
            head.father = null;
            head.children = max.children;
            for (Node child : head.children) {
                child.father = head;
            }
            min.father.children.set(min.father.children.indexOf(min), max);
            max.children = min.children;
            return head;
        }


        List<Node> tempMinChild = min.children;
        min.children = max.children;
        max.children = tempMinChild;

        return head;

    }

    public static void swap(Object o1, Object o2){
        Object temp = o1;
        o1 = o2;
        o2 = temp;
    }
}
