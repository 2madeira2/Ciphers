package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.ciphers.PolybianCipher;
import sample.ciphers.SkitalCipher;

public class Controller {

    public TextField input;
    public TextField key;
    public Button btn;
    public Label output;
    @FXML
    private ComboBox<String> chooseAlgorithm;
    @FXML
    private ComboBox<String> chooseAction;

    public void doAction(javafx.event.ActionEvent actionEvent) {
        if (chooseAction.getValue().equals("Шифровать")){
            switch (chooseAlgorithm.getValue()){
                case "Шифр Скитала":
                    System.out.println("Шифр Скитала");
                    SkitalCipher cipher = new SkitalCipher();
                    output.setText(cipher.encrypt(input.getText(), key.getText()));
                    break;
                case "Полибианский квадрат":
                    System.out.println("Квадрат");
                    PolybianCipher cipher1 = new PolybianCipher();
                    output.setText(cipher1.encrypt(input.getText(), key.getText()));
                    break;
                case "Шифр Уитстона":
                    System.out.println("Уитстон");
                    break;
            }
        }
        else{
            switch (chooseAlgorithm.getValue()){
                case "Шифр Скитала":
                    System.out.println("Шифр Скитала");
                    SkitalCipher cipher = new SkitalCipher();
                    output.setText(cipher.decrypt(input.getText(), key.getText()));
                    break;
                case "Полибианский квадрат":
                    System.out.println("Квадрат");
                    PolybianCipher cipher1 = new PolybianCipher();
                    output.setText(cipher1.decrypt(input.getText(), key.getText()));
                    break;
                case "Шифр Уитстона":
                    System.out.println("Уитстон");
                    break;
            }
        }
    }

    public void doButtonEnabled(){
        if(!input.getText().equals("") && !key.getText().equals("") && chooseAction.getValue()!=null && chooseAlgorithm.getValue()!=null){
            btn.setDisable(false);
            System.out.println("Hello");
        }
        else{
            btn.setDisable(true);
        }
    }
}
