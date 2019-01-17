/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stickmangame;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import static stickmangame.StickManGame.*;

/**
 *
 * @author Christopher
 */
public class Inventory extends javax.swing.JFrame
  {

    private StickMan p;

    /**
     * Creates new form Inventory
     */
    public Inventory()
      {
        p = StickManGame.getCharacter();
        initComponents();
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter()
          {
            @Override
            public void windowClosing(WindowEvent e)
              {
                StickManGame.unPauseWithBreak();
                StickManGame.setPlayer(p);
                dispose();
              }
          });
        
        loadEquipped();
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

        jPanel1 = new javax.swing.JPanel();
        lblEquipped = new javax.swing.JLabel();
        lblHelm = new javax.swing.JLabel();
        lblChest = new javax.swing.JLabel();
        lblLegs = new javax.swing.JLabel();
        lblBoots = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstInventory = new javax.swing.JList();
        lblInv = new javax.swing.JLabel();
        btnUse = new javax.swing.JButton();
        btnEquip = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        txaAction = new javax.swing.JTextArea();
        lblBoots1 = new javax.swing.JLabel();
        btnUnequipHelm = new javax.swing.JButton();
        lblDamage = new javax.swing.JLabel();
        lblArmour = new javax.swing.JLabel();
        lblHealth = new javax.swing.JLabel();
        lblDamagePoints = new javax.swing.JLabel();
        lblArmourPoints = new javax.swing.JLabel();
        lblHealthPoints = new javax.swing.JLabel();
        lblGold = new javax.swing.JLabel();
        lblGoldAmount = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();
        txfHelm = new javax.swing.JTextField();
        txfChest = new javax.swing.JTextField();
        txfLegs = new javax.swing.JTextField();
        txfFeet = new javax.swing.JTextField();
        txfWeapon = new javax.swing.JTextField();
        btnUnequipChest = new javax.swing.JButton();
        btnUnequipLegs = new javax.swing.JButton();
        btnUnequipFeet = new javax.swing.JButton();
        btnUnequipWeapon = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblEquipped.setText("Equipped Items");

        lblHelm.setText("Helm:");

        lblChest.setText("Chest:");

        lblLegs.setText("Legs:");

        lblBoots.setText("Feet:");

        lstInventory.setModel(new javax.swing.AbstractListModel()
            {
                String[] strings = p.getInventoryString();
                public int getSize() { return strings.length; }
                public Object getElementAt(int i) { return strings[i]; }
            });
            jScrollPane1.setViewportView(lstInventory);

            lblInv.setText("Inventory");

            btnUse.setText("Use");
            btnUse.addActionListener(new java.awt.event.ActionListener()
            {
                public void actionPerformed(java.awt.event.ActionEvent evt)
                {
                    btnUseActionPerformed(evt);
                }
            });

            btnEquip.setText("Equip");
            btnEquip.addActionListener(new java.awt.event.ActionListener()
            {
                public void actionPerformed(java.awt.event.ActionEvent evt)
                {
                    btnEquipActionPerformed(evt);
                }
            });

            txaAction.setColumns(20);
            txaAction.setLineWrap(true);
            txaAction.setRows(5);
            txaAction.setWrapStyleWord(true);
            jScrollPane6.setViewportView(txaAction);

            lblBoots1.setText("Weapon:");

            btnUnequipHelm.setText("Unequip");
            btnUnequipHelm.addActionListener(new java.awt.event.ActionListener()
            {
                public void actionPerformed(java.awt.event.ActionEvent evt)
                {
                    btnUnequipHelmActionPerformed(evt);
                }
            });

            lblDamage.setText("Damage:");

            lblArmour.setText("Armour:");

            lblHealth.setText("Health:");

            lblDamagePoints.setText(""+p.getDamage());

            lblArmourPoints.setText(""+p.getArmour());

            lblHealthPoints.setText(""+p.getHealth());

            lblGold.setText("Gold:");

            lblGoldAmount.setText(""+p.getGold());

            btnClose.setText("Close");
            btnClose.addActionListener(new java.awt.event.ActionListener()
            {
                public void actionPerformed(java.awt.event.ActionEvent evt)
                {
                    btnCloseActionPerformed(evt);
                }
            });

            txfHelm.setEditable(false);

            txfChest.setEditable(false);

            txfLegs.setEditable(false);

            txfFeet.setEditable(false);

            txfWeapon.setEditable(false);

            btnUnequipChest.setText("Unequip");
            btnUnequipChest.addActionListener(new java.awt.event.ActionListener()
            {
                public void actionPerformed(java.awt.event.ActionEvent evt)
                {
                    btnUnequipChestActionPerformed(evt);
                }
            });

            btnUnequipLegs.setText("Unequip");
            btnUnequipLegs.addActionListener(new java.awt.event.ActionListener()
            {
                public void actionPerformed(java.awt.event.ActionEvent evt)
                {
                    btnUnequipLegsActionPerformed(evt);
                }
            });

            btnUnequipFeet.setText("Unequip");
            btnUnequipFeet.addActionListener(new java.awt.event.ActionListener()
            {
                public void actionPerformed(java.awt.event.ActionEvent evt)
                {
                    btnUnequipFeetActionPerformed(evt);
                }
            });

            btnUnequipWeapon.setText("Unequip");
            btnUnequipWeapon.addActionListener(new java.awt.event.ActionListener()
            {
                public void actionPerformed(java.awt.event.ActionEvent evt)
                {
                    btnUnequipWeaponActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(43, 43, 43)
                            .addComponent(lblEquipped))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(lblBoots1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txfWeapon, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(lblChest)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txfChest, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(lblLegs)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txfLegs, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(lblBoots)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txfFeet, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(lblHelm)
                                    .addGap(50, 50, 50)
                                    .addComponent(txfHelm, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnUnequipHelm)
                                .addComponent(btnUnequipChest)
                                .addComponent(btnUnequipLegs)
                                .addComponent(btnUnequipFeet)
                                .addComponent(btnUnequipWeapon)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(29, 29, 29)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblDamage)
                                .addComponent(lblArmour)
                                .addComponent(lblHealth)
                                .addComponent(lblGold))
                            .addGap(24, 24, 24)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblArmourPoints, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblDamagePoints, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(lblHealthPoints)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addComponent(lblGoldAmount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(btnEquip)
                            .addGap(21, 21, 21)
                            .addComponent(btnUse)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                            .addComponent(lblInv)
                            .addGap(46, 46, 46)
                            .addComponent(btnClose)))
                    .addContainerGap())
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnClose)
                                .addComponent(lblInv))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(4, 4, 4)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnEquip)
                                .addComponent(btnUse))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblDamage)
                                .addComponent(lblDamagePoints))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblArmour)
                                .addComponent(lblArmourPoints))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblHealth)
                                .addComponent(lblHealthPoints))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblGold)
                                .addComponent(lblGoldAmount)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addComponent(lblEquipped)
                            .addGap(22, 22, 22)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblHelm)
                                .addComponent(txfHelm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnUnequipHelm))
                            .addGap(3, 3, 3)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblChest)
                                .addComponent(txfChest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnUnequipChest))
                            .addGap(3, 3, 3)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblLegs)
                                .addComponent(txfLegs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnUnequipLegs))
                            .addGap(3, 3, 3)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblBoots)
                                .addComponent(txfFeet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnUnequipFeet))
                            .addGap(13, 13, 13)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblBoots1)
                                .addComponent(txfWeapon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnUnequipWeapon))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap())
            );

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 3, Short.MAX_VALUE))
            );

            pack();
            setLocationRelativeTo(null);
        }// </editor-fold>//GEN-END:initComponents

    private void btnEquipActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnEquipActionPerformed
    {//GEN-HEADEREND:event_btnEquipActionPerformed

        Special item = p.getInventory().get(lstInventory.getSelectedIndex());
        if (item.getClass() == Armour.class)
          {
            Armour a = (Armour) p.removeFromInv(lstInventory.getSelectedIndex());
            p.equip(a, a.getSlot());
            switch (a.getSlot())
              {
                case HELM:
                    txfHelm.setText(a.getName());
                    break;

                case CHEST:
                    txfChest.setText(a.getName());
                    break;

                case LEGS:
                    txfLegs.setText(a.getName());
                    break;

                case FEET:
                    txfFeet.setText(a.getName());
                    break;
              }
            txaAction.setText("Equipped " + a.getName());
          } else if (p.getInventory().get(lstInventory.getSelectedIndex()).getClass() == Weapon.class)
          {
            Weapon a = (Weapon) p.removeFromInv(lstInventory.getSelectedIndex());
            p.setWeapon(a);
            txfWeapon.setText(a.getName());
            txaAction.setText("Equipped " + a.getName());

          } else
          {
            txaAction.setText("You cannot equip this item!");
          }

        reload();
// TODO add your handling code here:
    }//GEN-LAST:event_btnEquipActionPerformed

    private void btnUnequipHelmActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnUnequipHelmActionPerformed
    {//GEN-HEADEREND:event_btnUnequipHelmActionPerformed
        p.unEquip(HELM);
        txfHelm.setText("");
        reload();
    }//GEN-LAST:event_btnUnequipHelmActionPerformed

    private void btnUseActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnUseActionPerformed
    {//GEN-HEADEREND:event_btnUseActionPerformed

        Special e = p.getInventory().get(lstInventory.getSelectedIndex());
        if (e.getClass().equals(Useable.class))
          {
            Useable item = (Useable) p.getInventory().get(lstInventory.getSelectedIndex());
            item.use();
            if(item.getUses() < 1)
              {
                p.getInventory().remove(lstInventory.getSelectedIndex());
              }
            else
              {
                p.getInventory().set(lstInventory.getSelectedIndex(), item);
              }
            txaAction.setText(StickManGame.use(item));
          } else
          {
            txaAction.setText("You cannot use this item");
          }
        reload();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUseActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        StickManGame.unPauseWithBreak();
        StickManGame.setPlayer(p);
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnUnequipChestActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnUnequipChestActionPerformed
    {//GEN-HEADEREND:event_btnUnequipChestActionPerformed
        p.unEquip(CHEST);
        txfChest.setText("");
        reload();        // TODO add your handling code here:
    }//GEN-LAST:event_btnUnequipChestActionPerformed

    private void btnUnequipLegsActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnUnequipLegsActionPerformed
    {//GEN-HEADEREND:event_btnUnequipLegsActionPerformed
        p.unEquip(LEGS);
        txfLegs.setText("");
        reload();        // TODO add your handling code here:
    }//GEN-LAST:event_btnUnequipLegsActionPerformed

    private void btnUnequipFeetActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnUnequipFeetActionPerformed
    {//GEN-HEADEREND:event_btnUnequipFeetActionPerformed
        p.unEquip(FEET);
        txfFeet.setText("");
        reload();        // TODO add your handling code here:
    }//GEN-LAST:event_btnUnequipFeetActionPerformed

    private void btnUnequipWeaponActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnUnequipWeaponActionPerformed
    {//GEN-HEADEREND:event_btnUnequipWeaponActionPerformed
        p.unEquipWeapon();
        txfWeapon.setText("");
        reload();        // TODO add your handling code here:
    }//GEN-LAST:event_btnUnequipWeaponActionPerformed

    public void reload()
      {
        lblArmourPoints.setText("" + p.getArmour());
        lblDamagePoints.setText("" + p.getDamage());
        lblHealthPoints.setText("" + p.getHealth());

        lstInventory.setModel(new javax.swing.AbstractListModel()
          {
            String[] strings = p.getInventoryString();

            public int getSize()
              {
                return strings.length;
              }

            public Object getElementAt(int i)
              {
                return strings[i];
              }
          });
      }
    
    public void loadEquipped()
      {
        txfHelm.setText(p.getEquipped(HELM)!= null ? p.getEquipped(HELM).getName():"");
        txfChest.setText(p.getEquipped(CHEST)!= null ? p.getEquipped(CHEST).getName():"");
        txfLegs.setText(p.getEquipped(LEGS)!= null ? p.getEquipped(LEGS).getName():"");
        txfFeet.setText(p.getEquipped(FEET)!= null ? p.getEquipped(FEET).getName():"");
        txfWeapon.setText(p.getWeapon()!= null ? p.getWeapon().getName():"");
      }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnEquip;
    private javax.swing.JButton btnUnequipChest;
    private javax.swing.JButton btnUnequipFeet;
    private javax.swing.JButton btnUnequipHelm;
    private javax.swing.JButton btnUnequipLegs;
    private javax.swing.JButton btnUnequipWeapon;
    private javax.swing.JButton btnUse;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lblArmour;
    private static javax.swing.JLabel lblArmourPoints;
    private javax.swing.JLabel lblBoots;
    private javax.swing.JLabel lblBoots1;
    private javax.swing.JLabel lblChest;
    private javax.swing.JLabel lblDamage;
    private static javax.swing.JLabel lblDamagePoints;
    private javax.swing.JLabel lblEquipped;
    private javax.swing.JLabel lblGold;
    private static javax.swing.JLabel lblGoldAmount;
    private javax.swing.JLabel lblHealth;
    private static javax.swing.JLabel lblHealthPoints;
    private javax.swing.JLabel lblHelm;
    private javax.swing.JLabel lblInv;
    private javax.swing.JLabel lblLegs;
    private javax.swing.JList lstInventory;
    private javax.swing.JTextArea txaAction;
    private javax.swing.JTextField txfChest;
    private javax.swing.JTextField txfFeet;
    private javax.swing.JTextField txfHelm;
    private javax.swing.JTextField txfLegs;
    private javax.swing.JTextField txfWeapon;
    // End of variables declaration//GEN-END:variables
}
