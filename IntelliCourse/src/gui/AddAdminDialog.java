/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import beans.Kryptographie;
import intellicourse.entity.Admin;
import intellicourse.entity.User;
import intellicourse.util.HibernateUtil;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Sandra
 */
public class AddAdminDialog extends javax.swing.JDialog {

    private boolean isAdd;
    private int editID;
    private String vorname;
    private String nachname;
    private String username;
    private String password;
    private User admin;
    
    /**
     * Creates new form AddAdminDialog
     */
    public AddAdminDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    void setisAdd(boolean add) { this.isAdd = add; };
    void setAdmin(User ad) { this.admin = ad; };
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jButton2 = new javax.swing.JButton();
        addbtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        VornameTxt = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        NachnameTxt = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        UsernameTxt = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        PasswortTxt = new javax.swing.JPasswordField();
        OkBtn = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jButton1.setText("jButton1");

        jToggleButton1.setText("jToggleButton1");

        jButton2.setText("jButton2");

        addbtn.setText("Add Admin");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout(5, 1));

        jPanel5.setLayout(new java.awt.GridLayout(1, 2));

        jPanel6.setLayout(new java.awt.GridLayout(1, 2));

        jLabel5.setText("Vorname:");
        jPanel6.add(jLabel5);
        jPanel6.add(VornameTxt);

        jPanel5.add(jPanel6);

        jPanel1.add(jPanel5);

        jPanel7.setLayout(new java.awt.GridLayout(1, 2));

        jPanel8.setLayout(new java.awt.GridLayout(1, 2));

        jLabel6.setText("Nachname:");
        jPanel8.add(jLabel6);
        jPanel8.add(NachnameTxt);

        jPanel7.add(jPanel8);

        jPanel1.add(jPanel7);

        jPanel9.setLayout(new java.awt.GridLayout(1, 2));

        jPanel10.setLayout(new java.awt.GridLayout(1, 2));

        jLabel7.setText("Username:");
        jPanel10.add(jLabel7);
        jPanel10.add(UsernameTxt);

        jPanel9.add(jPanel10);

        jPanel1.add(jPanel9);

        jPanel11.setLayout(new java.awt.GridLayout(1, 2));

        jPanel12.setLayout(new java.awt.GridLayout(1, 2));

        jLabel8.setText("Passwort:");
        jPanel12.add(jLabel8);
        jPanel12.add(PasswortTxt);

        jPanel11.add(jPanel12);

        jPanel1.add(jPanel11);

        OkBtn.setText("Ok");
        OkBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OkBtnActionPerformed(evt);
            }
        });
        jPanel1.add(OkBtn);

        jMenu1.setText("log out");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void OkBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkBtnActionPerformed
        // TODO add your handling code here:
        vorname = VornameTxt.getText();
        nachname = NachnameTxt.getText();
        username = UsernameTxt.getText();
        String pw = PasswortTxt.getText();
        
        if(vorname.trim().equals("") ||nachname.trim().equals("") 
                || username.trim().equals("") ||pw.trim().equals("") )
        {
            JOptionPane.showMessageDialog(this, "Incorrect Input","Error",JOptionPane.ERROR_MESSAGE);
           
        }
        else if(isAdd == true)
        {
            Kryptographie k = new Kryptographie();
            try {
                password = k.encrypt(pw);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(AddAdminDialog.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoSuchPaddingException ex) {
                Logger.getLogger(AddAdminDialog.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalBlockSizeException ex) {
                Logger.getLogger(AddAdminDialog.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BadPaddingException ex) {
                Logger.getLogger(AddAdminDialog.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidKeyException ex) {
                Logger.getLogger(AddAdminDialog.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(AddAdminDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
            addAdmin();
            this.dispose();
        }
        else {
            editAdmin();
            this.dispose();
        }
        
    }//GEN-LAST:event_OkBtnActionPerformed

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
            java.util.logging.Logger.getLogger(AddAdminDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddAdminDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddAdminDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddAdminDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddAdminDialog dialog = new AddAdminDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextField NachnameTxt;
    private javax.swing.JButton OkBtn;
    private javax.swing.JPasswordField PasswortTxt;
    private javax.swing.JTextField UsernameTxt;
    private javax.swing.JTextField VornameTxt;
    private javax.swing.JButton addbtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables

    private void addAdmin() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        String sql;
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
            Admin admin = new Admin(user);
            session.save(admin);
            session.getTransaction().commit();
            this.setVisible(false);
        }
        else
        {
            JOptionPane.showMessageDialog(this, "User already exists", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void fillFields()
    {
        if(!isAdd)
        {
            editID = admin.getUid();
            VornameTxt.setText(admin.getVorname());
            NachnameTxt.setText(admin.getNachname());
            UsernameTxt.setText(admin.getUsername());
            PasswortTxt.setText(admin.getPassword());
        }
    }
    
    
    private void editAdmin() { 
        String sql;
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Kryptographie k = new Kryptographie();
            String pw = k.encrypt(PasswortTxt.getText());
            User user = new User(editID, UsernameTxt.getText(),pw , VornameTxt.getText(), NachnameTxt.getText());
            session.update(user);
            session.getTransaction().commit();
            session.close();      
             
        }catch(Exception e){
             
            JOptionPane.showMessageDialog(null, "Error occured !");
            e.printStackTrace();
        }  
    }
}
