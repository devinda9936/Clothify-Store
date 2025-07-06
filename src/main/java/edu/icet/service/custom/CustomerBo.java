package edu.icet.service.custom;

import edu.icet.dto.Customer;
import edu.icet.entity.CustomerEntity;
import edu.icet.service.SuperBo;
import javafx.collections.ObservableList;

public interface CustomerBo extends SuperBo {
    boolean addCustomer(Customer customer);
    boolean updateCustomer(Customer customer);
    boolean deleteCustomer(String id);
    CustomerEntity searchCustomer(String id);
    ObservableList<Customer> getAll();
}
