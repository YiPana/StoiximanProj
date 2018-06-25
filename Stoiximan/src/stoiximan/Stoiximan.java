/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stoiximan;

import java.awt.Frame;

/**
 *
 * @author jonnie
 */
public class Stoiximan {

    /**
     * @param args the command line arguments
     */
//    public static void main(String[] args, Frame NULL) {
        public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LogIn dialog = new LogIn(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    
        // TODO code application logic here
        double initBudget, interest, loss;
        interest = loss = 0;

        //declare initBudget
        initBudget = 250;

        BidPolicy bid = new BidPolicy(initBudget);
        System.out.println("Initial budget " + (int) initBudget + ((char) 8364));
        System.out.println("Starting bid " + bid.findIdealBID() + ((char) 8364));

        Round r1 = new Round(bid.findIdealBID());
        System.out.println("Next bid " + (int) r1.nextBid() + ((char) 8364));
        System.out.println("Next bid " + (int) r1.nextBid() + ((char) 8364));
        System.out.println("Next bid " + (int) r1.nextBid() + ((char) 8364));
        System.out.println("Next bid " + (int) r1.nextBid() + ((char) 8364));
        System.out.println("Next bid " + (int) r1.nextBid() + ((char) 8364));
        System.out.println("Next bid " + (int) r1.nextBid() + ((char) 8364));
        System.out.println("Next bid " + (int) r1.nextBid() + ((char) 8364));

//        LogIn lg = new LogIn(NULL, true);
    }

}
