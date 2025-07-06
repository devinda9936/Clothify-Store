package edu.icet.service;

import edu.icet.service.custom.impl.CustomerBoImpl;
import edu.icet.service.custom.impl.ItemBoImpl;
import edu.icet.service.custom.impl.OrderBoImpl;
import edu.icet.util.ServiceType;

public class BoFactory {
    //singleton
    private static BoFactory instance;
    private BoFactory(){}

    public static BoFactory getInstance(){
        return instance==null ? instance = new BoFactory():instance;
    }

    public <T extends SuperBo>T getServiceType(ServiceType type){
        switch (type){
            case CUSTOMER : return (T) new CustomerBoImpl();
            case ITEM: return (T) new ItemBoImpl();
            case ORDER: return (T) new OrderBoImpl();
        }
        return null;
    }
}
