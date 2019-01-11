package modelCreation;

public class TreeCreation {
    private static final int maxSize = 1000;
    private NodeCreation root;

    public TreeCreation(NodeCreation root) {
        this.root = root;
    }

    public NodeCreation getRoot() {

        return root;
    }

    public void printPaths(NodeCreation node) {
        int[] path = new int[maxSize];
        printPathsOfNode(node, path, 0);
    }

    private boolean isLeafNode(NodeCreation node) {
        return (node.getChildList().size() ==0);

    }

    private void printRootToLeafPath(int[] path, int length) {
        for (int i = 0; i < length; i++) {
            System.out.print(path[i]);
            if (i != length-1)

                System.out.print("->");

        }
        System.out.println();
    }

    private void printPathsOfNode(NodeCreation node, int[] path, int length) {

        if (node == null)
            return;

        path[length] = node.getValue();
        length++;

        if (isLeafNode(node))
            printRootToLeafPath(path, length);
        else {
            int size = node.getChildList().size();
            for (int i = 0; i < size; ++i) {
                printPathsOfNode(node.getChildList().get(i), path, length);
            }
        }

    }
}