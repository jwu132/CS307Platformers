package ooga.engine.dinosaur;

import ooga.engine.game.Player;

public class DinoPlayer extends Player {
    public static final double GRAVITY = 2.5;
    public static final int DEFAULT_JUMP_STRENGTH = 24;
    private double jumpStrength = DEFAULT_JUMP_STRENGTH;


    public DinoPlayer() {
        super();
        setX(100);
        setY(300);
    }

    @Override
    public void jump() {
        setY(getY() - jumpStrength);
        fall();
    }

    @Override
    public void fall() {
        jumpStrength -= GRAVITY;
    }

    public void resetJumpStrength() {
        jumpStrength = DEFAULT_JUMP_STRENGTH;
    }
}
