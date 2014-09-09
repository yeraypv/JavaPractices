/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.awt.Color;

/**
 *
 * @author yeray
 */
    public class Punto{
        private float x,y,z;
        private Color c;
        
        public Punto(){
            x = 0;
            y = 0;
            z = 0;
        }
        
        public Punto(float x, float y, float z, Color c){
            this.x = x;
            this.y = y;
            this.z = z;
            this.c = c;
        }
        
        public Color getColor(){
            return this.c;
        }
        public float getx(){
            return this.x;
        }
            
        public float gety(){
            return this.y;
        }
        
        public float getz(){
            return this.z;
        }
        
        public void setpoint(float x, float y, float z, Color c){
            this.x = x;
            this.y = y;
            this.z = z;
            this.c = c;
        }
                
        public void setx(float x){
            this.x = x;
      
        }
                      
        public void sety(float y){
            this.y = y;
        }
        
          
        public void setz(float z){
            this.z = z;
        }
    }
