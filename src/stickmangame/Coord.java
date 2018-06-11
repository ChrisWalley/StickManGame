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
public class Coord implements java.io.Serializable
{
    private int x;
    private int y;
    
    public Coord(int xPos, int yPos)
    {
        x = xPos;
        y = yPos;
    }
    
    public void set(int xPos, int yPos)
    {
        x = xPos;
        y = yPos;
    }
    
    public void setX(int xPos)
    {
        x = xPos;
    }
    
    public void setY(int yPos)
    {
        y = yPos;
    }
    
    public Coord getCoords()
    {
        return this;
    }
    
    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    }
    
    @Override
    public String toString()
    {
        return (x+";"+y);
    }
    
    @Override
    public int hashCode() {
        final int PRIME = 31;
        return PRIME+x*y;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Coord other = (Coord) obj;
        if (this.x != other.x)
        {
            return false;
        }
        if (this.y != other.y)
        {
            return false;
        }
        return true;
    }
 
    /*public boolean equals(Coord obj) {
        if ((this.getX() == obj.getX())&&(this.getY() == obj.getY())) 
            return true;
        else
            return false;
    }*/
    
    public void moveHoriz(int i)
    {
        x+=i;
    }
    public void moveVert(int i)
    {
        y+=i;
    }
}
