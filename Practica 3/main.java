import javax.swing.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class main {

    public static void main(String[] args){

        
        String[] arrLit = {"short", "int", "long", "double", "float", "boolean", "char", "String"} ;
        String[] arrOp = {"++", "--", "!", "*", "/", "%", "+", "-", "<", ">", "<=", ">=", "==", "!=", "&&", "||", "?", "="} ;
        String[] arrDelim = {"(", ")", "{", "}", "[", "]", ";", ",", "."} ;
        String[] arrComent = {"//", "/","/", "/", "*//"};


        String ele = JOptionPane.showInputDialog("Coloca una instrucción");
        esIdentificador(ele);



        String div= " ";


        String[] eleArreglos= ele.split(div);

        int i=0;
        for(String a: eleArreglos){

            System.out.println(i+".-"+a);
            i++;
        }










    }



    static boolean esIdentificador(String cadena){

        boolean esPalabraReservada=false;
        boolean contieneCaracteresNoPermitidos=false;

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



            }

        }

        if(!contieneCaracteresNoPermitidos && !esPalabraReservada){
            System.out.println(true);
            return true;
        }
        else {

            System.out.println(false);

            return false;
        }

    }

    static boolean esInt(String cadena){

        cadena = JOptionPane.showInputDialog("Ingresa cadena");
        Pattern pat2 = Pattern.compile("(1*|2*|3*|4*|5*|6*|7*|8*|9*|0*)*");
        Matcher mat2 = pat2.matcher(cadena);
        // Por hacer checar el tamaño de int

        if (mat2.matches()) {
            return true;
        }
        else {

            return false;
        }


    }

    static boolean esLong(String cadena){


        Pattern pat3 = Pattern.compile("([0-9])*");
        Matcher mat3 = pat3.matcher(cadena);
        // Por hacer checar el tamaño de int
        if (mat3.matches()) {
            return true;
        }
        else {

            return false;
        }

    }

    static boolean esFloat(String cadena){

        int contadorPuntos=0;

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

                        return true;

                    }

                    else {
                        return false;
                    }
                }else {
                    return false;
                }
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

    static boolean esDouble(String cadena){

        int contadorPuntos=0;

        // el "//" es para que reconozca el punto como caracter xd
        Pattern pat7 = Pattern.compile("([0-9]|\\.)*d");
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

                        return true;

                    }

                    else {
                        return false;
                    }
                }else {
                    return false;
                }
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

    static boolean esChar(String cadena){

        Pattern pat4 = Pattern.compile(".");
        Matcher mat4 = pat4.matcher(cadena);
        // Por hacer checar el tamaño de int
        if (mat4.matches()) {
            return true;
        }
        else {

            return false;
        }


    }

    static boolean esString(String cadena){

        Pattern pat5 = Pattern.compile(".*");
        Matcher mat5 = pat5.matcher(cadena);
        // Por hacer checar el tamaño de int
        if (mat5.matches()) {
            return true;
        }
        else {

            return false;
        }
    }

    static boolean esBooleano(String cadena){
        Pattern pat6 = Pattern.compile("true|false");
        Matcher mat6 = pat6.matcher(cadena);
        // Por hacer checar el tamaño de int
        if (mat6.matches()) {
            return true;
        }
        else {

            return false;
        }
    }












}
