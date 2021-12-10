package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.ciphers.Cipher;
import sample.ciphers.CipherFactory;

public class Controller {

    public TextField input;
    public TextField key;
    public Button btn;
    public TextField output;
    @FXML
    private ComboBox<String> chooseAlgorithm;
    @FXML
    private ComboBox<String> chooseAction;

    public void doAction(javafx.event.ActionEvent actionEvent) {
        CipherFactory factory = new CipherFactory();
        Cipher cipher = factory.getCipher(chooseAlgorithm.getValue());
        if (chooseAction.getValue().equals("Шифровать")){
            output.setText(cipher.encrypt(input.getText(),key.getText()));
        }
        else{
            output.setText(cipher.decrypt(input.getText(), key.getText()));
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
