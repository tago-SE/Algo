import java.util.Iterator;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static javafx.application.Application.launch;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import f_02_linkedlist.MyDoubleLinkedList;
import f_03_stack.Palindrome;
import f_03_stack.StackArray;

/**
 *
 * @author tiago
 */
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        TextArea outputArea = new TextArea();
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
        
        
        
        
        
        
        
        MyDoubleLinkedList<String> l = new MyDoubleLinkedList<>();
        
     
        
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
        stack.push("1 sudan");
  
        
        while (stack.peek() != null) {
            outputArea.appendText(stack.pop().toString() + "\n");
        }
        
        String s = "Madam";
        if (Palindrome.validateStrAsPalindrome(s)) {
            outputArea.appendText(s + " is a palindrome\n");
        } else {
            outputArea.appendText(s + " is not a palindrome\n");
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
