/**
 * @author txg170003 & dxk180015
 *
 */

package ShortProject_2;

public class BoundedQueue<T> {
    private int size;
    private Object[] queue;
    private int currentSize;
    private int front;
    private int rear;

    // Constructor to initialize the BoundedQueue
    BoundedQueue(int maxSize){
        size = maxSize;
        queue = new Object[size];
        clear();
    }

    // Insert element in the BQ at the position of front.
    // Returns true if the element is inserted and false if the queue is full.
    public boolean offer(T element){
        if(currentSize >= size){
            return false;
        }
        queue[front % size] = element;
        front++;
        currentSize++;        
        return true;
    } 

    // Return the element from the BQ from the rear position only if the Queue is not empty
    public T poll(){
        if(isEmpty()){
            return null;
        }
        
        T result = (T) queue[rear % size];
        rear++;
        currentSize--;
        return result;
    }

    // Check the rear pointer for the returning the element.
    public T peek(){
        if(isEmpty()){
            return null;
        }
        return (T) queue[rear % size];
    }

    // Return the currentSize variable that is maintained on every operation.
    public int size(){
        return  currentSize;
    }

    // Check with the CurrentSize variable for checking if the Queue is empty or not
    public boolean isEmpty(){
        return currentSize == 0;
    }

    // Initialize the Queue to the default settings setting all the variables to 0
    public void clear(){
        currentSize = 0;
        front = 0;
        rear = 0;
    }

    // Iterating through the BQ Array and copying the elements
    // based on the front and rear pointer using dummy variables.
    public void toArray(T[] arr){
        if(arr.length < currentSize){
            System.out.println("Array size is less than the current size of the Queue");
        }
        int dummyRear = rear;
        int dummyCurrentSize = currentSize;
        int i = 0;
        while(i < arr.length && dummyCurrentSize != 0){
            arr[i] = (T)queue[dummyRear % size];
            i++;
            dummyRear++;
            dummyCurrentSize--;
        }
    }
}

