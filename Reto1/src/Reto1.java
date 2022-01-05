import java.util.Scanner;
/**
 * Este es el método principal 
 * @author andresruedalibre
 */
class Reto1{

    /**
    *  Este debe ser el único objeto de tipo Scanner en el código
    */
    private final Scanner scanner = new Scanner(System.in);

    /**
    * Este método es usado para solicitar datos al usuario
    * @return  Lectura de la siguiente linea del teclado
    */
    public String read(){
        return this.scanner.nextLine();
    }

    /**
    * método principal
    */
    public void run(){
        /*
        solución propuesta
        */
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
        } else if (edad < 45 && imc < 22) {
            System.out.println(String.format("%.1f", imc).replace(",", ".") + " " + "LEVE");
        } else if (edad < 45 && imc >= 22) {
            System.out.println(String.format("%.1f", imc).replace(",", ".") + " " + "MEDIO");
        } else if (edad >= 45 && imc < 22) {
            System.out.println(String.format("%.1f", imc).replace(",", ".") + " " + "MEDIO");
        } else if (edad >= 45 && imc >= 22) {
            System.out.println(String.format("%.1f", imc).replace(",", ".") + " " + "ALTO");
        }
    }
}