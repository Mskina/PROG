package figuras;
import java.util.Scanner;

/**
 *
 * @author mskin
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /*Instanciamos el rectángulo 1
        Aunque inicialmente le he llamado rectángulo, como nos vamos a encontrar
        con cuadrados, les he llamado Figura en el texto. Lo mantengo para
        no olvidar el proceso que he seguido */
        Rectangulo objRect1 = new Rectangulo();
        System.out.println("----Figura 1----");
        
        // Solicitamos la base
        System.out.printf("Introduce la base: ");
        Scanner scan = new Scanner(System.in);
        float base = scan.nextFloat();
        objRect1.setBase(base);
        
        // Solicitamos la altura
        System.out.printf("Introduce la altura: ");
        float altura = scan.nextFloat();
        objRect1.setAltura(altura);
        float area = objRect1.getArea();
        
        //Vemos si es cuadrado
        boolean cuadrado = (objRect1.isCuadrado()==true);
        String esCuadrado = (cuadrado==true)?"cuadrado":"rectángulo";
        
        //Mostramos si es o no cuadrado y su área
        System.out.printf("El área del %s 1 es %.2f \n",esCuadrado,area);
        
        System.out.println();
        
        
        //Rectángulo 2. Como base y altura ya están definidos arriba
        //ahora solo reasignamos los nuevos valores
        System.out.println("----Figura 2----");
        System.out.printf("Introduce la base: ");
        base = scan.nextFloat();
        
        System.out.printf("Introduce la altura: ");
        altura = scan.nextFloat();
        
        //Instanciamos el segundo rectángulo al que se le asignan
        //base y altura que tenemos
        Rectangulo objRect2 = new Rectangulo(base,altura);
        area = objRect2.getArea();
        
        //Cuadrado. Al igual que base y altura, reasignamos nuevos valores
        cuadrado = (objRect2.isCuadrado()==true);
        esCuadrado = (cuadrado==true)?"cuadrado":"rectángulo";
        System.out.printf("El área del %s 1 es %.2f \n",esCuadrado,area);
        System.out.println();
        
        
        //Una tercera figura, imaginando que un alumno A establece unas condiciones
        //a un alumno B
        System.out.println("----Figura 3----");
        System.out.printf("Alumno A, introduce la base: ");
        base = scan.nextFloat();
        System.out.printf("Alumno A, introduce la altura: ");
        altura = scan.nextFloat();
        Rectangulo objRect3 = new Rectangulo(base,altura);
        //area = objRect3.getArea();
        System.out.println();
        
        System.out.printf("Alumno B: Dados los siguientes valores, calcula la base de la figura: \n");
        String enunciado = objRect3.toString();
        System.out.println(enunciado);
        /*cuadrado = (objRect3.isCuadrado()==true);
        esCuadrado = (cuadrado==true)?"cuadrado":"rectángulo";
        System.out.printf("El área del %s 1 es %f \n",esCuadrado,area); */
        
    }
    
    
    // En el método main,
    //instancia al menos dos objetos de la clase Rectangulo
    //y comprueba su funcionamiento.
    //Las bases y las alturas serán solicitadas al usuario por teclado.

}
