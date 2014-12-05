import java.util.*;
public class GenericStackDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GenericStack<String> stack = new GenericStack<String>();
		stack.push("1");
		stack.push("2");
		stack.push("3");
		stack.push("4");
		System.out.println("Print test");
		stack.printStack();
		System.out.println("Pop test");
		PopAll(stack);
		System.out.println("Add Array List Test.  If success it should print \"This will be reversed \" in reverse");
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("This");
		arrayList.add("will");
		arrayList.add("be");
		arrayList.add("reversed");
		stack.addArrayList(arrayList);
		PopAll(stack);
	}
	public static void PopAll(GenericStack aStack)
	{
		while(aStack.canPop())
		{
			System.out.println(aStack.pop());
		}
	}
}
