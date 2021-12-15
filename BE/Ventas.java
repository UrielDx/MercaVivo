package MenuPrincipal;
import ControlDeLaBD.ControlProductos;
import ControlDeLaBD.Generador;
import ControlDeLaBD.Limpiar;
import ControlDeLaBD.ConexionConBaseDatos;
import about.SimpleFrame;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Ventas extends javax.swing.JDialog {

    int c = 0;
    int n = 0;
    int totals = 0;
    DefaultTableModel modelo;
    ConexionConBaseDatos conectar = new ConexionConBaseDatos();
    String ClienteExistente = "no";

    /**
     * Clase que permite realizar las ventas y agregarlas a la tabla correspondiente, por
     * otro lado genera facturas y las alamacena en el sistema.
     */
    public Ventas(java.awt.Frame parent, boolean modal) {        
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
    
        modelo = new DefaultTableModel();
        // Agrega fila
        modelo.addColumn("No.");
        modelo.addColumn("idVentas");
        modelo.addColumn("Cod");
        modelo.addColumn("Productos");
        modelo.addColumn("Cant.");
        modelo.addColumn("Precios Units");
        modelo.addColumn("Importe");
        this.JTableProduct.setModel(modelo);
        setLocationRelativeTo(null);
        int[] anchos = {35, 70, 37, 180, 40, 90, 120};
        for (int i = 0; i < JTableProduct.getColumnCount(); i++) {
            JTableProduct.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
       fecha_actual();
        this.jTextFieldCodVentas.setText(String.valueOf(id_venta_auto()));
        this.jTextFieldCodFacturas.setText(String.valueOf(id_factura_auto()));
    }
    
    /**
     * Método para generar la fecha que ira en el formato de factura
     */
    
    public void fecha_actual(){
         Date fechaActual = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = formateador.format(fechaActual);
        jTextFieldFecha.setText(fecha);
        jTextFieldFecha.setEditable(false);
    }
    
    /**
     * Método para generar el folio de la venta
     */
    public int id_venta_auto(){
        Generador ge = new Generador();
        int id_max2 = 1;
        try{
            id_max2 = ge.auto_increm("SELECT MAX(folio) FROM table_ventas;");
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return id_max2;
    }
    
    /**
     * Método para generar el número de factura
     */
    public int id_factura_auto(){
        Generador ge = new Generador();
        int id_max2 = 1;
        try{
            id_max2 = ge.auto_increm("SELECT MAX(No_Facturas) FROM table_facturas;");
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return id_max2;
}
    
    /**
     * Método para limpiar los campos de texto de la interfaz para generar una nueva venta
     */
    public void limpiarTabla(JTable tabla){
        try {
            DefaultTableModel modelo=(DefaultTableModel) tabla.getModel();
            int filas=tabla.getRowCount();
            for (int i = 0;filas>i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
    }

    /**
     * Método para conocer los productos exitentes en el sistema
     */
    private void llamarProductos() {
        ControlProductos load = new ControlProductos();
        load.CargarProductos();
        jDialogProductos.setLocation(200, 100);
        jDialogProductos.setModal(true);
        jDialogProductos.setMinimumSize(new Dimension(747, 385));
        jDialogProductos.setTitle("Lista de Productos");
        jDialogProductos.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialogVendedor = new javax.swing.JDialog();
        jScrollPane1 = new javax.swing.JScrollPane();
        SeleccionarVendedor = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jDialogProductos = new javax.swing.JDialog();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        SeleccionarProductos = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jTextFieldParametroBusqueda = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jDialogCliente = new javax.swing.JDialog();
        jScrollPane4 = new javax.swing.JScrollPane();
        SeleccionarCliente = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        JTableProduct = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldCodFacturas = new javax.swing.JTextField();
        jTextFieldFecha = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldCodProducto = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldValor = new javax.swing.JTextField();
        xcant = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldProductos = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldCodVentas = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        LabelCant = new javax.swing.JLabel();
        jTextFieldNo = new javax.swing.JTextField();
        jTextFieldCant = new javax.swing.JTextField();
        jTextFieldImporte = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jTextFieldTotals = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();

        jDialogVendedor.setResizable(false);
        jDialogVendedor.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        SeleccionarVendedor.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        SeleccionarVendedor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(SeleccionarVendedor);

        jDialogVendedor.getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 330, 120));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 102, 102));
        jButton1.setText("Seleccionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jDialogVendedor.getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, -1, -1));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/FotoliaComp_65788270_jz4eEB4qgaZ0kMopuwpgOffUvlmIpQbP.jpg"))); // NOI18N
        jDialogVendedor.getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jDialogProductos.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 204, 0));
        jLabel16.setText("Productos y Articulos de Ferreteria");
        jDialogProductos.getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jScrollPane2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        SeleccionarProductos.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        SeleccionarProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(SeleccionarProductos);

        jDialogProductos.getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 610, 230));

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton7.setForeground(new java.awt.Color(0, 102, 102));
        jButton7.setText("Seleccionar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jDialogProductos.getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 300, -1, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel21.setText("Buscar ");

        jTextFieldParametroBusqueda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldParametroBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldParametroBusquedaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel21)
                    .addGap(12, 12, 12)
                    .addComponent(jTextFieldParametroBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel21)
                        .addComponent(jTextFieldParametroBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jDialogProductos.getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 250, 40));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/ferreteria-la-llave-portada-001.jpg"))); // NOI18N
        jDialogProductos.getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        SeleccionarCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SeleccionarCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(SeleccionarCliente);

        jLabel20.setFont(new java.awt.Font("Sylfaen", 0, 36)); // NOI18N
        jLabel20.setText("Lista de Clientes");

        jButton10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton10.setForeground(new java.awt.Color(0, 51, 51));
        jButton10.setText("Seleccionar");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialogClienteLayout = new javax.swing.GroupLayout(jDialogCliente.getContentPane());
        jDialogCliente.getContentPane().setLayout(jDialogClienteLayout);
        jDialogClienteLayout.setHorizontalGroup(
            jDialogClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogClienteLayout.createSequentialGroup()
                .addGroup(jDialogClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogClienteLayout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(jButton10))
                    .addGroup(jDialogClienteLayout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jLabel20)))
                .addContainerGap(159, Short.MAX_VALUE))
            .addGroup(jDialogClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDialogClienteLayout.createSequentialGroup()
                    .addGap(0, 30, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 30, Short.MAX_VALUE)))
        );
        jDialogClienteLayout.setVerticalGroup(
            jDialogClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogClienteLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 190, Short.MAX_VALUE)
                .addComponent(jButton10)
                .addContainerGap())
            .addGroup(jDialogClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDialogClienteLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro de Ventas");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JTableProduct.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JTableProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        JTableProduct.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        JTableProduct.setSelectionBackground(new java.awt.Color(153, 153, 153));
        jScrollPane3.setViewportView(JTableProduct);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 590, 200));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registros de Ventas");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 480, 40));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Facturas y Ventas:", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Source Sans Pro", 0, 18)); // NOI18N
        jLabel7.setText("Id-Ventas");

        jTextFieldCodFacturas.setEditable(false);
        jTextFieldCodFacturas.setBackground(new java.awt.Color(255, 204, 204));
        jTextFieldCodFacturas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextFieldFecha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        jLabel10.setText("N°.");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Valor $");

        jTextFieldCodProducto.setEditable(false);
        jTextFieldCodProducto.setBackground(new java.awt.Color(255, 204, 204));
        jTextFieldCodProducto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldCodProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCodProductoActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Cant");

        jTextFieldValor.setEditable(false);
        jTextFieldValor.setBackground(new java.awt.Color(255, 204, 204));
        jTextFieldValor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        xcant.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        xcant.setModel(new javax.swing.SpinnerNumberModel(1, 0, 30, 1));
        xcant.setToolTipText("");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Cod");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Productos");

        jTextFieldProductos.setEditable(false);
        jTextFieldProductos.setBackground(new java.awt.Color(255, 204, 204));
        jTextFieldProductos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        jLabel14.setText("Fecha:");

        jTextFieldCodVentas.setEditable(false);
        jTextFieldCodVentas.setBackground(new java.awt.Color(255, 204, 204));
        jTextFieldCodVentas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldCodVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCodVentasActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setText("Elegir un Producto?");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton6.setText("Agregar este Producto");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        LabelCant.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        LabelCant.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelCant.setText("Cantidad");

        jTextFieldNo.setEditable(false);
        jTextFieldNo.setBackground(new java.awt.Color(204, 255, 204));

        jTextFieldCant.setEditable(false);
        jTextFieldCant.setBackground(new java.awt.Color(204, 255, 204));

        jTextFieldImporte.setEditable(false);
        jTextFieldImporte.setBackground(new java.awt.Color(204, 255, 204));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("N°.");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Importe");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldCodFacturas, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel14)
                                        .addGap(10, 10, 10)
                                        .addComponent(jTextFieldFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 330, Short.MAX_VALUE)))
                                .addGap(95, 95, 95))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(jTextFieldCodVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(20, 20, 20)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jButton2)
                                        .addGap(29, 29, 29)
                                        .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE))))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jTextFieldNo)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextFieldCodProducto))
                                .addGap(36, 36, 36)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldCant)
                            .addComponent(LabelCant, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldProductos, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextFieldImporte))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel12)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jTextFieldValor)
                                                .addGap(34, 34, 34)))))
                                .addGap(20, 20, 20)
                                .addComponent(xcant, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(104, 104, 104)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCodFacturas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCodVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2)
                        .addComponent(jButton6)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel13)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldCodProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(jTextFieldProductos)
                    .addComponent(jTextFieldValor)
                    .addComponent(xcant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelCant, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCant)
                    .addComponent(jTextFieldImporte)
                    .addComponent(jTextFieldNo))
                .addGap(23, 23, 23))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 770, 250));

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 0, 0));
        jButton4.setText("Eliminar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 340, 170, -1));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(204, 0, 0));
        jButton5.setText("Cerrar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 490, 120, -1));

        jButton8.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jButton8.setForeground(new java.awt.Color(0, 51, 51));
        jButton8.setText("Registrar Facturas");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 170, -1));

        jTextFieldTotals.setEditable(false);
        jTextFieldTotals.setBackground(new java.awt.Color(204, 255, 204));
        jTextFieldTotals.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldTotals.setForeground(new java.awt.Color(0, 102, 0));
        jTextFieldTotals.setText("00.0");
        jPanel1.add(jTextFieldTotals, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 340, 170, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setText("Total a Pagar $");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 340, -1, 30));

        jToggleButton1.setText("Guardar Facturas");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 440, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldCodProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCodProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCodProductoActionPerformed

    private void jTextFieldCodVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCodVentasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCodVentasActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        llamarProductos();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        int i = SeleccionarProductos.getSelectedRow();
        if (i == -1) {
            JOptionPane.showMessageDialog(null, "Favor... seleccione una fila");
        } else{
            jTextFieldCodProducto.setText(String.valueOf(SeleccionarProductos.getValueAt(i, 0)));
            jTextFieldProductos.setText(String.valueOf(SeleccionarProductos.getValueAt(i, 1)));
            jTextFieldValor.setText(String.valueOf(SeleccionarProductos.getValueAt(i, 2)));

        }
        jDialogProductos.dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if (jTextFieldCodVentas.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Caja vacia");
        } else {

            n = 1 + n;
            jTextFieldNo.setText(String.valueOf(n));
            int cant = (Integer) xcant.getValue();
            jTextFieldCant.setText(String.valueOf(cant));
            int a = Integer.parseInt(jTextFieldValor.getText());
            int b = Integer.parseInt(jTextFieldCant.getText());
            int importe = a * b;
            jTextFieldImporte.setText(String.valueOf(importe));
            int can = Integer.parseInt(this.jTextFieldCodVentas.getText());
            can = can + c;       
            String datos[] = new String[7];
            datos[0] = jTextFieldNo.getText();
            datos[1] = String.valueOf(can);
            datos[2] = jTextFieldCodProducto.getText();
            datos[3] = jTextFieldProductos.getText();
            datos[4] = jTextFieldCant.getText();
            datos[5] = jTextFieldValor.getText();
            datos[6] = jTextFieldImporte.getText();
            modelo.addRow(datos);
            totals = totals + importe;
            jTextFieldTotals.setText(String.valueOf(totals));
           c++;
           System.out.println(can);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
         int i = JTableProduct.getSelectedRow();
        if (i == -1) {
            JOptionPane.showMessageDialog(null, "Favor... seleccione una fila");
        } else{
            String nums = (String) JTableProduct.getValueAt(i, 6);
            int entero = Integer.parseInt(nums);
            totals = totals - entero;
            jTextFieldTotals.setText(String.valueOf(totals));
            this.modelo.removeRow(i);
            n = n - 1;
            int num = 1;
            for (int w = 0; w < n; w = w + 1) {
                JTableProduct.setValueAt(num, w, 0);
                num = num + 1;
            }

        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
         System.out.println(jTextFieldCodFacturas.getText()+" - "+jTextFieldFecha.getText()+" - "+jTextFieldTotals.getText());
        Connection reg = conectar.getConexion();
        String sql_Facturas = "INSERT INTO table_Facturas (No_Facturas,cliente,fecha,vendedor,totals)VALUES (?,?,?,?,?)";
        try {
            PreparedStatement pst = reg.prepareStatement(sql_Facturas);
            pst.setString(1, jTextFieldCodFacturas.getText());
            pst.setString(3, jTextFieldFecha.getText());
            pst.setInt(5, Integer.parseInt(jTextFieldTotals.getText()));
            
            int ns = pst.executeUpdate();
            if (ns > 0) {
                JOptionPane.showMessageDialog(null, "Regristado Exitosamente de Facturas ");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error - FACTURAS: " + ex);
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
        }catch(Exception ex){
             System.out.println(ex.getMessage());
        }
        for (int w = 0; w < n; w = w + 1) {
            String col1 = (String) JTableProduct.getValueAt(w, 1);
            String col2 = (String) JTableProduct.getValueAt(w, 2);
            String col3 = (String) JTableProduct.getValueAt(w, 4);
            String col4 = (String) JTableProduct.getValueAt(w, 6);
            String sql_Ventas = "INSERT INTO table_Ventas (idVentas,No_Facturas,productos,cantidad,importe)VALUES (?,?,?,?,?)";
            try {
                PreparedStatement pst = reg.prepareStatement(sql_Ventas);
                pst.setString(1, col1);
                pst.setString(2, jTextFieldCodFacturas.getText());
                pst.setString(3, col2);
                pst.setString(4, col3);
                pst.setString(5, col4);
                int ns = pst.executeUpdate();
                if (ns > 0) {
                    JOptionPane.showMessageDialog(null, "Regristado Exitosamente de Ventas " + col1);
                }
            } catch (SQLException ex) {
                 System.out.println(ex.getMessage());
                JOptionPane.showMessageDialog(null, "Error - VENTAS: " + ex);
                Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
            }catch(Exception ex){
                 System.out.println(ex.getMessage());
            }
        }
        Image portada;  
        Document document = new Document(PageSize.LETTER, 50, 50, 50, 50);

        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("facturas/" + jTextFieldCodFacturas.getText() + ".pdf"));
            document.open();

            portada = Image.getInstance("portada.png");
            portada.setAlignment(Element.ALIGN_CENTER);
            portada.scalePercent(45f);

            document.add(portada);
            document.add(new Paragraph("---------------------------------------------------------"));
            document.add(new Paragraph("|    FACTURAS     |"));
            document.add(new Paragraph("---------------------------------------------------------"));
            document.add(new Paragraph("Numero Fact. : " + jTextFieldCodFacturas.getText()));
            document.add(new Paragraph("Fecha   : [ " + jTextFieldFecha.getText() + " ] - Total a Pagar : $ " + totals + "  pesos"));
            document.add(new Paragraph(" "));
            document.add(new Paragraph("| No. |  Id-Ventas   |  COD.  |          PRODUCTOS             |CANT.| VALOR UNIT "
                    + "|  IMPORTE  |"));
            document.add(new Paragraph("----------------------------------------------------------------------"
                    + "--------------------------------------------------------"));

            PdfContentByte cb = writer.getDirectContent();
            PdfTemplate tp = cb.createTemplate(500, 500);
            Graphics2D g2;
            g2 = tp.createGraphicsShapes(500, 500);
            JTableProduct.print(g2);
            g2.dispose();
            cb.addTemplate(tp, 50, -85);
            document.close();
            JOptionPane.showMessageDialog(null, "Generado PDF Exitosamente.");
            SimpleFrame sf = new SimpleFrame(jTextFieldCodFacturas.getText());
            sf.setVisible(true);
            dispose();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Generando PDF"+e);
        }finally{
            try{
                Limpiar l = new Limpiar();
         l.limpiar_texto(jPanel3);
         
         fecha_actual();
        
        this.jTextFieldCodVentas.setText(String.valueOf(id_venta_auto()));
        this.jTextFieldCodFacturas.setText(String.valueOf(id_factura_auto()));
        this.jTextFieldTotals.setText("");
        
        limpiarTabla(JTableProduct);
        
            }catch(Exception ex){
            }
        }
        this.totals = 0;
        n = 0;
        ClienteExistente = "no";
        c = 0;
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed

    }//GEN-LAST:event_jButton10ActionPerformed

    private void jTextFieldParametroBusquedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldParametroBusquedaKeyPressed
        ControlProductos cc = new ControlProductos();
        String parametroBusqueda = jTextFieldParametroBusqueda.getText();
        cc.buscarProductosparaVentas(parametroBusqueda);
    }//GEN-LAST:event_jTextFieldParametroBusquedaKeyPressed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        Image portada;
        Document document = new Document(PageSize.LETTER, 50, 50, 50, 50);
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("facturas/" + jTextFieldCodFacturas.getText() + ".pdf"));
            document.open();

            portada = Image.getInstance("portada.png");
            portada.setAlignment(Element.ALIGN_CENTER);
            portada.scalePercent(45f);
            document.add(portada);
            document.add(new Paragraph("---------------------------------------------------------"));
            document.add(new Paragraph("|    FACTURAS     |"));
            document.add(new Paragraph("---------------------------------------------------------"));
            document.add(new Paragraph("Numero Fact. : " + jTextFieldCodFacturas.getText()));
            document.add(new Paragraph("Fecha   : [ " + jTextFieldFecha.getText() + " ] - Total a Pagar : $ " + totals + "  pesos"));
            document.add(new Paragraph(" "));
            document.add(new Paragraph("| No. |  Id-Ventas   |  COD.  |          PRODUCTOS             |CANT.| VALOR UNIT "
                    + "|  IMPORTE  |"));
            document.add(new Paragraph("----------------------------------------------------------------------"
                    + "--------------------------------------------------------"));

            PdfContentByte cb = writer.getDirectContent();
            PdfTemplate tp = cb.createTemplate(500, 500);
            Graphics2D g2;
            g2 = tp.createGraphicsShapes(500, 500);
            JTableProduct.print(g2);
            g2.dispose();
            cb.addTemplate(tp, 50, -85);
            document.close();
            JOptionPane.showMessageDialog(null, "Generado PDF Exitosamente.");
            SimpleFrame sf = new SimpleFrame(jTextFieldCodFacturas.getText());
            sf.setVisible(true);
            dispose();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
          dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Ventas ven = new Ventas(new javax.swing.JFrame(), true);
                ven.addWindowListener(new java.awt.event.WindowAdapter() {
                });
                ven.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTable JTableProduct;
    private javax.swing.JLabel LabelCant;
    public static javax.swing.JTable SeleccionarCliente;
    public static javax.swing.JTable SeleccionarProductos;
    public static javax.swing.JTable SeleccionarVendedor;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JDialog jDialogCliente;
    private javax.swing.JDialog jDialogProductos;
    private javax.swing.JDialog jDialogVendedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextFieldCant;
    private javax.swing.JTextField jTextFieldCodFacturas;
    private javax.swing.JTextField jTextFieldCodProducto;
    private javax.swing.JTextField jTextFieldCodVentas;
    private javax.swing.JTextField jTextFieldFecha;
    private javax.swing.JTextField jTextFieldImporte;
    private javax.swing.JTextField jTextFieldNo;
    private javax.swing.JTextField jTextFieldParametroBusqueda;
    private javax.swing.JTextField jTextFieldProductos;
    private javax.swing.JTextField jTextFieldTotals;
    private javax.swing.JTextField jTextFieldValor;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JSpinner xcant;
    // End of variables declaration//GEN-END:variables
}
