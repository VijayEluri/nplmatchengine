package bom;

import java.io.IOException;



public class Author {
	private String name;
	private String authorCode;

	public Author(String name) throws IOException {
			setName(name);
			authorCode=name;
	}

	public void setName(String name) {
		this.name = name;
		this.authorCode = getAuthorCode();
	}

	public String getName() {
		return name;
	}
	
	public String getAuthorCode() {
		return authorCode;
	}


	
}
