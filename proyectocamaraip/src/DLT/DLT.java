package DLT;
import Jama.*;

public class DLT{
    Matrix puntosxiprima;
    Matrix dltCoefficients;

    
    public DLT(double[][] puntosxiprima){
        this.puntosxiprima = new Matrix(puntosxiprima);
    }

    public DLT(double[][] puntosxiprima, double[][] puntosxi){
        this.puntosxiprima = new Matrix(puntosxiprima);
        this.dltCoefficients = getDltCoefficients(puntosxiprima,puntosxi);	
    }

    public void setCalibrationObjectGlobalCoordinates(double[][] puntosxiprima){
        this.puntosxiprima = new Matrix(puntosxiprima);
    }

    public void setCalibrationObjectGlobalCoordinates(Matrix puntosxiprima){
        this.puntosxiprima = puntosxiprima;
    }

    public Matrix getDltCoefficients(double[][] puntos){
        return getDltCoefficients(this.puntosxiprima,puntos);
    }

    public Matrix getDltCoefficients(Matrix puntosxiprima,double[][] puntos){
        return getDltCoefficients(puntosxiprima.getArray(),puntos);
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
    
       public void showVec(double[] B){
        for (int j = 0;j<B.length;j++){
                System.out.print(B[j]);
                System.out.print(",");
        }
        System.out.println("");
 
        
    }

    //obtener los coeficientes de la matriz H.
    public Matrix getDltCoefficients(double[][] puntosxiprima,double[][] puntos){
        double[][] B = new double[2*puntosxiprima.length][9];//Tamaño matriz H 4 ptos = 8x8, 10x8 etc. porque el coeficiente 9 es 1.
        double[] C = new double[2*puntos.length]; //vector de puntos 
        int monta = 0;
        //
        for (int j =0;j<puntos.length;j++){
            for (int i =0;i<2;i++){
                C[monta] = puntos[j][i];
                ++monta;
            }
        }
        showVec(C);
       
       
        //obtener la matriz A.
        for (int i= 0;i<puntosxiprima.length;++i){
            B[2*i][0]	= -puntosxiprima[i][0];
            B[2*i][1]	= -puntosxiprima[i][1];
            B[2*i][2]   = -1;
            B[2*i][3]   = 0;
            B[2*i][4]   = 0;
            B[2*i][5]   = 0;
            B[2*i][6]	= puntosxiprima[i][0]*puntos[i][0];
            B[2*i][7]	= puntosxiprima[i][1]*puntos[i][0];
            B[2*i] [8]  = puntos[i][0];
            
            B[2*i+1][3]	= -puntosxiprima[i][0];
            B[2*i+1][4]	= -puntosxiprima[i][1];
            B[2*i+1][5]	= -1;
            B[2*i+1][6]	= puntosxiprima[i][0]*puntos[i][1];
            B[2*i+1][7]	= puntosxiprima[i][1]*puntos[i][1];
            B[2*i+1][8] = puntosxiprima[i][1];
        }
        
        //ver los resultados.
        for(int j = 0;j<B.length;j++){
            for(int k = 0; k< B[j].length;k++){
                System.out.print(B[j][k]);
                System.out.print(",");
            }
            System.out.println("");
            
        }
        System.out.println("");

        
        Matrix A = new Matrix(B);
        
        return A;
       // Matrix b = new Matrix(C,C.length);
       // Matrix coefficients = A.solve(b);
        
        /*SingularValueDecomposition svd = new SingularValueDecomposition(A);
        return svd.getV();
       // return coefficients;*/
   }

    public Matrix scaleCoordinates(double[] coordinates){
        return scaleCoordinates(this.dltCoefficients,coordinates);
    }

    //H * xi == xi'
    public Matrix scaleCoordinates(Matrix coefficients, double[] coordinates){
        double[][]	puntos1 = new double[2][2];
        double[]	puntos2 = new double[2];
        puntos1[0][0]	= coefficients.get(0,0)-coordinates[0]*coefficients.get(6,0);
        puntos1[0][1]	= coefficients.get(1,0)-coordinates[0]*coefficients.get(7,0);
        puntos1[1][0]	= coefficients.get(3,0)-coordinates[1]*coefficients.get(6,0);
        puntos1[1][1]	= coefficients.get(4,0)-coordinates[1]*coefficients.get(7,0);
        puntos2[0]	= coordinates[0]-coefficients.get(2,0);
        puntos2[1]	= coordinates[1]-coefficients.get(5,0);

        //ver puntos
        showMatrix(puntos1);
        showVec(puntos2);
        System.out.print("");
        Matrix l1 = new Matrix(puntos1);
        Matrix l2 = new Matrix(puntos2,puntos2.length);
        Matrix result= l1.solve(l2);
        return result;
    }

    public Matrix getCurrentDltCoefficients(){
        return dltCoefficients;
    }
}