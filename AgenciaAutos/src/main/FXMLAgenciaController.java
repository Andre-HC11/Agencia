/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import DAO.AgenciaDAO;
import java.io.IOException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Agencia;


/**
 *
 * @author User
 */
public class FXMLAgenciaController implements Initializable {
    
    private AgenciaDAO agenciaDao = new AgenciaDAO();
    private List<Agencia> agencias;
    private ListView<Agencia> vistaAgencias;
    private ObservableList<Agencia> observableAgencia;
    
    @FXML
    private TableView<Agencia> listaAgencias;
    
    @FXML
    private TableColumn<Agencia,String> colRFC;

    @FXML
    private TableColumn<Agencia,String> colNombre;
    
    @FXML
    private TableColumn<Agencia,String> colDireccion;
 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        agencias = agenciaDao.getAllAgencias();
        
        inicializarCeldas();
    }    
    
    @FXML
    private void inicializarCeldas() {
        colRFC.setCellValueFactory(new PropertyValueFactory<Agencia, String>("RFC"));
        colNombre.setCellValueFactory(new PropertyValueFactory<Agencia, String>("nombre"));
        colDireccion.setCellValueFactory(new PropertyValueFactory<Agencia, String>("direccion"));

        listaAgencias.getItems().setAll(agencias);
    }
    
    @FXML
    public void cargarPaginaAgregarAgencia(ActionEvent event) {
        Stage stage = new Stage();
        String ruta = "FXMLAgregarAgencia.fxml";
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLAgregarAgencia.fxml"));
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
            
        } catch(IOException ex) {
            ex.getMessage();
        }
    }
    
}
