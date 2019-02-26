package Gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Entities.Categorie;
import Entities.Rapport;
import Services.CategorieService;
import Services.RapportService;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.ConditionalFeature;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class RapportBackController implements Initializable {

    @FXML
    private TableView<Rapport> tableView;
    @FXML
    private TextField categorie;
    @FXML
    private TextField souscategorie;

    
    
    List<String> categories;
    @FXML
    private JFXComboBox<String> comboCat;
    @FXML
    private ListView<String> listCatt;
    @FXML
    private ListView<String> listsouscat;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        // to do : init combobox
        CategorieService cs = new CategorieService();
        categories = cs.getAllString();
        comboCat.setItems(FXCollections.observableArrayList(categories));
        listCatt.setItems(FXCollections.observableArrayList(categories));
        listCatt.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                listsouscat.setItems(FXCollections.observableArrayList(cs.getAllSousString(cs.getBynom(newValue).getId())));
            }
        });
    }  
    
    @FXML
    private void ajouterCategorie(ActionEvent event) {
        Categorie c = new Categorie(categorie.getText());
        CategorieService cs = new CategorieService();
        if(cs.insert(c))
        {
        comboCat.setItems(FXCollections.observableArrayList(cs.getAllString()));
        listCatt.setItems(FXCollections.observableArrayList(cs.getAllString()));
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            String message = "Categorie deja existante";
            alert.setContentText(message);
            alert.show();
        }
    }
    
   @FXML
    private void ajouterSousCategorie(ActionEvent event) {
        CategorieService cs = new CategorieService();
        Categorie c = new Categorie();
        c.setId(cs.getBynom(comboCat.getValue()).getId());
        c.setNom(souscategorie.getText());
        if(!cs.insertSousCat(c))
        {
            
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            String message = "Sous Categorie deja existante";
            alert.setContentText(message);
            alert.show();
        }
    }
    
  
   
   
    
    
    
    
   
   
   
    
       
}

;

 /* 
    
    /*public void fillUserForm()
    {
       if (tableView.getSelectionModel().getSelectedItem() != null) 
       {
        User selectedUser = tableView.getSelectionModel().getSelectedItem();
        firstName.setText(selectedUser.getFirstName());
        lastName.setText(selectedUser.getLastName());
        password.setText(selectedUser.getPassword());
        email.setText(selectedUser.getEmail());
        phoneNumber.setText(String.valueOf(selectedUser.getPhoneNumber()));
        birthDate.setValue(LocalDate.of(2001, 1, 1));
        city.setText(selectedUser.getCity());
        address.setText(selectedUser.getAddress());
        zipCode.setText(String.valueOf(selectedUser.getZipCode()));
        accountType.setValue(selectedUser.getAccountType());
        subscribe.setSelected(selectedUser.getNewsletterSubscription());
        currentSelectedId = selectedUser.getId();
       }
    }
    
    public void updateUser()
    {
        User updatedUser = new User();
        updatedUser.setId(currentSelectedId);
        updatedUser.setFirstName(firstName.getText());
        updatedUser.setLastName(lastName.getText());
        updatedUser.setPassword(password.getText());
        updatedUser.setEmail(email.getText());
        updatedUser.setPhoneNumber(Integer.valueOf(phoneNumber.getText()));
        updatedUser.setBirthDate(Date.from(birthDate.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        updatedUser.setCity(city.getText());
        updatedUser.setAddress(address.getText());
        updatedUser.setZipCode(Integer.valueOf(zipCode.getText()));
        updatedUser.setAccountType(accountType.getValue());
        updatedUser.setNewsletterSubscription(subscribe.isSelected());
        us.update(updatedUser);
        tableView.getItems().setAll(us.getAll());
    }

    @FXML
    public void resetForm()
    {
        firstName.setText("");
        lastName.setText("");
        password.setText("");
        email.setText("");
        phoneNumber.setText("");
        birthDate.setValue(LocalDate.of(2001, 1, 1));
        city.setText("");
        address.setText("");
        zipCode.setText("");
        accountType.setValue("");
        subscribe.setSelected(false);
    }
    */