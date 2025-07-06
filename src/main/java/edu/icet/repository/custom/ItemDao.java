package edu.icet.repository.custom;

import edu.icet.dto.Item;
import edu.icet.repository.CrudDao;

public interface ItemDao extends CrudDao<Item> {
    Integer getQTY(String itemCode);
}
