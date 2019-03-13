package aop1;

import java.lang.reflect.Method;

import aop1.Logger.Level;

public class LoggerOperation implements IOperation {

	public void end(Method method) {
		Logger.logging(Level.DEBUGE, method.getName() + " Method end .");
	}

	public void start(Method method) {
		Logger.logging(Level.INFO, method.getName() + " Method Start!");
	}

}
