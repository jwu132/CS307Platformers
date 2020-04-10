package ooga;

import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ooga.Screens.Screens;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxAssert;
import org.testfx.matcher.base.WindowMatchers;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScreensTest extends DukeApplicationTest{
    private Main game;
    private Screens screen;
    private Stage myStage;

    @Override
    public void start(Stage primaryStage) throws IOException {
        myStage = primaryStage;
        myStage.setTitle("Texas");
        Screens startMenu = new Screens();
        Scene firstscene = startMenu.createStartScreen(myStage);
        myStage.setScene(firstscene);
        myStage.show();
    }

    @Test
    void testStartScreen(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                screen = new Screens();
                Button start = lookup("#startbutton").query();
                Button end = lookup("#endbutton").query();
                Button quit = lookup("#quitbutton").query();
                Text title = lookup("#Title").query();
                assertEquals("Start Game",start.getText());
                assertEquals("End Game",end.getText());
                assertEquals("Quit Game",quit.getText());
                assertEquals("Welcome to TEXAS",title.getText());
                Parent changescreen = screen.createChangeScreen(myStage).getRoot();
                start.fire();
                for(int i = 0; i<changescreen.getChildrenUnmodifiable().size(); i++){
                    assertEquals(changescreen.getChildrenUnmodifiable().get(i).getId(),myStage.getScene().getRoot().getChildrenUnmodifiable().get(i).getId());
                }
                Parent endscreen = screen.createEndScreen(myStage).getRoot();
                end.fire();
                for(int i = 0; i<endscreen.getChildrenUnmodifiable().size(); i++){
                    assertEquals(endscreen.getChildrenUnmodifiable().get(i).getId(),myStage.getScene().getRoot().getChildrenUnmodifiable().get(i).getId());
                }
            }
        });
    }

    @Test
    void testChangeScreen(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                showChangeScreen();
                Button dinosaur = lookup("#dino").query();
                Button flappy = lookup("#flappybird").query();
                Button jetpack = lookup("#jet").query();
                Text title = lookup("#Title").query();
                assertEquals("Dinosaur",dinosaur.getText());
                assertEquals("Flappy Bird",flappy.getText());
                assertEquals("Jetpack Joyride",jetpack.getText());
                assertEquals("Choose A Game",title.getText());
                flappy.fire();
                Parent phscreen = screen.placeholderScene().getRoot();
                for(int i = 0; i<phscreen.getChildrenUnmodifiable().size(); i++){
                    assertEquals(phscreen.getChildrenUnmodifiable().get(i).getId(),myStage.getScene().getRoot().getChildrenUnmodifiable().get(i).getId());
                }
                jetpack.fire();
                for(int i = 0; i<phscreen.getChildrenUnmodifiable().size(); i++){
                    assertEquals(phscreen.getChildrenUnmodifiable().get(i).getId(),myStage.getScene().getRoot().getChildrenUnmodifiable().get(i).getId());
                }
            }
        });
    }

    private void showChangeScreen(){
        screen = new Screens();
        Scene changescene = screen.createChangeScreen(myStage);
        myStage.setScene(changescene);
        myStage.show();
    }

    @Test
    void testEndScreen(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                screen = new Screens();
                Parent changescreen = screen.createChangeScreen(myStage).getRoot();
                showEndScreen();
                Button playagain = lookup("#again").query();
                Button quit = lookup("#quitbutton").query();
                Text title = lookup("#Title").query();
                assertEquals("Play Again",playagain.getText());
                assertEquals("Quit Game",quit.getText());
                assertEquals("Game Over",title.getText());
                playagain.fire();
                for(int i = 0; i<changescreen.getChildrenUnmodifiable().size(); i++){
                   assertEquals(changescreen.getChildrenUnmodifiable().get(i).getId(),myStage.getScene().getRoot().getChildrenUnmodifiable().get(i).getId());
                }
            }
        });
    }

    private void showEndScreen(){
        screen = new Screens();
        Scene endscene = screen.createEndScreen(myStage);
        myStage.setScene(endscene);
        myStage.show();
    }
}
