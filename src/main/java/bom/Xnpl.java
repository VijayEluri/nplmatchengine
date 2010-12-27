package bom;

public class Xnpl {
	private static final char ISBN = 0;
	private static final char ISSN = 1;
	
	private String xnpl;
	private char type;

	public void setXnpl(String xnpl) {
		this.xnpl = xnpl;
		int numberOfDashes = xnpl.replaceAll("-","").length();
		
		if(numberOfDashes==1) this.type=ISBN; else this.type=ISSN;
	}

	public String getXnpl() {
		return xnpl;
	}

	public char getType() {
		return type;
	}
	
}
