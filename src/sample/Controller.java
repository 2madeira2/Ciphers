package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import sample.ciphers.Cipher;
import sample.ciphers.CipherFactory;
import sample.ciphers.PolybiusException;

public class Controller {

    public TextField input;
    public TextArea key;
    public Button btn;
    public TextField output;
    public Label warning;
    public TextArea mnogo;
    @FXML
    private ComboBox<String> chooseAlgorithm;
    @FXML
    private ComboBox<String> chooseAction;

    public void doAction(javafx.event.ActionEvent actionEvent) {
        CipherFactory factory = new CipherFactory();
        Cipher cipher = factory.getCipher(chooseAlgorithm.getValue());
        if (chooseAction.getValue().equals("Шифровать")){
            try {
                output.setText(cipher.encrypt(input.getText(), key.getText()));
            }
            catch (PolybiusException ex){
                warning.setText(ex.getMessage());
                warning.setStyle("-fx-text-fill: red; -fx-font-size: 26px;");
            }
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
        else {
            btn.setDisable(true);
        }
    }
}
