import javax.swing.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Pract2ER {
    public static void main(String[] args) {

        String cadena = "";
        int contadorPuntos = 0;
        String ele = "";


        boolean seguirCiclo= true;

        boolean esPalabraReservada=false;
        boolean contieneCaracteresNoPermitidos=false;

        do {

        ele = JOptionPane.showInputDialog("\n1.-identificador\n2.-int\n3.-long\n(todavia no)4.-float\n(todavia no)5.-double\n6.-char\n7.-String\n8.-boolean\n9.-Salir");

        // ".*" Para String, "." Para char, "true|false" para boolean, "(1*|2*|3*|4*|5*|6*|7*|8*|9*|0*)*" para int, ".*" para ID con un if aparte que verifique el primer o siguiente caracter,
        switch (ele) {
            case "1":
                cadena = JOptionPane.showInputDialog("Ingresa cadena");
                Pattern pat1 = Pattern.compile(".*");
                Matcher mat1 = pat1.matcher(cadena);

                // Por hacer checar las verificaciones de tipo ID
                Pattern patComp = Pattern.compile("[0-9]");
                String complementario="";
                complementario+=cadena.charAt(0);
                Matcher matComp = patComp.matcher(complementario);
                // caracteres como + – * / = % & # ! ? ^ “ ‘ ~ \ | < > ( )


                char[] caracteresNoPermitidos={'+','-',' ','*','/','=','%','&','#','!','?','^','"','\'','~','\\','|','<','>','(',')','@',':',';'};

                String[] tokens={"abstract","boolean","break","byte","byvalue","case","cast"
                        ,"catch","char","class","const","continue","default","do","double","else",
                        "extends", "final", "finally", "float", "for", "future", "generic",
                        "goto", "if", "implements", "import", "inner", "instanceof", "int",
                        "interface", "long", "native", "new", "null", "operator", "outer",
                        "package", "private", "protected", "public", "rest", "return", "short",
                        "static", "super", "switch", "synchronized", "this", "threadsafe", "throw",
                        "transient", "try", "var", "void", "while"
                };

                if (mat1.matches()) {
                    // si el primer caracter no es 0-9

                    if(!(matComp.matches())){

                        // se hace una comparación con todas las palabras reservadas
                        for(int i=0;i<=tokens.length-1;i++){

                            if(cadena.equals(tokens[i])){
                                System.out.println("No es una cadena ya que ocupa una palabra reservada");
                                esPalabraReservada=true;
                                break;
                            }

                        }

                        for(int i=0;i<=caracteresNoPermitidos.length-1;i++){

                            // se agarra un caracter y se busca ese caracter en la cadena
                            // si no se encuentra quiere decir que es una cadena valida
                            for(int j=0;j<=cadena.length()-1;j++){

                                if(caracteresNoPermitidos[i]==cadena.charAt(j)){
                                    contieneCaracteresNoPermitidos=true;
                                }
                            }
                        }
                        if(contieneCaracteresNoPermitidos){
                            System.out.println("No es una cadena tipo id ya que hay caracteres no validos!");
                        }

                        if(!contieneCaracteresNoPermitidos && !esPalabraReservada){
                            System.out.println("Si es un identificador valido");
                        }

                    }

                }
                break;
            case "2":
                cadena = JOptionPane.showInputDialog("Ingresa cadena");
                Pattern pat2 = Pattern.compile("(1*|2*|3*|4*|5*|6*|7*|8*|9*|0*)*");
                Matcher mat2 = pat2.matcher(cadena);
                // Por hacer checar el tamaño de int
                if (mat2.matches()) {
                    System.out.println("Si es una cadena tipo int");
                }
                break;
            case "3":
                cadena = JOptionPane.showInputDialog("Ingresa cadena");
                Pattern pat3 = Pattern.compile("([0-9])*");
                Matcher mat3 = pat3.matcher(cadena);
                // Por hacer checar el tamaño de int
                if (mat3.matches()) {
                    System.out.println("Si es una cadena tipo long");
                }
                break;
            case "4":
                cadena = JOptionPane.showInputDialog("Ingresa cadena");
                // el "//" es para que reconozca el punto como caracter xd
                Pattern pat7 = Pattern.compile("([0-9]|\\.)*f");
                Matcher mat7 = pat7.matcher(cadena);
                if (mat7.matches()) {

                    for (int i = 0; i <= cadena.length() - 1; i++) {
                        if (cadena.charAt(i) == '.') {
                            contadorPuntos += 1;
                        }
                    }
                    if (contadorPuntos <= 1) {
                        // checa si es que el penultimo caracter no es . para evitar que sea algo tipo 3.f
                        if (cadena.length() > 1) { // comprobación de que el tamaño del string es mayor a 1 para evitar errores
                            if (cadena.charAt(cadena.length() - 2) != '.') {

                                System.out.println("Si es una cadena tipo float");

                            }
                        }
                    }
                }
                break;
            case "5":
                cadena = JOptionPane.showInputDialog("Ingresa cadena");
                Pattern pat8 = Pattern.compile("([0-9]|\\.)*d");
                Matcher mat8 = pat8.matcher(cadena);
                // Por hacer checar el tamaño de int
                if (mat8.matches()) {

                    for (int i = 0; i <= cadena.length() - 1; i++) {
                        if (cadena.charAt(i) == '.') {
                            contadorPuntos += 1;
                        }
                    }
                    if (contadorPuntos <= 1) {
                        // checa si es que el penultimo caracter no es . para evitar que sea algo tipo 3.f

                        if (cadena.length() > 1) {
                            if (cadena.charAt(cadena.length() - 2) != '.') {

                                System.out.println("Si es una cadena tipo double");

                            }
                        }
                    }
                }
                break;
            case "6":
                cadena = JOptionPane.showInputDialog("Ingresa cadena");
                Pattern pat4 = Pattern.compile(".");
                Matcher mat4 = pat4.matcher(cadena);
                // Por hacer checar el tamaño de int
                if (mat4.matches()) {
                    System.out.println("Si es una cadena tipo char");
                }
                break;
            case "7":
                cadena = JOptionPane.showInputDialog("Ingresa cadena");
                Pattern pat5 = Pattern.compile(".*");
                Matcher mat5 = pat5.matcher(cadena);
                // Por hacer checar el tamaño de int
                if (mat5.matches()) {
                    System.out.println("Si es una cadena tipo String");
                }
                break;
            case "8":
                cadena = JOptionPane.showInputDialog("Ingresa cadena");
                Pattern pat6 = Pattern.compile("true|false");
                Matcher mat6 = pat6.matcher(cadena);
                // Por hacer checar el tamaño de int
                if (mat6.matches()) {
                    System.out.println("Si es una cadena tipo booleano");
                }
                break;
            case "9":
                seguirCiclo=false;
                break;
            default:
                System.out.println("XD");
                break;
        }

    }while(seguirCiclo);

    }
}
