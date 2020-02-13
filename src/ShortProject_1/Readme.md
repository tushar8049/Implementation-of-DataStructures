SP-1 submitted by Tushar Gonawala(txg170003) and Dishant Khanna(dxk180015)

According to our program
1. If you input 1 it moves to the next element and prints it.
2. If you input 3 it deletes the element.
3. If you input 2 it moves to the previous element and prints it.
4. If you input 4 it will ask for number and add node after current cursor

Steps to compile and run the program:
(If you run on an ide)
1. Download and import the package folder from the program file.
2. Run the DoublyLinkedList.java and given the inputs from the terminal (by default the size is 10).

(If you run on command run prompt)
1. Unzip the folder.
2. javac txg170003_dxk180015/SinglyLinkedList.java
3. javac txg170003_dxk180015/DoublyLinkedList.java
4. java txg170003_dxk180015.DoublyLinkedList

NOTE:
Two successive delete operation cannot be performed in middle of list but only from the tail.
In order to do so, Next operation needs to be performed

MENU Options:
1. Move forward
2. Delete current element
3. Move backward
4. Add element after current cursor
    eg. after selecting option 4 and hitting enter the terminal will be waiting for another input that will be the element that needs to be inserted.

Output:

    10: 1 2 3 4 5 6 7 8 9 10        --> Initial state of the LinkedList with size
    
    1                               --> Move forward
    
    1                               --> Result
    
    1                               --> Move forward
    
    2                               --> Result
    
    1                               --> Move forward
    
    3                               --> Result
    
    1                               --> Move forward
    
    4                               --> Result
    
    2                               --> Delete Current Element i.e. 4
    
    Element Deleted Successfully
    
    9: 1 2 3 5 6 7 8 9 10           --> Result and State of the LinkedList
    
    1                               --> Move forward
    
    5                               --> Result
    
    3                               --> Move backward
    
    3                               --> Result
    
    4                               --> Add element after Cursor
    
    1000                            --> Element to be Inserted
    
    true                            --> Result True if Insertion successful otherwise false
    
    5                               --> Input other that 1,2,3,4 opt for termination
    
    10: 1 2 3 1000 5 6 7 8 9 10     --> Final state of the LinkedList with size
    


