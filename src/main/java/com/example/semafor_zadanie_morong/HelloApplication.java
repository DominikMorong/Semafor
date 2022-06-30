package com.example.semafor_zadanie_morong;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    private int pom=1;  //pomocná premenná pre tlačidlo Zapni/Vypni
    @Override
    public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root, 600, 480);
        Semafor semafor = new Semafor(scene);

        Button playButton = new Button(); // tlačidlo Vypni/Zapni (ľavá strana)
        playButton.setLayoutX(180);
        playButton.setLayoutY(215);
        playButton.setStyle("-fx-background-radius: 50em; "
                + "-fx-background-image: url(powerOnOf.PNG);"
                + "-fx-background-size: 30px 30px;"
                + "-fx-min-width: 30px; "
                + "-fx-min-height: 30px; "
                + "-fx-max-width: 30px; "
                + "-fx-max-height: 30px;");
        playButton.setOnAction(actionEvent -> {
            if (pom==1){
            semafor.powerOFF();
            pom=0;
            }else{
                semafor.powerOn();
            pom=1;
            }
        });

        Button nightMode = new Button();    //tlačidlo pre prepnutie do nočného režimu (ľavá strana)
        nightMode.setLayoutX(210);
        nightMode.setLayoutY(215);
        nightMode.setStyle("-fx-background-radius: 50em; "
                + "-fx-background-image: url(nightMode.PNG);"
                + "-fx-background-size: 30px 30px;"
                + "-fx-min-width: 30px; "
                + "-fx-min-height: 30px; "
                + "-fx-max-width: 30px; "
                + "-fx-max-height: 30px;");
       nightMode.setOnAction(actionEvent -> {
            semafor.nightMode();
        });

        Button normalMode = new Button();   //tlačidlo pre prepnutie denného režimu (ľavá strana)
        normalMode.setLayoutX(240);
        normalMode.setLayoutY(215);
        normalMode.setStyle("-fx-background-radius: 50em; "
                + "-fx-background-image: url(normalMode.PNG);"
                + "-fx-background-size: 30px 30px;"
                + "-fx-min-width: 30px; "
                + "-fx-min-height: 30px; "
                + "-fx-max-width: 30px; "
                + "-fx-max-height: 30px;");
        normalMode.setOnAction(actionEvent -> {
            semafor.normalMode();
        });

        Button playButton2 = new Button();  // tlačidlo Vypni/Zapni (pravá strana)
        playButton2.setLayoutX(180+150);
        playButton2.setLayoutY(215);
        playButton2.setStyle("-fx-background-radius: 50em; "
                + "-fx-background-image: url(powerOnOf.PNG);"
                + "-fx-background-size: 30px 30px;"
                + "-fx-min-width: 30px; "
                + "-fx-min-height: 30px; "
                + "-fx-max-width: 30px; "
                + "-fx-max-height: 30px;");
        playButton2.setOnAction(actionEvent -> {
            if (pom==1){
                semafor.powerOFF();
                pom=0;
            }else{
                semafor.powerOn();
                pom=1;
            }
        });

        Button nightMode2 = new Button();   //tlačidlo pre prepnutie do nočného režimu (pravá strana)
        nightMode2.setLayoutX(210+150);
        nightMode2.setLayoutY(215);
        nightMode2.setStyle("-fx-background-radius: 50em; "
                + "-fx-background-image: url(nightMode.PNG);"
                + "-fx-background-size: 30px 30px;"
                + "-fx-min-width: 30px; "
                + "-fx-min-height: 30px; "
                + "-fx-max-width: 30px; "
                + "-fx-max-height: 30px;");
        nightMode2.setOnAction(actionEvent -> {
            semafor.nightMode();
        });

        Button normalMode2 = new Button();  //tlačidlo pre prepnutie denného režimu (pravá strana)
        normalMode2.setLayoutX(240+150);
        normalMode2.setLayoutY(215);
        normalMode2.setStyle("-fx-background-radius: 50em; "
                + "-fx-background-image: url(normalMode.PNG);"
                + "-fx-background-size: 30px 30px;"
                + "-fx-min-width: 30px; "
                + "-fx-min-height: 30px; "
                + "-fx-max-width: 30px; "
                + "-fx-max-height: 30px;");
        normalMode2.setOnAction(actionEvent -> {
            semafor.normalMode();
        });

        root.getChildren().addAll(semafor,playButton,nightMode,normalMode,playButton2,nightMode2,normalMode2);
        stage.setTitle("Semafor by Dominik Morong");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}