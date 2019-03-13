package aop1;

public class test {
	public static void main(String[] args) {
		IHello hello = (IHello) new DynaProxyHello().bind(new Hello(),new LoggerOperation());
		hello.sayGoogBye("Double J");
		hello.sayHello("Double J");

	}
}
