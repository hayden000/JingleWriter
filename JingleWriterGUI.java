import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class JingleWriterGUI extends Application {
    private Label JingleWriter;
    private Label History;
    private Label item;
    private Stage primaryStage;

    public static void main (String[] args) {
        launch(args);
        JingleWriterCli.playGame(new Game());
    }

    public void start (Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("JingleWriterGUI");
        VBox root = new VBox();
        JingleWriter = new Label("JingleWriter");
        History = new Label("History:");
        root.getChildren().addAll(JingleWriter , History);
        for (int i = 0 ; i < 20 ; i++) {
            item = new Label(String.valueOf(i));
            root.getChildren().addAll(item);
        }
        HBox buttonBox = new HBox();
        Button close = new Button("Close");
        close.setOnAction(new CloseHandler());
        buttonBox.getChildren().addAll(close);
        root.getChildren().add(buttonBox);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private class CloseHandler implements EventHandler<ActionEvent> {
        public void handle (ActionEvent event) {
            primaryStage.close();
        }
    }
}
