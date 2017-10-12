package com.sheila;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;




public class Main {

    public static void main(String[] args)  throws FileNotFoundException{


        Scanner entrada = new Scanner(System.in);

        ArrayList estados = new ArrayList();
        ArrayList alfabeto = new ArrayList();
        ArrayList estadoInicial = new ArrayList();
        ArrayList estadosFinales = new ArrayList();
        ArrayList transiciones = new ArrayList();

        //Pregunto por el directorio
        System.out.println("Dirección del archivo con la definición formal del autómata finito: ");
        String rutaDefinicion = entrada.nextLine();
        System.out.println("Dirección del archivo con las palabras a probar en el automata");
        String rutaPalabras = entrada.nextLine();

        // Creo files
        File rutaDefinicionFormal = new File(rutaDefinicion + "/Definicion-del-automata.txt");
        File rutaPalabrasPrueba = new File(rutaPalabras + "/Palabras-a-revisar.txt");

        //Si este archivo existe,entonces se obtiene información acerca del archivo,sino se avisa:
        if (rutaDefinicionFormal.exists()) {
            System.out.println("------ Archivo txt con definición formal de AF--------");
            System.out.println("Nombre del archivo " + rutaDefinicionFormal.getName());
            System.out.println("Camino             " + rutaDefinicionFormal.getPath());
            System.out.println("Camino absoluto    " + rutaDefinicionFormal.getAbsolutePath());
            System.out.println("Se puede leer      " + rutaDefinicionFormal.canWrite());

        }else{
            System.out.println("Se puede leer      " + rutaDefinicionFormal.canWrite());
        }
        if (rutaPalabrasPrueba.exists()) {
            System.out.println("------ Archivo txt con Palabras a probar en AF-------");
            System.out.println("Nombre del archivo " + rutaPalabrasPrueba.getName());
            System.out.println("Camino             " + rutaPalabrasPrueba.getPath());
            System.out.println("Camino absoluto    " + rutaPalabrasPrueba.getAbsolutePath());

        }
        else{
            System.out.println("Se puede leer      " + rutaPalabrasPrueba.canWrite());
        }

        Scanner definicion =new Scanner(rutaDefinicionFormal);

        // Inserto los estados al Arraylist "estados"
        do{
            String lecturaEstados = definicion.nextLine();
            if (lecturaEstados.equals("Z=")) {
                break;
            }else{
                estados.add(lecturaEstados);
            }
        }while (definicion.hasNextLine());
        // Inserto el alfabeto al Arraylist "alfabeto"
        do{
            String lecturaAlfabeto= definicion.nextLine();
            if (lecturaAlfabeto.equals("S=")){
                break;
            }else{
                alfabeto.add(lecturaAlfabeto);
            }
        }while (definicion.hasNextLine());
        //Inserto el estado inicial al Arraylist "estadoInicial"
        do{
            String lecturaEstadoInicial= definicion.nextLine();
            if (lecturaEstadoInicial.equals("F=")){
                break;
            }else{
                estadoInicial.add(lecturaEstadoInicial);
            }
        }while (definicion.hasNextLine());
        //Inserto los estados finales al Arraylist "estadosFinales"
        do{
            String lecturaEstadosFinales = definicion.nextLine();
            if(lecturaEstadosFinales.equals("T=")){
                break;
            }else{
                estadosFinales.add(lecturaEstadosFinales);
            }
        }while ((definicion.hasNextLine()));
        //Inserto las transiciones al Arraylist "transiciones"
        do{
            String lecturaTransiciones = definicion.nextLine();
            transiciones.add(lecturaTransiciones);
        }while (definicion.hasNextLine());

        // Ahora checaré las palabras del archivo txt para ver si pertenecen o no al AF

        Scanner palabras =new Scanner(rutaPalabrasPrueba);

        String caracterAnalizado,unEstado,linea3;
        int i, p,q;

        while(palabras.hasNextLine()) {

            String palabraActual = palabras.nextLine();
            System.out.println("Palabra: "+ palabraActual);
            int longitud= palabraActual.length();
            String estadoActual = (String) estadoInicial.get(0);

            for(i=0;i<longitud;i++) {
                caracterAnalizado=palabraActual.substring((i),(i+1));
                estadoActual= estadoActual.concat("," );
                estadoActual= estadoActual.concat(caracterAnalizado);
                System.out.print(estadoActual +"->");
                estadoActual=estadoActual.concat(",");
                linea3=estadoActual;//checar

                for(p=0;p<estados.size();p++){
                    unEstado = (String) estados.get(p);;
                   estadoActual=linea3;//checar
                    estadoActual=estadoActual.concat(unEstado);

                    for(q=0;q<transiciones.size();q++){
                        if (estadoActual.equals(transiciones.get(q))){
                            caracterAnalizado =estadoActual.substring(4,5);
                            p= estados.size();
                            q=transiciones.size();
                            estadoActual=caracterAnalizado;
                            System.out.println(caracterAnalizado);
                        }
                    }
                }
            }

            caracterAnalizado=estadoActual;

            int s, cumpleNocumple=0;

            for(s=0;s<estadosFinales.size();s++) {
                unEstado=(String) estadosFinales.get(s);
                if(unEstado.equals(caracterAnalizado)) {
                    cumpleNocumple=1;
                    s=estadosFinales.size();
                }

            }
            if(cumpleNocumple==1) {
                System.out.println("El estado "+caracterAnalizado+ " es final");
                System.out.println("Por tanto la palabra "+ palabraActual +" cumple con las caracteristicas del lenguaje \n\n");
            }
            else {
                System.out.println("El estado "+caracterAnalizado +" NO es final");
                System.out.println("Por tanto la palabra "+ palabraActual+" NO cumple con las caracteristicas del lenguaje \n\n");
            }



        }


    }



}
