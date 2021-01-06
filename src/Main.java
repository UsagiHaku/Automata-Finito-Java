import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    private static FiniteAutomata finiteAutomata;

    private static void printFileInformation(File file){
        System.out.println("------ Archivo txt con definición formal de AF--------\n" +
                "Nombre del archivo: " + file.getName() + "\n" +
                "Camino: " + file.getPath() + "\n" +
                "Camino absoluto: " + file.getAbsolutePath() + "\n" +
                "Se puede leer: " + file.canWrite()
        );
    }

    private static void printFinalResult(String currentWord, String success){
        System.out.println("La palabra " + currentWord + success + "cumple con las caracteristicas del lenguaje");
    }

    private static String checkValidWord(String currentWord){
        String character,currentState,auxRequiredTransition,requiredTransition ;
        requiredTransition = (String) finiteAutomata.getInitialState().get(0);
        for(int i=0;i<currentWord.length();i++) {
            character = currentWord.substring(i,i+1);
            requiredTransition = requiredTransition.concat("," );
            requiredTransition = requiredTransition.concat(character);
            System.out.print(requiredTransition +"->");
            requiredTransition = requiredTransition.concat(",");
            auxRequiredTransition = requiredTransition;
            for(int p=0;p<finiteAutomata.getStates().size();p++){
                currentState = (String) finiteAutomata.getStates().get(p);;
                requiredTransition = auxRequiredTransition;
                requiredTransition = requiredTransition.concat(currentState);
                for(int q=0;q<finiteAutomata.getTransitions().size();q++){
                    if (requiredTransition.equals(finiteAutomata.getTransitions().get(q))){
                        requiredTransition = requiredTransition.substring(4,5);
                        System.out.println(requiredTransition);
                        p = finiteAutomata.getStates().size();
                        break;
                    }
                }
            }
        }
        character = requiredTransition;
        String success = " no ";
        for(int s=0;s<finiteAutomata.getFinalStates().size();s++) {
            currentState = (String)finiteAutomata.getFinalStates().get(s);
            if(currentState.equals(character)) {
                success = " si ";
                break;
            }
        }
        return success;
    }

    public static void main(String[] args)  throws FileNotFoundException{
        File automataDefPath = new File(  "Automata-definition.txt");
        File wordsPath = new File("Words-for-check.txt");
        if (automataDefPath.exists() && wordsPath.exists()) {
            printFileInformation(automataDefPath);
            printFileInformation(wordsPath);
        }else{
            System.out.println("Alguno de los txt solicitados no existe o no es posible leerlo");
        }
        Scanner sc = new Scanner(automataDefPath);
        finiteAutomata = new FiniteAutomata(sc);
        // We get the words in file of words and check if these belong to our language( are these words valid in our Automata Finito?)
        sc = new Scanner(wordsPath);
        while(sc.hasNextLine()) {
            String currentWord = sc.nextLine();
            System.out.println("Palabra: "+ currentWord);
            String success = checkValidWord(currentWord);
            printFinalResult(currentWord,success);
        }
    }
}
