/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stickmangame;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Christopher
 */
public class StickMan implements java.io.Serializable
  {
    
    private Coord pos;
    private ArrayList<Special> inventory = new ArrayList(0);
    private HashMap<Special, Integer> inv = new HashMap<>();
    private Armour[] equipped = new Armour[4];
    private Weapon weapon;
    private double health;
    private double maxHealth;
    private double damage = 1;
    private double armour;
    private int gold = 0;
    
    public StickMan()
      {
        health = 100.0;
        maxHealth = 100;
        armour = 0.0;
      }
    
    public void setPos(Coord p)
      {
        pos = p;
      }
    
    public void setWeapon(Weapon w)
      {
        unEquipWeapon();
        weapon = w;
        damage = w.getDamage();
      }
    
    public Coord getPos()
      {
        return pos;
      }
    
    public Weapon getWeapon()
      {
        if (weapon != null)
          {
            return weapon;
          } else
          {
            return (null);
          }
      }
    
    public boolean hasCollected(Special s)
      {
        return (inventory.contains(s));
      }
    
    public boolean isEquipped(Special s)
      {
        for (Special equipped1 : equipped)
          {
            if (equipped1.equals(s))
              {
                return true;
              }
          }
        
        return (false);
      }
    
    public void equip(Armour s, int i)
      {
        unEquip(i);
        equipped[i] = s;
        armour = armour + s.getAp();
      }
    
    public Special getEquipped(int i)
      {
        if (equipped[i] != null)
          {
            return equipped[i];
          } else
          {
            return (null);
          }
      }
    
    public void unEquip(int i)
      {
        if (equipped[i] != null)
          {
            armour = armour - equipped[i].getAp();
            addToInv(equipped[i]);
            equipped[i] = null;
          }
      }
    
    public void unEquipWeapon()
      {
        if (weapon != null)
          {
            damage = 1;
            addToInv(weapon);
            weapon = null;
          }
      }
    
    public void addToInv(Special s)
      {
        if (inventory.contains(s))
          {
            inventory.get(inventory.indexOf(s)).increaseCount();
          } else
          {
            inventory.add(s);
          }
      }
    
    public void removeFromInv(Special s)
      {
        if (inventory.contains(s))
          {
            inventory.get(inventory.indexOf(s)).decreaseCount();
          } else
          {
            inventory.remove(s);
          }
      }
    
    public Special removeFromInv(int itemIndex)
      {
        if (inventory.get(itemIndex).getCount() > 1)
          {
            inventory.get(itemIndex).decreaseCount();
            return inventory.get(itemIndex);
          } else
          {
            return inventory.remove(itemIndex);
          }
      }
    
    public ArrayList<Special> getInventory()
      {
        return inventory;
      }
    
    public String[] getInventoryString()
      {
        Object[] invArr = inventory.toArray();
        String[] temp = new String[invArr.length];
        
        for (int loop = 0; loop < invArr.length; loop++)
          {
            Special tempSpec = (Special) invArr[loop];
            temp[loop] = tempSpec.getName() + " (x"+tempSpec.getCount()+")";
          }
        return temp;
      }
    
    public int[] getInventoryPrices()
      {
        Object[] invArr = inventory.toArray();
        int [] temp = new int[invArr.length];
        
        for (int loop = 0; loop < invArr.length; loop++)
          {
            Special tempSpec = (Special) invArr[loop];
            temp[loop] = (tempSpec.getWorth());
          }
        return temp;
      }
    
    public String[] getInventoryNameCountAndPrice()
      {
        Special[] invArr = inventory.toArray(new Special[0]);
        String[] temp = new String[invArr.length];

        for (int loop = 0; loop < invArr.length; loop++)
          {
            Special tempSpec = (Special) invArr[loop];
            temp[loop] = (tempSpec.getName() + " - \t" + tempSpec.getWorth() + " gold - \t (x" + tempSpec.getCount()+")");
          }
        return temp;
      }
    
    public boolean addGold(int amount)
      {
        if (gold + amount >= 0)
          {
            gold += amount;
            return true;
          } else
          {
            return false;
          }
      }
    
    public int getGold()
      {
        return gold;
      }
    
    public double getHealth()
      {
        return health;
      }
    
    public void setHealth(double h)
      {
        health = h;
      }
    
    public double getMaxHealth()
      {
        return maxHealth;
      }
    
    public void setMaxHealth(double h)
      {
        maxHealth = h;
      }
    
    public double getArmour()
      {
        return armour;
      }
    
    public void setArmour(double AP)
      {
        armour = AP;
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
  }
