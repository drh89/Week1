/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Dennis
 */
public class CustomerFacade {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

    public Customer createCustomer(Customer c) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        return c;
    }

    public List<Customer> getAllCustomers() {
        EntityManager em = emf.createEntityManager();
        TypedQuery tq = em.createQuery("SELECT c FROM Customer c", Customer.class);
        List<Customer> customers = tq.getResultList();
        return customers;

    }
    
    public Customer getCustomerById(int id){
        EntityManager em = emf.createEntityManager();
        TypedQuery tq = em.createQuery("SELECT c FROM Customer c WHERE c.id = :id", Customer.class);
        tq.setParameter("id", id);
        Customer cus = (Customer)tq.getSingleResult();
        return cus;
    }
    public int getCustomerListSize(List<Customer> cus){
        return getAllCustomers().size();
        
    }
    
    public static void main(String[] args) {
        CustomerFacade cf = new CustomerFacade();
        
        System.out.println(cf.getCustomerById(1));
        
    }

}
