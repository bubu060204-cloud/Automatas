import javax.swing.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.ArrayList;

// falta actualizar los métodos de ES
public class main {

    public static void main(String[] args){

        //Divisiones
        String[] arrOp = {"\\+\\+", "--", "!", "%", "\\+", "-", "<", ">", "<=", ">=", "==", "!=", "&&", "\\|\\|", "\\?", "="};
        // sin "\\*" y "/" porque arruinan los comentarios, si pueden checar como ponerlos estaria chevere si no ya ni modo
        String[] arrDelim = {"\\(", "\\)", "\\{", "\\}", "\\[", "\\]", ";", ",", "\\."," "}; // espacio agregar?

        // los \\ son para agarrar los caracteres porque sino no jalan xd
        // todo porque esta parte es para dividir
        String[] arrComent = {"//", "/\\*", "\\*/"};

        // Lista de contenedores
        ArrayList<String> palabrasReservadas = new ArrayList<String>();
        ArrayList<String> identificadores = new ArrayList<String>();
        ArrayList<String> literales = new ArrayList<String>();
        ArrayList<String> operadores = new ArrayList<String>();
        ArrayList<String> delimitadores = new ArrayList<String>();
        ArrayList<String> comentarios = new ArrayList<String>();

        //Comparaciones
        String[] arrOpC = {"++", "--", "<=", ">=", "==", "!=", "&&", "||", "*", "/", "%", "+", "-", "<", ">", "!", "?", "="};
        String[] arrDelimC = {"(", ")", "{", "}", "[", "]", ";", ",", "."," "} ;
        String[] arrComentC = {"//", "/*","*/"};


        String[] tokens={"abstract","boolean","break","byte","byvalue","case","cast"
                ,"catch","char","class","const","continue","default","do","double","else",
                "extends", "final", "finally", "float", "for", "future", "generic",
                "goto", "if", "implements", "import", "inner", "instanceof", "int",
                "interface", "long", "native", "new", "null", "operator", "outer",
                "package", "private", "protected", "public", "rest", "return", "short",
                "static", "super", "switch", "synchronized", "this", "threadsafe", "throw",
                "transient", "try", "var", "void", "while"
        };


        String ele = JOptionPane.showInputDialog("Coloca una instrucción");

        String div ="((?<=";
        String div2=")|(?=";
        String div3="))";

        String or="|";
        String divisiones= "";


        //Comentarios
        for(int i=0;i<= arrComent.length-1;i++){

            divisiones+=div+arrComent[i]+div2+arrComent[i]+div3+or;
        }

        //Operadores
        for(int i=0;i<= arrOp.length-1;i++){
            divisiones+=div+arrOp[i]+div2+arrOp[i]+div3+or;
        }

        //Delimitadores
        for(int i=0;i<= arrDelim.length-1;i++){



                //divisiones+=div+arrDelim[i]+div2+arrDelim[i]+div3+or;
            if(i==arrDelim.length-1){
                divisiones+=div+arrDelim[i]+div2+arrDelim[i]+div3;
            }else {

                divisiones+=div+arrDelim[i]+div2+arrDelim[i]+div3+or;
            }


        }



        String[] eleArreglos= ele.split(divisiones);

        System.out.println(divisiones);
        int i=0;

          ;
        for(String a: eleArreglos){

            System.out.println(i+".-"+a);
            i++;
        }

        boolean elementoEncontrado= false;


        for(String a: eleArreglos){

            elementoEncontrado= false;

            for(int b=0;b<=tokens.length-1;b++){
                if(tokens[b].equals(a)){
                    palabrasReservadas.add(a);
                    elementoEncontrado=true;
                }
            }
            if(elementoEncontrado){
                continue;
            }

            for(int j=0;j<=arrOpC.length-1;j++){
                if(arrOpC[j].equals(a)){
                    operadores.add(a);
                    elementoEncontrado=true;
                }
            }
            if(elementoEncontrado){
                continue;
            }

            for(int k=0;k<=arrDelimC.length-1;k++){
                if(arrDelimC[k].equals(a)){
                    delimitadores.add(a);
                    elementoEncontrado=true;
                }
            }
            if(elementoEncontrado){
                continue;
            }

            for(int l=0;l<=arrComentC.length-1;l++){
                if(arrComentC[l].equals(a)){
                    comentarios.add(a);
                    elementoEncontrado=true;
                }
            }
            if(elementoEncontrado){
                continue;
            }

            if(esIdentificador(a)){

                identificadores.add(a);

            }

            else if(esInt(a)){
                literales.add(a + "(int)");
            }else if(esDouble(a)){
                literales.add(a + "(double)");
            }else if(esFloat(a)){
                literales.add(a + "(float)");
            }else if(esBooleano(a)){
                literales.add(a + "(booleano)");
            }else if(esChar(a)){
                literales.add(a + "(char)");
            }else if(esString(a)){
                literales.add(a + "(String)");
            }


        }

        System.out.println("-------Palabras reservadas-------");

        for(int x=0;x<= palabrasReservadas.size()-1;x++){

            System.out.println((x+1)+".-"+palabrasReservadas.get(x));
        }

        System.out.println("-------Identificadores-------");

        for(int x=0;x<= identificadores.size()-1;x++){

            System.out.println((x+1)+".-"+identificadores.get(x));
        }

        System.out.println("-------Literales-------");

        for(int x=0;x<= literales.size()-1;x++){

            System.out.println((x+1)+".-"+literales.get(x));
        }



        System.out.println("-------Operadores-------");

        for(int x=0;x<= operadores.size()-1;x++){

            System.out.println((x+1)+".-"+operadores.get(x));
        }

        System.out.println("-------Delimitadores-------");

        for(int x=0;x<= delimitadores.size()-1;x++){

            System.out.println((x+1)+".-"+delimitadores.get(x));
        }

        System.out.println("-------Comentarios-------");

        for(int x=0;x<= comentarios.size()-1;x++){

            System.out.println((x+1)+".-"+comentarios.get(x));
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


        char[] caracteresNoPermitidos={'+','-',' ','*','/','=','%','&','#','!','?','^','"','\'','~','\\','|','<','>','(',')','@',':',';','.',','};

        String[] tokens={"abstract","boolean","break","byte","byvalue","case","cast"
                ,"catch","char","class","const","continue","default","do","double","else",
                "extends", "final", "finally", "float", "for", "future", "generic",
                "goto", "if", "implements", "import", "inner", "instanceof", "int",
                "interface", "long", "native", "new", "null", "operator", "outer",
                "package", "private", "protected", "public", "rest", "return", "short",
                "static", "super", "switch", "synchronized", "this", "threadsafe", "throw",
                "transient", "try", "var", "void", "while"
        };

        if(matComp.matches()){

            contieneCaracteresNoPermitidos=true;
        }

        if (mat1.matches()) {
            // si el primer caracter no es 0-9

            if(!contieneCaracteresNoPermitidos){

                // se hace una comparación con todas las palabras reservadas
                for(int i=0;i<=tokens.length-1;i++){

                    if(cadena.equals(tokens[i])){

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




            }

        }

        if(!contieneCaracteresNoPermitidos && !esPalabraReservada){

            return true;
        }
        else {

            return false;
        }

    }

    static boolean esInt(String cadena){


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

