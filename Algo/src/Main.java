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

/**
 *
 * @author tiago
 */
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        MySingleLinkedList<String> sll = new MySingleLinkedList<>();
        
     
        
        sll.add("Hello");
        sll.add("there");
        
        sll.add(2, "tihi");
        sll.set(2, "something");

        //sSystem.out.println("deleted: " + sll.remove("Hello"));
        
        System.out.println("size: " + sll.size());
        
      //  System.out.println("deleted: " + sll.remove(2));
        System.out.println("contains: " + sll.contains("there"));
        System.out.println("indexOf: " + sll.indexOf("therea"));

        
        
        sll.add("Mother");
        sll.add("wtf");
        
        Iterator itr = sll.iterator();
        
       // itr.next();
        //itr.remove();
        
        
        while (itr.hasNext()) {
            Object o = itr.next();
            System.out.println(o.toString());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
