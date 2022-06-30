package com.example.semafor_zadanie_morong;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Semafor extends Canvas {
    boolean day;
    private int pom; //pomocná premenná na určenie stavu
    GraphicsContext gc;
    Timeline timeline;
    Scene scene;


    public Semafor(Scene scene){    //konštruktor
        super(600,480);
        this.scene=scene;
        gc=getGraphicsContext2D();
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> colorChange())); //vytvorenie časovača a nastavenie na 1 sec.
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        day=false;
        pom=0;
        draw();
    }
    public void colorChange(){      //Tu je jednoduchý cyklus (každú sekundu ho volá Timeline)
        pom++;                      //pom sa každú sekundu zvyšuje o 1, to zabezpečuje vykreslenie po 5,2,5,5 sec a znovu
        if (pom>16)pom=0;
        draw();
    }
    public void draw() {            //Vykreslenie Semaforu
        gc.clearRect(0,0,scene.getWidth(),scene.getHeight());
        gc.strokeRect(scene.getWidth()/2-150, 20, 150, 250);
        gc.strokeRect(scene.getWidth()/2+2, 20, 150, 250);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(2);
        gc.setFill(Color.GAINSBORO);
        gc.fillOval(scene.getWidth()/2-95,40,40,40);
        gc.fillOval(scene.getWidth()/2-95,100,40,40);
        gc.fillOval(scene.getWidth()/2-95,160,40,40);
        gc.fillOval(scene.getWidth()/2+57,40,40,40);
        gc.fillOval(scene.getWidth()/2+57,100,40,40);
        gc.fillOval(scene.getWidth()/2+57,160,40,40);
        if (day) {              //svetlá počas dna
            switch (pom) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                    gc.setFill(Color.RED);
                    gc.fillOval(scene.getWidth() / 2+57, 40, 40, 40);
                    break;
                case 5:
                case 6:
                    gc.setFill(Color.RED);
                    gc.fillOval(scene.getWidth() / 2+57, 40, 40, 40);
                    gc.setFill(Color.ORANGE);
                    gc.fillOval(scene.getWidth()/2+57,100,40,40);
                    break;
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                    gc.setFill(Color.GREEN);
                    gc.fillOval(scene.getWidth()/2+57,160,40,40);
                    break;
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                    gc.setFill(Color.ORANGE);
                    gc.fillOval(scene.getWidth()/2+57,100,40,40);
                    break;
            }
        }
       if (!day){           //svetlá počas noci
           if (pom>1)pom=0;
           switch (pom) {
               case 0:
                   gc.setFill(Color.ORANGE);
                   gc.fillOval(scene.getWidth() / 2-95, 100, 40, 40);
                   break;
               case 1:
                   gc.setFill(Color.GAINSBORO);
                   gc.fillOval(scene.getWidth()/2-95,100,40,40);
                   break;
           }
       }
    }

    public void nightMode(){
        day=false;
    }
    public void normalMode(){
        day=true;
    }
    public void powerOFF(){
        timeline.stop();
    } //zastavenie časovača
    public void powerOn(){
        timeline.play();
    } //znovuspustenie časovača
}
