import java.util.*;

public class BasicLinkedList
{
  public static Scanner scn = new Scanner(System.in);
  
  public static class LinkedList
  {
    private class Node 
    {
      int data;
      Node next;

      // public Node(int data) {
      //   this.data = data;
      // }

      public Node() {

      }
    }
    
    private Node head;                  // ! Pointer
    private Node tail;                  // ! Pointer
    private int size;
    
    public boolean isEmpty() {
      return size == 0;
    }

    public int size() {
      return size;
    }

    public void display() 
    {
      for (Node temp = head; temp != null; temp = temp.next)
        System.out.print(temp.data + " ");
      System.out.println();
    }

    int getFirst()
    {
      if (size == 0)
      {
        System.out.println("LinkedList is Empty");
        return -1;
      }
      else  
        return head.data;  
    }
    
    int getLast()
    {
      if (size == 0) 
      {
        System.out.println("LinkedList is Empty");
        return -1;
      } 
      else
        return tail.data;
    }

    int getAt(int idx)
    { 
      Node temp = head;
      for(int i = 0; i < idx; i++)
        temp = temp.next;
      return temp.data;
    }

    void addLast(int val) 
    {
      Node temp = new Node();                  
      temp.data = val;
      temp.next = null;

      // Node AlternativeTemp = new Node(10);

      if (size == 0) 
        head = tail = temp; 
      else 
      {
        tail.next = temp;                                 // ! Joining the tail with New Node temp
        tail = temp;                                      // ! Updating the tail on the Current Node 
      }

      size++;
    }
    
    void addFirst(int val)
    {
      Node temp = new Node();
      temp.data = val;
      temp.next = null;
      
      if(size == 0)
        head = tail = temp;
      else
      {
        temp.next = head;
        head = temp;
      }
      size++;
    }

    void removeFirst()
    {
      if(size == 0)
        System.out.println("LinkedList is Empty");
      else if (size == 1)
      {
        head = tail = null;
        size = 0;
      }
      else
      {
        head = head.next;
        size-- ;
      }  
    }
    
    void removeLast()
    {
      if(size == 0)
        System.out.println("LinkedList is Empty");
      else if(size == 1) 
      {
        head = tail = null;
        size = 0;
      }
      else
      {
        Node temp = head;
        for (int i = 0; i < size - 2; i++) 
          temp = temp.next;
        tail = temp;
        tail.next = null;
        size--; 
      } 
    }
    
    void addAt(int val, int idx)
    {
      Node node = new Node();
      node.data = val;
      
      if (idx < 0 || idx > size)
      System.out.println("Invalid Index");
      else if (idx == 0)
        addFirst(val);
      else if (idx == size)
        addLast(val);
      else
      {
        Node temp = head;
        for (int i = 0; i < idx - 1; i++) 
          node = node.next;
        node.next = temp.next;
        temp.next = node;
        size++;   
      }
    }

    void removeAt(int idx)
    {
      if (idx < 0 || idx > size)
        System.out.println("Invalid Index");
      else if (idx == 0)
        removeFirst();
      else if (idx == size - 1)
        removeLast();
      else
      {
        Node temp = head;
        for(int i = 0; i < idx - 1; i++)
          temp = temp.next;
        temp.next = temp.next.next;
        size--;
      }  
    }
  }
  

  public static void main(String[] args)
  {
    System.out.println();
    LinkedList list = new LinkedList();
    System.out.println("Size of linked List: " + list.size()); 
    list.addLast(20);
    list.addLast(30);
    list.addLast(40);
    list.addFirst(10);
    list.display();
    System.out.println("First Value: " + list.getFirst());
    System.out.println("Last Value: " + list.getLast());
    System.out.println("Value at Index 1: " + list.getAt(1));
    list.removeFirst();
    list.removeLast();
    list.addAt(25, 1);
    list.addAt(40, 3);
    list.removeAt(2);
    list.display();
    System.out.println("Size of linked List: " + list.size());
  }
}