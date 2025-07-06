package edu.icet.repository;

import edu.icet.dto.Customer;
import edu.icet.entity.CustomerEntity;
import javafx.collections.ObservableList;

public interface CrudDao <T> extends SuperDao{
    boolean save(T type);
    boolean delete(String id);
    boolean update(T type);
    T search(String id);
    //get All
    ObservableList<T> getAll();
}
