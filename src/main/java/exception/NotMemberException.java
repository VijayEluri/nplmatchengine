/**
 * 
 */
package exception;

/**
 * @author pd51444
 * 
 */
public class NotMemberException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6699709694943342989L;

	/**
	 * 
	 */
	public NotMemberException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public NotMemberException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public NotMemberException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public NotMemberException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

}
