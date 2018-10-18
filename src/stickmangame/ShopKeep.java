/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stickmangame;

import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author Christopher
 */
public class ShopKeep extends MobUnit
  {

    private ArrayList<Special> inventory = new ArrayList(0);

    public ShopKeep(Coord pos, String map, String name)
      {
        super(pos, map);
        this.setIcon('$');
        this.setName(name);
      }

    public ShopKeep(Coord posCoord, double healthPoints, double armourPoints, double damagePoints, Map dropsMap, String mapString, Coord position2, String name)
      {
        super(posCoord, healthPoints, armourPoints, damagePoints, dropsMap, mapString);
        this.setIcon('$');
        this.setName(name);
      }

    public void addToInv(Special item)
      {
        inventory.add(item);
      }

    public void removeFromInv(Special item)
      {
        inventory.remove(item);
      }

    public void removeFromInv(int itemIndex)
      {
        inventory.remove(itemIndex);
      }

    public ArrayList<Special> getInv()
      {
        return inventory;
      }

    public void setInv(ArrayList<Special> s)
      {
        inventory = s;
      }

    public String[] getInventoryString()
      {
        Object[] invArr = inventory.toArray();
        String[] temp = new String[invArr.length];

        for (int loop = 0; loop < invArr.length; loop++)
          {
            Special tempSpec = (Special) invArr[loop];
            temp[loop] = tempSpec.getName();
          }
        return temp;
      }

    public ArrayList<Special> getInventory()
      {
        return inventory;
      }

    public String[] getInventoryPrices()
      {
        Object[] invArr = inventory.toArray();
        String[] temp = new String[invArr.length];

        for (int loop = 0; loop < invArr.length; loop++)
          {
            Special tempSpec = (Special) invArr[loop];
            temp[loop] = ("" + tempSpec.getWorth() * 1.5);
          }
        return temp;
      }

    public String[] getInventoryNameAndPrice()
      {
        Object[] invArr = inventory.toArray();
        String[] temp = new String[invArr.length];

        for (int loop = 0; loop < invArr.length; loop++)
          {
            Special tempSpec = (Special) invArr[loop];
            temp[loop] = (tempSpec.getName() + " - \t" + tempSpec.getWorth());
          }
        return temp;
      }
  }
