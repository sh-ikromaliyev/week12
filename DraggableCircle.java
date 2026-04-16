import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class DraggableCircle extends Application {
    double offsetX, offsetY;
    public void start(Stage stage) {
        Pane root = new Pane();
        root.setPrefSize(500,400);
        Circle c = new Circle(250,200,40,Color.CORAL);

        c.setOnMousePressed(e -> {
            offsetX = e.getSceneX() - c.getCenterX();
            offsetY = e.getSceneY() - c.getCenterY();
        });

        c.setOnMouseDragged(e -> {
            c.setCenterX(e.getSceneX() - offsetX);
            c.setCenterY(e.getSceneY() - offsetY);
            c.setFill(Color.TOMATO);
        });

        c.setOnMouseReleased(e -> {
            c.setFill(Color.CORAL);
        });

        root.getChildren().add(c);
        stage.setScene(new Scene(root));
        stage.show();
    }
    public static void main(String[] args){launch();}
}