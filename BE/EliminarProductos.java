package OperacionesProducto;
import ControlDeLaBD.ControlProductos;
import ControlDeLaBD.ConexionConBaseDatos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class EliminarProductos extends javax.swing.JDialog {

    /**
     * Clase que permite eliminar un producto seleccionado por el usuario
     */

    ControlProductos bash = new ControlProductos();    
    
    public EliminarProductos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        codig = new javax.swing.JTextField();
        jButtonBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButtonEliminarCliente = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("EliminarClientes");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        codig.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        codig.setToolTipText("Ingrese el código del cliente para ser buscado.");
        jPanel1.add(codig, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 110, -1));

        jButtonBuscar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonBuscar.setText("Buscar");
        jButtonBuscar.setToolTipText("Pulse para buscar datos del cliente.");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 100, 30));

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 290, 120));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Código");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, -1, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Salir");
        jButton1.setToolTipText("Pulse para regresar al menú.");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, 130, 40));

        jButtonEliminarCliente.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonEliminarCliente.setText("Eliminar ");
        jButtonEliminarCliente.setToolTipText("Pulse para eliminar el cliente.");
        jButtonEliminarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarClienteActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonEliminarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 150, 40));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 153));
        jLabel8.setText("Eliminar Productos");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 413, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 343, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        String codigoE =  codig.getText();
        try {
            Connection conexion = ConexionConBaseDatos.getConexion();
            Statement comando = conexion.createStatement();
            ResultSet registro = comando.executeQuery("select * from table_producto where codigo=" +codigoE);
            if (registro.next() == true) {
                String cod = registro.getString("codigo");
                String mar = registro.getString("marca");
                String des = registro.getString("descripcion");
                String pre = registro.getString("precio");
                String stoc = registro.getString("stock");
                String idP = registro.getString("idPro");
                String idC = registro.getString("idCat");
                jTextArea1.setText("" 
                +"\n Código: "+cod
                +"\n-----------------------------"
                +"\n Marca: "+mar
                +"\n Descripción: "+des
                +"\n Precio: "+pre
                +"\n Stock: "+stoc
                +"\n Id Proveedor: "+idP
                +"\n Id categoría: "+idC
                +"");
            } else {
                JOptionPane.showMessageDialog(null,"No existe este codigo del Producto"+codig.getText());
            }
            conexion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error "+ex);
        }
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonEliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarClienteActionPerformed
       String code = codig.getText();
       bash.EliminarProductos(code);
       codig.setText("");
       jTextArea1.setText("");
    }//GEN-LAST:event_jButtonEliminarClienteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.gc();
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EliminarProductos dialog = new EliminarProductos(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                  
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField codig;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonEliminarCliente;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
