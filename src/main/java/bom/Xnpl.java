package bom;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Xnpl {
	private static final boolean tISBN = false;
	private static final boolean tISSN = true;
	
	private String xnpl;
	private boolean type;

	private String ISBN;
	private String ISSN;
	private String V;
	private String N;
	private String P;
	
	
	public String getV() {
		return V;
	}

	public String getN() {
		return N;
	}

	public String getP() {
		return P;
	}


	

	public Xnpl(String xnpl) {
		this.xnpl = xnpl;
/*		String[] aux = xnpl.split("[^-]");
		
		int numberOfDashes = aux.length; //xnpl.replaceAll("[^-]","").length();  
		
		if(numberOfDashes>3){
			this.type=tISBN;
			
			ISBN=aux[0]+"-" + aux[1];
			P=aux[2];
		}
		 else {
			 this.type=tISSN;
			 
			 ISSN=
		 }
*/
		analyze(xnpl);
	}

	public String getXnpl() {
		return xnpl;
	}

	public boolean getType() {
		return type;
	}
	
	
	private static Pattern PATTERN_ISSN_XNPL = Pattern
	.compile("^(\\w{1,4}-\\w{1,4})-(\\w+)-(\\w+)-(\\w+)$");
private static Pattern PATTERN_ISBN_XNPL = Pattern
	.compile("^(97[89]-\\w+-*\\w+-*\\w+-*\\w*-*\\w)-(\\w+)+$"); // detects

// ISBN 13

public void analyze(String xnpl) {
String aux;
aux = xnpl.trim();

Matcher matcher = PATTERN_ISSN_XNPL.matcher(aux);
if (matcher.find()) {
	this.type=tISSN;
	this.ISSN = matcher.group(1);
	this.V = matcher.group(2);
	this.N = matcher.group(3);
	this.P = matcher.group(4);
	//String pIssn = IssnTabcor.e2pIssn(issn);
//	if (pIssn == null)
//			pIssn = issn;
//	xnpl = pIssn + matcher.group(2);
} else {
	matcher = PATTERN_ISBN_XNPL.matcher(aux);
	if (matcher.find()) { // transform ISBN 13 into ISBN 10
		this.type=tISBN;
		this.ISBN=matcher.group(1);
		this.P=matcher.group(2);
			
	}
}

}

}
