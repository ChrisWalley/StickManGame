/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stickmangame;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Christopher
 */
public class InteractUI extends javax.swing.JFrame
  {

    private ShopKeep e;
    private StickMan p;
    private boolean isBuying;

    /**
     * Creates new form InteractUI
     */
    public InteractUI(ShopKeep en)
      {
        initComponents();

        e = en;
        p = StickManGame.getCharacter();
        lblGoldAmount.setText(p.getGold() + " coins");
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
          } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex)
          {
            java.util.logging.Logger.getLogger(InteractUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }

        //UIManager.put("ProgressBar.foreground", Color.RED);
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

        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 5), new java.awt.Dimension(0, 5), new java.awt.Dimension(32767, 5));
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnBuy = new javax.swing.JButton();
        btnLeave = new javax.swing.JButton();
        lblItems = new javax.swing.JLabel();
        btnBuySell = new javax.swing.JButton();
        lblGold = new javax.swing.JLabel();
        lblGoldAmount = new javax.swing.JLabel();
        btnSell = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstItems = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Welcome to my store!");

        jLabel2.setText("How can I help you?");

        btnBuy.setText("Buy Goods");
        btnBuy.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnBuyActionPerformed(evt);
            }
        });

        btnLeave.setText("Leave");
        btnLeave.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnLeaveActionPerformed(evt);
            }
        });

        lblItems.setText("Items");

        btnBuySell.setText("");
        btnBuySell.setVisible(false);
        btnBuySell.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnBuySellActionPerformed(evt);
            }
        });

        lblGold.setText("Gold:");

        lblGoldAmount.setText("");

        btnSell.setText("Sell Goods");
        btnSell.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnSellActionPerformed(evt);
            }
        });

        lstItems.setModel(new javax.swing.AbstractListModel<String>()
            {
                String[] strings = { "" };
                public int getSize() { return strings.length; }
                public String getElementAt(int i) { return strings[i]; }
            });
            jScrollPane3.setViewportView(lstItems);

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addComponent(btnBuy)
                                .addComponent(btnSell))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(lblItems)
                                    .addGap(154, 154, 154))
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(btnLeave)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBuySell)
                            .addGap(45, 45, 45)
                            .addComponent(lblGold)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lblGoldAmount)
                            .addContainerGap())))
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(7, 7, 7)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel2)
                            .addGap(48, 48, 48)
                            .addComponent(btnBuy)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnSell)
                            .addGap(22, 22, 22))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(lblItems)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBuySell)
                        .addComponent(btnLeave)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblGold)
                            .addComponent(lblGoldAmount)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            );

            pack();
            setLocationRelativeTo(null);
        }// </editor-fold>//GEN-END:initComponents

    private void btnBuyActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnBuyActionPerformed
    {//GEN-HEADEREND:event_btnBuyActionPerformed

        reloadBuy();
        btnBuySell.setVisible(true);
        btnBuySell.setText("Buy");
        isBuying = true;

    }//GEN-LAST:event_btnBuyActionPerformed

    private void btnLeaveActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnLeaveActionPerformed
    {//GEN-HEADEREND:event_btnLeaveActionPerformed
        StickManGame.unPauseWithBreak();
        dispose();
        StickManGame.setPlayer(p);
// TODO add your handling code here:
    }//GEN-LAST:event_btnLeaveActionPerformed

    private void btnBuySellActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnBuySellActionPerformed
    {//GEN-HEADEREND:event_btnBuySellActionPerformed

        int index = lstItems.getSelectedIndex();

        if (index > -1)
          {
            if (isBuying)
              {

                int worth = e.getInventory().get(index).getWorth();

                if (p.addGold((-1) * worth))
                  {
                    p.addToInv(e.removeFromInv(index));
                    reloadBuy();
                  } else
                  {
                    JOptionPane.showMessageDialog(null, "You do not have enough gold");
                  }

              } else
              {
                int worth = p.getInventory().get(index).getWorth();

                p.addGold(worth);

                e.addToInv(p.removeFromInv(index));
                reloadSell();
              }
          }
    }//GEN-LAST:event_btnBuySellActionPerformed

    private void btnSellActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnSellActionPerformed
    {//GEN-HEADEREND:event_btnSellActionPerformed

        reloadSell();
        btnBuySell.setVisible(true);
        btnBuySell.setText("Sell");
        isBuying = false;

// TODO add your handling code here:
    }//GEN-LAST:event_btnSellActionPerformed

    /**
     * @param en enemy to fight
     * @param c
     */
    public void reloadSell()
      {
        lstItems.setModel(new javax.swing.AbstractListModel<String>()
          {
            String[] strings = p.getInventoryNameCountAndPrice();

            public int getSize()
              {
                return strings.length;
              }

            public String getElementAt(int i)
              {
                return strings[i];
              }
          });
        lblGoldAmount.setText(p.getGold() + " coins");

      }

    public void reloadBuy()
      {
        lstItems.setModel(new javax.swing.AbstractListModel<String>()
          {
            String[] strings = e.getInventoryNameCountAndPrice();

            public int getSize()
              {
                return strings.length;
              }

            public String getElementAt(int i)
              {
                return strings[i];
              }
          });
        lblGoldAmount.setText(p.getGold() + " coins");

      }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuy;
    private javax.swing.JButton btnBuySell;
    private javax.swing.JButton btnLeave;
    private javax.swing.JButton btnSell;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblGold;
    private javax.swing.JLabel lblGoldAmount;
    private javax.swing.JLabel lblItems;
    private javax.swing.JList<String> lstItems;
    // End of variables declaration//GEN-END:variables
}
