import java.lang.Math;

public class State {
    public int[] array = {0,0,0,0};
    public static int[] finalState;
    int fitness;
    int cost = 0;
    State previousState = null;

    public State(){
        this.fitness = calculateFitness();
    }

    public int calculateFitness(){
        this.fitness = Math.abs(array[0] - finalState[0]) + Math.abs(array[1] - finalState[1]) + Math.abs(array[2] - finalState[2]) + Math.abs(array[3] - finalState[3]);
        if(this.fitness==0){
            this.cost=0;
        }
        this.fitness = this.fitness + this.cost;
        return this.fitness;
    }

    public void setPreviousState(State previousState){
        this.previousState = previousState;
    }

    public void setArray(int[] array){
        this.array = array;
    }

    public  void increment(int[] array, int index, int previousCost, int costIncrement){
        this.array = array;
        this.array[index] = (this.array[index]+1)%10;
        this.cost = previousCost;
        this.cost = this.cost + costIncrement;
        this.fitness = calculateFitness();
    }

    public  void decrement(int[] array, int index, int previousCost, int costIncrement){
        this.array = array;
        this.array[index]= (this.array[index]+9)%10;
        this.cost = previousCost;
        this.cost = this.cost + costIncrement;
        this.fitness = calculateFitness();
    }
}