package edu.icet.repository.custom.Impl;

import edu.icet.dto.Customer;
import edu.icet.dto.Order;
import edu.icet.repository.custom.OrderDao;
import javafx.collections.ObservableList;

public class OrderDaoImpl implements OrderDao {
    @Override
    public boolean save(Order type) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public boolean update(Order type) {
        return false;
    }

    @Override
    public Order search(String id) {
        return null;
    }

    @Override
    public ObservableList<Order> getAll() {
        return null;
    }
}
