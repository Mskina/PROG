/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package micalculadorafx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author mskin
 */
public class MiniCalcVentanaController implements Initializable {

    @FXML
    private TextField tfPantalla;
    private char operacion;
    private long num1;
    private boolean controlOperacion; //true si pulso una operación (suma, resta...)

    private void numberClic(String number) {
        if (controlOperacion) {
            tfPantalla.clear();
            controlOperacion = false;
        }
        long num = Long.parseLong(tfPantalla.getText().concat(number));
        tfPantalla.setText(Long.toString(num));
    }

    // <editor-fold defaultstate="collapsed" desc="Números ">
    @FXML
    private void btn0(ActionEvent event) {
        numberClic("0");
    }

    @FXML
    private void btn1(ActionEvent event) {
        numberClic("1");
    }

    @FXML
    private void btn2(ActionEvent event) {
        numberClic("2");
    }

    @FXML
    private void btn3(ActionEvent event) {
        numberClic("3");
    }

    @FXML
    private void btn4(ActionEvent event) {
        numberClic("4");
    }

    @FXML
    private void btn5(ActionEvent event) {
        numberClic("5");
    }

    @FXML
    private void btn6(ActionEvent event) {
        numberClic("6");
    }

    @FXML
    private void btn7(ActionEvent event) {
        numberClic("7");
    }

    @FXML
    private void btn8(ActionEvent event) {
        numberClic("8");
    }

    @FXML
    private void btn9(ActionEvent event) {
        numberClic("9");
    }

    // </editor-fold>
    private void operar() {
        try {
            long resultado = 0;

            long num2 = Long.parseLong(tfPantalla.getText());

            switch (operacion) {
                case '+':
                    resultado = num1 + num2;
                    break;
                case '-':
                    resultado = num1 - num2;
                    break;
                case 'x':
                    resultado = num1 * num2;
                    break;
                case '/':
                    resultado = num1 / num2;
                    break;
                default:
                    resultado = num2;
            }

            tfPantalla.setText(Long.toString(resultado));

            num1 = resultado;
            controlOperacion = true;

        } catch (Exception e) {
            tfPantalla.setText("Error");
            num1 = 0;
            controlOperacion = false;
            operacion = ' ';

        }
    }

    // <editor-fold defaultstate="collapsed" desc="Operaciones">
    @FXML
    private void btnIgual(ActionEvent event) {
        if (!controlOperacion) {
            operar();
        }
        operacion = ' ';
        System.out.println("Igual");
        controlOperacion = true;
    }

    @FXML
    private void btnSumar(ActionEvent event) {
        if (!controlOperacion) {
            operar();
        }
        operacion = '+';
        System.out.println("Sumando");
        controlOperacion = true;
    }

    @FXML
    private void btnRestar(ActionEvent event) {
        if (!controlOperacion) {
            operar();
        }
        operacion = '-';
        System.out.println("Restando");
        controlOperacion = true;
    }

    @FXML
    private void btnMultiplicar(ActionEvent event) {
        if (!controlOperacion) {
            operar();
        }
        operacion = 'x';
        System.out.println("Multiplicando");

        controlOperacion = true;
    }

    @FXML
    private void btnDividir(ActionEvent event) {
        if (!controlOperacion) {
            operar();
        }
        operacion = '/';
        System.out.println("Dividiendo");

        controlOperacion = true;
    }

    // </editor-fold>
    @FXML
    private void btnAC(ActionEvent event) {
        System.out.println("Todo a 0");
        
        tfPantalla.setText("0");
        num1 = 0;
        controlOperacion = false;
        operacion = ' ';
    }

    @FXML
    private void btnOffHandler(ActionEvent event) {
        System.out.println("Saliendo");
        System.exit(0);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
