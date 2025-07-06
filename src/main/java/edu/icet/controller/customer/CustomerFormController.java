package edu.icet.controller.customer;

import edu.icet.dto.Customer;
import edu.icet.service.BoFactory;
import edu.icet.service.SuperBo;
import edu.icet.service.custom.CustomerBo;
import edu.icet.util.ServiceType;

import java.time.LocalDate;

public class CustomerFormController {
    Customer newCustomer = new Customer("011","Mr. ","Sunimal","Colombo", LocalDate.parse("2025-07-04"));

    CustomerBo customerService = BoFactory.getInstance().getServiceType(ServiceType.CUSTOMER);

    //add customer
    public void addBtn(){
        customerService.addCustomer(newCustomer);
    }

    //update customer
    public void update(){
        customerService.updateCustomer(newCustomer);
    }

    //delete customer
    public void delete(){
        customerService.deleteCustomer("011");
    }

    //search customer
    public void search(){
        customerService.searchCustomer("010");
    }

    //get all customers
    public void getAll(){
        customerService.getAll();
    }

}

















