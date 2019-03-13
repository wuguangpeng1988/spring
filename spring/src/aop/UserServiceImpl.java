package aop;

public class UserServiceImpl implements UserService {

	@Override
	public void addUser() {
		System.out.println("aaaa");

	}

	@Override
	public void updateUser() {
		System.out.println("bbbbb");

	}

	@Override
	public void deleteUser() {
		System.out.println("cccc");

	}

}
