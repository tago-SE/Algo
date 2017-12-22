import java.util.Iterator;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import linkedlist_2.MySingleLinkedList;
import static javafx.application.Application.launch;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import linkedlist_2.MyDoubleLinkedList;

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
        
     
        
        l.add("One");
        l.add("WTF");
        l.add("SomeRemovedText");
        l.set(1, "Two");

        l.add(2, "Inserted_1");
        l.add(0, "addedFirst");
        l.add(4, "Four");
        
        //System.out.println("removing: " + l.remove(0));
        //System.out.println("removing: " + l.remove(3));
        
        System.out.println(l);
        
        Iterator itr = l.iterator();
       
       // itr.next();
        //itr.remove();
        
        
        while (itr.hasNext()) {
            Object o = itr.next();
            System.out.println(o.toString());
        }
        //l.clear();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
