package modelCreation;

import java.util.LinkedList;

public class GraphCreation {

    private LinkedList<TreeCreation> rootList;

    public GraphCreation() {
        this.rootList = new LinkedList<>();
    }

    public LinkedList<TreeCreation> getRootList() {
        return rootList;
    }
}