import javafx.application.Application;

import javafx.stage.Stage;
import static javafx.application.Application.launch;
import javafx.scene.control.TextArea;
import f_02_linkedlist.MyDoubleLinkedList;
import f_03_stack.Palindrome;
import f_03_stack.PostfixEvaluator;
import f_03_stack.StackArray;
import f_04_queue.CircularQueue;
import f_06_back_tracking.Elevator;
import f_06_back_tracking.Fastest_Path;
import f_06_back_tracking.Maze;
import f_06_back_tracking.LinkedListRec;
import f_06_back_tracking.Puzzle;
import f_06_back_tracking.Queens;
import f_06_back_tracking.RobotSort;
import f_07_binary_tree.BinarySearchTree;
import f_08_hash.HashtableArray;
import f_08_hash.HashtableBucket;
import f_08_hash.HashtableOpen;
import f_09_sort.*;

/**
 *
 * @author tiago
 */
public class Main extends Application {
    
    private TextArea outputArea;
    
    private void out(String str) {
        outputArea.appendText(str);
    }
    
    
    @Override
    public void start(Stage primaryStage) {
        
        /*
        outputArea = new TextArea();
        TextField inputArea = new TextField();
        VBox root = new VBox();
        
        // Background
        root.setStyle("-fx-background-color: #2b3330;");
        
        // Output
        double caW = 400.;
        double caH = 280.;
        double caX = 15.;
        double caY = 15.;
        outputArea.setMaxWidth(caW);
        outputArea.setMaxHeight(caH);   
        outputArea.setLayoutX(caX);
        outputArea.setLayoutY(caY);
        outputArea.setEditable(false);
        root.getChildren().add(outputArea); 
        
        // Input
        double tfW = caW;
        double tfH = 20;
        double tfX = caX;
        double tfY = caY + caH;
        inputArea.setMaxWidth(tfW);
        inputArea.setMinWidth(tfW);
        inputArea.setMaxHeight(tfH);
        inputArea.setLayoutX(tfX);
        inputArea.setLayoutY(tfY);
        root.getChildren().add(inputArea); 

        // Input Event
        inputArea.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Command: " + inputArea.getText());
                outputArea.appendText(inputArea.getText() + "\n");
                inputArea.clear();
            }
        });
        
        Scene scene = new Scene(root, 300, 250);
        
        
        primaryStage.setTitle("Algo App");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setOnCloseRequest(event -> {
            System.out.println("Exit");
            Platform.exit();
        });
        */
        
       // int[] a =  Gen.generate(10);
       // RadixSort.sort(a);
       // Gen.print(a);
        
        /*
        SingleLinkedList_T<String> l = new SingleLinkedList_T();
        l.add("Tiago");
        l.add("Julian");
        l.add("Filip");
        System.out.println(l.toString());
       
        
        Iterator<String> it = l.iterator(0);
       
        while (it.hasNext()) {
            System.out.println(it.next());
        }
       */
        BinarySearchTree<String> b = new BinarySearchTree<>();
        b.add("H");
        b.add("B");
        b.add("N");
        b.add("A");
        b.add("E");
        b.add("C");
        b.add("F");
        b.add("D");
        b.add("G");
        b.add("J");
        b.add("I");
         System.out.println(b.printTree());
        System.out.println(b.findLargestChild());
        System.out.println("....");
       // MapPath.solve(3, 3);
        
        
        //Puzzle.solve(1, 3);
        

        RobotSort.sort("Hi");
        
        /*
        Maze m = new Maze();
        m.print();
        if(m.solve()) System.out.println("Lyckades");
        System.out.println();
        m.print();
        */
       // Labyrinth l = new Labyrinth();
       
       //out(Fastest_Path.solve() + "\n");
       
       
       //out(RobotSort.sort("BEACD") + "\n");
       
       //Queens.solve();
       
        /*
        int t = Elevator.numTimesTraveled(78, 15, 8, 35);
        out("times traveled = " + t + "\n");
        
        LinkedListRec<String> l = new LinkedListRec();
        l.add(0, "Tiago");
        l.add(1, "Julian");
        l.add(2, "Filip");
        l.add(3, "Peter");
        l.remove(1);
        
        out(l.toString() + "\n");
        out("size: " + l.size());
        
        
        
        /*
        BinarySearchTree<String> b = new BinarySearchTree();
        
        b.add("H");
        b.add("C");
        b.add("I");
        b.add("E");
        b.add("D");
        b.add("J");
        
        String cont = "H";
        String del = "H";
        
        outputArea.appendText(b.toString() + "\n");
        outputArea.appendText("leaves: " + b.numberOfLeaves() + "\n");
        outputArea.appendText("nodes: " + b.numberOfNodes() + "\n");
        outputArea.appendText("Largest child: " + b.findLargestChild() + "\n");
        outputArea.appendText("Parents with 2 children: " + b.numberOfNodesWith2Children() + "\n");
        outputArea.appendText("Tree height: " + b.treeHeight() + "\n");
        outputArea.appendText("Contains " + cont + ": " + b.contains(cont) + "\n");
        outputArea.appendText("delete " + del + ": " + b.delete(del) + "\n");
        outputArea.appendText("print tree: \n" + b.printTree() + "\n");
        //ShortestDistanceGraph.test();
        
        /*
        HashtableOpen hashtable = new HashtableOpen();
        hashtable.put("T", "Tiago");
        hashtable.put("J", "Julian");
        hashtable.put("N", "Niklas");
        hashtable.put("F", "Filip");
        hashtable.put("G", "Gustav");
        hashtable.put("GG", "Granitvägen");
        //outputArea.appendText(hashtable.toString() + "\n");
        //outputArea.appendText(hashtable.get("N") + "\n");
        //hashtable.remove("T");
        outputArea.appendText(hashtable.exist("FF") + "\n");
        
        
        /*
        int rdm, range = 100, min = 0;
        int size = 7;
        int[] a = new int[size];
        int[] b = new int[size];
        for (int i = 0; i < size; i++) {
            rdm = (int) (Math.random()*range) + min;
            a[i] = rdm;
            b[i] = rdm;
        }
        BucketSort.sort(b);
        for (int i = 0; i < size; i++) {
            outputArea.appendText("a: " + a[i] + "\t b: " + b[i] + "\n");
        }
        */
        /*
        CircularQueue<String> q = new CircularQueue<>();
        
        q.offer("Tiago");
        q.offer("Julian");
        outputArea.appendText(q.toString());
        outputArea.appendText("peek: " + q.peek());
        outputArea.appendText("poll: " + q.poll());
        q.offer("Niklas");
        outputArea.appendText(q.toString());
        /*
        MyDoubleLinkedList<String> l = new MyDoubleLinkedList<>();
        
        DummyLinkedList<String> l2 = new DummyLinkedList<>();
     
        PostfixEvaluator eval = new PostfixEvaluator();
        String exp = "1 2 + 5 -";
        int a = eval.evaluateString(exp);
        outputArea.appendText(exp + " = " + a);
        */
        //System.out.println(l2.toString());
        
        /*
        
        l.add(1);
        l.add("SomeRemovedText");
        l.set(1, "Two");

        l.add(2, "Inserted_1");
        l.add(0, 0);
        l.add(4, 4);
        
        System.out.println("removing: " + l.remove(1));
        System.out.println("removing: " + l.remove(3));
        
        System.out.println(l);
        
        Iterator itr = l.iterator();
       
       // itr.next();
        //itr.remove();
        
        
        while (itr.hasNext()) {
            Object o = itr.next();
            System.out.println(o.toString());
        }
        //l.clear();
        
        
        StackArray<String> stack = new StackArray();
        
        stack.push("3 lol");
        stack.push("2 poll");
        stack.push("1 roll");
  
        
        while (stack.peek() != null) {
            outputArea.appendText(stack.pop().toString() + "\n");
        }
        
        String s = "Madam";
        if (Palindrome.validateStrAsPalindrome(s)) {
            outputArea.appendText(s + " is a palindrome\n");
        } else {
            outputArea.appendText(s + " is not a palindrome\n");
        }
        */
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
