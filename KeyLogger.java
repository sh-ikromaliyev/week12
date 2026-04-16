import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.*;

public class KeyLogger extends Application {
    public void start(Stage stage) {
        TextField tf = new TextField();
        TextArea ta = new TextArea();
        ta.setEditable(false);
        ta.setPrefRowCount(5);
        Button clear = new Button("Clear Log");

        tf.setOnKeyPressed(e -> {
            ta.appendText("PRESSED | Code: "+e.getCode()+" | Shift: "+e.isShiftDown()+" | Ctrl: "+e.isControlDown()+"\n");
        });

        tf.setOnKeyReleased(e -> {
            ta.appendText("RELEASED | Code: "+e.getCode()+"\n");
        });

        tf.setOnKeyTyped(e -> {
            ta.appendText("TYPED | Char: "+e.getCharacter()+"\n");
        });

        clear.setOnAction(e -> ta.clear());

        VBox root = new VBox(10, tf, ta, clear);
        root.setPadding(new Insets(20));

        stage.setScene(new Scene(root,420,320));
        stage.show();
    }
    public static void main(String[] args){launch();}
}