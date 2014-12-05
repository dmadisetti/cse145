/**
* @author  Dylan Madisetti
* @version 1.0, Dec 5, 2014
* @source  https://github.com/dmadisetti/cse145
* @website http://dylanmadisetti.com
*/

import java.util.ArrayList;
public class GenericStack<T>{

	private StackNode last = null;
	private class StackNode{
		public T value;
		private StackNode prev;
		public StackNode(T val, StackNode p){
			value = val;
			prev = p;
		}
		public StackNode getPrev(){
			return prev;
		}
	}
	public GenericStack(){}

	public void push(T value){
		last = new StackNode(value, last);
	}

	public T pop(){
		if(!canPop()){
			System.out.println("Stack is empty");
			return null;
		}
		T value = last.value;
		last = last.getPrev();
		return value;
	}

	public boolean canPop(){
		return last != null;
	}

	public void printStack(){
		StackNode current = last;
		while(current != null){
			System.out.println(current.value);
			current = current.getPrev();
		}
	}

	public void addArrayList(ArrayList<T> list){
		for (T value : list) {
			push(value);
		}
	}
}
