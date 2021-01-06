import java.util.ArrayList;
import java.util.Scanner;

public class FiniteAutomata {
    private ArrayList states = new ArrayList();
    private ArrayList vocabulary = new ArrayList();
    private ArrayList initialState = new ArrayList();
    private ArrayList finalStates = new ArrayList();
    private ArrayList transitions = new ArrayList();

    public FiniteAutomata(Scanner sc) {
        String currentLine ;
        //Insert states,initial state, final states , transitions and vocabulary from txt to the variables

        do{
            currentLine =  sc.nextLine();
            if (currentLine.equals("Z=")) {
                break;
            }else{
               this.states.add(currentLine);
            }
        }while (sc.hasNextLine());

        do{
            currentLine =  sc.nextLine();
            if (currentLine.equals("S=")) {
                break;
            }else{
               this.vocabulary.add(currentLine);
            }
        }while (sc.hasNextLine());

        do{
            currentLine =  sc.nextLine();
            if (currentLine.equals("F=")) {
                break;
            }else{
                this.initialState.add(currentLine);
            }
        }while (sc.hasNextLine());

        do{
            currentLine =  sc.nextLine();
            if (currentLine.equals("T=")) {
                break;
            }else{
                this.finalStates.add(currentLine);
            }
        }while (sc.hasNextLine());

        do{
            currentLine =  sc.nextLine();
            this.transitions.add(currentLine);
        }while (sc.hasNextLine());
    }

    public ArrayList getStates(){
        return states;
    }

    public void setStates(ArrayList states) {
        this.states = states;
    }

    public ArrayList getVocabulary() {
        return vocabulary;
    }

    public void setVocabulary(ArrayList vocabulary) {
        this.vocabulary = vocabulary;
    }

    public ArrayList getInitialState() {
        return initialState;
    }

    public void setInitialState(ArrayList initialState) {
        this.initialState = initialState;
    }

    public ArrayList getFinalStates() {
        return finalStates;
    }

    public void setFinalStates(ArrayList finalStates) {
        this.finalStates = finalStates;
    }

    public ArrayList getTransitions() {
        return transitions;
    }

    public void setTransitions(ArrayList transitions) {
        this.transitions = transitions;
    }
}
