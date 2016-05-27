package adapter;

import java.util.Enumeration;
import java.util.Iterator;

public class EnumerationIterator implements Iterator {
	Enumeration enums;
	public EnumerationIterator(Enumeration enums){
		this.enums  = enums;
	}
	
	public boolean hasNext(){
		return enums.hasMoreElements();
	}
	
	public Object next(){
		return enums.nextElement();
	}
	public void remove(){
		throw new UnsupportedOperationException();
	}
}
