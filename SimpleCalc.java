import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.*;

public class SimpleCalc extends Application {
    public void start(Stage stage) {
        TextField t1 = new TextField();
        TextField t2 = new TextField();
        TextField res = new TextField();
        res.setEditable(false);
        Button calc = new Button("Calculate");
        Button clear = new Button("Clear");

        calc.setOnAction(e -> {
            try {
                double a = Double.parseDouble(t1.getText());
                double b = Double.parseDouble(t2.getText());
                res.setText(String.format("Sum: %.2f", a+b));
            } catch(Exception ex){
                res.setText("Invalid input!");
            }
        });

        clear.setOnAction(e -> {
            t1.clear();
            t2.clear();
            res.clear();
        });

        GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);

        root.add(new Label("Number 1"),0,0);
        root.add(t1,1,0);
        root.add(new Label("Number 2"),0,1);
        root.add(t2,1,1);
        root.add(calc,0,2);
        root.add(clear,1,2);
        root.add(res,0,3,2,1);

        stage.setScene(new Scene(root));
        stage.show();
    }
    public static void main(String[] args){launch();}
}