package edu.icet.controller.customer;

import edu.icet.db.DBConnection;
import edu.icet.dto.Customer;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static edu.icet.controller.customer.SearchCustomerFormController.customerService;

public class UpdateCustomerFormController extends SearchCustomerFormController{

    private UpdateCustomerFormController(){}

    static void updateCustomer(Customer selectedCustomer) {
//        String sql =
//                "UPDATE student SET title='"+selectedCustomer.getTitle()+"',name='"+selectedCustomer.getName()+"'," +
//                        "address='"+selectedCustomer.getAddress()+"',dob='"+selectedCustomer.getDob()+"' WHERE id='"+selectedCustomer.getId()+"'";


        selectedCustomer.setId(selectedCustomer.getId());
        selectedCustomer.setName(txtName.getText());
        selectedCustomer.setDob(dateDOB.getValue());
        selectedCustomer.setTitle(cmbTitles.getValue());
        selectedCustomer.setAddress(txtAddress.getText());
        selectedCustomer.setFullName(cmbTitles.getValue() + " " + txtName.getText());

        customerService.addCustomer(selectedCustomer);

    }
}
