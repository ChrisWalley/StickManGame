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
    private static ShopKeep e;
    private static StickMan p = StickManGame.getCharacter();
    private static Coord co;
    private static boolean isBuying = false;

    /**
     * Creates new form FightUI
     */
    public InteractUI()
    {
        initComponents();
        UIManager.put("ProgressBar.foreground", Color.RED);

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
        btnSell = new javax.swing.JButton();
        btnLeave = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstItems = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstPrice = new javax.swing.JList();
        lblItems = new javax.swing.JLabel();
        lblPrice = new javax.swing.JLabel();
        btnBuySell = new javax.swing.JButton();
        lblGold = new javax.swing.JLabel();
        lblGoldAmount = new javax.swing.JLabel();

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

        btnSell.setText("Sell Items");
        btnSell.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnSellActionPerformed(evt);
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

        lstItems.setModel(new javax.swing.AbstractListModel()
            {
                String[] strings = { "" };
                public int getSize() { return strings.length; }
                public Object getElementAt(int i) { return strings[i]; }
            });
            jScrollPane1.setViewportView(lstItems);

            lstPrice.setModel(new javax.swing.AbstractListModel()
                {
                    String[] strings = { "" };
                    public int getSize() { return strings.length; }
                    public Object getElementAt(int i) { return strings[i]; }
                });
                lstPrice.setFocusable(false);
                jScrollPane2.setViewportView(lstPrice);

                lblItems.setText("Items");

                lblPrice.setText("Price");

                btnBuySell.setText("");
                btnBuySell.addActionListener(new java.awt.event.ActionListener()
                {
                    public void actionPerformed(java.awt.event.ActionEvent evt)
                    {
                        btnBuySellActionPerformed(evt);
                    }
                });

                lblGold.setText("Gold:");

                lblGoldAmount.setText(p.getGold()+" coins");

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(btnSell, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnBuy, javax.swing.GroupLayout.Alignment.LEADING)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(lblItems)
                                        .addGap(123, 123, 123)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPrice)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(24, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnBuySell)
                                .addGap(156, 156, 156))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnLeave)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblGold)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblGoldAmount)
                                .addGap(28, 28, 28))))
                );
                jPanel1Layout.setVerticalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblItems)
                            .addComponent(lblPrice))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addGap(48, 48, 48)
                                .addComponent(btnBuy)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSell))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuySell)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblGold)
                            .addComponent(lblGoldAmount)
                            .addComponent(btnLeave))
                        .addGap(14, 14, 14))
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

    private void btnSellActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnSellActionPerformed
    {//GEN-HEADEREND:event_btnSellActionPerformed
        isBuying = false;
        btnBuySell.setText("Sell");

        lstPrice.setModel(new javax.swing.AbstractListModel()
    {
        String[] strings = p.getInventoryPrices();
        public int getSize() { return strings.length; }
        public Object getElementAt(int i) { return strings[i]; }
    });
        lstItems.setModel(new javax.swing.AbstractListModel()
    {
        String[] strings = p.getInventoryString();
        public int getSize() { return strings.length; }
        public Object getElementAt(int i) { return strings[i]; }
    });    }//GEN-LAST:event_btnSellActionPerformed

    private void btnBuyActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnBuyActionPerformed
    {//GEN-HEADEREND:event_btnBuyActionPerformed
        isBuying = true;
        btnBuySell.setText("Buy");

        lstPrice.setModel(new javax.swing.AbstractListModel()
    {
        String[] strings = e.getInventoryPrices();
        public int getSize() { return strings.length; }
        public Object getElementAt(int i) { return strings[i]; }
    });
        lstItems.setModel(new javax.swing.AbstractListModel()
    {
        String[] strings = e.getInventoryString();
        public int getSize() { return strings.length; }
        public Object getElementAt(int i) { return strings[i]; }
    });

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
double price;
Special item;
if(isBuying)
{
    item = e.getInventory().get(lstItems.getSelectedIndex());
    price = item.getWorth()*1.5;
    if(p.addGold((-1)*price))
    {
    p.addToInv(item);
    e.removeFromInv(item);
    lblGoldAmount.setText(p.getGold()+" coins");

    
    lstPrice.setModel(new javax.swing.AbstractListModel()
    {
        String[] strings = e.getInventoryPrices();
        public int getSize() { return strings.length; }
        public Object getElementAt(int i) { return strings[i]; }
    });
        lstItems.setModel(new javax.swing.AbstractListModel()
    {
        String[] strings = e.getInventoryString();
        public int getSize() { return strings.length; }
        public Object getElementAt(int i) { return strings[i]; }
    });
    }
    else
    {
        JOptionPane.showMessageDialog(null, "You don't have enough gold!");
    }
    
}
else
{
    item = p.getInventory().get(lstItems.getSelectedIndex());
    price = item.getWorth();
    p.addGold(price);
    p.removeFromInv(item);
    e.addToInv(item);
    lblGoldAmount.setText(p.getGold()+" coins");
    
    
    lstPrice.setModel(new javax.swing.AbstractListModel()
    {
        String[] strings = p.getInventoryPrices();
        public int getSize() { return strings.length; }
        public Object getElementAt(int i) { return strings[i]; }
    });
        lstItems.setModel(new javax.swing.AbstractListModel()
    {
        String[] strings = p.getInventoryString();
        public int getSize() { return strings.length; }
        public Object getElementAt(int i) { return strings[i]; }
    });
}
    }//GEN-LAST:event_btnBuySellActionPerformed

    /**
     * @param e enemy to fight
     */
    public static void startUI(ShopKeep en, Coord c)
    {
        e = en;
        co = c;
// TODO add your handling code here:

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
            java.util.logging.Logger.getLogger(InteractUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(InteractUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(InteractUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(InteractUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new InteractUI().setVisible(true);
            }
        });
    }
    
    public void reload()
    {
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblGold;
    private javax.swing.JLabel lblGoldAmount;
    private javax.swing.JLabel lblItems;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JList lstItems;
    private javax.swing.JList lstPrice;
    // End of variables declaration//GEN-END:variables
}
