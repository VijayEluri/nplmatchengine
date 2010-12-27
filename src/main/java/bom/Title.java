package bom;

import java.io.IOException;

import util.Standardizer;

public class Title {
	private String title;
	private String titleCode;

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}
	
	public String getTitleCode() throws IOException {
		if(null==titleCode) return standardize(title); else return titleCode;  
	}

	private String standardize(String title) throws IOException {
		return Standardizer.standardize(title);
	}
	
	
}
