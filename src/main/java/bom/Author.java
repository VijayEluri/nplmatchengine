package bom;

import java.io.IOException;

import java.util.Arrays;

import parser.UseLexi;

import util.Standardizer;

public class Author {
	private String name;
	private String authorCode;

	public Author(String name) {
			setName(name);
	}

	public void setName(String name) {
		this.name = name;
		this.authorCode = getAuthorCode();
	}

	public String getName() {
		return name;
	}
	
	public String getAuthorCode() {
		if(null==authorCode)
			try {
				return standardize(name);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		else return authorCode;
	}

	
	private static String standardize(String name) throws IOException {
		if(null==name) return "";
		
		name = Standardizer.standardize(name);
		
		name = Standardizer.PATTERN_NON_DISPLAYABLE.matcher(name).replaceAll(" ");

		name = UseLexi.parse(name.toUpperCase());
/*		Matcher matcher = Standardizer.PATTERN_NUMERICS.matcher(name);
		StringBuffer number = new StringBuffer("");
		while (matcher.find())
			number.append(matcher.group());

		name = Standardizer.getDoubleMetaphone().encode(name);
		if (name == null)
			name = "";

		String aux= name + number.toString();
*/
		char[] temp = name.toCharArray();
		Arrays.sort(temp);

		return String.valueOf(temp);
	}

	
}
