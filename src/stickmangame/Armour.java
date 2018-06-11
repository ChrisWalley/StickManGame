/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stickmangame;

/**
 *
 * @author Christopher
 */
public class Armour extends Special
{
    private int slot;
    private double armourPoints;
    public Armour(String name, Coord location, String type,String mapID, int s, double aP, int price)
    {
        super(name, location, type, mapID, price);
        slot = s;
        armourPoints = aP;
    }
    
    public Armour()
    {
        this.setName("");
    }
    public Armour(String name,String type, int slotInt, int aP, int price)
    {
        super(name, type, price);
        slot = slotInt;
        armourPoints = aP;
    }
    
    public void setSlot(int t)
    {
        slot = t;
    } 
    
    public void setAP(double aP)
    {
        armourPoints = aP;
    }
    
    public int getSlot()
    {
        return slot;
    }
    
    public double getAp()
    {
        return armourPoints;
    }
    
    @Override
    public String toInfo()
    {
        return(this.getName()+" - "+armourPoints+"armour");
    }
}
