package com.itproger.itprogerjavafxapp.animations;

import javafx.animation.TranslateTransition;
import javafx.util.Duration;
import javafx.scene.Node;

public class Shake {

    private TranslateTransition translateTransition;

    public Shake(Node node) {
        translateTransition = new TranslateTransition(Duration.millis(70), node);
        translateTransition.setFromX(0);
        translateTransition.setByX(10);
        //translateTransition.setByY(23f);
        translateTransition.setCycleCount(3);
        translateTransition.setAutoReverse(true);
    }

    public void playAnimation() {
        translateTransition.playFromStart();
    }
}
