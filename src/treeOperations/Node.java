package treeOperations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Евгений Дубовой on 18.09.2017.
 */
public class Node {
    public int value;
    public List<Node> children;
    public Node father;

    public Node(Node other){
        this(other.value, other.children, other.father);
    }

    public Node() {
    }

    public Node(int value) {
        this.value = value;
        children = new ArrayList<Node>();
    }

    public Node(int value, Node father) {
        this.value = value;
        this.father = father;
        children = new ArrayList<Node>();
    }

    public Node(int value, List<Node> children, Node father) {
        this.value = value;
        this.children = children;
        this.father = father;
    }
}
