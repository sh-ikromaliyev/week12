import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MouseCoords extends Application {
    public void start(Stage stage) {
        StackPane pane = new StackPane();
        pane.setPrefSize(400,300);
        pane.setStyle("-fx-background-color: lightblue;");
        Label label = new Label("Move the mouse over the pane");

        pane.setOnMouseMoved(e -> {
            label.setText("X: "+e.getX()+" Y: "+e.getY());
        });

        pane.setOnMouseClicked(e -> {
            int r=(int)(Math.random()*256);
            int g=(int)(Math.random()*256);
            int b=(int)(Math.random()*256);
            pane.setStyle(String.format("-fx-background-color: rgb(%d,%d,%d);",r,g,b));
        });

        pane.setOnMouseExited(e -> {
            label.setText("Move the mouse over the pane");
        });

        BorderPane root = new BorderPane();
        root.setCenter(pane);
        root.setBottom(label);

        stage.setScene(new Scene(root));
        stage.show();
    }
    public static void main(String[] args){launch();}
}