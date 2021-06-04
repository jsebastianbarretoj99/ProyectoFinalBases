/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import control.FacadeOCR;
import entidades.Billete;
import entidades.Carro;
import entidades.DTOResumen;
import entidades.DTOTabla;
import entidades.Linea;
import entidades.Renta;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author juansebastianbarretojimenez
 */
public class FXMLPantallaOCRController implements Initializable {
    
    private Renta rentaActual;

    private final FacadeOCR facadeOCR = new FacadeOCR();

    private final ObservableList<Carro> catalogoCarro
            = FXCollections.observableArrayList();
    private final ObservableList<Billete> listaDenominacion
            = FXCollections.observableArrayList();
    private final ObservableList<DTOTabla> lineas
            = FXCollections.observableArrayList();

    @FXML
    private Label labelFecha;
    @FXML
    private Button btnNuevaRenta;
    @FXML
    private ComboBox<Carro> cmbCarros;
    @FXML
    private Button btnEliminar;
    @FXML
    private Button btnAgregarL;
    @FXML
    private Label labValorT;
    @FXML
    private TableView<DTOTabla> tblCarros;
    @FXML
    private TableColumn<DTOTabla, String> columCarro;
    @FXML
    private TableColumn<DTOTabla, Integer> colmCantidad;
    @FXML
    private TableColumn<DTOTabla, Integer> columSub;
    @FXML
    private TextField textCanBillete;
    @FXML
    private ComboBox<Billete> cmbDenomina;
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
    private Label labelError;
    @FXML
    private TableView<?> tablaReporte;
    @FXML
    private TableColumn<?, ?> anio;
    @FXML
    private TableColumn<?, ?> mes;
    @FXML
    private TableColumn<?, ?> cantidadCarrosRentados;
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
    private void iniciarTabla() {
        PropertyValueFactory<DTOTabla, String> placaProperty
                = new PropertyValueFactory<>("placa");
        columCarro.setCellValueFactory(placaProperty);

        PropertyValueFactory<DTOTabla, Integer> canProperty
                = new PropertyValueFactory<>("cantidad");
        colmCantidad.setCellValueFactory(canProperty);

        PropertyValueFactory<DTOTabla, Integer> subProperty
                = new PropertyValueFactory<>("subtotalM");
        columSub.setCellValueFactory(subProperty);
    } // end iniciarTabla
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.iniciarTabla();
    }    
    
    private void recorridoLineas(List<Linea> nuevasLineas) {
        final List<DTOTabla> resumLineas = new ArrayList<>();
        for (Linea linea : nuevasLineas) {
            DTOTabla tabla = new DTOTabla();
            tabla.setPlaca(linea.getCarroRentado().getPlaca());
            tabla.setCantidad(linea.getCantidad());
            tabla.setSubtotalM(linea.getCarroRentado().getPrecio());
            resumLineas.add(tabla);
        } // end for
        this.lineas.setAll(resumLineas);
        this.tblCarros.setItems(lineas);
    }

    @FXML
    private void crearRenta(ActionEvent event) {
        this.catalogoCarro.clear();
        this.listaDenominacion.clear();
        for(Carro car: this.facadeOCR.consultarCarros())
            this.catalogoCarro.add(car);
        for(Billete bil: this.facadeOCR.consultaTiposBilletes())
            this.listaDenominacion.add(bil);
        this.cmbCarros.setItems(catalogoCarro);
        this.cmbDenomina.setItems(listaDenominacion);
        DTOResumen res = this.facadeOCR.crearRenta();
        this.rentaActual = res.getRenta();
        this.labelSaldo.setText(Integer.toString(res.getSaldoBilletesIngresados()));
        this.labelVueltas.setText(Integer.toString(res.getVueltasRenta()));
        this.labelFecha.setText(res.getFecha().toString() + " " + res.getHora().toString());
        this.textCanBillete.clear();
        this.labValorT.setText(Integer.toString(res.getTotalRenta()));
        this.recorridoLineas(res.getListaCarrosLinea());
    } // end crearRenta

    @FXML
    private void elimarLinea(ActionEvent event) {
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
