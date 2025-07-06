package edu.icet.controller.customer;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class CustomerControllerDash {
    public void addCustomerBtnOnAction(ActionEvent actionEvent) {
        System.out.println("add btn clicked");
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource(
                    "/view/customer_fxml/addCustomerForm.fxml")))));
            stage.getIcons().add(new Image("/img/add-user.png"));
            stage.setTitle("Add Customer");
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void viewCustomerBtnOnAction(ActionEvent actionEvent) {
        System.out.println("view btn clicked");
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource(
                    "/view/customer_fxml/view_customer.fxml")))));
            stage.getIcons().add(new Image("/img/contact-list.png"));
            stage.setTitle("View Customer");
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void searchCustomerBtnOnAction(ActionEvent actionEvent) {
        System.out.println("search btn clicked");
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource(
                    "/view/customer_fxml/search_customer.fxml")))));
            stage.getIcons().add(new Image("/img/search.png"));
            stage.setTitle("Search Customer");
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteCustomerBtnOnAction(ActionEvent actionEvent) {
        System.out.println("delete btn clicked");
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource(
                    "/view/customer_fxml/delete_customer.fxml")))));
            stage.getIcons().add(new Image("/img/delete.png"));
            stage.setTitle("Delete Customer");
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
