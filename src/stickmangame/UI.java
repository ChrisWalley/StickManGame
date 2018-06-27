/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stickmangame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Christopher
 */
public class UI extends javax.swing.JFrame implements KeyListener
{

    /**
     * Creates new form UI
     */
    public UI()
    {
        initComponents();
        this.addKeyListener(this);
        this.setFocusable(true);
        this.requestFocusInWindow();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnlBackground = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaDisplay = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txaDisplay.setEditable(false);
        txaDisplay.setColumns(20);
        txaDisplay.setFont(new java.awt.Font("Courier", 0, 13)); // NOI18N
        txaDisplay.setRows(5);
        txaDisplay.setFocusable(false);
        jScrollPane1.setViewportView(txaDisplay);

        javax.swing.GroupLayout jpnlBackgroundLayout = new javax.swing.GroupLayout(jpnlBackground);
        jpnlBackground.setLayout(jpnlBackgroundLayout);
        jpnlBackgroundLayout.setHorizontalGroup(
            jpnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnlBackgroundLayout.setVerticalGroup(
            jpnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void StartUI()
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() ->
        {
            new UI().setVisible(true);
            JOptionPane.showMessageDialog(null,"Welcome!\nUse the arrow keys to move around.\nUse \'I\' to open your inventory.");
            txaDisplay.setText(StickManGame.getMapAsString());
            StickManGame.gameStarted();
            StickManGame.unPause();
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpnlBackground;
    private static javax.swing.JTextArea txaDisplay;
    // End of variables declaration//GEN-END:variables

    @Override
    public void keyTyped(KeyEvent e)
    {
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        int keyCode = e.getKeyCode();
        if(!StickManGame.isPaused())
         switch( keyCode ) 
         { 
           case KeyEvent.VK_UP:
               moveChar('^');
               break;
           case KeyEvent.VK_DOWN:
               moveChar('v');
               break;
           case KeyEvent.VK_LEFT:
               moveChar('<');
              break;
          case KeyEvent.VK_RIGHT:
               moveChar('>');
               break;
          case KeyEvent.VK_I:
               openInv();
               break;
          case KeyEvent.VK_ESCAPE:
               openPauseMenu();
               break;   
         }    
    }

    public void moveChar(char d)
    {
        boolean sideWays;
        int dir = 0;
        
        
        if(d=='<'||d=='>')
            sideWays = true;
        else
            sideWays = false;
        
        if(d=='>'||d=='v')
            dir = (1);
        else
            dir = (-1);
        

        
        if(sideWays)
        {
            moveHoriz(dir);
        }
        else 
        {
            moveVert(dir);
        }
        
        
      //  for (String map1 : map)
      //      System.out.println(map1);
        
        
    }
    
    public static void reDraw()
    {
        try
        {
        txaDisplay.setText(StickManGame.getMapAsString());
        }
        catch (NullPointerException e)
        {
            System.out.println("Error"+e);
        }
    }
    
    public void moveHoriz(int d)
    {
        String [] map = StickManGame.getCurrMap();
        Coord charPos = StickManGame.getCharPos();
        int X = charPos.getX();
        int Y = charPos.getY();
        
            int newX = X+d;
            if(newX>=0&&newX<StickManGame.getWidth())
            if(map[Y].charAt(newX)==' ')
            {
                map[Y] = (map[Y].substring(0,X)+StickManGame.getInPlace()+map[Y].substring(X+1));
                char temp = map[Y].charAt(newX);
                map[Y] = (map[Y].substring(0,newX)+"웃"+map[Y].substring(newX+1));
                StickManGame.setInPlace(temp);
                charPos.setX(newX);
                StickManGame.setCurrMap(map);
                StickManGame.setCharPos(charPos);
                reDraw();
            }
            else
                if((map[Y].charAt(newX)=='⌑')||(map[Y].charAt(newX)=='◊')||(map[Y].charAt(newX)=='⏚'))
                    {
                         if(StickManGame.foundSpecial(new Coord(newX, Y)))
                             map[Y] = (map[Y].substring(0,newX)+"⌂"+map[Y].substring(newX+1));
                         
                         StickManGame.setCurrMap(map);
                         reDraw();
                    }
            else
                if((map[Y].charAt(newX)=='>'))
                    {
                        String nextMapID = StickManGame.getNextMapID('>');
                        StickManGame.changeMap(nextMapID, charPos, new Coord(1, Y), false);
                        reDraw();
                    }
                
                else
                if((map[Y].charAt(newX)=='<'))
                    {
                        String nextMapID = StickManGame.getNextMapID('<');
                        StickManGame.changeMap(nextMapID, charPos, new Coord(StickManGame.getWidth()-2, Y), false);
                        reDraw();
                    }
            else
                if((StickManGame.isEnemy(map[Y].charAt(newX))))
                    {
                        StickManGame.encounteredMob(new Coord(newX,Y));
                    }
             else
                if((StickManGame.isFriendly(map[Y].charAt(newX))))
                    {
                        StickManGame.encounteredFriend(new Coord(newX,Y));
                    }
    }
    
    public void moveVert(int d)
    {
        
            String [] map = StickManGame.getCurrMap();
            Coord charPos = StickManGame.getCharPos();
            int X = charPos.getX();
            int Y = charPos.getY();
            int newY = Y+d;
            if(newY>=0&&newY<StickManGame.getHeight())
            if(map[newY].charAt(X)==' ')
            {
                map[Y] = (map[Y].substring(0,X)+StickManGame.getInPlace()+map[Y].substring(X+1));
                char temp = map[newY].charAt(X);
                map[newY] = (map[newY].substring(0,X)+"웃"+map[newY].substring(X+1));
                StickManGame.setInPlace(temp);
                charPos.setY(newY);
                StickManGame.setCurrMap(map);
                StickManGame.setCharPos(charPos);
                reDraw();
            }
            else 
                if((map[newY].charAt(X)=='⌑')||(map[newY].charAt(X)=='◊')||(map[newY].charAt(X)=='⏚'))
            {
                if(StickManGame.foundSpecial(new Coord(X, newY)))
                    map[newY] = (map[newY].substring(0,X)+"⌂"+map[newY].substring(X+1));
                
                StickManGame.setCurrMap(map);
                reDraw();
            }
             else
                if((map[newY].charAt(X)=='^'))
                    {
                        String nextMapID = StickManGame.getNextMapID('^');
                        StickManGame.changeMap(nextMapID, charPos, new Coord(X,StickManGame.getHeight()), false);
                        reDraw();
                    }
            
            else
                if((StickManGame.isEnemy(map[newY].charAt(X))))
                    {
                        StickManGame.encounteredMob(new Coord(X,newY));
                    }
             else
                if((StickManGame.isFriendly(map[newY].charAt(X))))
                    {
                        StickManGame.encounteredFriend(new Coord(X,newY));
                    }
    }
    
    @Override
    public void keyReleased(KeyEvent e)
    {
    }
    
    public void openInv()
    {
        Inventory InvUI = new Inventory();
        StickManGame.pause();
        InvUI.startUI();
    }
    public void openPauseMenu()
    {
        PauseMenu PauseUI = new PauseMenu();
        StickManGame.pause();
        PauseUI.startPauseMenu();
    }
}
