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

/*
package Client;

import Model.Message;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ChatView extends AnchorPane implements MyObservable {
    
    private TextArea chatArea = new TextArea();
    private TextArea userArea = new TextArea();
    private TextField textField = new TextField();
    private Button sendButton = new Button();
    
    private List<MyObserver> observers = new ArrayList<>();

    public ChatView() {
        
        this.setStyle("-fx-background-color: #2b3330;");
        
        double caW = 400.;
        double caH = 280.;
        double caX = 15.;
        double caY = 15.;
        chatArea.setMaxWidth(caW);
        chatArea.setMaxHeight(caH);   
        chatArea.setLayoutX(caX);
        chatArea.setLayoutY(caY);
        chatArea.setEditable(false);
        this.getChildren().add(chatArea); 
        
        double uaW = 100.;
        double uaH = caH;
        double uaX = caX + caW + 5;
        double uaY = caY;
        userArea.setMaxWidth(uaW);
        userArea.setMaxHeight(uaH);
        userArea.setLayoutX(uaX);
        userArea.setLayoutY(uaY);
        userArea.setEditable(false);

        this.getChildren().add(userArea); 
        
        double tfW = caW;
        double tfH = 20;
        double tfX = caX;
        double tfY = caY + caH;
      
        textField.setMaxWidth(tfW);
        textField.setMinWidth(tfW);
        textField.setMaxHeight(tfH);
        
        textField.setLayoutX(tfX);
        textField.setLayoutY(tfY);
        this.getChildren().add(textField); 
        
        sendButton.setText("Send");
        sendButton.setMaxWidth(caW);
        sendButton.setMaxHeight(caH);   
        sendButton.setLayoutX(caX + caW + 5);
        sendButton.setLayoutY(caY + caH);
        this.getChildren().add(sendButton); 

        
        initEventHandlers();
    }
    
    private void initEventHandlers() {
        sendButton.setOnAction(this::handleSendMessage);
        
    }

    private void handleSendMessage(ActionEvent event) {
        notifyObservers(new Message("Me" , textField.getText()));
        textField.clear();
    }
    
    @Override
    synchronized public void notifyObservers(Object arg) {
        observers.stream().forEach((o) -> {
            o.update(this, arg);
        });
    }

    @Override
    public void registerObserver(MyObserver observer) {
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(MyObserver observer) {
         observers.remove(observer);
    }

    @Override
    public Object getUpdate(Observer obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   

}

*/