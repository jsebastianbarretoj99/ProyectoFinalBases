/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import control.FacadeOCR;
import entidades.Billete;
import entidades.Carro;
import entidades.DTOReporte;
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
    
    private int numeroLinea;
    
    private boolean rentaActiva = true;

    private final FacadeOCR facadeOCR = new FacadeOCR();

    private final ObservableList<Carro> catalogoCarro
            = FXCollections.observableArrayList();
    private final ObservableList<Billete> listaDenominacion
            = FXCollections.observableArrayList();
    private final ObservableList<DTOTabla> lineas
            = FXCollections.observableArrayList();
    private final ObservableList<DTOReporte> lineasReporte
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
    private TableView<DTOReporte> tablaReporte;
    @FXML
    private TableColumn<DTOReporte, Integer> anio;
    @FXML
    private TableColumn<DTOReporte, Integer> mes;
    @FXML
    private TableColumn<DTOReporte, Integer> cantidadCarrosRentados;
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
    
    private void iniciarTablaReporte() {
        PropertyValueFactory<DTOReporte, Integer> anioProperty
                = new PropertyValueFactory<>("anio");
        anio.setCellValueFactory(anioProperty);

        PropertyValueFactory<DTOReporte, Integer> mesProperty
                = new PropertyValueFactory<>("mes");
        mes.setCellValueFactory(mesProperty);

        PropertyValueFactory<DTOReporte, Integer> cantProperty
                = new PropertyValueFactory<>("cantidadCarros");
        cantidadCarrosRentados.setCellValueFactory(cantProperty);
    } // end iniciarTablaReporte
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.iniciarTabla();
        this.iniciarTablaReporte();
    }    
    
    private void recorridoLineas() {
        final List<DTOTabla> resumLineas = new ArrayList<>();
        for (Linea linea : this.rentaActual.getLineas()) {
            DTOTabla tabla = new DTOTabla();
            tabla.setNumero(linea.getLineaPK().getNumero());
            tabla.setPlaca(linea.getCarroRentado().getPlaca());
            tabla.setCantidad(linea.getCantidad());
            tabla.setSubtotalM(linea.getCarroRentado().getPrecio());
            resumLineas.add(tabla);
        } // end for
        this.lineas.setAll(resumLineas);
        this.tblCarros.setItems(lineas);
    }
    
    private void recorridoLineasReporte(List<DTOReporte> reporteLista) {
        this.lineasReporte.setAll(reporteLista);
        this.tablaReporte.setItems(lineasReporte);
    }

    @FXML
    private void crearRenta(ActionEvent event) {
        if(this.rentaActiva == true){
            this.rentaActiva = false;
            this.numeroLinea = 0;
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
            this.labelError.setText(res.getMensaje());
            this.recorridoLineas();
        }else{
            this.labelError.setText("No se puede crear renta, finalice la actual");
        }
        
    } // end crearRenta

    @FXML
    private void elimarLinea(ActionEvent event) {
        Linea dtoLinea = new Linea();
        DTOTabla tabla = this.tblCarros.getSelectionModel().selectedItemProperty().get();
        dtoLinea.getLineaPK().setNumero(tabla.getNumero());
        dtoLinea.setCantidad(1);
        dtoLinea.getLineaPK().setRentanumero(this.rentaActual.getNumero());
        DTOResumen res = this.facadeOCR.eliminarLinea(dtoLinea);
        this.labelError.setText(res.getMensaje());
        if(res.getMensaje().equals("")){
            this.labValorT.setText(Integer.toString(res.getTotalRenta()));
            this.rentaActual.setLineas(res.getListaCarrosLinea());
            this.recorridoLineas();
        } // end if
    }

    @FXML
    private void agregarLinea(ActionEvent event) {
        Linea dtoLinea = new Linea();
        Carro c = new Carro();
        c = this.cmbCarros.getValue();
        this.numeroLinea++;
        dtoLinea.getLineaPK().setNumero(this.numeroLinea);
        dtoLinea.setCarroid(c.getId());
        dtoLinea.setCantidad(1);
        dtoLinea.getLineaPK().setRentanumero(this.rentaActual.getNumero());
        DTOResumen res = this.facadeOCR.agregarLinea(dtoLinea);
        this.labelError.setText(res.getMensaje());
        if(res.getMensaje().equals("")){
            this.labValorT.setText(Integer.toString(res.getTotalRenta()));
            this.rentaActual.setLineas(res.getListaCarrosLinea());
            this.recorridoLineas();
        } // end if
    } // end agregarLinea

    @FXML
    private void agregarBillete(ActionEvent event) {
        Billete bil = this.cmbDenomina.getValue();
        bil.setCantidad(Integer.parseInt(this.textCanBillete.getText()));
        DTOResumen res = this.facadeOCR.agregarBillete(bil, this.rentaActual.getNumero());
        this.labelError.setText(res.getMensaje());
        if(res.getMensaje().equals("")){
            this.labelSaldo.setText(Integer.toString(res.getSaldoBilletesIngresados()));
            this.rentaActual.setPagoBilletes(res.getRenta().getPagoBilletes());
        }
    }

    @FXML
    private void terminarRenta(ActionEvent event) {
        DTOResumen res = this.facadeOCR.terminarRenta(this.rentaActual.getLineas(), this.rentaActual.getNumero(), Integer.parseInt(this.labelSaldo.getText()));
        this.labelError.setText(res.getMensaje());
        if(res.getMensaje().equals("")){
            this.labelVueltas.setText(Integer.toString(res.getVueltasRenta()));
            this.rentaActiva = true;
        }
    }

    @FXML
    private void generarReporte(ActionEvent event){
        this.recorridoLineasReporte(this.facadeOCR.consultarAcumlados());
    }
    
}
