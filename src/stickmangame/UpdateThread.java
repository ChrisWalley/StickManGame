/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stickmangame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

/**
 *
 * @author Christopher
 */
class UpdateThread implements Runnable {

    private static boolean isAlive = true;

    @Override
    public void run() {
        Timer timer = new Timer(250, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (!StickManGame.areUpdatesPaused()) {
                    StickManGame.updateMobs();
                } else {
                    UI.reDraw();
                }
                UI.reDraw();
            }
        });
        timer.setRepeats(true);
        timer.start();

        /*
        while(isAlive)
        {
            try
            {
                if(StickManGame.hasGameStarted())
                            {
                            UI.reDraw();
                            Thread.sleep(250);
                            if(!StickManGame.isPaused())
                            {
                            StickManGame.updateMobs();
                            }
                            UI.reDraw();
                            Thread.sleep(250);
                            UI.reDraw();
                           Thread.sleep(250);
                            }
                
             else
             {
                 Thread.sleep(1000);
             }
            } catch (InterruptedException ex)
            {
                System.out.println("Something broke with the update thread");
            }
           
        }
        System.out.println("Update thread stopped");
         */
    }

    public void killThread() {
        isAlive = false;
    }

    public void sleep(long millis) throws InterruptedException {
        Thread.sleep(millis);
    }

}
