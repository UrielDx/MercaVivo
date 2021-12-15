package OperacionesProducto;
import ControlDeLaBD.ControlProductos;
import ControlDeLaBD.ConexionConBaseDatos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ModificarProductos extends javax.swing.JDialog {

    /**
     * Clase que permite modificar un producto de la elección del usuario del sistema
     * Los método realizan busqueda y modificación
     */
    public ModificarProductos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cod = new javax.swing.JTextField();
        jButtonBuscar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButtonCancelar = new javax.swing.JButton();
        jButtonModificarVendedor = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        codig = new javax.swing.JTextField();
        mar = new javax.swing.JTextField();
        des = new javax.swing.JTextField();
        pre = new javax.swing.JTextField();
        sto = new javax.swing.JTextField();
        pro = new javax.swing.JTextField();
        cate = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cod.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cod.setToolTipText("Ingrese el código del Vendedor para ser buscado.");
        jPanel1.add(cod, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 80, -1));

        jButtonBuscar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonBuscar.setText("Buscar");
        jButtonBuscar.setToolTipText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, 100, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Código del Producto");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));

        jButtonCancelar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonCancelar.setText("Salir");
        jButtonCancelar.setToolTipText("Cancelar Modificar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 360, 130, 30));

        jButtonModificarVendedor.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonModificarVendedor.setText("Modificar");
        jButtonModificarVendedor.setToolTipText("presionar para modificar");
        jButtonModificarVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarVendedorActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonModificarVendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 130, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 102));
        jLabel8.setText("Modificar Productos");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        codig.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        mar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        des.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        sto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stoActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        jLabel7.setText("Stock:");

        jLabel3.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        jLabel3.setText("Marca:");

        jLabel9.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        jLabel9.setText("Precio:");

        jLabel10.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        jLabel10.setText("Proveedor:");

        jLabel11.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        jLabel11.setText("Categoría:");

        jLabel5.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        jLabel5.setText("Descripción:");

        jLabel6.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        jLabel6.setText("Codigo:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(des)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(codig, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mar, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                .addComponent(pro, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(sto, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(pre, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(0, 135, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(sto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(pro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(cate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(codig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(des, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 470, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        codig.setText("");
        mar.setText("");
        des.setText("");
        pre.setText("");
        sto.setText("");
        pro.setText("");
        cate.setText("");
        try {
            Connection conexion = ConexionConBaseDatos.getConexion();
            Statement comando = conexion.createStatement();
            ResultSet registro = comando.executeQuery("select * from table_producto where codigo=" + cod.getText());
            if (registro.next() == true) {
                codig.setText(registro.getString("codigo"));
                mar.setText(registro.getString("marca"));
                des.setText(registro.getString("descripcion"));
                pre.setText(registro.getString("precio"));
                sto.setText(registro.getString("stock"));
                pro.setText(registro.getString("idPro"));
                cate.setText(registro.getString("idCat"));
            } else {
                JOptionPane.showMessageDialog(null,"No existe el codigo del producto en la base de datos"+cod.getText());
            }
            conexion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error "+ex);
        }
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonModificarVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarVendedorActionPerformed
        ControlProductos change = new ControlProductos();
        String codigo = codig.getText();
        String marca = mar.getText();
        String descr= des.getText();
        String preci = pre.getText();
        float precio;
        precio = Float.parseFloat(preci);
        String stoc = sto.getText();
        int stock =Integer.parseInt(stoc);
        String idPro = pro.getText();
        String idCa= cate.getText();
        int idCat =Integer.parseInt(idCa);
        change.ModificarProductos(codigo, marca,descr,precio,stock,idPro,idCat);
        
    }//GEN-LAST:event_jButtonModificarVendedorActionPerformed

    private void stoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stoActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ModificarProductos dialog = new ModificarProductos(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                   
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cate;
    private javax.swing.JTextField cod;
    private javax.swing.JTextField codig;
    private javax.swing.JTextField des;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonModificarVendedor;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField mar;
    private javax.swing.JTextField pre;
    private javax.swing.JTextField pro;
    private javax.swing.JTextField sto;
    // End of variables declaration//GEN-END:variables
}
