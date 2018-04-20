package bom;

import java.io.IOException;



public class Title {
	private String title;
	private String titleCode;
	private String titleCodeTest;

	public Title(String title) throws IOException {
		this.title=title;
		this.titleCode=title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}
	
	public String getTitleCode() {
		return titleCode;  
	}
	
	
}
