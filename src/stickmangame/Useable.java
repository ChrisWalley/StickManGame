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
public class Useable extends Special
  {
    private int uses;
    private String itemUseText = "You used the "+this.getName();
    
    public Useable(String nameString, String typeStr, int price, int count, int uses, String itemUseText)
      {
        super(nameString, typeStr, price, count);
        this.itemUseText = itemUseText;
        this.uses = uses;
      }

    public Useable(String nameString, Coord loc, String typeString, String mapIDString, int price, int count, int uses, String itemUseText)
      {
        super(nameString, loc, typeString, mapIDString, price, count);
        this.itemUseText = itemUseText;
        this.uses = uses;
      }
    
    public void use()
      {
        uses--;
      }
    
    public void charge()
      {
        uses++;
      }
    
    public String getItemText()
      {
        return itemUseText;
      }
    
    public int getUses()
      {
        return uses;
      }
    
  }
