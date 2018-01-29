package main;


/**
 * Created by Alex Gao
 * 01/29/2018
 **/

import java.util.Iterator;

public class FilteringIterator implements Iterator<Object> {
    private final Iterator<Object> iterator;
    private final IObjectTest iot;
    private Object next;
    
    public FilteringIterator(Iterator<Object> iterator, IObjectTest predicate) {
        this.iterator = iterator;
        this.iot = predicate;
    }

    @Override
    public boolean hasNext() {
        while (next == null && iterator.hasNext()) {
            next = iterator.next();
            if (iot.test(next))
                return true;
            next = null;
        }
        return next != null;
    }

    @Override
    public Object next() {
        if (next == null)
            hasNext();
        try {
            return next;
        } finally {
            next = null;
            hasNext();
        }
    }

    @Override
    public void remove() {
    		iterator.remove();
    }
}