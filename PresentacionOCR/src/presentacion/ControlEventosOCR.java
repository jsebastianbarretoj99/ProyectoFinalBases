/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author juansebastianbarretojimenez
 */
public class ControlEventosOCR implements Initializable {

    @FXML
    private Label labelFecha;
    @FXML
    private Button btnNuevaRenta;
    @FXML
    private ComboBox<?> cmbCarros;
    @FXML
    private Button btnEliminar;
    @FXML
    private Button btnAgregarL;
    @FXML
    private Label labValorT;
    @FXML
    private TableView<?> tblCarros;
    @FXML
    private TableColumn<?, ?> columCarro;
    @FXML
    private TableColumn<?, ?> colmCantidad;
    @FXML
    private TableColumn<?, ?> columSub;
    @FXML
    private TextField textCanBillete;
    @FXML
    private ComboBox<?> cmbDenomina;
    @FXML
    private Button btnAgregarBil;
    @FXML
    private Label labelSaldo;
    @FXML
    private Button btnTerminar;
    @FXML
    private Label labelVueltas;
    @FXML
    private Label labelNumeroPres;
    @FXML
    private Label labelSaldo1;
    @FXML
    private TableView<?> tablaReporte;
    @FXML
    private TableColumn<?, ?> isbnLibro;
    @FXML
    private TableColumn<?, ?> nombreLibro;
    @FXML
    private TableColumn<?, ?> cantidadTotal;
    @FXML
    private TableColumn<?, ?> cantidadPesos;
    @FXML
    private Button btnReporte;
    @FXML
    private Label textCantidaLibros;
    @FXML
    private Label textCantidadTotal;
    @FXML
    private Label textCantidadTotalPesos;
    @FXML
    private Label textCantidadTotalMonedas;
    @FXML
    private Label textMonedas500;
    @FXML
    private Label textMonedasMil;
    @FXML
    private Label MensajeError;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void IniciarRenta(ActionEvent event) {
    }

    @FXML
    private void ElimarLinea(ActionEvent event) {
    }

    @FXML
    private void agregarLinea(ActionEvent event) {
    }

    @FXML
    private void agregarBillete(ActionEvent event) {
    }

    @FXML
    private void terminarRenta(ActionEvent event) {
    }

    @FXML
    private void generarReporte(ActionEvent event) {
    }
    
}
