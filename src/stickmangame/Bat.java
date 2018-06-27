/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stickmangame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Christopher
 */
public class Bat extends MobUnit
{
    
    private Coord pos1;
    private Coord pos2;
    private int currPos = 0;
    private int GOLDPRICE = 1;
    public Bat(Coord p, String m)
    {
        super(p,m);
        pos1 = p;
        pos2 = p;
        this.setIcon('×');
        this.setName("Bat");
        ArrayList<String> fightStr = new ArrayList <>();
        fightStr.add("The Bat scratches you with its claws");
        fightStr.add("The Bat screeches");
        fightStr.add("The Bat bites you");
        this.setFightString(fightStr);
        this.setPrice(GOLDPRICE);
    }
    
    public Bat(Coord posCoord, double healthPoints, double armourPoints, double damagePoints, Map dropsMap, String mapString, Coord position2)
    {
        super(posCoord,healthPoints,armourPoints, damagePoints,dropsMap,mapString);
        pos1 = posCoord;
        pos2 = position2;
        this.setIcon('×');
        this.setName("Bat");
        ArrayList<String> fightStr = new ArrayList <>();
        fightStr.add("The Bat scratches you with its claws");
        fightStr.add("The Bat screeches");
        fightStr.add("The Bat bites you");
        this.setFightString(fightStr);   
        this.setPrice(GOLDPRICE);
    }
    public void setPos2(Coord p2)
    {
        pos2 = p2;
    }
    @Override
    public void nextPos()
    {
     if(StickManGame.canSwapChars(pos1, pos2))
     {
     if(currPos == 0)
         this.setPos(pos2);
     else if(currPos == 1)
         this.setPos(pos1);
     
     StickManGame.swapChars(pos1,pos2);
    currPos=currPos ^ (1);
     }
     else
     {
         StickManGame.encounteredMob(this.getID());
         System.out.println("In Bat");
     }
    }

    @Override
    public void setDefaultDrops()
    {
        Map<Double, Special> tempDrops = new HashMap<>();
        tempDrops.put(100.0, new Special("Bat wing", this.getPos(), "Ingredient", this.getMapID(), 2));
        setDrops(tempDrops);
    }
    
    @Override
    public String getName()
    {
        return "Bat";
    }
    
    @Override
    public Coord [] getAllPos()
    {
        Coord [] temp = {pos1, pos2};
        return temp;
    }
    
    @Override
    public int getCurrPosIndex()
    {
        return currPos;
    }
    
    @Override
    public Coord getCurrPos()
    {
        Coord [] temp = {pos1, pos2};
        return  temp[currPos];
    }
    
    @Override
    public ArrayList <Special>  getDropsArray()
     {
         ArrayList <Special> list = new ArrayList<>();
         int place = 0;
         for (Map.Entry<Double, Special> entry : this.getDrops().entrySet()) 
                {
                    double chance = Math.random()*100;
                    if(chance<=entry.getKey())
                    {
                        list.add(place, entry.getValue());
                        place++;
                    }
		}
         return list;
     }
    
    public Bat addDrop(double dropChance, Special item)
    {
        this.getDrops().put(dropChance, item);
        return this;
    }
    
    
}
