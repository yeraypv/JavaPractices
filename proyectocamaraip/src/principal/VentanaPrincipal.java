package principal;
import Jama.Matrix;
import Jama.SingularValueDecomposition;
import java.awt.Color;
import java.net.Authenticator;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yeray
 */
public class VentanaPrincipal extends javax.swing.JFrame {
    private VistaVirtual v = new VistaVirtual();
       
    private String puntos = "";
    private List<Punto> ListaDePuntosXi = new ArrayList();
      
    private List<Punto> ListaDePuntosXiPrima = new ArrayList();
    private double xc,yc;
    
    public VentanaPrincipal() {
           
        initComponents();
        setTitle("Visor de Cámaras IP");
        setResizable(false);
        setLocationRelativeTo(null);

        panelVideo.repaint();
        panelVideo2.repaint();

    }

    //configuro la url de destino, user y password.
    public Authenticator setLogin(String url, final String user, final String pass){
        URL nurl = null;
        try {
            nurl = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Authenticator au = new Authenticator() {
        String u = user;
        String p = pass;
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication (u, p.toCharArray());
        }
        };
        
        return au;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        conectar1 = new javax.swing.JButton();
        usuario = new javax.swing.JTextField();
        password = new java.awt.TextField();
        txtDireccionIp = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        coordenadas = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Visorpuntosxi = new java.awt.TextArea();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        coordenas2 = new javax.swing.JLabel();
        VisorPuntosCalculados = new java.awt.TextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        conectar1.setText("Conectar Camara 1");
        conectar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conectar1ActionPerformed(evt);
            }
        });

        usuario.setText("root");

        password.setText("1234");

        txtDireccionIp.setText("http://192.168.0.116/axis-cgi/jpg/image.cgi?rotation=180");
        txtDireccionIp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionIpActionPerformed(evt);
            }
        });

        jLabel1.setText("Direccion Ip:");

        jLabel2.setText("Usuario:");

        jLabel3.setText("Password:");

        coordenadas.setText("Coordenadas:");

        jButton1.setText("Vista Virtual");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Puntos Xi:");

        jButton2.setText("Calcular puntos");
        jButton2.setToolTipText("");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        coordenas2.setText("Coordenadas:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(conectar1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(password, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                                    .addComponent(usuario, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(coordenadas, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Visorpuntosxi, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 10, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtDireccionIp)
                                .addGap(8, 8, 8)))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(VisorPuntosCalculados, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(coordenas2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(496, 496, 496)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDireccionIp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(coordenas2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(coordenadas))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(conectar1)
                                    .addComponent(jButton1)))
                            .addComponent(Visorpuntosxi, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton2)
                        .addComponent(VisorPuntosCalculados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void conectar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conectar1ActionPerformed
        
        String url = txtDireccionIp.getText();
        Authenticator.setDefault(this.setLogin(url,usuario.getText() , password.getText()));
        panelVideo.setDireccionIP(url);
        panelVideo.setHayConexion(true);
        panelVideo.repaint();
    }//GEN-LAST:event_conectar1ActionPerformed

    private void panelVideoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelVideoMousePressed
        int x = evt.getX();
        int y = evt.getY();
        int sx = evt.getXOnScreen();
        int sy = evt.getYOnScreen();
        String co= "Coordenadas del punto: X: " + x + " " + "Y: " + y + "; "+ " XScreen: " + sx + " " + "YScreen: "+ sy;
        coordenadas.setText(co);
        
        v.setPoint(x, y, Color.red);
        
        panelVideo.setPoint(x, y, Color.red);
        
        Punto p = new Punto((float)evt.getX(), (float)evt.getY(),(float)1.0, Color.red);
        ListaDePuntosXi.add(p);
        puntos = puntos + "punto: Xi=" + (float)evt.getX() + "; Yi=" + (float)evt.getY() + "\n";
        Visorpuntosxi.setText(puntos);
    }//GEN-LAST:event_panelVideoMousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        v.setVisible(true);
      
    }//GEN-LAST:event_jButton1ActionPerformed

    public double sumatorio(double[][] p,int dim){
        double t = 0.0;
        for(int i=0; i<p.length;i++){
            //for(int j=0; j<p[0].length;j++){
                t+=p[i][dim];
              
            //}
        }
        return t;
    }
   
    public Matrix getMT (double[][] puntosxi)
    {
        //obtener T.
        double xc,yc;
        xc = (double)sumatorio(puntosxi,0) / puntosxi.length;//sumatorio x / n
        yc = (double)sumatorio(puntosxi,1) / puntosxi.length;//sumatorio y / n
        
        this.xc = xc;
        this.yc = yc;
        
        double[][] mt = new double[3][3];
        mt[0][0] = 1;
        mt[0][1] = 0;
        mt[1][1] = 1;
        mt[1][0] = 0;
        mt[2][0] = 0;
        mt[2][1] = 0;
        mt[2][2] = 1;
        mt[0][2] = -xc;
        mt[1][2] = -yc;
        
        Matrix T = new Matrix(mt);
        
        return T;
    }
    
    /**
     *
     * @param xc
     * @param yc
     * @param puntosxi
     * @return
     */
    public Matrix getMS(double[][] puntosxi){
         double[][] puntosxitransladados = new double[puntosxi.length][puntosxi[0].length];
        //Escalar puntos. obtener S.
        
        for(int i=0; i< puntosxitransladados.length;i++){
           // for(int j=0; j<puntosxitransladados[i].length;j++){
                puntosxitransladados[i][0] = puntosxi[i][0] - this.xc;
                puntosxitransladados[i][1] = puntosxi[i][1] - this.yc;
           // }       
        }
        double dm = 0.0;
        
        for(int i=0;i<puntosxitransladados.length;i++){
           // for(int j=0; j<puntosxitransladados[i].length;j++){
                dm += (double)(Math.sqrt(puntosxitransladados[i][0] * puntosxitransladados[i][0]) + 
                        (puntosxitransladados[i][1] * puntosxitransladados[i][1]));  
            //}
        }
        dm = (Math.sqrt(dm) / (double)puntosxitransladados.length);
        System.out.println("dm = " + dm);
        double[][] ms = new double[3][3];     
        
        ms[0][0] = (double)(Math.sqrt(2.0)/dm);
        ms[0][1] = 0;
        ms[0][2] = 0;
        ms[1][0] = 0;
        ms[1][1] = (double)(Math.sqrt(2.0)/dm);
        ms[1][2] = 0;
        ms[2][0] = 0;
        ms[2][1] = 0;
        ms[2][2] = 1;
        
        Matrix S = new Matrix(ms);
        
        return S;
      
    }
    

        //obtener los coeficientes de la matriz H.
    public Matrix getA(double[][] puntosxiprima, double[][] puntos){
        double[][] B = new double[2*puntosxiprima.length][9];
        //obtener la matriz A.
        for (int i= 0;i<puntos.length;i++){
            B[2*i][0]   = 0;
            B[2*i][1]   = 0;
            B[2*i][2]   = 0;
            
            B[2*i][3]	= -1 * puntos[i][0]; //-wi' * xi
            B[2*i][4]   = -1 * puntos[i][1] * 1;//-wi' * yi
            B[2*i][5]   = -1; //-wi
            
            B[2*i][6]	= puntosxiprima[i][1] * puntos[i][0];//yi'*xi
            B[2*i][7]	= puntosxiprima[i][1] * puntos[i][1];//yi'*yi
            B[2*i][8]   = puntosxiprima[i][1]; //yi'
            
            
            B[2*i+1][0]	= puntos[i][0] * 1; //xi*wi'
            B[2*i+1][1]	= puntos[i][1] * 1; //yi*wi'
            B[2*i+1][2]	= 1; //wi'
            
            B[2*i+1][3] = 0;
            B[2*i+1][4] = 0;
            B[2*i+1][5] = 0;
            
            B[2*i+1][6]	= -puntosxiprima[i][0]*puntos[i][0];//-xi'*xi
            B[2*i+1][7]	= -puntosxiprima[i][0]*puntos[i][1];//-xi'*yi
            B[2*i+1][8] = -puntosxiprima[i][0];//-xi'
            
        }
        
        //ver los resultados.
        for(int j = 0;j<B.length;j++){
            for(int k = 0; k< B[j].length;k++){
                System.out.print(B[j][k]);
                System.out.print(" , ");
            }
            System.out.println("");
            
        }
        System.out.println("");
      
        Matrix A = new Matrix(B);
        
        return A;
   }
    
    public void showVec(double[] B){
        for (int j = 0;j<B.length;j++){
                System.out.print(B[j]);
                System.out.print(",");
        }
        System.out.println("");
 
        
    }
    
    public double[] getPoint(Matrix H, double[] p){

       
        double r=0.0;
        double[] rvec = new double[3];
        
        for(int i=0;i<H.getRowDimension();i++){
            r=0.0;
            for(int j=0;j<H.getColumnDimension();j++){
                r += H.get(i,j)*p[j];
            
            }
            
            rvec[i] = r;
        }
        
        return rvec;
    }

       
    public void showMatrix(double[][] B){
        for (int j = 0;j<B.length;j++){
            for(int k = 0; k< B[j].length;k++){
                System.out.print(B[j][k]);
                System.out.print(",");
            }
            System.out.println("");
             System.out.println("");
        }
        
    }
        
        
        
    public void showMatrix(Matrix B){
        for (int j = 0;j<B.getRowDimension();j++){
            for(int k = 0; k< B.getColumnDimension();k++){
                System.out.print(B.get(j, k));
                System.out.print(",");
            }
            System.out.println("");
             System.out.println("");
        }

    }

    public Matrix multiplicarMatrices(Matrix a, Matrix b){
    
        double[][] p = new double[a.getRowDimension()][a.getColumnDimension()];
        
        for(int i=0; i< a.getRowDimension();i++){
            for ( int j = 0; j < a.getColumnDimension(); j++){
                for ( int k = 0; k < b.getColumnDimension(); k++ ){
                    p[i][j] += a.get(i, k) * b.get(k, j);
                }
            }
        }
        Matrix r = new Matrix(p);
        return r;
    }
        
    public Matrix getHt(double [][] puntosxi, double[][] puntosxiprima){
          
        System.out.println("Matriz A:");
        Matrix A = getA(puntosxiprima, puntosxi);

        System.out.append("");
        System.out.println("------------------------------------------------");
        SingularValueDecomposition svd = new SingularValueDecomposition(A);
        Matrix V =svd.getV();

        System.out.println("Matriz V:");
        showMatrix(V);
        System.out.append("");
        System.out.println("------------------------------------------------");

        
        double[][] H = new double[3][3];
        int cont=0;
        for(int i=0; i<H.length;i++){
            for(int j=0; j<H[i].length;j++){
                H[i][j] = V.get(8,cont);
                cont++;
            }
        }
  
        double[][] H2 = new double[3][3];
        int cont2=0;
        for(int i=0; i<H2.length;i++){
            for(int j=0; j<H2[i].length;j++){
                H2[i][j] = V.get(cont2,8);
                cont2++;
            }
        }
        
        Matrix Ht = new Matrix(H);
        Matrix Ht2 = new Matrix(H2);
        
     /*   System.out.println("------------------------------------------------");
        System.out.println("Matriz H: Con ultima fila de V");
        showMatrix(Ht);

        double[] rp = getPoint(Ht,puntos);
        rp[0] /= rp[2];
        rp[1] /= rp[2];
        rp[2] /= rp[2];
        for(int i=0; i< rp.length;i++){
            System.out.println(rp[i]);
        }
        */
        
        
        System.out.println("------------------------------------------------");
        System.out.println("Matriz H: Con ultima columna de V");
        
        showMatrix(Ht2);
        return Ht2;
  
    }
    
    public Matrix transpuesta(Matrix a){
        double[][] t = new double[a.getRowDimension()][a.getColumnDimension()];
        for(int i=0;i<a.getRowDimension();i++){
            for(int j=0; j<a.getColumnDimension();j++){
                t[j][i] = a.get(i, j);
            }
        }
        Matrix r = new Matrix(t);
        return r;
    }
        
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
 
       //calculo del DLT
        String calculos;
        double[][] puntosxi = {{0.,0.}, {0., 4.}, {4., 0.}, {4.,4.}};
        double[][] puntosxiprima = {{0.,2.}, {0., 4.}, {4., 0.}, {4.,6.}};
        //punto a calcular xi'
        double[] puntos = {0.0,0.0,1.0};
        
        //Matriz Hm
        Matrix Hm = getHt(puntosxi,puntosxiprima);
        
        //Matriz T
        Matrix T = getMT(puntosxi);
        System.out.println("Matriz T:");
        showMatrix(T);
        
        //Matriz S
        Matrix S = getMS(puntosxi);
        System.out.println("Matriz S:");
        showMatrix(S);
        
        //Matriz Tprima
        Matrix Tprima = getMT(puntosxiprima);
        System.out.println("Matriz T':");
        showMatrix(Tprima);
        
        //Matriz Sprima
        Matrix Sprima = getMS(puntosxi);
        System.out.println("Matriz S':");
        showMatrix(Sprima);
        
        //Matriz M
        Matrix M = multiplicarMatrices(S,T);
        System.out.println("Matriz M:");
        showMatrix(M);
        
        //Matriz M'
        Matrix Mprima = multiplicarMatrices(Sprima,Tprima);
        System.out.println("Matriz M':");
        showMatrix(Mprima);
        
        //Matriz M'inversa
        System.out.println("Matriz M' inversa:");
        showMatrix(Mprima.transpose());
        
        Matrix Mprimainversatranspuesta = transpuesta(Mprima.transpose());
        
        //Matriz M'inversa transpuesta
        System.out.println("Matriz M'inversa Transpuesta:");
        showMatrix(Mprimainversatranspuesta);
        
        //Matriz Hm
        System.out.println("Matrix Hm:");
        showMatrix(Hm);
        
        //Matriz H'inversa * Hm
        Matrix Hi = multiplicarMatrices(Mprimainversatranspuesta,Hm);
        System.out.println("Hi = Mprima'inversa * Hm");
        showMatrix(Hi);
        
        //Matriz H
        Matrix H =  multiplicarMatrices(Hi,M);
        System.out.println("H=M'inversa * Hm * M");
        showMatrix(H);
   
        double[] rp = getPoint(H,puntos);
        
        rp[0] /= rp[2];
        rp[1] /= rp[2];
        rp[2] /= rp[2];
        for(int i=0; i< rp.length;i++){
            System.out.println(rp[i]);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void panelVideo2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelVideo2MousePressed
        
        int x = evt.getX();
        int y = evt.getY();
        int sx = evt.getXOnScreen();
        int sy = evt.getYOnScreen();
        String co2= "Coordenadas del punto: X: " + x + " " + "Y: " + y + "; "+ " XScreen: " + sx + " " + "YScreen: "+ sy;
        coordenadas.setText(co2);

        v.setPoint(x, y, Color.blue);

        panelVideo2.setPoint(x, y,Color.blue);
        
        Punto p = new Punto((float)evt.getX(), (float)evt.getY(),(float)1.0, Color.red);
        ListaDePuntosXiPrima.add(p);
        puntos = puntos + "punto: Xi'=" + (float)evt.getX() + "; Yi'=" + (float)evt.getY() + "\n";
        Visorpuntosxi.setText(puntos);
    }//GEN-LAST:event_panelVideo2MousePressed

    private void txtDireccionIpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionIpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionIpActionPerformed

    
    
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.TextArea VisorPuntosCalculados;
    private java.awt.TextArea Visorpuntosxi;
    private javax.swing.JButton conectar1;
    private javax.swing.JLabel coordenadas;
    private javax.swing.JLabel coordenas2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private java.awt.TextField password;
    private javax.swing.JTextField txtDireccionIp;
    private javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables
}
