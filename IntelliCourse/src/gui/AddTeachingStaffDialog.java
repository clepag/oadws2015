/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import intellicourse.entity.Staff;
import intellicourse.entity.User;
import intellicourse.util.HibernateUtil;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Clemens
 */
public class AddTeachingStaffDialog extends javax.swing.JDialog {

    
    private boolean isAdd;
    private String vorname;
    private String nachname;
    private String username;
    private String password;
    private User user;
    /**
     * Creates new form AddTeachingStaffDialog
     */
    
    public void setUser(User user) {
        this.user = user;
    }
    public void setIsAdd(boolean isAdd) {
        this.isAdd = isAdd;
    }
    
    
    public AddTeachingStaffDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setTitle("Add Teaching Staff");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfVorname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfNachname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfUsername = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        pfPassword = new javax.swing.JPasswordField();
        btOk = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(6, 2));

        jLabel1.setText("Teacher ID:");
        getContentPane().add(jLabel1);

        tfID.setEditable(false);
        tfID.setText("<SampleID>");
        tfID.setEnabled(false);
        getContentPane().add(tfID);

        jLabel2.setText("Vorname:");
        getContentPane().add(jLabel2);
        getContentPane().add(tfVorname);

        jLabel5.setText("Nachname:");
        getContentPane().add(jLabel5);
        getContentPane().add(tfNachname);

        jLabel3.setText("Username:");
        getContentPane().add(jLabel3);
        getContentPane().add(tfUsername);

        jLabel4.setText("Initial Password:");
        getContentPane().add(jLabel4);

        pfPassword.setText("jPasswordField1");
        pfPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pfPasswordMouseClicked(evt);
            }
        });
        getContentPane().add(pfPassword);

        btOk.setText("Ok");
        btOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOkActionPerformed(evt);
            }
        });
        getContentPane().add(btOk);

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pfPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pfPasswordMouseClicked
        pfPassword.setText("");
    }//GEN-LAST:event_pfPasswordMouseClicked

    
    public void fillFields()
    {
        if(!isAdd)
        {
            String name = user.getUsername().toString();
            tfID.setText(user.getUid()+"");
            tfUsername.setText(user.getUsername());
            tfVorname.setText(user.getVorname());
            tfNachname.setText(user.getNachname());
            pfPassword.setText(user.getPassword());
        }
    }
    private void btOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOkActionPerformed
        // TODO add your handling code here:
        
        vorname = tfVorname.getText();
        nachname = tfNachname.getText();
        username = tfUsername.getText();
        password = pfPassword.getText();
        if(vorname.trim().equals("") ||nachname.trim().equals("") 
                || username.trim().equals("") ||password.trim().equals("") )
        {
            JOptionPane.showMessageDialog(this, "Incorrect Input","Error",JOptionPane.ERROR_MESSAGE);
           
        }
        else
        {
            if(isAdd)
            {
                addStaff();
            }
            else
            {
                editStaff();
            }            
            this.dispose();
        }
    }//GEN-LAST:event_btOkActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    
    private void editStaff(){
        String sql;
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            User user = new User(Integer.parseInt(tfID.getText()), tfUsername.getText(), pfPassword.getText(), tfVorname.getText(), tfNachname.getText());
            session.update(user);
//            sql = "from User where username like '" + username + "'";
//            Query q = session.createQuery(sql);
//            List resultList = q.list();
//            if(resultList.size() == 0){
//                User user2 = new User();
//                user2.setUid(user.getUid());
//                user2.setUsername(username);
//                user2.setPassword(password);
//                user2.setVorname(vorname);
//                user2.setNachname(nachname);
//
//                session.update(user2);
                session.getTransaction().commit();
                session.close();
//                JOptionPane.showMessageDialog(null, "Data updated succesfully !");
            
//            else
//            {
//                JOptionPane.showMessageDialog(this, "User already exists", "Error", JOptionPane.ERROR_MESSAGE);
//            }        
             
        }catch(Exception e){
             
            JOptionPane.showMessageDialog(null, "Error occured !");
            e.printStackTrace();
        }
    }
  
    
    
            
    private void addStaff()
    {
        int id;
        String sql;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
   
        User user = new User();
        user.setVorname(vorname);
        user.setNachname(nachname);
        user.setUsername(username);
        user.setPassword(password);
        
        sql = "from User where username like '" + username + "'";
        Query q = session.createQuery(sql);
        List resultList = q.list();
        if(resultList.size() == 0){
            session.save(user);
            Staff staff = new Staff(user);
            session.save(staff);
            session.getTransaction().commit();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "User already exists", "Error", JOptionPane.ERROR_MESSAGE);
        }
                
    }    
     
     private void executeHQLQuery(String hql) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery(hql);
            List resultList = q.list();
            session.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        }

    }
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(AddTeachingStaffDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddTeachingStaffDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddTeachingStaffDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddTeachingStaffDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddTeachingStaffDialog dialog = new AddTeachingStaffDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btOk;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField pfPassword;
    private javax.swing.JTextField tfID;
    private javax.swing.JTextField tfNachname;
    private javax.swing.JTextField tfUsername;
    private javax.swing.JTextField tfVorname;
    // End of variables declaration//GEN-END:variables
}
