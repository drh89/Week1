/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;

/**
 *
 * @author Dennis
 */
public class Animal implements Serializable {
    
    private String type;
    private String sound;
    private int birthYear;
    
    public Animal(){
        
    }

    public Animal(String type, String sound, int birthYear) {
        this.type = type;
        this.sound = sound;
        this.birthYear = birthYear;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }
   
}
