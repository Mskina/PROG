/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figuras;

/**
 *
 * @author mskin
 */
public class Rectangulo {
    // Declaración de atributos base y altura para el rectángulo
    float base;
    float altura;
    
    // Declaración de un constructor vacío (atributos a 0)
    public Rectangulo() {
    }
    
    // Declaración de un constructor que inicialice base y altura
    public Rectangulo(float base, float altura) {
        setBase(base);
        setAltura(altura);
    }
    
    // Declaración de métodos
    
    // Método para actualizar y obtener el valor de cada atributo
    // Obtenemos la base
    public float getBase() {
        return base;
    }
    // Le damos valor a la base
    public void setBase(float base) {
        if (base <= 0) {
            throw new IllegalArgumentException("La base debe ser positiva y has escrito: " +base);
        }
        this.base = base;
    }
    
    // Obtenemos la altura
    public float getAltura() {
        return altura;
    }
    
    // Le damos valor a la altura
    public void setAltura(float altura) {
        if (altura <= 0) {
            throw new IllegalArgumentException("La altura debe ser positiva y has escrito: " +altura);
        }
        this.altura = altura;
    }
    
    // Método para devolver el área del rectángulo
    // Área= base* altura
    public float getArea() {
        float area = base*altura;
        return area;
    }
    
    // Método para devolver una cadena que contenga área y altura
    public String toString() {
        return "Altura: " + getAltura() + "\nÁrea: " + getArea();
    }
    
    // Método booleano que indique si se trata de un cuadrado
    public boolean isCuadrado() {
        boolean isCuadrado = (base==altura)?true:false;
        return isCuadrado;
    }
}

/*
if (radio <= 0){
            throw new IllegalArgumentException("El radio debe ser positivo: " + radio);
        }
*/