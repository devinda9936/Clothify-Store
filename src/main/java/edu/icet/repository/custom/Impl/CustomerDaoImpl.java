package edu.icet.repository.custom.Impl;

import edu.icet.db.DBConnection;
import edu.icet.dto.Customer;
import edu.icet.entity.CustomerEntity;
import edu.icet.repository.custom.CustomerDao;
import edu.icet.util.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {

    //Create New Customer
    @Override
    public boolean save(CustomerEntity customer) {
        System.out.println("Repo layer, cus entity -> " + customer);

        //use hibernate
        try(Session session = HibernateUtil.getSession()){
            System.out.println(session.getClass().getName());
            session.beginTransaction();
            session.persist(customer);
            session.getTransaction().commit();
//            session.close();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    //Delete
    @Override
    public boolean delete(String id) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            CustomerEntity deleteCustomer = search(id);
            System.out.println(deleteCustomer);
            if (deleteCustomer != null) {
                session.remove(deleteCustomer); // JPA-style delete
                session.getTransaction().commit();
                return true;
            } else {
                System.out.println("Customer not found with ID: " + id);
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //Update
    @Override
    public boolean update(CustomerEntity customer) {
        //use hibernate
        try(Session session = HibernateUtil.getSession()){
            System.out.println(session.getClass().getName());
            session.beginTransaction();
            session.merge(customer);
            session.getTransaction().commit();
//            session.close();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //Search
    @Override
    public CustomerEntity search(String id) {
        try (Session session = HibernateUtil.getSession()) {
            CustomerEntity searchedCustomer = session.find(CustomerEntity.class, id);
            System.out.println(searchedCustomer);
            return searchedCustomer;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ObservableList<CustomerEntity> getAll() {
        try (Session session = HibernateUtil.getSession()) {
            List<CustomerEntity> customerEntityList = session.createQuery("FROM CustomerEntity", CustomerEntity.class).list();
            System.out.println(customerEntityList);

            //convert to observable list
            return FXCollections.observableArrayList(customerEntityList);
        } catch (Exception e) {
            e.printStackTrace();
            //return empty observable list
            return FXCollections.observableArrayList();
        }
    }

}
