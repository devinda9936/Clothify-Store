package edu.icet.repository;

import edu.icet.repository.custom.Impl.CustomerDaoImpl;
import edu.icet.repository.custom.Impl.ItemDaoImpl;
import edu.icet.repository.custom.Impl.OrderDaoImpl;
import edu.icet.util.DaoType;

public class DaoFactory {
    //Singleton
    private static DaoFactory instance;
    private DaoFactory(){}

    public static DaoFactory getInstance(){
        return instance==null ? instance = new DaoFactory():instance;
    }

    //get dao types
    public <T extends SuperDao> T getDaoType(DaoType type) {
        switch (type) {
            case CUSTOMER:
                return (T) new CustomerDaoImpl();
            case ITEM:
                return (T) new ItemDaoImpl();
            case ORDER:
                return (T) new OrderDaoImpl();
            default:
                throw new IllegalArgumentException("Unknown DaoType: " + type);
        }
    }

}
