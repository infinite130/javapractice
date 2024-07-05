class AAA {
	public void aa() throws Exception {
		BBB b = new BBB();
		b.bb();
	}
}

class BBB {
	public void bb() throws Exception {
		CCC c = new CCC();
		c.cc();
	}
}

class CCC {
	public void cc() throws Exception {
			throw new Exception();
	}
}



public class Throw {

	public static void main(String[] args) throws Exception {
		
		AAA a = new AAA();
		a.aa();

	}

}
