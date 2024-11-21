package com.example.myjavaapp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class Test extends Application {

    List<Person> personlist= new ArrayList<>();
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();


        Label banner = new Label("Banner");
        banner.setStyle("-fx-font-size: 18px; -fx-text-fill: white; -fx-background-color: #4CAF50; -fx-padding: 10px;");
        root.setTop(banner);
        BorderPane.setAlignment(banner,Pos.CENTER);

        VBox leftColumn = new VBox(10);
        leftColumn.setPadding(new Insets(20));
        leftColumn.setStyle("-fx-background-color: #f0f0f0; -fx-border-color: #cccccc;");

//        TextField age = new TextField();
//        age.setPromptText("Enter your age");
//        Label ageLabel = new Label("Age:");
//        leftColumn.getChildren().addAll(ageLabel,age);

        TextField nameField = new TextField();
        nameField.setPromptText("Enter your name");
        Label nameLabel = new Label("Name:");
        nameLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: #333;");
        leftColumn.getChildren().addAll(nameLabel, nameField);

        TextField fatherNameField = new TextField();
        fatherNameField.setPromptText("Enter your father's name");
        Label fatherNameLabel = new Label("Father Name:");
        fatherNameLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: #333;");
        leftColumn.getChildren().addAll(fatherNameLabel, fatherNameField);

        TextField cnicField = new TextField();
        cnicField.setPromptText("Enter CNIC");
        Label cnicLabel = new Label("CNIC:");
        cnicLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: #333;");
        leftColumn.getChildren().addAll(cnicLabel, cnicField);

        DatePicker datePicker = new DatePicker();
        datePicker.setPromptText("Enter date of birth");
        Label dateLabel = new Label("Date of Birth:");
        dateLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: #333;");
        leftColumn.getChildren().addAll(dateLabel, datePicker);

        Label genderLabel = new Label("Gender:");
        genderLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: #333;");
        RadioButton maleRadio = new RadioButton("Male");
        RadioButton femaleRadio = new RadioButton("Female");
        ToggleGroup genderGroup = new ToggleGroup();
        maleRadio.setToggleGroup(genderGroup);
        femaleRadio.setToggleGroup(genderGroup);
        HBox genderBox = new HBox(10, maleRadio, femaleRadio);
        leftColumn.getChildren().addAll(genderLabel, genderBox);

        ComboBox<String> cityComboBox = new ComboBox<>();
        cityComboBox.getItems().addAll("Faisalabad", "Lahore", "Jhang");
        cityComboBox.setPromptText("Select a city");
        Label cityLabel = new Label("City:");
        cityLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: #333;");
        leftColumn.getChildren().addAll(cityLabel, cityComboBox);

        Button saveButton = new Button("Save");
        saveButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold;");
        leftColumn.getChildren().add(saveButton);

        root.setLeft(leftColumn);

        VBox rightColumn = new VBox(10);
        rightColumn.setPadding(new Insets(20));
        rightColumn.setStyle("-fx-background-color: #f9f9f9; -fx-border-color: #cccccc;");


        ImageView imageView = new ImageView();
        imageView.setFitHeight(150);
        imageView.setFitWidth(150);
        imageView.setStyle("-fx-border-color: black;");

        Label imageLabel = new Label("Image:");
        Button fileChooserButton = new Button("Choose File");

        FileChooser fileChooser = new FileChooser();
        fileChooserButton.setOnAction(e -> {
            File file = fileChooser.showOpenDialog(primaryStage);
            if (file != null) {
                imageView.setImage(new Image(file.toURI().toString()));
            }
        });

        rightColumn.getChildren().addAll(imageLabel, imageView, fileChooserButton);

        root.setRight(rightColumn);

        //Save button action
        saveButton.setOnAction(e -> {
            String name = nameField.getText();
            String fatherName = fatherNameField.getText();
            String cnic = cnicField.getText();
            String dateOfBirth =datePicker.getValue()!=null? datePicker.getValue().toString(): "Empty";
            String gender= maleRadio.isSelected()?"Male":femaleRadio.isSelected() ?"Female":"Empty";
            String city=cityComboBox.getValue()!=null?cityComboBox.getValue():"Empty";

            if (name.isEmpty() || fatherName.isEmpty() || cnic.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Please fill all required fields.");
                alert.show();
            } else {

                Person person = new Person(name, fatherName, cnic, dateOfBirth, gender, city);
                personlist.add(person);

                nameField.clear();
                fatherNameField.clear();
                cnicField.clear();
                datePicker.setValue(null);
                genderGroup.selectToggle(null);
                cityComboBox.setValue(null);

                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Person saved successfully!");
                alert.show();
            }


        });

        Scene scene = new Scene(root, 600, 500);
        primaryStage.setTitle("Foam");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}