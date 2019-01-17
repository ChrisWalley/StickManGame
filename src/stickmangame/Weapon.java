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
public class Weapon extends Special
  {

    private double damage;

    public Weapon(String name, Coord location, String type, String map, double damageDouble, int price, int count)
      {
        super(name, location, type, map, price, count);
        damage = damageDouble;
      }

    public Weapon()
      {
        super();
      }

    public Weapon(String name, String type, double dam, int price, int count)
      {
        super(name, type, price, count);
        damage = dam;
      }

    public void setAP(double d)
      {
        damage = d;
      }

    public double getDamage()
      {
        return damage;
      }

    @Override
    public String toInfo()
      {
        return (this.getName() + " - " + damage + "dmg");
      }
  }
