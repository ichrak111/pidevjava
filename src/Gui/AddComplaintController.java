/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entities.Reclamation;
import Services.ServicesReclamation;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class AddComplaintController implements Initializable {

    @FXML
    private JFXTextField subject;
    @FXML
    private JFXTextArea description;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    @FXML
    public void submitComplaint()
    {
        
        ServicesReclamation rs = new ServicesReclamation();
        Reclamation r = new Reclamation(0,0,subject.getText(),description.getText());
        rs.addReclamation(r);
         String title = "Rapport pris en compte";
        String message = "Votre rapport est pris en compte ,\n vouz recevez un email de notification lors du traitement";

        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndWait();
    }
    
}
