import javax.swing.*; // Libreria para elementos gráficos

import java.util.regex.Matcher; // Se ocupa para comprobar si es que un String coincide con un patron (una expresión regular)
import java.util.regex.Pattern; // Se ocupa para tener un patron, es decir una expresion regular


// Cualquier duda con el codigo o los comentarios mandenme un mensaje al whats

public class Pract2ER {
    public static void main(String[] args) {

        String cadena = ""; // Se inicializa cadena que sera donde se coloca el String a comparar
        int contadorPuntos = 0; // Variable que se usa al comprobar si una LITERAL es un float o un double, se usa para comprobar si es que un STRING no tiene más de dos puntos ( ya que de acuerdo a la sintaxis de float o double esto no seria correcto)
        String ele = ""; // Variable que maneja la elección de elementos en el programa


        boolean seguirCiclo= true; // Maneja si es que el ciclo continua, el ciclo que maneja el programa

        boolean esPalabraReservada=false; // Usado para validar identificadores, sirve para ver si un identificador es valido o no, si es una palabra reservada no lo es
        boolean contieneCaracteresNoPermitidos=false; // Si el IDENTIFICADOR contiene caracteres como @ no sera valido

        do {

        ele = JOptionPane.showInputDialog("\n1.-identificador\n2.-int\n3.-long\n(todavia no)4.-float\n(todavia no)5.-d    ouble\n6.-char\n7.-String\n8.-boolean\n9.-Salir");
        // Se elige una opción para el menú
            
        // ".*" Para String, "." Para char, "true|false" para boolean, "(1*|2*|3*|4*|5*|6*|7*|8*|9*|0*)*" para int, ".*" para ID con un if aparte que verifique el primer o siguiente caracter,
        switch (ele) {
            // Todos los casos en el switch siguen la misma logica, un patron (que es la expresión regular), un matcher que de acuerdo al patron verifica si la cadena es valida y el resultado
                
            case "1": // La cadena ingresada es un identificador?
                // Para este caso hay tres REGLAS que debe seguir un identificador para que el programa lo capte como un IDENTIFICADOR
                //Reglas
                // 1.- No se permiten caracteres caracteres como + – * / = % & # ! ? ^ “ ‘ ~ \ | < > ( )
                // 2.- No puede empezar por un numero [0-9]
                // 3.- No puede ser palabra reservada
                
                // El caso 1 es especial, en este primero se tiene un patron y un matcher, pero despues se ve otro 
                // el segundo sirve para comparar el PRIMER caracter del string para asi validar la segunda regla "No puede empezar por un numero [0-9]"
                cadena = JOptionPane.showInputDialog("Ingresa cadena");
                
                Pattern pat1 = Pattern.compile(".*"); // La expresion regular es '.' ( '.' es un comodin es decir puede ser cualquier caracter) seguido de * ( por lo que la cadena puede ser cualquier caracter cualquier cantidad de veces)
                // como puede ser cualquier caracter se usan if's despues para verificar su validez y que no viole las reglas ya establecidas
                Matcher mat1 = pat1.matcher(cadena);

                // Expresión regular que tiene como Alfabeto del 0 al 9, esto para comprobar si el primer caracter de la cadena coincide con esta
                Pattern patComp = Pattern.compile("[0-9]");
                String complementario=""; // String que guardara dentro de si el primer caracter de la cadena
                
                // Se guarda dentro del String complementario el primer caracter de la cadena 
                complementario+=cadena.charAt(0);
                Matcher matComp = patComp.matcher(complementario);
                

                // Arreglo de caracteres no permitidos
                // Si se encuentra alguno de estos se viola la reglas de "No se permiten caracteres caracteres como + – * / = % & # ! ? ^ “ ‘ ~ \ | < > ( )" por lo que la cadena no sera valida
                char[] caracteresNoPermitidos={'+','-',' ','*','/','=','%','&','#','!','?','^','"','\'','~','\\','|','<','>','(',')','@',':',';'};

                // Arreglo de palabras reservadas
                // Si la cadena coincide al 100% con alguno de estos Strings no sera valida puesto que seria una palabra reservada
                String[] tokens={"abstract","boolean","break","byte","byvalue","case","cast"
                        ,"catch","char","class","const","continue","default","do","double","else",
                        "extends", "final", "finally", "float", "for", "future", "generic",
                        "goto", "if", "implements", "import", "inner", "instanceof", "int",
                        "interface", "long", "native", "new", "null", "operator", "outer",
                        "package", "private", "protected", "public", "rest", "return", "short",
                        "static", "super", "switch", "synchronized", "this", "threadsafe", "throw",
                        "transient", "try", "var", "void", "while"
                };

                

                if (mat1.matches()) { // Primero se comprueba si la cadena coincide, como es cualquier combinacion de caracteres siempre lo hara
                
                    if(!(matComp.matches())){ // Segundo filtro: Si es que el primer caracter no es un numero pasa la "prueba"
                        
                        for(int i=0;i<=tokens.length-1;i++){ // Se recorre el arreglo de palabras reservadas para compararlas con la cadena ingresada
                            
                            if(cadena.equals(tokens[i])){ // Si la cadena coincide con alguna palabra reservada no sera valida
                                System.out.println("No es una cadena ya que ocupa una palabra reservada");
                                esPalabraReservada=true; // este booleano se ocupara para la condición final del caso
                                break;
                            }
                        }

                        for(int i=0;i<=caracteresNoPermitidos.length-1;i++){ // Se usa el arreglo de los caracteres no permitidos para buscarlos dentro de la cadena ingresada

                            // se agarra un caracter y se busca ese caracter en la cadena
                            // si no se encuentra quiere decir que es una cadena valida
                            
                            for(int j=0;j<=cadena.length()-1;j++){ // Cada caracter de la lista de no permitidos se a comparar con CADA uno de los caracteres de la cadena a validar

                                if(caracteresNoPermitidos[i]==cadena.charAt(j)){ // Si alguno de los caracteres no permitidos y los de la cadena coincide  la cadena no sera valida
                                     
                                    contieneCaracteresNoPermitidos=true; // Booleano que ayudara a la comprobación final
                                }
                            }
                        }
                        if(contieneCaracteresNoPermitidos){ // Mensaje que indica que la cadena ingresada no es valida
                            System.out.println("No es una cadena tipo id ya que hay caracteres no validos!");
                        }

                        if(!contieneCaracteresNoPermitidos && !esPalabraReservada){ // Si no es una palabra reservada y no tiene caracteres no permitidos es valida
                            System.out.println("Si es un identificador valido"); // Se imprime que si es valida
                        }

                    }

                }
                break;
            case "2": // int
                // POR IMPLEMENTAR: Diferencia de caracteres entre un int y un long, es diferente la cantidad de caracteres que soportan pero en las expresiones regulares no hay diferencia todavia.
                cadena = JOptionPane.showInputDialog("Ingresa cadena"); // Se pide una cadena 
                Pattern pat2 = Pattern.compile("(1*|2*|3*|4*|5*|6*|7*|8*|9*|0*)*"); // Esta expresión regular es lo mismo que [0-9] es decir cualquier cantidad de caracteres
                                                                                    // que sean numeros del 0 al 9 
                Matcher mat2 = pat2.matcher(cadena);
                // Por hacer checar el tamaño de int
                if (mat2.matches()) { // Se checa si coincide la cadena con la expresión regular
                    System.out.println("Si es una cadena tipo int");
                }
                break;
                
            case "3": // Long
                cadena = JOptionPane.showInputDialog("Ingresa cadena");
                Pattern pat3 = Pattern.compile("([0-9])*"); // Puede ser cualquier caracter del alfabeto [0-9] cualquier cantidad de veces
                Matcher mat3 = pat3.matcher(cadena);
                // Por hacer checar el tamaño de int
                if (mat3.matches()) {
                    System.out.println("Si es una cadena tipo long");
                }
                break;
            case "4": // float
                cadena = JOptionPane.showInputDialog("Ingresa cadena");
                // el "//" es para que reconozca el punto como caracter xd
                // si se pone "//" no reconoce al '.' como comodin
                Pattern pat7 = Pattern.compile("([0-9]|\\.)*f"); // La expresion regular indica que puede ser cualquier cantidad de numeros o puntos siempre terminando con una f
                                                                 // por lo que cadenas como ....3f serian validas, es por eso que hay unos if's que hacen unas validaciones extras
                Matcher mat7 = pat7.matcher(cadena);
                
                if (mat7.matches()) { // Si la cadena coincide se hacen unas comprobaciones consecuentes

                    for (int i = 0; i <= cadena.length() - 1; i++) { // Se recorre la cadena en busca de caracteres '.' o puntos
                        if (cadena.charAt(i) == '.') { 
                            contadorPuntos += 1; // Si se encuentra un punto se agrega uno al contador
                        }
                    }
                    if (contadorPuntos <= 1) { // Si es que al recorrer la cadena la cantidad de puntos es menor o igual 1 ( hay un punto o ninguno)
                                               // se hace una ultima evaluación, hay un punto como ´penultimo caracter? algo como 5.f
                                               // si es que si lo hay este sera invalido
                    
                        // checa si es que el penultimo caracter no es . para evitar que sea algo tipo 3.f
                        if (cadena.length() > 1) { // comprobación de que el tamaño del string es mayor a 1 para evitar errores
                            if (cadena.charAt(cadena.length() - 2) != '.') { // Si el penultimo caracter no es un punto entonces es una cadena valida

                                System.out.println("Si es una cadena tipo float");

                            }
                        }
                    }
                }
                break;
            case "5": // Double, mismo codigo que float solo que al final de la expresión regular es una d
                cadena = JOptionPane.showInputDialog("Ingresa cadena");
                Pattern pat8 = Pattern.compile("([0-9]|\\.)*d"); // Al final tiene que haber una d, de ahi en mas es igual al float
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

                // De aqui en adelante solo se va explicar la expresión regular porque siguen la mimsa logica los casos
            case "6": // Char
                cadena = JOptionPane.showInputDialog("Ingresa cadena");
                Pattern pat4 = Pattern.compile("."); // Puede ser cualquier caracter ya que es un comodin
                Matcher mat4 = pat4.matcher(cadena);
                // Por hacer checar el tamaño de int
                if (mat4.matches()) {
                    System.out.println("Si es una cadena tipo char");
                }
                break;
            case "7": // String
                cadena = JOptionPane.showInputDialog("Ingresa cadena");
                Pattern pat5 = Pattern.compile(".*"); // Puede ser cualquier caracter sin limite de cantidad del mismo
                Matcher mat5 = pat5.matcher(cadena);
                // Por hacer checar el tamaño de int
                if (mat5.matches()) {
                    System.out.println("Si es una cadena tipo String");
                }
                break;
            case "8": // Booleanos
                cadena = JOptionPane.showInputDialog("Ingresa cadena");
                Pattern pat6 = Pattern.compile("true|false"); // la expresión solo puede ser true o false
                Matcher mat6 = pat6.matcher(cadena);
                // Por hacer checar el tamaño de int
                if (mat6.matches()) {
                    System.out.println("Si es una cadena tipo booleano");
                }
                break;
            case "9": // Condición de salida
                seguirCiclo=false;
                break;
            default: // Condición por defecto si no coincide con alguna del 1 al 9
                System.out.println("XD");
                break;
        }

    }while(seguirCiclo); // Si seguirCiclo es verdadero sigue el ciclo

    }
}
