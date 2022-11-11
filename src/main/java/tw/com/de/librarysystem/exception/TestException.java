package tw.com.de.librarysystem.exception;

public class TestException extends Exception {
	private static final long serialVersionUID = 1L;
//	System.err.println("error!!! what's happen!!!!");
	private String m = null;
	public TestException() {
		super();
	}
	public TestException(String m) {
		this.m = m;
	}
	
	public TestException(Throwable cace) {
		super(cace);//把bug狀況用父類的例外類別去執行
	}
	
	
	@Override
	public String toString() {
		return m;
	}
	@Override
	public String getMessage() {
		return m;
	}
	
}
