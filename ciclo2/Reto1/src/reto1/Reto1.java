/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto1;

/**
 *
 * @author andresruedalibre
 */
public class Reto1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String datos = read();
        String[] arregloDatos = datos.split(" ");
        double masa = Double.parseDouble(arregloDatos[0]);
        double altura = Double.parseDouble(arregloDatos[1]);
        int edad = Integer.parseInt(arregloDatos[2]);
        double imc = masa / Math.pow(altura, 2);

        // revisar valores y condiciones
        if (masa < 0 || masa > 150 || altura < 0.1 || altura > 2.5 || edad < 0 || edad > 110) {
            System.out.println("ERROR");
        } else if (edad >= 45 && imc < 22) {
            System.out.println(String.format("%.3f", imc).replace(",", ".") + " " + "MEDIO");
        } else if (edad < 45 && imc < 22) {
            System.out.println(String.format("%.3f", imc).replace(",", ".") + " " + "LEVE");
        } else if (edad < 45 && imc >= 22) {
            System.out.println(String.format("%.3f", imc).replace(",", ".") + " " + "MEDIO");
        } else if (edad >= 45 && imc >= 22) {
            System.out.println(String.format("%.3f", imc).replace(",", ".") + " " + "ALTO");
        }

    }
