package dagimplementation;

import modelCreation.GraphCreation;
import modelCreation.NodeCreation;
import modelCreation.TreeCreation;

import java.util.Scanner;
import java.util.LinkedList;

public class DagImplementation {
    private static Scanner in=new Scanner(System.in);

//Extract node
    private static NodeCreation getNodeByValue(LinkedList<NodeCreation> inputNodesList, int value) {
        for (int i = 0; i < inputNodesList.size(); i++) {
            NodeCreation node = inputNodesList.get(i);
            if (node.getValue() == value)
                return node;
        }
        return null;
    }

    public static void main(String args[])  {


        System.out.println("Enter the total no of Nodes:");
        int inputTotalNoOfNodes =in.nextInt();
        //Graph Creation
        LinkedList<NodeCreation> inputNodesList = new LinkedList<>();

        GraphCreation graphByUser = new GraphCreation();
        for (int i = 0; i < inputTotalNoOfNodes; ++i) {
            NodeCreation userNode = new NodeCreation(i);
            inputNodesList.add(userNode);
        }

        System.out.println("Enter total no of edges:");
        int inputNoOfEdges=in.nextInt();
        System.out.println("Enter the parent node and child node connected to it:");

        for (int i = 0; i < inputNoOfEdges; ++i) {
            System.out.println("Enter the parent node:");
            int nodeValue = in.nextInt();

            NodeCreation parentNode = getNodeByValue(inputNodesList, nodeValue);
            System.out.println("Enter the connected immediate child node:");
            int userChildNodeValue = in.nextInt();
            NodeCreation childNode = getNodeByValue(inputNodesList, userChildNodeValue);
            if (childNode != null)

                parentNode.getChildList().add(childNode);
        }
            //Set degree of node
        for (int i = 0; i < inputNodesList.size(); i++) {
            NodeCreation currentNode = inputNodesList.get(i);
            for (NodeCreation n : currentNode.getChildList()) {
                int degreeOfNode = n.getDegreeOfNode() + 1;
                n.setDegreeOfNode(degreeOfNode);
            }
        }
            // degree of current node and tree creation
        for (int i = 0; i < inputNodesList.size(); i++) {
            NodeCreation inputNode = inputNodesList.get(i);
            int currentNodeInDegree = inputNode.getDegreeOfNode();
            if (currentNodeInDegree == 0)
                graphByUser.getRootList().add(new TreeCreation(inputNode));
        }
            //print all possible path  from node of degree zero
        for (TreeCreation tree : graphByUser.getRootList()) {
            tree.printPaths(tree.getRoot());
        }

    }
}
