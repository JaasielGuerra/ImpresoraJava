package ejemploimpresora;

import java.util.ArrayList;
import java.util.List;
import javax.print.PrintService;

/**
 *
 * @author lgmar
 */
public class JF_Inicio extends javax.swing.JFrame {
    private List<PrintService> impresoras = new ArrayList<>();
    private ServiciosImpresora servicioImpresora;

    public JF_Inicio() {
        initComponents();
        servicioImpresora = new ServiciosImpresora();
        
        //impresoras = servicioImpresora.listarImpresoras();
        //llenarCombo();
        
        // eventos
        Jbtn_imprimir.addActionListener(e -> imprimirTexto() );
    }
    
    private void llenarCombo(){
        for(PrintService x : impresoras){
            Jcb_impresoras.addItem(x.getName());
        }
    }
    
    /**
     * Metodo para imprimir el texto del cuadro de dialogo a una impresora
     */
    private void imprimirTexto(){
        String texto = JtxtA_texto.getText();
        servicioImpresora.establecerTexto(texto);
        servicioImpresora.imprimir();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPnl_impresora = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Jcb_impresoras = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        JtxtA_texto = new javax.swing.JTextArea();
        Jbtn_imprimir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Seleccionar impresora:");

        javax.swing.GroupLayout JPnl_impresoraLayout = new javax.swing.GroupLayout(JPnl_impresora);
        JPnl_impresora.setLayout(JPnl_impresoraLayout);
        JPnl_impresoraLayout.setHorizontalGroup(
            JPnl_impresoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPnl_impresoraLayout.createSequentialGroup()
                .addGroup(JPnl_impresoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPnl_impresoraLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(JPnl_impresoraLayout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(Jcb_impresoras, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JPnl_impresoraLayout.setVerticalGroup(
            JPnl_impresoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPnl_impresoraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Jcb_impresoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        JtxtA_texto.setColumns(20);
        JtxtA_texto.setRows(5);
        jScrollPane1.setViewportView(JtxtA_texto);

        Jbtn_imprimir.setText("Imprimir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(Jbtn_imprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 20, Short.MAX_VALUE))
                    .addComponent(JPnl_impresora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JPnl_impresora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Jbtn_imprimir))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPnl_impresora;
    private javax.swing.JButton Jbtn_imprimir;
    private javax.swing.JComboBox<String> Jcb_impresoras;
    private javax.swing.JTextArea JtxtA_texto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
