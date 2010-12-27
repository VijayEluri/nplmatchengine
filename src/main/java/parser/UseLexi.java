package parser;

import java.io.IOException;

public class UseLexi {
	static Lexi lexi = null;

	public static String parse(String str) throws IOException {
		StringBuilder aux = new StringBuilder();
		Yytoken token = null;
		lexi = new Lexi(new java.io.StringReader(str));
		// lexi.yyreset(reader) // TODO reset the reader without recreating lexi
		token = lexi.yylex();
		while (token != null) {
			aux.append(token);
			token = lexi.yylex();
		}

		return aux.toString();
	}

}
