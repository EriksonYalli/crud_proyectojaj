/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import conexion.conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

public class vistas extends javax.swing.JFrame {
    conexion con = new conexion();
    Connection cn;
    Statement st;
    ResultSet rs;
    DefaultTableModel modelo;
    int id;
    String genero;
    public vistas() {
        initComponents();
        setLocationRelativeTo(null);
        Listar();
    }

 
    
    

    
    
    
    
    void gruop9() {
        buton.add(rb_masculino_eriksonyallico);
        buton.add(rb_femenino_eriksonyallico);
    }
    
    
    void Listar() {
        String sql = "select * from formulario";
        try {
            cn=con.getCon();
            st=cn.createStatement();
            rs=st.executeQuery(sql);
            Object[]registro=new Object [13];
            modelo=(DefaultTableModel)tabladatos.getModel();
            while (rs.next()) {
                registro[0]=rs.getInt("id");
                registro[1]=rs.getString("dni");
                registro[2]=rs.getString("nombres");
                registro[3]=rs.getString("apellidos");
                registro[4]=rs.getString("fecha_nacimiento");
                registro[5]=rs.getString("sexo");
                registro[6]=rs.getString("celular");
                registro[7]=rs.getString("email");
                registro[8]=rs.getString("direccion");
                registro[9]=rs.getString("colesterol");
                registro[10]=rs.getString("glucosa");
                registro[11]=rs.getString("hemoglobina");
                registro[12]=rs.getString("tipoSeguro");
                modelo.addRow(registro);
            }   
            tabladatos.setModel(modelo);
            System.out.println("listado exitoso");
        } catch (Exception e) {
            System.out.println("error de listado" + e);
        }
    }
      void Agregar () {
        String dni=txt_dni_eriksonyallico.getText();
        String nombres= txt_nombre_eriksonyallico.getText();
        String apellidos=txt_apellidos_eriksonyallico.getText();
        String nacimiento=txt_fechanacimiento_eriksonyallico.getText();
        String celular=txt_celular_eriksonyallico.getText();
        String correo=txt_correo_eriksonyallico.getText();
        String direccion=txt_direccion_eriksonyallico.getText();
        String colesterol=sp_colesterol_eriksonyallico.getValue().toString();
        String glucosa=sp_glucosa_eriksonyallico.getValue().toString();
        String hemoglobina=sp_hemoglobina_eriksonyallico.getValue().toString();
        String seguro=cb_seguro_eriksonyallico.getSelectedItem().toString();
        if(dni.equals("")||nombres.equals("")||apellidos.equals("")||nacimiento.equals("")||celular.equals("")||correo.equals("")||direccion.equals("")||colesterol.equals("")||glucosa.equals("")||hemoglobina.equals("")||seguro.equals("")){
            JOptionPane.showMessageDialog(null,"no se agrego......!!!");
        }else{
            String sql = "insert into formulario(dni,nombres,apellidos,fecha_nacimiento,sexo,celular,email,direccion,colesterol,glucosa,hemoglobina,tipoSeguro)values('"+dni+"','"+nombres+"','"+apellidos+"','"+nacimiento+"','"+genero+"','"+celular+"','"+correo+"','"+direccion+"','"+colesterol+"','"+glucosa+"','"+hemoglobina+"','"+seguro+"')";
            try {
                cn=con.getCon();
                st=cn.createStatement();
                st.executeUpdate(sql);
                System.out.println("agregado exitoso");
                limpiartabla();
            } catch (Exception e) {
                System.out.println("error" + e);
            }
            }
        }
      
      
       void limpiartabla(){
         for(int i=0;i<=tabladatos.getRowCount();i++) {
             modelo.removeRow(i);
             i=i-1;
         }
     }
    
       
       
       
       
        void modificar () {
        String dni=txt_dni_eriksonyallico.getText();
        String nombre= txt_nombre_eriksonyallico.getText();
        String apellidos=txt_apellidos_eriksonyallico.getText();
        String nacimiento=txt_fechanacimiento_eriksonyallico.getText();
        String celular=txt_celular_eriksonyallico.getText();
        String correo=txt_correo_eriksonyallico.getText();
        String direccion=txt_direccion_eriksonyallico.getText();
        String colesterol=sp_colesterol_eriksonyallico.getValue().toString();
        String glucosa=sp_glucosa_eriksonyallico.getValue().toString();
        String hemoglobina=sp_hemoglobina_eriksonyallico.getValue().toString();
        String seguro =cb_seguro_eriksonyallico.getSelectedItem().toString();
        String sql="update formulario set dni='"+dni+"', nombres='"+nombre+"', apellidos='"+apellidos+"', fecha_nacimiento='"+nacimiento+"', sexo='"+genero+"', celular='"+celular+"', email='"+correo+"', direccion='"+direccion+"', colesterol='"+colesterol+"', glucosa='"+glucosa+"', hemoglobina='"+hemoglobina+"', tipoSeguro='"+seguro+"'  where id= "+id;
         if(dni.equals("")||nombre.equals("")||apellidos.equals("")||nacimiento.equals("")||celular.equals("")||correo.equals("")||direccion.equals("")||colesterol.equals("")||glucosa.equals("")||hemoglobina.equals("")||seguro.equals("")){
             JOptionPane.showMessageDialog(null,"debe ingresar datos");
         }else{
             try {
                 cn=con.getCon();
                 st=cn.createStatement();
                 st.executeUpdate(sql);
                 JOptionPane.showMessageDialog(null,"Usuario actualizado");
                 limpiartabla();
             } catch (Exception e) {
                 System.out.println("error al actualizar" + e);
             }
         }
     }
        
        
        void eliminar() {
         int filaseleccionado=tabladatos.getSelectedRow();
         if(filaseleccionado==-1) {
             JOptionPane.showMessageDialog(null,"Debe seleccionar fila");
         }else{
             String sql = "delete from formulario where id="+id;
             try {
                 cn=con.getCon();
                 st=cn.createStatement();
                 st.executeUpdate(sql);
                 JOptionPane.showMessageDialog(null,"Usuario eliminado con exito.....!!!!");
                 limpiartabla();
             } catch (Exception e) {
             }
         }
     }
        
        
          void nuevo(){
           txt_id_eriksonyallico.setText("");
           txt_dni_eriksonyallico.setText("");
           txt_nombre_eriksonyallico.setText("");
           txt_apellidos_eriksonyallico.setText("");
           txt_fechanacimiento_eriksonyallico.setText("");
           rb_masculino_eriksonyallico.setSelected(false);
           rb_femenino_eriksonyallico.setSelected(false);
           txt_celular_eriksonyallico.setText("");
           txt_correo_eriksonyallico.setText("");
           txt_direccion_eriksonyallico.setText("");
           sp_colesterol_eriksonyallico.setValue(0);
           sp_glucosa_eriksonyallico.setValue(0);
           sp_hemoglobina_eriksonyallico.setValue(0);
     }
        
        
        
        
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buton = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_id_eriksonyallico = new javax.swing.JTextField();
        txt_nombre_eriksonyallico = new javax.swing.JTextField();
        txt_apellidos_eriksonyallico = new javax.swing.JTextField();
        txt_fechanacimiento_eriksonyallico = new javax.swing.JTextField();
        txt_celular_eriksonyallico = new javax.swing.JTextField();
        txt_correo_eriksonyallico = new javax.swing.JTextField();
        txt_direccion_eriksonyallico = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabladatos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btn_agregar_eriksonyallico = new javax.swing.JButton();
        btn_modificar_eriksonyallico = new javax.swing.JButton();
        btn_eliminar_eriksonyallico = new javax.swing.JButton();
        btn_nuevo_eriksonyallico = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txt_dni_eriksonyallico = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        rb_masculino_eriksonyallico = new javax.swing.JRadioButton();
        rb_femenino_eriksonyallico = new javax.swing.JRadioButton();
        cb_seguro_eriksonyallico = new javax.swing.JComboBox<>();
        sp_colesterol_eriksonyallico = new javax.swing.JSpinner();
        sp_glucosa_eriksonyallico = new javax.swing.JSpinner();
        sp_hemoglobina_eriksonyallico = new javax.swing.JSpinner();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("VALLE GRANDE");

        jLabel2.setText("ID");

        jLabel3.setText("Nombres");

        jLabel4.setText("Apellidos");

        jLabel5.setText("Fecha de nacimiento");

        jLabel6.setText("sexo");

        jLabel7.setText("Celular");

        jLabel8.setText("Correo electronico");

        jLabel9.setText("Direccion");

        txt_id_eriksonyallico.setEditable(false);

        tabladatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DNI", "Nombre", "Apellidos", "Fecha Nacimiento", "Correo", "Sexo", "Correo", "Direccion", "Colesterol", "Glucosa", "Hemoglobina", "Seguro"
            }
        ));
        tabladatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabladatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabladatos);

        btn_agregar_eriksonyallico.setText("AGREGAR");
        btn_agregar_eriksonyallico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregar_eriksonyallicoActionPerformed(evt);
            }
        });

        btn_modificar_eriksonyallico.setText("MODIFICAR");
        btn_modificar_eriksonyallico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificar_eriksonyallicoActionPerformed(evt);
            }
        });

        btn_eliminar_eriksonyallico.setText("ELIMINAR");
        btn_eliminar_eriksonyallico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminar_eriksonyallicoActionPerformed(evt);
            }
        });

        btn_nuevo_eriksonyallico.setText("NUEVO");
        btn_nuevo_eriksonyallico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevo_eriksonyallicoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_modificar_eriksonyallico, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_agregar_eriksonyallico, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btn_nuevo_eriksonyallico, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_eliminar_eriksonyallico, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btn_agregar_eriksonyallico, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_modificar_eriksonyallico, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_eliminar_eriksonyallico, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_nuevo_eriksonyallico, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jLabel10.setText("DNI");

        jLabel11.setText("Colesterol");

        jLabel12.setText("Glucosa");

        jLabel13.setText("Hemoglobina");

        jLabel14.setText("Seguro");

        rb_masculino_eriksonyallico.setText("Masculino");
        rb_masculino_eriksonyallico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_masculino_eriksonyallicoActionPerformed(evt);
            }
        });

        rb_femenino_eriksonyallico.setText("Femenino");
        rb_femenino_eriksonyallico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_femenino_eriksonyallicoActionPerformed(evt);
            }
        });

        cb_seguro_eriksonyallico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "seguro publico", "seguro privado", "seguro universal" }));

        sp_colesterol_eriksonyallico.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                sp_colesterol_eriksonyallicoAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        sp_glucosa_eriksonyallico.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                sp_glucosa_eriksonyallicoAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        sp_hemoglobina_eriksonyallico.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                sp_hemoglobina_eriksonyallicoAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel15.setText("(mg/dl)");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel16.setText("(mg/dl)");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel17.setText("(mg/dl)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel10)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_direccion_eriksonyallico, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rb_masculino_eriksonyallico)
                                .addGap(18, 18, 18)
                                .addComponent(rb_femenino_eriksonyallico))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txt_fechanacimiento_eriksonyallico)
                                    .addComponent(txt_nombre_eriksonyallico, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_id_eriksonyallico, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_dni_eriksonyallico, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                    .addComponent(txt_celular_eriksonyallico, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_correo_eriksonyallico, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_apellidos_eriksonyallico, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(67, 67, 67)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cb_seguro_eriksonyallico, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(sp_hemoglobina_eriksonyallico, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                                            .addComponent(sp_glucosa_eriksonyallico, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(sp_colesterol_eriksonyallico, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel15)
                                            .addComponent(jLabel16)
                                            .addComponent(jLabel17)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 974, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(203, 203, 203))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_id_eriksonyallico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(sp_colesterol_eriksonyallico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txt_dni_eriksonyallico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(sp_glucosa_eriksonyallico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_nombre_eriksonyallico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(sp_hemoglobina_eriksonyallico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_apellidos_eriksonyallico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(cb_seguro_eriksonyallico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_fechanacimiento_eriksonyallico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(rb_masculino_eriksonyallico)
                                    .addComponent(rb_femenino_eriksonyallico))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(txt_celular_eriksonyallico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(txt_correo_eriksonyallico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(txt_direccion_eriksonyallico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_agregar_eriksonyallicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregar_eriksonyallicoActionPerformed
        Agregar();
        Listar();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_agregar_eriksonyallicoActionPerformed

    private void tabladatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabladatosMouseClicked
 int fila=tabladatos.getSelectedRow();
       if(fila==-1) {
           JOptionPane.showMessageDialog(null,"no se selecionado......!!!");
       }else{
           id=Integer.parseInt((String)tabladatos.getValueAt(fila,0).toString());
           String dni=(String)tabladatos.getValueAt(fila,1);
           String nombre=(String)tabladatos.getValueAt(fila,2);
           String apellidos=(String)tabladatos.getValueAt(fila,3);
           String fechanacimiento=(String)tabladatos.getValueAt(fila,4);
           String sexo=(String)tabladatos.getValueAt(fila,5);
           String celular=(String)tabladatos.getValueAt(fila,6);
           String correo=(String)tabladatos.getValueAt(fila,7);
           String direccion=(String)tabladatos.getValueAt(fila,8);
           String colesterol0=(String)tabladatos.getValueAt( fila, 9);
           int colesterol1 = Integer.parseInt(colesterol0);
           String glucosa0=(String)tabladatos.getValueAt( fila, 10);
           int glucosa1 = Integer.parseInt(glucosa0);
           String hemoglobina0=(String)tabladatos.getValueAt( fila, 11);
           int hemoglobina1 = Integer.parseInt(hemoglobina0);
           String seguro=tabladatos.getValueAt( fila, 12).toString();
           
           txt_id_eriksonyallico.setText(String.valueOf(id));
           txt_dni_eriksonyallico.setText(dni);
           txt_nombre_eriksonyallico.setText(nombre);
           txt_apellidos_eriksonyallico.setText(apellidos);
           txt_fechanacimiento_eriksonyallico.setText(fechanacimiento);
           txt_celular_eriksonyallico.setText(celular);
           txt_correo_eriksonyallico.setText(correo);
           txt_direccion_eriksonyallico.setText(direccion);
           sp_colesterol_eriksonyallico.setValue(colesterol1);
           sp_glucosa_eriksonyallico.setValue(glucosa1);
           sp_hemoglobina_eriksonyallico.setValue(hemoglobina1);
           cb_seguro_eriksonyallico.setSelectedItem(seguro);
           if(sexo.equals("Masculino")){
              rb_masculino_eriksonyallico.setSelected(true);
              rb_femenino_eriksonyallico.setSelected(false);
           }else if(sexo.equals("Femenino")){
              rb_masculino_eriksonyallico.setSelected(false);
              rb_femenino_eriksonyallico.setSelected(true);
           }else {
                rb_masculino_eriksonyallico.setSelected(false);
              rb_femenino_eriksonyallico.setSelected(false);
           }
                 
  
       }
        // TODO add your handling code here:
    }//GEN-LAST:event_tabladatosMouseClicked

    private void btn_modificar_eriksonyallicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificar_eriksonyallicoActionPerformed
         modificar();
         Listar();    
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_modificar_eriksonyallicoActionPerformed

    private void btn_eliminar_eriksonyallicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminar_eriksonyallicoActionPerformed
        eliminar();
        Listar();
        nuevo();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_eliminar_eriksonyallicoActionPerformed

    private void btn_nuevo_eriksonyallicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevo_eriksonyallicoActionPerformed
        nuevo();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_nuevo_eriksonyallicoActionPerformed

    private void rb_masculino_eriksonyallicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_masculino_eriksonyallicoActionPerformed
          genero = rb_masculino_eriksonyallico.getText();
         if(rb_masculino_eriksonyallico.isSelected()){
             rb_femenino_eriksonyallico.setSelected(false);
         }
        // TODO add your handling code here:
    }//GEN-LAST:event_rb_masculino_eriksonyallicoActionPerformed

    private void rb_femenino_eriksonyallicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_femenino_eriksonyallicoActionPerformed
        genero = rb_femenino_eriksonyallico.getText();
       if(rb_femenino_eriksonyallico.isSelected()){
             rb_masculino_eriksonyallico.setSelected(false);
         }
        // TODO add your handling code here:
    }//GEN-LAST:event_rb_femenino_eriksonyallicoActionPerformed

    private void sp_colesterol_eriksonyallicoAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_sp_colesterol_eriksonyallicoAncestorAdded

    }//GEN-LAST:event_sp_colesterol_eriksonyallicoAncestorAdded

    private void sp_glucosa_eriksonyallicoAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_sp_glucosa_eriksonyallicoAncestorAdded

        // TODO add your handling code here:
    }//GEN-LAST:event_sp_glucosa_eriksonyallicoAncestorAdded

    private void sp_hemoglobina_eriksonyallicoAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_sp_hemoglobina_eriksonyallicoAncestorAdded

        // TODO add your handling code here:
    }//GEN-LAST:event_sp_hemoglobina_eriksonyallicoAncestorAdded

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
            java.util.logging.Logger.getLogger(vistas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vistas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vistas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vistas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vistas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregar_eriksonyallico;
    private javax.swing.JButton btn_eliminar_eriksonyallico;
    private javax.swing.JButton btn_modificar_eriksonyallico;
    private javax.swing.JButton btn_nuevo_eriksonyallico;
    private javax.swing.ButtonGroup buton;
    private javax.swing.JComboBox<String> cb_seguro_eriksonyallico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rb_femenino_eriksonyallico;
    private javax.swing.JRadioButton rb_masculino_eriksonyallico;
    private javax.swing.JSpinner sp_colesterol_eriksonyallico;
    private javax.swing.JSpinner sp_glucosa_eriksonyallico;
    private javax.swing.JSpinner sp_hemoglobina_eriksonyallico;
    private javax.swing.JTable tabladatos;
    private javax.swing.JTextField txt_apellidos_eriksonyallico;
    private javax.swing.JTextField txt_celular_eriksonyallico;
    private javax.swing.JTextField txt_correo_eriksonyallico;
    private javax.swing.JTextField txt_direccion_eriksonyallico;
    private javax.swing.JTextField txt_dni_eriksonyallico;
    private javax.swing.JTextField txt_fechanacimiento_eriksonyallico;
    private javax.swing.JTextField txt_id_eriksonyallico;
    private javax.swing.JTextField txt_nombre_eriksonyallico;
    // End of variables declaration//GEN-END:variables
}
