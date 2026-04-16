import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.scene.text.*;

public class ClickCounter extends Application {
    int count = 0;
    public void start(Stage stage) {
        Label label = new Label("Clicks: 0");
        label.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        Button btn = new Button("Click me!");
        btn.setOnAction(e -> {
            count++;
            label.setText("Clicks: " + count);
        });
        VBox root = new VBox(20, label, btn);
        root.setPadding(new Insets(30));
        root.setAlignment(Pos.CENTER);
        stage.setScene(new Scene(root,300,200));
        stage.setTitle("Click Counter");
        stage.show();
    }
    public static void main(String[] args){launch();}
}