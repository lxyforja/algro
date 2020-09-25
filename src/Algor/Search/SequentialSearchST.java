package Algor.Search;

import java.util.LinkedList;
import java.util.Queue;

//无序数组的顺序查找
public class SequentialSearchST<Key,Value> {
    private Node first;
    private int N;
    private class Node
    {
        Key key;
        Value val;
        Node next;
        public  Node(Key key,Value val,Node next)
        {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public int size()
    {
        return N;
    }
    public boolean isEmpty()
    {
        return size() == 0;
    }
    public boolean contains(Key key)
    {
        return get(key) != null;
    }
    public Value get(Key key)
    {
        for(Node x = first;x!=null;x=x.next)
            if(key.equals(x.key))
                return x.val;
            return null;
    }

    public void put(Key key,Value val)
    {
        for(Node x = first;x!=null;x= x.next)
            if(key.equals(x.key))
            {
                x.val = val;
                return;
            }
        first = new Node(key,val,first);
    }

    public Iterable<Key> keys()
    {
        Queue<Key> queue = new LinkedList<Key>();
        for(Node x = first; x != null;x = x.next)
            queue.add(x.key);
        return queue;
    }

    public void delete(Key key)
    {
        first = delete(first,key);
    }
    public Node delete(Node x,  Key key)
    {
        if(x == null) return null;
        if(key.equals(x.key))
        {
            N--;
            return x.next;
        }
        x.next = delete(x.next,key);
        return x;
    }
}
