/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gymproject;

import java.io.Serializable;

/**
 * The declaration and assignment of variable of sport activities members can choose from. Get and set methods to be used within classes.
 * @author HopefulSplash
 */
public class Sport implements Serializable {
    //added <public>
    private static final long serialVersionUID = 19981019L;
    private String sportTitle, sportdescription;
    private int noCourts, maxPlayers;
    private double pricePerPerson;
    private String[] equipment;
    private double pricePerEquipment;

    public Sport(String sportTitle, String sportdescription, int noCourts, int maxPlayers, double pricePerPerson, String[] equipment, double pricePerEquipment) {
        this.sportTitle = sportTitle;
        this.sportdescription = sportdescription;
        this.noCourts = noCourts;
        this.maxPlayers = maxPlayers;
        this.pricePerPerson = pricePerPerson;
        this.equipment = equipment;
        this.pricePerEquipment = pricePerEquipment;
    }

    Sport(String badminton, String play_Badminton_in_one_or_multiple_zones, int i, int i0, Object object, Object object0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getSportTitle() {
        return sportTitle;
    }

    public void setSportTitle(String sportTitle) {
        this.sportTitle = sportTitle;
    }

    public String getSportdescription() {
        return sportdescription;
    }

    public void setSportdescription(String sportdescription) {
        this.sportdescription = sportdescription;
    }

    public int getNoCourts() {
        return noCourts;
    }

    public void setNoCourts(int noCourts) {
        this.noCourts = noCourts;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public double getPricePerPerson() {
        return pricePerPerson;
    }

    public void setPricePerPerson(double pricePerPerson) {
        this.pricePerPerson = pricePerPerson;
    }

    public String[] getEquipment() {
        return equipment;
    }

    public void setEquipment(String[] equipment) {
        this.equipment = equipment;
    }

    public double getPricePerEquipment() {
        return pricePerEquipment;
    }

    public void setPricePerEquipment(double pricePerEquipment) {
        this.pricePerEquipment = pricePerEquipment;
    }

    @Override
    public String toString() {
        return sportTitle; //To change body of generated methods, choose Tools | Templates.
    }
    
    

    
    


}
