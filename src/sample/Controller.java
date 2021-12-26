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
    @FXML
    private ComboBox<String> chooseAlgorithm;
    @FXML
    private ComboBox<String> chooseAction;

    public void doAction(javafx.event.ActionEvent actionEvent) throws PolybiusException {
        CipherFactory factory = new CipherFactory(input.getText(), key.getText());
        Cipher cipher = factory.getCipher(chooseAlgorithm.getValue());

        if (chooseAction.getValue().equals("Шифровать")){
            output.setText(cipher.encrypt());
        }
        else{
            output.setText(cipher.decrypt());
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
