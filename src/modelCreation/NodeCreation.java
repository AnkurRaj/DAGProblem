package modelCreation;

import java.util.LinkedList;

public class NodeCreation {


    private int value;

    private int degreeOfNode;

    private LinkedList<NodeCreation> childList;

    public NodeCreation(int value) {
        this.value = value;
        this.degreeOfNode = 0;
        this.childList = new LinkedList<>();
    }

    public int getValue() {
        return value;
    }



    public int getDegreeOfNode() {
        return degreeOfNode;
    }

    public void setDegreeOfNode(int degreeOfNode) {
        this.degreeOfNode = degreeOfNode;
    }

    public LinkedList<NodeCreation> getChildList() {
        return childList;
    }



}
