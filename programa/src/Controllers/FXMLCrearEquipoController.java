/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Deporte;
import model.DeporteModel;
import model.EquipoModel;

/**
 * FXML Controller class
 *
 * @author Joan_2k2
 */
public class FXMLCrearEquipoController implements Initializable {

    @FXML
    private ChoiceBox<String> laBox;
    @FXML
    private Button botonCrearEquipo;
    @FXML
    private TextArea descripccionEquipo;
    @FXML
    private TextField textoNombreEquipo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        DeporteModel dm = new DeporteModel();
        ObservableList<String> lista =dm.getDeportes();

        
            
        

        laBox.setItems(lista);
    }

    @FXML
    private void crearEquipo(ActionEvent event) {
        EquipoModel em = new EquipoModel();
        boolean resultado = false;

        String s = laBox.getSelectionModel().getSelectedItem();
        
        if (textoNombreEquipo.getText().isEmpty() || s == null) {

            Alert ale = new Alert(Alert.AlertType.ERROR);
            ale.setHeaderText("Error");
            ale.setContentText("No puedes dejar ni el deporte ni el nombre vacio");
            ale.showAndWait();
        } else {
            
            resultado = em.crearEquipo(textoNombreEquipo.getText(), descripccionEquipo.getText(), laBox.getValue());
            
            if (resultado == true) {
                
                Alert ale = new Alert(Alert.AlertType.CONFIRMATION);
                ale.setHeaderText("Creado con exito");
                ale.setContentText("Se ha creado con exito");
                ale.showAndWait();
                
            } else {
                
                Alert ale = new Alert(Alert.AlertType.ERROR);
                ale.setHeaderText("No se puede crear");
                ale.setContentText("Ya existen");
                ale.showAndWait();
            }

        }

    }

}
