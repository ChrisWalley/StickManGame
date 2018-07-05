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
public class MobUnit implements java.io.Serializable
  {

    private Coord pos;
    private String map;
    private double health;
    private double maxHealth;
    private double armour;
    private int GOLDPRICE = 1;
    private char icon = '&';
    private double damage;
    private Map<Double, Special> drops = new HashMap<>();
    private final int ID;
    private boolean isAlive = true;
    private String name = "Enemy";
    private ArrayList<String> fightString = new ArrayList<>();

    public MobUnit(Coord position, String mapString)
      {
        this.ID = (int) Math.round(Math.random() * 100);
        pos = position;
        health = 10;
        armour = 0;
        drops = null;
        map = mapString;
        this.setDefaultDrops();
        fightString.add("The Enemy gives you a bad look");
      }

    public MobUnit(Coord posCoord, double healthPoints, double armourPoints, double damagePoints, Map dropsMap, String mapString)
      {
        this.ID = (int) Math.round(Math.random() * 100);
        pos = posCoord;
        health = healthPoints;
        maxHealth = healthPoints;
        armour = armourPoints;
        damage = damagePoints;
        if (dropsMap != null)
          {
            drops = dropsMap;
          } else
          {
            setDefaultDrops();
          }
        map = mapString;
      }

    public void setHealth(double d)
      {
        health = d;
      }

    public void setIcon(char s)
      {
        icon = s;
      }

    public char getIcon()
      {
        return icon;
      }

    public double getHealth()
      {
        return health;
      }

    public void setArmour(double a)
      {
        armour = a;
      }

    public double getArmour()
      {
        return armour;
      }

    public void setDrops(Map s)
      {
        drops = s;
      }

    public Map<Double, Special> getDrops()
      {
        return drops;
      }

    public void setPos(Coord c)
      {
        pos = c;
      }

    public Coord getPos()
      {
        return pos;
      }

    public void nextPos()
      {
        pos = pos;
      }

    @Override
    public int hashCode()
      {
        return (ID * ID) / 31;
      }

    @Override
    public boolean equals(Object obj)
      {
        if (this == obj)
          {
            return true;
          }
        if (obj == null)
          {
            return false;
          }
        if (getClass() != obj.getClass())
          {
            return false;
          }
        final MobUnit other = (MobUnit) obj;
        return this.ID == other.ID;
      }

    public boolean equals(MobUnit obj)
      {
        return this.hashCode() == obj.hashCode();
      }

    public void kill()
      {
        isAlive = false;
      }

    public void setMap(String s)
      {
        map = s;
      }

    public String getMapID()
      {
        return map;
      }

    public void setDefaultDrops()
      {
        Map<Double, Special> tempDrops = new HashMap<>();
        setDrops(tempDrops);
      }

    public int getID()
      {
        return ID;
      }

    public String getName()
      {
        return name;
      }

    public void setName(String nameString)
      {
        name = nameString;
      }

    public Coord[] getAllPos()
      {
        Coord[] temp =
          {
            pos
          };
        return temp;
      }

    public int getCurrPosIndex()
      {
        return 0;
      }

    public Coord getCurrPos()
      {
        return pos;
      }

    public double getMaxHealth()
      {
        return maxHealth;
      }

    public void setMaxHealth(double h)
      {
        maxHealth = h;
      }

    public double getDamage()
      {
        return damage;
      }

    public void setDamage(double d)
      {
        damage = d;
      }

    public void addHealth(double h)
      {
        health = health + h;
      }

    public void setFightString(ArrayList<String> s)
      {
        fightString = s;
      }

    public String getFightString(int i)
      {

        return fightString.get(i);
      }

    public ArrayList<Special> getDropsArray()
      {
        ArrayList<Special> list = new ArrayList<>();
        int place = 0;
        for (Map.Entry<Double, Special> entry : drops.entrySet())
          {
            double chance = Math.random() * 100;
            if (chance <= entry.getKey())
              {
                list.add(place, entry.getValue());
                place++;
              }
          }
        return list;
      }

    public boolean isAlive()
      {
        return isAlive;
      }

    public int lootedGold()
      {
        return GOLDPRICE;
      }

    public void setPrice(int i)
      {
        GOLDPRICE = i;
      }

  }
