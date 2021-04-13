import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class PlayingWithWheel {

    static LinkedList<State> openSet = new LinkedList<>();
    static LinkedList<State> closedSet = new LinkedList<>();
    static LinkedList<State> shortPath = new LinkedList<>();
    static LinkedList<State> blockedSet = new LinkedList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Number of Problem: ");
        int numberOfProblems = Integer.parseInt(scanner.next());
        problem(numberOfProblems);
    }

    public static void problem(int i){
        int k = 1;
        for(int j=i;j>0;j--){
            System.out.println("Problem " + k + ":");
            int a,b,c,d;
            System.out.print("Initial State: ");
            a = Integer.parseInt(scanner.next());
            b = Integer.parseInt(scanner.next());
            c = Integer.parseInt(scanner.next());
            d = Integer.parseInt(scanner.next());
            int[] startArray = {a,b,c,d};

            System.out.print("Final State: ");
            a = Integer.parseInt(scanner.next());
            b = Integer.parseInt(scanner.next());
            c = Integer.parseInt(scanner.next());
            d = Integer.parseInt(scanner.next());
            int[] finalArray = {a,b,c,d};
            playingWithWheels(startArray, finalArray);
            k++;
            shortPath.clear();
            closedSet.clear();
            openSet.clear();
            blockedSet.clear();
        }
    }

    static public State closestState(){
        State state = openSet.element();
        for (State compareState : openSet) {
            if (compareState.fitness < state.fitness) {
                state = compareState;
                return state;
            }
        }
        return state;
    }

    static  public void addToOpenSet(State state ,State previousState){
        if(!checkSets(state)){
            state.setPreviousState(previousState);
            openSet.add(state);
        }
    }

    static public boolean checkSets(State state){
        boolean inOpenSet = false;
        boolean inClosedSet = false;
        boolean inBlockedSet = false;
        for (State compareState : openSet) {
            if (Arrays.equals(compareState.array, state.array)) {
                inOpenSet = true;
            }
        }
        for (State compareState : closedSet) {
            if (Arrays.equals(compareState.array, state.array)) {
                inClosedSet = true;
            }
        }
        for (State compareState : blockedSet) {
            if (Arrays.equals(compareState.array, state.array)) {
                inBlockedSet = true;
            }
        }
        return inClosedSet || inOpenSet ||inBlockedSet;
    }

    public static void setBlockedSet(int numberOfBlockedState){
        int k = 1;
        State[] blockStates = new State[numberOfBlockedState];
        for(int i=numberOfBlockedState; i>0; i--){
            System.out.print("Block State " + k + ": ");
            int a,b,c,d;
            blockStates[k-1] = new State();
            a = Integer.parseInt(scanner.next());
            b = Integer.parseInt(scanner.next());
            c = Integer.parseInt(scanner.next());
            d = Integer.parseInt(scanner.next());
            int[] blockedArray = {a,b,c,d};
            blockStates[k-1].setArray(blockedArray);
            blockedSet.add(blockStates[k-1]);
            k++;
        }
    }

    public static void createState(State state){
        State[] state1 = new State[4];
        for(int i = 0; i<4; i++){
            state1[i] = new State();
            state1[i].increment(Arrays.copyOf(state.array,state.array.length), i , state.cost, 1);
            addToOpenSet(state1[i], state);
        }
        State[] state2 = new State[4];
        for(int i = 0; i<4; i++){
            state2[i] = new State();
            state2[i].decrement(Arrays.copyOf(state.array,state.array.length), i , state.cost, 1);
            addToOpenSet(state2[i], state);
        }
    }

    public static void playingWithWheels(int[] startArray, int[] finalState) {

        State.finalState = finalState;

        State startState = new State();
        startState.setArray(startArray);
        openSet.add(startState);

        System.out.print("Number of Blocked States: ");
        int numberOfBlockStates = Integer.parseInt(scanner.next());
        setBlockedSet(numberOfBlockStates);

        State currentState = closestState();
        while(true){
            if(openSet.size() == 0){
                System.out.println("\n\nUnreachable");
                break;
            }
            if(currentState.fitness == 0){
                System.out.println("\n\nReached");
                State pathState = currentState;
                while (pathState!=null){
                    shortPath.addFirst(pathState);
                    pathState = pathState.previousState;
                }
                break;
            }
            closedSet.add(currentState);
            openSet.remove(currentState);
            createState(currentState);
            if(openSet.size()!=0){
                currentState = closestState();
            }
        }

        System.out.println("Solution:");
        for (int i=0; i<shortPath.size(); i++){
            State printState = shortPath.get(i);
            System.out.print("[" + printState.array[0]+ "," + printState.array[1]+ "," + printState.array[2]+ "," + printState.array[3]+"]");
            if (i+1<shortPath.size()){
                System.out.print("===>>");
            }
        }
        System.out.println("\nShortest distance to solution: " + (shortPath.size()-1));
    }

}
