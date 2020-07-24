package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    static Stage stage;



    @Override
    public void start(Stage primaryStage) throws Exception{
        // définir et ouvrir la fenetre d'acceuil comme fenetre parent
        Parent parent = FXMLLoader.load(getClass().getResource("fxml/main.fxml"));
        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(true);

        // Sauvegarder la fenetre d'acceuil
        stage = primaryStage;
        stage.setTitle("Accueil"); // le titre de la fenetre d'acceuil.
    }


    public static void main(String[] args) {
        launch(args);
    }
}
