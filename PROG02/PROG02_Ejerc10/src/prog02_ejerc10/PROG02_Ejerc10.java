/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog02_ejerc10;

/**
 *
 * @author mskin
 */
public class PROG02_Ejerc10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("------- Conversiones entre enteros y coma flotante -------");
        float x = 4.5f;
        float y = 3.0f;
        int i = 2;
        int j = (int)(i*x);
        System.out.println("Producto de int por float: j= i*x = "+j);
        double dx = 2.0;
        double dz = dx*y;
        System.out.println("Producto de float por double: dz=dx * y = "+dz);
        
        
        System.out.println("\n------- Operaciones con byte -------");
        byte bx = 5;
        byte by = 2;
        byte bz = (byte)(bx-by);
        System.out.printf("byte: %d - %d = %d\n",bx,by,bz);
        bx = -128;
        by = 1;
        bz = (byte)(bx-by);
        System.out.printf("byte %d - %d = %d\n",bx,by,bz);
        int z = bx-by;
        System.out.printf("(int)(%d - %d) = %d\n",bx,by,z);
        
        
        System.out.println("\n------- Operaciones con short -------");
        short sx = 5;
        short sy = 2;
        short sz = (short)(sx-sy);
        System.out.printf("short: %d - %d = %d\n",sx,sy,sz);
        sx = 32767;
        sy = 1;
        sz = (short)(sx+sy);
        System.out.printf("short %d + %d = %d\n",sx,sy,sz);
        
        
        System.out.println("\n------- Operaciones con char -------");
        char cx = '\u000F';
        char cy = '\u0001';
        z = cx-cy;
        System.out.printf("char: %s - %s = %d\n",cx,cy,z);
        z = cx-1;
        System.out.printf("char(0x000F) - 1 = %d\n",z);
        cx = '\uFFFF';
        z = cx;
        System.out.printf("(int)(%s) = %d\n", cx,z);
        sx = (short) cx;
        System.out.printf("(short)(%s) = %d\n", cx,sx);
        sx = -32768;
        cx = (char) sx;
        z = cx;
        System.out.printf("%d short-char-int = %d\n", sx,z);
        sx = -1;
        cx = (char) sx;
        z = cx;
        System.out.printf("%d short-char-int = %d\n", sx,z);
        
        
        
        
                
        
        
        
              
        
        
        
        
    }
    
}
