package test;

public class Test {
	public static int n=1;
	static{
			n=10;
	}
	
	public static int get(){ return n;};
	public static void main(String[] args) {
		
		System.out.println(Test.get());
	}

}
