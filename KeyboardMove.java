import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;

public class KeyboardMove extends Application {
    public void start(Stage stage) {
        Pane pane = new Pane();
        pane.setPrefSize(500,400);
        Rectangle r = new Rectangle(60,40,Color.BLUE);
        r.setX(220);
        r.setY(180);

        TextField tf = new TextField();
        tf.setEditable(false);

        BorderPane root = new BorderPane();
        root.setCenter(pane);
        root.setBottom(tf);

        pane.getChildren().add(r);

        Scene scene = new Scene(root);

        scene.setOnKeyPressed(e -> {
            if(e.getCode()==KeyCode.UP) r.setY(Math.max(0,r.getY()-10));
            if(e.getCode()==KeyCode.DOWN) r.setY(Math.min(400-40,r.getY()+10));
            if(e.getCode()==KeyCode.LEFT) r.setX(Math.max(0,r.getX()-10));
            if(e.getCode()==KeyCode.RIGHT) r.setX(Math.min(500-60,r.getX()+10));
            tf.setText("X: "+(int)r.getX()+" Y: "+(int)r.getY());
        });

        stage.setScene(scene);
        stage.show();
        scene.getRoot().requestFocus();
    }
    public static void main(String[] args){launch();}
}