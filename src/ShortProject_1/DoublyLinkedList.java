/**
 * @author txg170003 & dxk180015
 *
 */
package ShortProject_1;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class DoublyLinkedList<T> extends SinglyLinkedList<T> {

    static class Entry<E> extends SinglyLinkedList.Entry<E> {
        Entry<E> prev;
        Entry(E x, Entry<E> next, Entry<E> prev) {
            super(x, next);
            this.prev = prev;
        }
    }

    public DoublyLinkedList() {
        head = new DoublyLinkedList.Entry<>(null, null,null);
        tail = head;
        size = 0;
    }

    // Getting the Iterator
    public Iterator<T> iterator() {
        return new DLLIterator();
    }

    protected class DLLIterator extends SinglyLinkedList.SLLIterator {

        public boolean hasPrev(){
            return ((Entry) cursor).prev != null;
        }

        public T prev(){
            T temp = (T)((Entry)cursor).prev.element;
            cursor = ((Entry)cursor).prev;
            return temp;
        }

        public boolean add(T x){
            try {
                add(new Entry<>(x,null,null));
                return true;
            }
            catch (Exception e){
                return false;
            }
        }

        private void add(Entry e){
            if(cursor == tail){
                cursor.next = e;
                e.prev = ((Entry)cursor).prev;
            }else{
                e.next = cursor.next;
                e.prev = ((Entry)cursor.next).prev;
                ((Entry)cursor.next).prev = e;
                cursor.next = e;
                if(cursor == head){
                    head.next = e;
                }
            }
            cursor = e;
            size++;
        }

        // remove current element
        public void remove() {
            if(!ready) {
                throw new NoSuchElementException();
            }
            if(size == 0){
                return;
            }
            // Case of deletion at the tail
            if(cursor == tail){
                tail = ((Entry)cursor).prev;
                ((Entry)cursor).prev.next = null;
                cursor = ((Entry)cursor).prev;
                ready = true;
            } else { // Case of deletion in middle of the LinkedList.
                ((Entry)cursor.next).prev =((Entry)cursor).prev;
                ((Entry)cursor).prev.next =  ((Entry)cursor).next;

                // Setting ready to false so that we ensure next is called before delete operation.
                ready = false;
            }
            size--;
        }
    }

    // Add new elements to the end of the list and also link the previous element.
    public void add(T x) {
        add(new Entry<>(x, null,null));
    }

    // Helper method for the adding the element.
    public void add(Entry<T> ent) {
        ent.prev = (Entry)tail;
        tail.next = ent;
        tail = tail.next;
        size++;
    }


    public static void main(String[] args) throws NoSuchElementException {
        int n = 10;
        if(args.length > 0) {
            n = Integer.parseInt(args[0]);
        }

        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        for(int i=1; i<=n; i++) {
            dll.add(Integer.valueOf(i));
        }
        dll.printList();

        Iterator<Integer> it = dll.iterator();
        Scanner in = new Scanner(System.in);
        whileloop:
        while(in.hasNext()) {
            int com = in.nextInt();
            switch(com) {
                case 1: // Move to next element and print it
                    if (it.hasNext()) {
                        System.out.println(it.next());
                    } else {
                        break whileloop;
                    }
                    break;
                case 2 : // Remove element
                    try{
                        it.remove();
                        System.out.println("Element Deleted Successfully");
                    } catch (Exception e) {
                        System.out.println("Perform the next operation for deleting the desired element");
                    }
                    dll.printList();
                    break;
                case 3: // move to previous element and print
                    if (((DoublyLinkedList.DLLIterator)it).hasPrev()) {
                        System.out.println(((DoublyLinkedList.DLLIterator)it).prev());
                    } else {
                        break whileloop;
                    }
                    break;
                case 4: // Add element x after the cursor position
                    Scanner input = new Scanner(System.in);
                    int x = input.nextInt();
                    System.out.println(((DoublyLinkedList.DLLIterator)it).add(x));
                    break;
                default:  // Exit loop
                    break whileloop;
            }
        }
        dll.printList();
    }
}
