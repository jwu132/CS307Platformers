package ooga;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ooga.Screens.StartScreen;


import java.io.IOException;

import static javafx.application.Application.launch;

public class Main extends Application {

    private Stage myStage;
    public static final int FRAMES_PER_SECOND = 30;
    public static final double SECOND_DELAY = 1.0 / FRAMES_PER_SECOND;
    public static void main (String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        myStage = primaryStage;
        myStage.setTitle("Texas");
        StartScreen startScreen = new StartScreen();
        Scene firstscene = startScreen.createStartScreen(myStage);
        myStage.setScene(firstscene);
        startScreen.setOnDarkMode(e -> {
            Application.setUserAgentStylesheet(Application.STYLESHEET_MODENA);
            com.sun.javafx.css.StyleManager.getInstance().addUserAgentStylesheet(getClass().getResource("/dark-theme.css").toString());
        });
        myStage.show();
    }


}
