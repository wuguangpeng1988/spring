package aop1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import aop1.Logger.Level;

public class DynaProxyHello implements InvocationHandler {

	private Object delegate;
	private Object proxy;
	// public Object bind(Object delegate) {
	// this.delegate = delegate;
	// return Proxy.newProxyInstance(this.delegate.getClass().getClassLoader(),
	// this.delegate.getClass().getInterfaces(), this);
	// }

	public Object bind(Object delegate, Object proxy) {

		this.proxy = proxy;
		this.delegate = delegate;
		return Proxy.newProxyInstance(this.delegate.getClass().getClassLoader(),
				this.delegate.getClass().getInterfaces(), this);
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;
		try {
			// // 执行原来的方法之前记录日志
			// Logger.logging(Level.DEBUGE, method.getName() + " Method end .");
			//
			// // JVM通过这条语句执行原来的方法(反射机制)
			// result = method.invoke(this.delegate, args);
			// // 执行原来的方法之后记录日志
			// Logger.logging(Level.INFO, method.getName() + " Method Start!");
			// 反射得到操作者的实例
			Class clazz = this.proxy.getClass();
			// 反射得到操作者的Start方法
			Method start = clazz.getDeclaredMethod("start", new Class[] { Method.class });
			// 反射执行start方法
			start.invoke(this.proxy, new Object[] { method });
			// 执行要处理对象的原本方法
			result = method.invoke(this.delegate, args);
			// 反射得到操作者的end方法
			Method end = clazz.getDeclaredMethod("end", new Class[] { Method.class });
			// 反射执行end方法
			end.invoke(this.proxy, new Object[] { method });
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 返回方法返回值给调用者
		return result;
	}

}
