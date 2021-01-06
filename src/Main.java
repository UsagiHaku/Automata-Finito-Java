import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    private static void printFileInformation(File file){
        System.out.println("------ Archivo txt con definición formal de AF--------");
        System.out.println("Nombre del archivo " + file.getName());
        System.out.println("Camino             " + file.getPath());
        System.out.println("Camino absoluto    " + file.getAbsolutePath());
        System.out.println("Se puede leer      " + file.canWrite());
    }

    public static void main(String[] args)  throws FileNotFoundException{
        File automataDefPath = new File(  "Definicion-del-automata.txt");
        File wordsPath = new File("Palabras-a-revisar.txt");

        if (automataDefPath.exists() && wordsPath.exists()) {
            printFileInformation(automataDefPath);
            printFileInformation(wordsPath);
        }else{
            System.out.println("Alguno de los txt solicitados no existe o no es posible leerlo");
        }
        ArrayList states = new ArrayList();
        ArrayList vocabulary = new ArrayList();
        String initialState = "";
        ArrayList finalStates = new ArrayList();
        ArrayList transitions = new ArrayList();
        Scanner sc = new Scanner(automataDefPath);
        String currentLine = sc.nextLine();
        //Insert states,initial state, final states , transitions and vocabulary from txt to the variables
        while(!currentLine.equals("Z=")){
            currentLine = sc.nextLine();
            states.add(currentLine);
        }
        while(!currentLine.equals("S=")){
            currentLine = sc.nextLine();
            vocabulary.add(currentLine);
        }
        currentLine = sc.nextLine();
        initialState = currentLine;
        currentLine = sc.nextLine();
        while(!currentLine.equals("T=")){
            currentLine = sc.nextLine();
            finalStates.add(currentLine);
        }
        while(sc.hasNextLine()){
            currentLine = sc.nextLine();
            transitions.add(currentLine);
        }
        // We get the words in file of words and check if these belong to our language( are these words valid in our Automata Finito?)
        sc = new Scanner(wordsPath);
        String requiredTransition = "";
        String character,currentState,auxRequiredTransition;
        while(sc.hasNextLine()) {
            String currentWord = sc.nextLine();
            System.out.println("Palabra: "+ currentWord);
            requiredTransition = initialState;
            for(int i=0;i<currentWord.length();i++) {
                character = currentWord.substring(i,i+1);
                requiredTransition = requiredTransition.concat("," );
                requiredTransition = requiredTransition.concat(character);
                System.out.print(requiredTransition +"->");
                requiredTransition = requiredTransition.concat(",");
                auxRequiredTransition = requiredTransition;
                for(int p=0;p<states.size();p++){
                    currentState = (String) states.get(p);;
                    requiredTransition = auxRequiredTransition;
                    requiredTransition = requiredTransition.concat(currentState);
                    for(int q=0;q<transitions.size();q++){
                        if (requiredTransition.equals(transitions.get(q))){
                            requiredTransition = requiredTransition.substring(4,5);
                            System.out.println(requiredTransition);
                            p = states.size();
                            break;
                        }
                    }
                }
            }
            character = requiredTransition;
            Boolean success = false;
            for(int s=0;s<finalStates.size();s++) {
                currentState = (String) finalStates.get(s);
                if(currentState.equals(character)) {
                    success = true;
                   break;
                }
            }
            if(success) {
                System.out.println("El estado "+character+ " es final");
                System.out.println("Por tanto la palabra "+ currentWord +" cumple con las caracteristicas del lenguaje \n\n");
            }
            else {
                System.out.println("El estado "+character +" NO es final");
                System.out.println("Por tanto la palabra "+ currentWord+" NO cumple con las caracteristicas del lenguaje \n\n");
            }
        }
    }
}
