/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stickmangame;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
// List of chars used ◊&@×ɯ$⏚⌑℧
//rRG8ewm2weDfsYayCkrY_A
/**
 *
 * @author Christopher
 */
public class StickManGame
  {

    private static String[] currMap;
    private static String[][][] mapsList;
    private static String[] savesList;
    private static String currMapID;
    private static final String ENEMY_CHAR_LIST = "&@×ɯ";
    private static final String SPECIAL_CHAR_LIST = "ɸψ⏚F";
    private static final String FRIEND_CHAR_LIST = "$";

    private static boolean isPaused = true;
    private static boolean updatesPaused = true;
    private static Map<Coord, Special> Specials = new HashMap<>();
    private static Map<Coord, MobUnit> MobsMap = new HashMap<>();
    private static char inPlace = getCharacterIcon();
    private static final char CHAR_ICON = 'O';
    private static final char SPECIAL_ICON = 'ɸ';
    private static final char WEAPON_ICON = 'ψ';
    private static final char ARMOUR_ICON = '⏚';

    public final static int HELM = 0;
    public final static int CHEST = 1;
    public final static int LEGS = 2;
    public final static int FEET = 3;

    public final static String START_MAP = "A0";
    public final static String LVL_2_MAP = "A1";

    private static int WIDTH;
    private static int HEIGHT;

    private static ArrayList<MobUnit> mobs = new ArrayList<>();
    private static ArrayList<Special> items = new ArrayList<>();
    private static ArrayList<Weapon> weapons = new ArrayList<>();

    private static StickMan MainMan = new StickMan();

    private static boolean gameStarted = false;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
      {
        mapsList = readMaps();
        savesList = readSaves();
        Timer timer = new Timer(750, (ActionEvent arg0)
                ->
          {
            if (!(isPaused))
              {
                if (!StickManGame.areUpdatesPaused())
                    StickManGame.updateMobs();
                UI.reDraw();
              }
          });
        timer.setRepeats(true);

        populateArrays();
        changeMap(START_MAP, null, new Coord(3, 16), true);
        detectWidthAndHeight();
        MainMenu.StartUI();
        timer.start();
      }

    public static void setWidth(int w)
      {
        WIDTH = w;
      }

    public static int getWidth()
      {
        return WIDTH;
      }

    public static void detectWidthAndHeight()
      {
        WIDTH = currMap[0].length();
        HEIGHT = currMap.length;
      }

    public static void setHeight(int h)
      {
        HEIGHT = h;
      }

    public static int getHeight()
      {
        return HEIGHT;
      }

    public static StickMan getCharacter()
      {
        return MainMan;
      }

    public static String getMapAsString()
      {
        String s = "";
        for (String map1 : currMap)
          {
            s = s.concat(map1 + "\n");
          }
        return s;
      }

    public static String[] getCurrMap()
      {
        return currMap;
      }

    public static void setCurrMap(String[] m)
      {
        currMap = m;
      }

    public static Coord getCharPos()
      {
        return MainMan.getPos();
      }

    public static void setCharPos(Coord c)
      {
        MainMan.setPos(c);
      }

    public Coord findStickMan()
      {
        for (int loop = 0; loop < currMap.length; loop++)
          {
            if (currMap[loop].contains("" + getCharacterIcon()))
              {
                return new Coord(currMap[loop].indexOf("" + getCharacterIcon()), loop);
              }
          }
        return new Coord(0, 0);
      }

    public static void setStickman(Coord c)
      {
        int x = c.getX();
        int y = c.getY();

        char t = currMap[y].charAt(x);

        String newLine = (currMap[y].substring(0, x) + inPlace + currMap[y].substring(x + 1));
        currMap[y] = newLine;
        inPlace = t;
      }

    public static void setChar(Coord c, char ch)
      {
        String firstHalf = currMap[c.getY()].substring(0, c.getX());
        String secondHalf = "";
        if (c.getX() < currMap[c.getY()].length())
          {
            secondHalf = currMap[c.getY()].substring(c.getX() + 1);
          } else
          {
            System.out.println("ere");
          }
        currMap[c.getY()] = (firstHalf + ch + secondHalf);
      }

    public static char getInPlace()
      {
        return inPlace;
      }

    public static void setInPlace(char p)
      {
        inPlace = p;
      }

    public static void placeSpecial(Special n)
      {
        Specials.put(n.Getlocation(), n);
        setChar(n.Getlocation(), SPECIAL_ICON);
      }

    public static void placeArmour(Armour n)
      {
        Specials.put(n.Getlocation(), n);
        setChar(n.Getlocation(), ARMOUR_ICON);
      }

    public static void placeWeapon(Weapon n)
      {
        Specials.put(n.Getlocation(), n);
        setChar(n.Getlocation(), WEAPON_ICON);
      }

    public static void placeMob(MobUnit e)
      {
        MobsMap.put(e.getPos(), e);
        setChar(e.getPos(), e.getIcon());
      }

    public static void moveMob(MobUnit e)
      {
        MobsMap.put(e.getPos(), e);
        setChar(e.getPos(), e.getIcon());
      }

    public static boolean foundSpecial(Coord c)
      {
        System.out.println(Specials.containsKey(c));
        Specials.get(c).found();
        Special Spec = Specials.get(c);
        int option = JOptionPane.showConfirmDialog(null, "You found: " + Spec.toInfo() + "!\nAdd to inventory?", "New Item Found!", JOptionPane.YES_NO_OPTION);

        if (option == JOptionPane.YES_OPTION)
          {
            MainMan.addToInv(Spec);
            return true;
          } else
          {
            JOptionPane.showMessageDialog(null, "You discarded the " + Spec.getName());
            return false;
          }

      }

    public static void changeMap(String mapNo, Coord playerPos, Coord newPlayerPos, boolean f)
      {
        if (!f)
          {
            saveCurrMap();
          }

        if (playerPos != null)
          {
            setStickman(playerPos);
          }

        currMapID = mapNo;
        currMap = getMap(mapNo);
        loadSpecials(mapNo);
        loadWeapons(mapNo);
        loadMobs(mapNo);
        setStickman(newPlayerPos);
        setCharPos(newPlayerPos);

        //special stuff
        switch (mapNo)
          {
            case START_MAP:
                break;

            case LVL_2_MAP:
                Coord[] s
                        =
                          {
                            new Coord(0, 7), new Coord(0, 8), new Coord(0, 9), new Coord(0, 10)
                          };
                reveal(s, '<');
                break;

          }
      }

    public static void saveCurrMap()
      {
        setMap(currMapID, currMap);
      }

    public static String getNextMapID(char dir)
      {
        char letter = currMapID.charAt(0);
        char num = currMapID.charAt(1);
        switch (dir)
          {
            case '>':
                num++;
                break;

            case '<':
                num--;
                break;

            case 'v':
                letter++;
                break;

            case '^':
                letter--;
                break;
          }

        return (letter + "" + num);
      }

    public static void updateMobs()
      {
        mobs.stream().filter((mob) -> (mob.getMapID().equals(currMapID))).forEachOrdered((mob) ->
          {
            mob.nextPos();
          });
      }

    public void addMob(MobUnit c)
      {
        mobs.add(c);
      }

    public static void loadSpecials(String mapID)
      {
        items.stream().filter((item) -> (item.getMapID().equals(mapID))).filter((item) -> (!item.isFound())).forEachOrdered((item) ->
          {
            placeSpecial(item);
          });
      }

    public static void loadWeapons(String mapID)
      {
        weapons.stream().filter((weapon) -> (weapon.getMapID().equals(mapID))).filter((weapon) -> (!weapon.isFound())).forEachOrdered((weapon) ->
          {
            placeWeapon(weapon);
          });
      }

    public static void loadMobs(String mapID)
      {
        for (int loop = 0; loop < mobs.size(); loop++)
          {
            if (mobs.get(loop).getMapID().equals(mapID))
              {
                placeMob(mobs.get(loop));
              }
          }
      }

    public static void populateArrays()
      {
        //items
        items.add(new Special("The Map of Arkangthamz", new Coord(19, 12), "Map", START_MAP, 15).makeUseable());

        //weapons
        weapons.add(new Weapon("Stone sword", new Coord(14, 2), "Weapon", START_MAP, 4, 5));

        //armour
        
        
        //mobs
        mobs.add(new Bat(new Coord(3, 9), 10, 0, 5, null, START_MAP, new Coord(3, 10)));
        mobs.add((new Bat(new Coord(34, 1), 10, 0, 5, null, LVL_2_MAP, new Coord(35, 1))).addDrop(100.00, new Special("Old silver key", "Key", 2)));
        mobs.add(new Bat(new Coord(11, 1), 10, 0, 5, null, LVL_2_MAP, new Coord(11, 2)));

        ShopKeep Marvin = new ShopKeep(new Coord(15, 15), LVL_2_MAP, "Marvin - Shopkeeper");
        Marvin.addToInv(new Weapon("Iron sword", "Weapon", 10, 10));
        Marvin.addToInv(new Armour("Leather Chestpiece", "Weapon", CHEST, 3, 10));
        Marvin.addToInv(new Weapon("Wooden sword", "Weapon", 3, 2));
        mobs.add(Marvin);

      }

    public static void swapChars(Coord pos1, Coord pos2)
      {
        char char1 = currMap[pos1.getY()].charAt(pos1.getX());
        char char2 = currMap[pos2.getY()].charAt(pos2.getX());
        setChar(pos1, char2);
        setChar(pos2, char1);
      }

    public static Boolean canSwapChars(Coord pos1, Coord pos2)
      {
        char char1 = currMap[pos1.getY()].charAt(pos1.getX());
        char char2 = currMap[pos2.getY()].charAt(pos2.getX());
        return !(char1 == getCharacterIcon() || char2 == getCharacterIcon());
      }

    public static void gameStarted()
      {
        gameStarted = true;
      }

    public static boolean hasGameStarted()
      {
        return gameStarted;
      }

    public static void encounteredMob(int ID)
      {
        pause();
        for (int loop = 0; loop < mobs.size(); loop++)
          {

            if (mobs.get(loop).getID() == ID)
              {
                MobUnit temp = mobs.get(loop);
                Coord c = temp.getCurrPos();
                JOptionPane.showMessageDialog(null, "You have encountered a " + temp.getName() + "\nHealth: " + temp.getHealth() + "\tArmour: " + temp.getArmour());
                FightUI fight = new FightUI();
                fight.startFightUI(temp, c);
                break;
              }
          }
      }

    public static void encounteredMob(Coord tempC)
      {
        pause();
        Coord c = tempC;
        for (int loop = 0; loop < mobs.size(); loop++)
          {

            Coord tempCoord = mobs.get(loop).getAllPos()[mobs.get(loop).getCurrPosIndex()];
            if (tempCoord.equals(tempC))
              {
                MobUnit temp = mobs.get(loop);
                JOptionPane.showMessageDialog(null, "You have encountered a " + temp.getName() + "\nHealth: " + temp.getHealth() + "\tArmour: " + temp.getArmour());
                FightUI fight = new FightUI();
                fight.startFightUI(temp, c);
                break;
              }
          }
      }

    public static void encounteredFriend(Coord tempC)
      {
        pause();
        Coord c = tempC;
        for (int loop = 0; loop < mobs.size(); loop++)
          {

            Coord tempCoord = mobs.get(loop).getAllPos()[mobs.get(loop).getCurrPosIndex()];
            if (tempCoord.equals(tempC))
              {
                ShopKeep temp = (ShopKeep) mobs.get(loop);
                JOptionPane.showMessageDialog(null, "You have encountered a " + temp.getName());
                InteractUI interaction = new InteractUI();
                interaction.startUI(temp, c);
                break;
              }
          }
      }

    public static void setMob(MobUnit E, Coord C)
      {
        if (E.isAlive())
          {
            MobUnit old = MobsMap.get(C);
            MobsMap.replace(C, old, E);
            mobs.set(mobs.indexOf(old), E);
          } else
          {
            MobsMap.remove(C);
            mobs.remove(E);
            setChar(C, ' ');
          }
      }

    public static boolean isEnemy(char c)
      {
        return ENEMY_CHAR_LIST.indexOf(c) != -1;
      }

    public static boolean isFriendly(char c)
      {
        return FRIEND_CHAR_LIST.indexOf(c) != -1;
      }

    public static boolean isSpecial(char c)
      {
        return SPECIAL_CHAR_LIST.indexOf(c) != -1;
      }

    public static boolean isPaused()
      {
        return isPaused;
      }

    public static boolean areUpdatesPaused()
      {
        return updatesPaused;
      }

    public static void pause()
      {
        isPaused = true;
        updatesPaused = true;
        System.out.println("Paused");
      }

    public static void unPauseWithBreak()
      {
        isPaused = false;
        Timer timer = new Timer(1500, (ActionEvent arg0) ->
          {
            updatesPaused = false;
            System.out.println("UnPaused");
          });
        timer.setRepeats(false);
        timer.start();
      }

    public static void unPause()
      {
        isPaused = false;
        updatesPaused = false;
        System.out.println("UnPaused");
      }

    public static void setPlayer(StickMan s)
      {
        MainMan = s;
      }

    public static String use(Special s)
      {
        switch (s.getName())
          {
            case ("The Map of Arkangthamz"):
                if (currMapID.equals(START_MAP))
                  {
                    Coord[] coords
                            =
                              {
                                new Coord(37, 7), new Coord(37, 8), new Coord(37, 9), new Coord(37, 10)
                              };
                    reveal(coords, '>');
                    return "You look over the map,\nand discover an open\npassage to the East";
                  } else
                  {
                    return "You can't use this item\nin this area";
                  }

          }
        return "";
      }

    public static void reveal(Coord[] s, char c)
      {
        for (Coord item : s)
          {
            setChar(item, c);
          }

      }

    public static void Save(String s)
      {
        FileOutputStream fos;
        try
          {
            try (PrintWriter fileNames = new PrintWriter(new FileWriter("SaveFiles.smm", true)))
              {
                fileNames.append(";" + s);
              }

            fos = new FileOutputStream("Save - " + s + ".sms");
            try (ObjectOutputStream oos = new ObjectOutputStream(fos))
              {
                oos.writeObject(currMap);
                oos.writeObject(mapsList);
                oos.writeObject(currMapID);
                //oos.writeObject(startMap);
                //oos.writeObject(lvl2Map);
                oos.writeBoolean(isPaused);
                oos.writeBoolean(updatesPaused);
                oos.writeObject(Specials);
                oos.writeObject(MobsMap);
                oos.writeObject(inPlace);
                oos.writeObject(mobs);
                oos.writeObject(items);
                oos.writeObject(weapons);
                oos.writeObject(MainMan);
                oos.writeBoolean(gameStarted);
              }

          } catch (FileNotFoundException ex)
          {
            System.out.println(ex);
          } catch (IOException ex)
          {
            System.out.println(ex);
          }

      }

    public static boolean Load(String s)
      {
        boolean success = false;
        try
          {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Save - " + s + ".sms")))
              {
                currMap = (String[]) ois.readObject();
                mapsList = (String[][][]) ois.readObject();
                currMapID = (String) ois.readObject();
                // startMap = (String []) ois.readObject();
                // lvl2Map = (String []) ois.readObject();
                isPaused = (boolean) ois.readObject();
                updatesPaused = (boolean) ois.readObject();
                Specials = (Map<Coord, Special>) ois.readObject();
                MobsMap = (Map<Coord, MobUnit>) ois.readObject();
                inPlace = (char) ois.readObject();
                mobs = (ArrayList<MobUnit>) ois.readObject();
                items = (ArrayList<Special>) ois.readObject();
                weapons = (ArrayList<Weapon>) ois.readObject();
                MainMan = (StickMan) ois.readObject();
                gameStarted = (boolean) ois.readObject();
              }
            success = true;

          } catch (FileNotFoundException ex)
          {
            System.out.println(ex);
          } catch (IOException | ClassNotFoundException ex)
          {
            System.out.println(ex);
          }
        return success;
      }

    public static String[][][] readMaps()
      {
        String[][][] maps = new String[2][10][17];

        int AorB;
        int OnetoX;
        int mapRow1toLength;

        try
          {
            Scanner scFile = new Scanner(new File("maps.txt")).useDelimiter("%");
            while (scFile.hasNext())
              {
                String code = scFile.next().trim();
                char letter = code.charAt(0);
                AorB = (letter & 31) - 1;

                OnetoX = Integer.parseInt("" + code.charAt(1));
                mapRow1toLength = -1;
                Scanner inLine = new Scanner(scFile.next()).useDelimiter(",");

                while (inLine.hasNext())
                  {
                    mapRow1toLength++;
                    maps[AorB][OnetoX][mapRow1toLength] = inLine.next().substring(1);
                  }
                maps[AorB][OnetoX][mapRow1toLength] = maps[AorB][OnetoX][mapRow1toLength].substring(0, maps[AorB][OnetoX][mapRow1toLength].length() - 1);
              }
          } catch (FileNotFoundException ex)
          {
            Logger.getLogger(StickManGame.class.getName()).log(Level.SEVERE, null, ex);
          }
        return maps;
      }

    public static String[] getMap(String code)
      {
        return mapsList[(((code.charAt(0)) & 31) - 1)][(code.charAt(1) - 48)];
      }

    public static void setMap(String code, String[] temp)
      {
        mapsList[(((code.charAt(0)) & 31) - 1)][(code.charAt(1) - 48)] = temp;
      }

    public static char getCharacterIcon()
      {
        return CHAR_ICON;
      }

    public static String[] readSaves()
      {
        ArrayList<String> list = new ArrayList<>();
        String[] stringArr;
        try
          {
            try (Scanner readFile = new Scanner(new File("SaveFiles.smm")).useDelimiter(";"))
              {
                while (readFile.hasNext())
                  {
                    list.add(readFile.next());
                  }

                stringArr = new String[list.size()];
                for (int loop = 0; loop < list.size(); loop++)
                  {
                    stringArr[loop] = list.get(loop);
                  }
                if (!(stringArr.length > 0))
                  {
                    String[] other =
                      {
                        "No Save Files Found"
                      };
                    stringArr = other;
                  }
              }

          } catch (FileNotFoundException ex)
          {
            String[] other =
              {
                "No Save Files Found"
              };
            stringArr = other;
          }
        return stringArr;
      }

    public static String getTime()
      {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return (dtf.format(now));
      }

  }
