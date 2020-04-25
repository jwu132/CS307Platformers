package ooga.engine.flappy;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import ooga.engine.game.Enemy;
import ooga.engine.game.Player;

/**
 * Pipe class extends parent class Enemy.
 * This class houses the Pipe Version 2 object constructor.
 */
public class Pipe2 extends Enemy {
    public static final int SPEED = 9;
    private String image = "Sprites/flappy_pipe_2.png";
    private DoubleProperty x = new SimpleDoubleProperty();
    private DoubleProperty y = new SimpleDoubleProperty();
    private int lowerHalfY = 280;
    private int upperHalfY = 170;
    private int xOffset = 100;
    private int playerOffset = 40;
    private final int standardY = -61;
    /**
     * Pipe2 constructor creates new Pipe2 object.
     * @param x double that initializes the Pipe2's x double property.
     * @param y double that initializes the Pipe2's y double property.
     */
    public Pipe2(double x, double y) {
        super();
        this.x.setValue(x);
        this.y.setValue(y);
    }
    /**
     * Additional Pipe2 constructor.
     */
    public Pipe2(){
        super();
    }
    /**
     * scroll method used to make Pipe2 move across screen.
     */
    @Override
    public void scroll() {
        setXPos(getXPos() - SPEED);
    }
    /**
     * sets Pipe2 object's X-coordinate
     * @param x desired X-coordinate
     */
    @Override
    public void setXPos(double x) {
        this.x.setValue(x);
    }
    /**
     * sets Pipe2 object's Y-coordinate
     * @param y desired Y-coordinate
     */
    @Override
    public void setYPos(double y){
        this.y.setValue(y);
    }
    /**
     * gets Pipe2 object's X-coordinate
     * @return double x that represents the Pipe2's X-coordinate.
     */
    @Override
    public double getXPos(){ return x.getValue(); }
    /**
     * gets Pipe2 object's Y-coordinate
     * @return double y that represents the Pipe2's Y-coordinate.
     */
    @Override
    public double getYPos(){ return y.getValue(); }
    /**
     * getXProperty returns the Pipe's X double property.
     * @return x which is the Pipe's X double property.
     */
    @Override
    public DoubleProperty getXProperty(){
        return x;
    }
    /**
     * collide method implemented to fit Pipe object parameters.
     * method determines whether the player is colliding with a Pipe.
     * @param player the BirdPlayer in the game.
     * @return isColliding a boolean that represents whether the Player and Pipe are colliding.
     */
    @Override
    public boolean collide(Player player) {
        return inXBounds(player) && inYBounds(player);
    }
    /**
     * boolean inXBounds helper method for collide method. Determines whether BirdPlayer and Pipe have overlapping x-values.
     * @param player BirdPlayer in current game.
     * @return boolean whether Pipe and player are colliding.
     */
    private boolean inXBounds(Player player) {
        return player.getXPos() > this.getXPos() - playerOffset && player.getXPos() < this.getXPos() + xOffset - playerOffset;
    }
    /**
     * boolean inYBounds helper method for collide method. Determines whether BirdPlayer and Pipe have overlapping y-values.
     * @param player BirdPlayer in current game.
     * @return boolean whether Pipe and player are colliding.
     */
    private boolean inYBounds(Player player) {
        return (player.getYPos() < upperHalfY || player.getYPos() > lowerHalfY);
    }
    /**
     * getImage method returns the Pipe's Sprite path.
     * @return String that indicates where Pipe image is stored.
     */
    public String getImage() {
        return image;
    }
    /**
     * setStandardY method used to set an Pipe2's position to line up
     * with the Y-coordinate of FlappyGame's floor.
     */
    @Override
    public void setStandardY(){
        setYPos(standardY);
    }
    /**
     * getYProperty returns the Pipe's Y double property.
     * @return y which is the Pipe's Y double property.
     */
    @Override
    public DoubleProperty getYProperty(){
        return y;
    }
}
