package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import sample.ciphers.SkitalCipher;

public class Controller {

    public TextField input;
    public TextField key;
    public Button btn;
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
                    cipher.encrypt();
                case "Полибианский квадрат":
                    System.out.println("Квадрат");
                    break;
                case "Шифр Уитстона":
                    System.out.println("Уитстон");
                    break;
            }
        }
        else{
            System.out.println("Декрипт");
            //decrypt();
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
