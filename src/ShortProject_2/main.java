package ShortProject_2;

import java.util.Scanner;

public class main {
    public static void main(String[] args){

        BoundedQueue<Integer> boundedQueue = new BoundedQueue<>(5);
        int choice;
        int element;
        Scanner input = new Scanner(System.in);
        do{
            System.out.println("Choose from the options below:");
            System.out.println("1. Add element to the Bounded Queue");
            System.out.println("2. Remove the element from the Bounded Queue");
            System.out.println("3. Return the Front element of the Bounded Queue");
            System.out.println("4. Return the size of the Bounded Queue");
            System.out.println("5. Check if the Bounded Queue is empty");
            System.out.println("6. Clear the Bounded Queue");
            System.out.println("7. Add the Bounded Queue elements to an array");
            System.out.println("0. Exit");
            choice = input.nextInt();
            switch(choice) {
                case 1: {
                    System.out.println("Enter the element to add to the Bounded Queue");
                    element = input.nextInt();
                    boundedQueue.offer(element);
                    break;
                }

                case 2: {
                    System.out.println("Element removed: " + boundedQueue.poll());
                    break;
                }

                case 3: {
                    System.out.println("Element at the front of the Bounded Queue is: " + boundedQueue.peek());
                    break;
                }

                case 4: {
                    System.out.println("The size of the Bounded Queue is: " + boundedQueue.size());
                    break;
                }

                case 5: {
                    if (boundedQueue.isEmpty())
                        System.out.println("Bounded Queue is empty");
                    else
                        System.out.println("Bounded Queue is not empty");

                    break;
                }

                case 6: {
                    boundedQueue.clear();
                    System.out.println("Bounded Queue is cleared");
                    break;
                }

                case 7: {
                    System.out.println("Enter the Size of the array");
                    int size = input.nextInt();
                    Integer[] arr = new Integer[size];
                    boundedQueue.toArray(arr);
                    break;
                }

                case 0: {
                    break;
                }

                default: {
                    System.out.println("Invalid option. Please choose from the above available options.");
                    break;
                }
            }
        } while(choice != 0);
    }
}
