package parser;

/** A single scanner token. */
public class Yytoken {
	public boolean is_separator = false;
	public boolean is_int = false;
	public boolean is_token = false;

	public char separator;
	public String token = null;
	public int value = 0;

	/** Default for range separator. */
	public Yytoken(char c) {
		is_separator = true;
		separator = c;
	}

	public Yytoken(int value) {
		is_int = true;
		this.value = value;
	}

	public Yytoken(String token) {
		is_token = true;
		this.token = token;
	}

	@Override
	public String toString() {
		return token;
	}
}
