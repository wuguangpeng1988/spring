package spring;

public class Chinese implements Person {

	private Axe axe;

	public void setAxe(Axe axe) {
		this.axe = axe;
	}

	public void useAxe() {
		System.out.println("�Ҵ���ȥ������");
		System.out.println(axe.chop());
	}

}
