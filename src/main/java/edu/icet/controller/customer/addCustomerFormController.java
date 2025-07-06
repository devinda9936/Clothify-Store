package edu.icet.controller.customer;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import edu.icet.db.DBConnection;
import edu.icet.dto.Customer;
import edu.icet.service.BoFactory;
import edu.icet.service.custom.CustomerBo;
import edu.icet.util.HibernateUtil;
import edu.icet.util.ServiceType;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import org.hibernate.Session;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class addCustomerFormController implements Initializable {

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXComboBox<String> cmbTitles;

    @FXML
    private DatePicker dateDOB;

    @FXML
    private JFXTextField txtId;

    @FXML
    private JFXTextField txtName;

//    Customer newCustomer = new Customer("011","Mr. ","Chinthaka","Tangalle", LocalDate.parse("2025-07-04"));

    CustomerBo customerService = BoFactory.getInstance().getServiceType(ServiceType.CUSTOMER);

    public void addCustomerOnAction(ActionEvent actionEvent) {

        if (!(txtName.getText()==null||cmbTitles.getValue()==null||txtAddress.getText()==null||dateDOB.getValue()==null)){

            //add data
//            String sql =
//                    "INSERT INTO student VALUES('" + txtId.getText()+"','"+cmbTitles.getValue()+"','"+txtName.getText()+"','"+txtAddress.getText()+"','"+dateDOB.getValue()+"')";
//
//            try {
//                PreparedStatement dbConnection = DBConnection.getInstance().getDBConnection(sql);
//                dbConnection.executeUpdate();
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
            Customer newCustomer = new Customer();
            newCustomer.setId(generateID());
            newCustomer.setName(txtName.getText());
            newCustomer.setDob(dateDOB.getValue());
            newCustomer.setTitle(cmbTitles.getValue());
            newCustomer.setAddress(txtAddress.getText());
            newCustomer.setFullName(cmbTitles.getValue() + " " + txtName.getText());

            customerService.addCustomer(newCustomer);

            //clear form
            clearForm();

            //generate ID
            generateID();

            //show success msg
            handleShowDialog("Success","Add Customer Successfully!", Alert.AlertType.INFORMATION);

        }else {

            //clear form
            clearForm();

            //show error msg
            handleShowDialog("Error","Oops! Fill out All the Fields ",Alert.AlertType.ERROR);

        }

    }

    //clear form
    private void clearForm(){
        generateID();
        txtName.setText(null);
        txtAddress.setText(null);
        cmbTitles.setValue(null);
        dateDOB.setValue(null);
    }

    //generate ID
    private String generateID(){
//        PreparedStatement dbConnection = DBConnection.getInstance().getDBConnection("SELECT COUNT(id) AS id FROM " +
//                "student");
//        try {
//            ResultSet resultSet = dbConnection.executeQuery();
//            resultSet.next();
//            int idCount = resultSet.getInt("id");
//            txtId.setText(String.format("C%03d",idCount+1));
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();

            // Get the max numeric part of the ID
            String hql = "SELECT MAX(SUBSTRING(c.id, 2)) FROM CustomerEntity c";
            String maxIdStr = (String) session.createQuery(hql).uniqueResult();

            int maxId = 0;
            if (maxIdStr != null) {
                maxId = Integer.parseInt(maxIdStr);
            }

            session.getTransaction().commit();
            txtId.setText(String.format("C%03d", maxId + 1));
            return String.format("C%03d", maxId + 1);
        }

    }

    //Show Dialog
    private void handleShowDialog(String title,String msg,Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //generate ID
        generateID();

        //set read-only
        txtId.setEditable(false);

        //set titles
        ObservableList<String> titles = FXCollections.observableArrayList();
        titles.add("Mr.");
        titles.add("Miss.");
        cmbTitles.setItems(titles);

        //focus combo box
        Platform.runLater(() -> cmbTitles.requestFocus());

    }

}
