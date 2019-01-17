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
        if (inventory.contains(item))
          {
            inventory.get(inventory.indexOf(item)).increaseCount();
          } else
          {
            inventory.add(item);
          }
      }

    public void removeFromInv(Special item)
      {
        if (inventory.contains(item))
          {
            inventory.get(inventory.indexOf(item)).decreaseCount();
          } else
          {
            inventory.remove(item);
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
            temp[loop] = tempSpec.getName() + " (x"+tempSpec.getCount()+")";
          }
        return temp;
      }

    public ArrayList<Special> getInventory()
      {
        return inventory;
      }

    public int[] getInventoryPrices()
      {
        Object[] invArr = inventory.toArray();
        int[] temp = new int[invArr.length];

        for (int loop = 0; loop < invArr.length; loop++)
          {
            Special tempSpec = (Special) invArr[loop];
            temp[loop] = (int)Math.round(tempSpec.getWorth() * 1.5);
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
  }
