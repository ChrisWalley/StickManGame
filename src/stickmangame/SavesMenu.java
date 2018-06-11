/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stickmangame;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Christopher
 */
public class SavesMenu extends javax.swing.JFrame
{
    private ArrayList<String> tempList = new ArrayList<>();
    private String [] stringArr;
    private static boolean fromMainBool = false;
    
    public SavesMenu()
    {
    try
    {
        Scanner readFile = new Scanner(new File("SaveFiles.smm"));
        while(readFile.hasNextLine())
            tempList.add(readFile.nextLine());
        
                stringArr = new String [tempList.size()];
                for(int loop = 0; loop <tempList.size(); loop++)
                    stringArr[loop] = tempList.get(loop);
                if(!(stringArr.length>0))
                {
                    String [] other = {"No Save Files Found"};
                    stringArr = other;
                }
                  
        readFile.close();
         initComponents();
         
    } catch (FileNotFoundException ex)
    {
      String [] other = {"No Save Files Found"};
      stringArr = other;   
      initComponents();
    }
    this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter()
        {
             @Override
             public void windowClosing(WindowEvent e)
             {
                 dispose();
             }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jScrollPane1 = new javax.swing.JScrollPane();
        SavesList = new javax.swing.JList();
        btnLoad = new javax.swing.JButton();
        btnDelSave = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        SavesList.setModel(new javax.swing.AbstractListModel()
            {
                String[] strings = stringArr;
                public int getSize() { return strings.length; }
                public Object getElementAt(int i) { return strings[i]; }
            });
            jScrollPane1.setViewportView(SavesList);

            btnLoad.setText("Load Save");
            btnLoad.addActionListener(new java.awt.event.ActionListener()
            {
                public void actionPerformed(java.awt.event.ActionEvent evt)
                {
                    btnLoadActionPerformed(evt);
                }
            });

            btnDelSave.setText("Delete");
            btnDelSave.addActionListener(new java.awt.event.ActionListener()
            {
                public void actionPerformed(java.awt.event.ActionEvent evt)
                {
                    btnDelSaveActionPerformed(evt);
                }
            });

            jButton1.setText("Back");
            jButton1.addActionListener(new java.awt.event.ActionListener()
            {
                public void actionPerformed(java.awt.event.ActionEvent evt)
                {
                    jButton1ActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addContainerGap())
                .addGroup(layout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addComponent(btnLoad)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelSave, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(26, 26, 26))
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jButton1)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jButton1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnLoad)
                        .addComponent(btnDelSave))
                    .addGap(0, 70, Short.MAX_VALUE))
            );

            pack();
            setLocationRelativeTo(null);
        }// </editor-fold>//GEN-END:initComponents

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnLoadActionPerformed
    {//GEN-HEADEREND:event_btnLoadActionPerformed
            if(!(SavesList.getSelectedValue().toString().equals("No Save Files Found")))
            {

             if(fromMainBool)
             {
               if(StickManGame.Load(SavesList.getSelectedValue().toString()));  
               {
                    this.dispose();
                    UI.StartUI();
                    UI.reDraw();
               }
             }
             else
             {
             if(StickManGame.Load(SavesList.getSelectedValue().toString())); 
             {
                    this.dispose();
                    UI.reDraw();
             }
             }
            }
    }//GEN-LAST:event_btnLoadActionPerformed

    private void btnDelSaveActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnDelSaveActionPerformed
    {//GEN-HEADEREND:event_btnDelSaveActionPerformed
            PrintWriter fileNames = null;
        try
        {
            if(!(SavesList.getSelectedValue().toString().equals("No Save Files Found")))
                for(int loop = 0; loop < stringArr.length;loop++)
                {
                    if(stringArr[loop].equals(SavesList.getSelectedValue().toString()))
                    {
                        new File("Save - "+stringArr[loop]+".sms").delete();
                        tempList.remove(loop);
                    }
                }
            stringArr = new String [tempList.size()];
            for(int loop = 0; loop <tempList.size(); loop++)
            {
                stringArr[loop] = tempList.get(loop);
                fileNames = new PrintWriter(new FileWriter("SaveFiles.smm",false));
                fileNames.append(stringArr[loop]);
            }
            if(!(stringArr.length>0))
            {
                String [] other = {"No Save Files Found"};
                fileNames = new PrintWriter(new FileWriter("SaveFiles.smm",false));
                stringArr = other;
            }
            SavesList.setModel(new javax.swing.AbstractListModel()
            {
                String[] strings = stringArr;
                public int getSize() { return strings.length; }
                public Object getElementAt(int i) { return strings[i]; }
            }); 
            
            
        } catch (IOException ex)
        {
            Logger.getLogger(SavesMenu.class.getName()).log(Level.SEVERE, null, ex);
        } finally
        {
            fileNames.close();
        }
    }//GEN-LAST:event_btnDelSaveActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
if(fromMainBool)   
{
    this.dispose();
    MainMenu.StartUI();
}
else
    this.dispose();
// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param fromMain
     * @param args the command line arguments
     */
    public static void StartUI(boolean fromMain)
    {
        fromMainBool = fromMain;
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
            java.util.logging.Logger.getLogger(SavesMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(SavesMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(SavesMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(SavesMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new SavesMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList SavesList;
    private javax.swing.JButton btnDelSave;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
