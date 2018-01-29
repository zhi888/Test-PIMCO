package test;


/**
 * Alex Gao
 * 01/29/2018
 * */

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;

import main.FilteringIterator;

public class UnitTest1 {	
	
// get the numbers which are even
@Test
public void test1() {
	List<Object> list = new ArrayList<>();
	list.add(1);
	list.add(2);
	list.add(3);
	list.add(4);
	list.add(5);
	list.add(6);
	list.add(7);
	list.add(8);
	
	
	Iterator<Object> newIterator = list.iterator();
	
	FilteringIterator fi = new FilteringIterator(newIterator, i -> (Integer)i%2==0 );
	assertEquals(fi.next(),2);
	assertEquals(fi.next(),4);
	assertEquals(fi.next(),6);
	assertEquals(fi.next(),8);
	
}
	
}
