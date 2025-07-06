package edu.icet.repository.custom.Impl;

import edu.icet.dto.Customer;
import edu.icet.dto.Item;
import edu.icet.repository.custom.ItemDao;
import javafx.collections.ObservableList;

public class ItemDaoImpl implements ItemDao {
    @Override
    public boolean save(Item type) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public boolean update(Item type) {
        return false;
    }

    @Override
    public Item search(String id) {
        return null;
    }

    @Override
    public ObservableList<Item> getAll() {
        return null;
    }

    @Override
    public Integer getQTY(String itemCode) {
        return null;
    }
}
