/**
 * 
 */
package exception;

/**
 * @author pd51444
 * 
 */
public class DuplicateMemberException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4968622007770625378L;

	/**
	 * 
	 */
	public DuplicateMemberException() {
	}

	/**
	 * @param message
	 */
	public DuplicateMemberException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public DuplicateMemberException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public DuplicateMemberException(String message, Throwable cause) {
		super(message, cause);
	}

}
