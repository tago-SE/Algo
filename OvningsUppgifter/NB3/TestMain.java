/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NB3;

/**
 *
 * @author Jacob
 */
public class TestMain {

    public static void main(String[] args) {
        //list one -------------------------------------

        //create a linked list with size of 10
        int maxSize = 10;
        Node[] nodes = new Node[maxSize];

        //initiate each node
        for (int i = 0; i < maxSize; i++) {
            nodes[i] = new Node();
        }

        //adds data to the first 4 nodes
        nodes[0].data = "Gilgamesh";
        nodes[1].data = "löper";
        nodes[2].data = "på";
        nodes[3].data = "stäppen";

        //add reference to each node where data is not null to the next one
        int i = 0;
        Node currentNode = nodes[i];
        while (currentNode.data != "") {
            currentNode.next = nodes[i + 1];
            currentNode = nodes[++i]; //increment i first then set currentnode to the next one
        }

        //set currentnode as loop through them all and add to stringbuilder
        Node current = nodes[0];
        StringBuilder builder = new StringBuilder();

        while (current.next != null) {
            builder.append(current.data);
            builder.append(" -> ");
            current = current.next;
        }

        //remove last -> and prints out the items of the linkedlist
        String result = (builder.substring(0, builder.length() - 4).toString());
        System.out.println(result + "\n");

        //searches and change nodes next node (to the one after that one) if that next node has the data = "på"
        current = nodes[0];
        while (current.next != null) {
            if (current.next.data.equals("på")) {
                current.next = current.next.next;
                //what if the size of the list is not big enough?
            } else {
                current = current.next;
            }

        }

        //prints out info
        current = nodes[0];
        builder = new StringBuilder();

        while (current.next != null) {
            builder.append(current.data);
            builder.append(" -> ");
            current = current.next;
        }

        result = (builder.substring(0, builder.length() - 4).toString());
        System.out.println("After removal: " + result);

        //linked list two -----------------------------------------------------------------
        int maxSizeTwo = 10;
        Node[] nodesTwo = new Node[maxSizeTwo];

        //initiate each node
        for (int j = 0; j < maxSizeTwo; j++) {
            nodesTwo[j] = new Node();
        }

        //adds data to the first 4 nodes
        nodesTwo[0].data = "Får";
        nodesTwo[1].data = "Iterator";
        nodesTwo[2].data = "Användas";
        nodesTwo[3].data = "?";

        //add reference to each node where data is not null to the next one
        int j = 0;
        Node currentNodeTwo = nodesTwo[j];
        while (currentNodeTwo.data != "") {
            currentNodeTwo.next = nodesTwo[j + 1];
            currentNodeTwo = nodesTwo[++j]; //increment i first then set currentnode to the next one
        }

        //set currentnode as loop through them all and add to stringbuilder
        Node currentTwo = nodesTwo[0];
        builder = new StringBuilder();

        while (currentTwo.next != null) {
            builder.append(currentTwo.data);
            builder.append(" -> ");
            currentTwo = currentTwo.next;
        }

        //remove last -> and prints out the items of the linkedlist
        result = (builder.substring(0, builder.length() - 4));
        System.out.println("Second list: " + result + "\n");

        //to add the list together first we find the last node in the first list
        Node lastNode = null;

        current = nodes[0];
        while (current.next != null) {
            lastNode = current; //needs to be the last not null element, why before next row
            current = current.next;
        }
        System.out.println("Last node: " + lastNode);

        //then we loop through the next list and add them to the first list
        currentTwo = nodesTwo[0];

        while (currentTwo.next != null) {
            lastNode.next = currentTwo;
            lastNode = currentTwo;
            currentTwo = currentTwo.next;
        }

        //prints out info
        current = nodes[0];
        builder = new StringBuilder();

        while (current.next != null) {
            builder.append(current.data);
            builder.append(" -> ");
            current = current.next;
        }

        result = (builder.substring(0, builder.length() - 4).toString());
        System.out.println("After adding the lists: " + result);

        //cut list halfway --------------
        //find the size of the list
        float halfSize = 0;
        current = nodes[0];
        while (current.next != null) {
            halfSize++;
            current = current.next;
        }

        halfSize = Math.round(halfSize / 2)-1; //-1 for adjusting to array of 0..n

        current = nodes[(int) halfSize];

        Node beforeNode = null;
        try {
            while (current.next != null) {
                beforeNode = current;
                beforeNode.next = null;
                current = current.next;
            }
        } catch(NullPointerException e) {
            //continue
        }

        //prints out info
        current = nodes[0];
        builder = new StringBuilder();

        while (current.next != null) {
            builder.append(current.data);
            builder.append(" -> ");
            current = current.next;
        }

        result = (builder.substring(0, builder.length() - 4).toString());
        System.out.println("After cutting the list: " + result);

    }
}
