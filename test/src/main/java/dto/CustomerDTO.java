/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entity.Customer;

/**
 *
 * @author Dennis
 */
public class CustomerDTO {
    private String name;
    private String address;
    
    public CustomerDTO(Customer cus){
        this.name = cus.getName();
        this.address = cus.getAddress();
    }
}
