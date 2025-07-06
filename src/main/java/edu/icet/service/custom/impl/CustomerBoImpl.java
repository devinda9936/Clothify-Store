package edu.icet.service.custom.impl;

import edu.icet.dto.Customer;
import edu.icet.entity.CustomerEntity;
import edu.icet.repository.DaoFactory;
import edu.icet.repository.custom.CustomerDao;
import edu.icet.service.custom.CustomerBo;
import edu.icet.util.DaoType;
import javafx.collections.ObservableList;
import org.modelmapper.ModelMapper;

public class CustomerBoImpl implements CustomerBo {

    CustomerEntity cusEntity;

    //pass entity to Dao layer
    CustomerDao customerDao = DaoFactory.getInstance().getDaoType(DaoType.CUSTOMER);

    public boolean addCustomer(Customer customer) {

        System.out.println("Bo layer, customer -> " + customer);
        cusEntity =  new ModelMapper().map(customer, CustomerEntity.class);

        customerDao.save(cusEntity);

        return false;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        cusEntity =  new ModelMapper().map(customer, CustomerEntity.class);

        customerDao.update(cusEntity);
        return false;
    }

    @Override
    public boolean deleteCustomer(String id) {
//        cusEntity =  new ModelMapper().map(customer, CustomerEntity.class);

        customerDao.delete(id);
        return false;
    }

    @Override
    public CustomerEntity searchCustomer(String id) {
        CustomerEntity searchedCustomer = customerDao.search(id);
        System.out.println(searchedCustomer);
        return null;
    }

    @Override
    public ObservableList<Customer> getAll() {
        ObservableList<CustomerEntity> allCustomers = customerDao.getAll();
        System.out.println(allCustomers);
        return null;
    }

}

