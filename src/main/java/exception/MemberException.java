/**
 * 
 */
package exception;

/**
 * @author pd51444
 * 
 */
public class MemberException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4968622007770625378L;

	/**
	 * 
	 */
	public MemberException() {
	}

	/**
	 * @param message
	 */
	public MemberException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public MemberException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public MemberException(String message, Throwable cause) {
		super(message, cause);
	}

}
