package sistema.presentacion.clientes;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import sistema.logic.Cliente;
import java.util.Observable;
import javax.swing.DefaultComboBoxModel;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import sistema.logic.Canton;
import sistema.logic.Distrito;
import sistema.logic.Provincia;

/**
 *
 * @author ariqq
 */
public class Mapa extends javax.swing.JFrame implements java.util.Observer {
//**************  MVC ***********
    Controller controller;
    Model model;
    
    public void setController(Controller controller){
        this.controller=controller;
    }

    public Controller getController() {
        return controller;
    }
    
    public void setModel(Model model){
        this.model=model;
         model.addObserver(this);
    }

    public Model getModel() {
        return model;
    }
    
    public String getCedula(){
        return cedula.getText();
    }
    
    public Cliente getCliente()
    {
      return model.getCliente();
    }
    
    @Override
    public void update(Observable o, Object arg) {
        
        canton.setModel(new DefaultComboBoxModel(model.getCantones().toArray()));
        //canton.setSelectedItem(model.getCanton());
        distrito.setModel(new DefaultComboBoxModel(model.getDistritos().toArray()));
       // distrito.setSelectedItem(model.getDistrito());
        
    }
    //************** END MVC ***********
    
    /**
     * Creates new form Mapa
     */
    public Mapa() {
        initComponents();
        int a = 100;
        button6=new JButton();
        button5=new JButton();
        button4=new JButton();
        button3=new JButton();
        button2=new JButton();
        button1=new JButton();
        button=new JButton();
        
        iniciarBotonProvincia(button6, 282, 523-a, 142, 120, "/Imagenes/s1.png", "/Imagenes/San jose.png", "San José");
        iniciarBotonProvincia(button5, 336, 526-a, 100, 75, "/Imagenes/c1.png", "/Imagenes/Cartago.png", "Cartago");
        iniciarBotonProvincia(button4, 316, 453-a, 70, 110, "/Imagenes/h1.png", "/Imagenes/Heredia.png", "Heredia");
        iniciarBotonProvincia(button3, 100, 403-a, 170, 175, "/Imagenes/g1.png", "/Imagenes/Guanacaste.png", "Guanacaste");
        iniciarBotonProvincia(button2, 357, 438-a, 160, 215, "/Imagenes/l1.png", "/Imagenes/Limon.png", "Limón");
        iniciarBotonProvincia(button1, 178, 508-a, 330, 235, "/Imagenes/p1.png", "/Imagenes/Puntarenas.png", "Puntarenas");
        iniciarBotonProvincia(button, 179, 418-a, 160, 150, "/Imagenes/a1.png", "/Imagenes/Alajuela.png", "Alajuela");

        try {
            p1 = new Pic(ImageIO.read(getClass().getResource("/Imagenes/mapa.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setPreferredSize(new Dimension(1100, 800));
        add(button4);
        add(button5);
        add(button6);
        add(button);
        add(button2);
        add(button3);
        add(button1);
        p1.setBounds(30,400-a,700,600);
      //  pics.setVisible(true);
        add(p1);
    }
    
    
    public void iniciarBotonProvincia(final JButton boton, int izq, int abajo, int ancho, int alto, String imaNoSelec, String imaSelec, String nombreProvi){
        
          try {
            //inicializar btones desde afuera
            boton.setIcon(new ImageIcon(ImageIO.read(getClass().getResource(imaNoSelec))));
            boton.setBorderPainted(false);
            boton.setFocusPainted(false);
            boton.setContentAreaFilled(false);
            boton.setBounds(izq,abajo,ancho,alto);
        } catch (IOException e) {
            e.printStackTrace();
        }
        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                System.out.println("entro!");
                try {
                    boton.setIcon(new ImageIcon(ImageIO.read(getClass().getResource(imaSelec))));
                    boton.repaint();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            @Override
            public void mouseExited(MouseEvent e) {
                
                if(!provincias.getText().equals(nombreProvi)){
                     System.out.println("salio!");
                try {
                   
                    boton.setIcon(new ImageIcon(ImageIO.read(getClass().getResource(imaNoSelec))));
                    boton.repaint();

                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
                
               
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    clearMap();
                    provincias.setText(nombreProvi); 
                    boton.setIcon(new ImageIcon(ImageIO.read(getClass().getResource(imaSelec))));
                    boton.repaint();
                    controller.cargarCantones(nombreProvi);
                    
                } catch (IOException ex) {
                    Logger.getLogger(Mapa.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
    }
    
    private void clearMap(){
        try {
            button6.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/Imagenes/s1.png"))));
            button6.repaint();
            button5.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/Imagenes/c1.png"))));
            button5.repaint();
            button4.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/Imagenes/h1.png"))));
            button4.repaint();
            button3.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/Imagenes/g1.png"))));
            button3.repaint();
            button2.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/Imagenes/l1.png"))));
            button2.repaint();
            button1.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/Imagenes/p1.png"))));
            button1.repaint();
            button.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/Imagenes/a1.png"))));
            button.repaint();
            
        } catch (IOException ex) {
            Logger.getLogger(Mapa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cedLabel = new javax.swing.JLabel();
        cedula = new javax.swing.JTextField();
        consultar = new javax.swing.JButton();
        nomLabel = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        provinciaLabel = new javax.swing.JLabel();
        provincias = new javax.swing.JTextField();
        cantonLabel = new javax.swing.JLabel();
        canton = new javax.swing.JComboBox<>();
        distritoLabel = new javax.swing.JLabel();
        distrito = new javax.swing.JComboBox<>();
        guardar = new javax.swing.JButton();
        prestamoBoton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Clientes");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        cedLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        cedLabel.setText("Cedula");

        consultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Lupa.jpg"))); // NOI18N
        consultar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarActionPerformed(evt);
            }
        });

        nomLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        nomLabel.setText("Nombre");

        provinciaLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        provinciaLabel.setText("Provincias");

        provincias.setToolTipText("");

        cantonLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        cantonLabel.setText("Canton");

        canton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cantonMouseClicked(evt);
            }
        });
        canton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantonActionPerformed(evt);
            }
        });

        distritoLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        distritoLabel.setText("Distrito");

        distrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                distritoActionPerformed(evt);
            }
        });

        guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Guardar.jpg"))); // NOI18N
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        prestamoBoton.setText("Prestamos");
        prestamoBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prestamoBotonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(provinciaLabel)
                            .addComponent(nomLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(50, 50, 50)
                                        .addComponent(consultar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(cantonLabel)
                                .addGap(120, 120, 120)
                                .addComponent(distritoLabel)
                                .addGap(110, 110, 110)
                                .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(provincias, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(canton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(distrito, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(277, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(prestamoBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cedLabel)
                        .addComponent(cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(consultar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomLabel)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(provinciaLabel)
                        .addComponent(cantonLabel)
                        .addComponent(distritoLabel))
                    .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(provincias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(canton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(distrito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(115, 115, 115)
                .addComponent(prestamoBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(244, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void prestamoBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prestamoBotonActionPerformed
        // TODO add your handling code here:
        
        //sistema.presentacion.prestamo.View viewPrestamo = new sistema.presentacion.prestamo.View();
       // viewPrestamo.cedText.setText(this.getCedula());
       // viewPrestamo.setVisible(true);
        controller.showPrestamoCliente(this.getCedula());
        //controller.showPrestamoCliente();
    }//GEN-LAST:event_prestamoBotonActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        Canton c = (Canton)canton.getSelectedItem();
        Distrito d = (Distrito)distrito.getSelectedItem();
        controller.guardar(cedula.getText(), nombre.getText(), provincias.getText(), c.getNumero(), d.getNumero());
    }//GEN-LAST:event_guardarActionPerformed

    private void consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarActionPerformed
        controller.consultar(cedula.getText());
        Cliente cliente = model.getCliente();
        cedula.setText(cliente.getCedula());
        nombre.setText(cliente.getNombre());
        provincias.setText(cliente.getProvincia());
        controller.cargarCantones(cliente.getProvincia());
        canton.setSelectedItem(model.getCanton());
        distrito.setSelectedItem(model.getDistrito());
        
    }//GEN-LAST:event_consultarActionPerformed

    private void distritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_distritoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_distritoActionPerformed

    private void cantonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantonActionPerformed
        Canton c = (Canton)canton.getSelectedItem();
        controller.cargarDistritos(c);
       canton.setSelectedItem(c);
    }//GEN-LAST:event_cantonActionPerformed

    //**********************************************************************************************************
    private void cantonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cantonMouseClicked
        /* distrito.setModel(new DefaultComboBoxModel(model.getCanton().getDistrito().toArray()));*/
        //canton.setSelectedItem(cliente.getCanton());
    }//GEN-LAST:event_cantonMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        controller.guardarDatos();
    }//GEN-LAST:event_formWindowClosing

    
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
            java.util.logging.Logger.getLogger(Mapa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mapa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mapa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mapa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mapa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Canton> canton;
    private javax.swing.JLabel cantonLabel;
    private javax.swing.JLabel cedLabel;
    private javax.swing.JTextField cedula;
    private javax.swing.JButton consultar;
    private javax.swing.JComboBox<Distrito> distrito;
    private javax.swing.JLabel distritoLabel;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel nomLabel;
    private javax.swing.JTextField nombre;
    private javax.swing.JButton prestamoBoton;
    private javax.swing.JLabel provinciaLabel;
    private javax.swing.JTextField provincias;
    // End of variables declaration//GEN-END:variables

    private Pic p1;
    private JButton button,button1,button2,button3,button4,button5,button6;
}

