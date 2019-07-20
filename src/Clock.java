import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Clock extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  public void start(Stage primaryStage) {
    StackPane root = new StackPane();
    root.setPrefSize(800, 805);
    WebView webView = new WebView();
    WebEngine webEngine = webView.getEngine();
    webEngine.load("http://localhost:5000");
    root.getChildren().add(webView);
    Scene scene = new Scene(root);
    primaryStage.setTitle("Clock");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
