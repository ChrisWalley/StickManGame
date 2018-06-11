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
public class Special implements java.io.Serializable
{
    private String name = null;
    private Coord location = null;
    private String mapID = null;
    private String type = null;
    private boolean isUsable = false;
    private boolean hasBeenFound = false;
    private int worth = 0;
    
    public Special()
    {
        name = "";
        type = "";
    }
    
    public Special(String nameString, String typeStr, int price)
    {
        name = nameString;
        type = typeStr;
        worth = price;
    }
    
    public Special(String nameString, Coord loc, String typeString, String mapIDString, int price)
    {
        name = nameString;
        location = loc;
        type = typeString;
        mapID = mapIDString;
        worth = price;
    }
    
    public void setName(String n)
    {
        name = n;
    }
    
    public void setType(String t)
    {
        type = t;
    }
    
    public void setlocation(Coord c)
    {
        location = c;
    }
    
    public String getName()
    {
        if(this!=null)
            return name;
        else
            return"";
    }
    
    public String getType()
    {
        if(this!=null)
            return type;
        else
            return"";
    }
    
    public Coord Getlocation()
    {
        return location;
    }
    
    @Override
    public String toString()
    {
        return(name+" : "+location);
    }
    
    public String toInfo()
    {
        return(name);
    }
    
    public void setMapID(String s)
    {
        mapID = s;
    }
    
    public String getMapID()
    {
        return mapID;
    }
    
    @Override
    public int hashCode() {
        final int hash = name.hashCode();
        return hash/31;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        return true;
    }
    
    public Special makeUseable()
    {
        this.isUsable = true;
        return this;
    }
    
    public boolean isUsable()
    {
        return isUsable;
    }
    
    public boolean isFound()
    {
        return hasBeenFound;
    }
    
    public void found()
    {
        hasBeenFound = true;
    }
    
    public void setWorth(int price)
    {
        worth = price;
    }
    
    public int getWorth()
    {
        return worth;
    }
}
