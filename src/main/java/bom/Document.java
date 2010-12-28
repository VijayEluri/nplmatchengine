package bom;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Document {
	private int supplierId;
	private String an;
	private Doi doi;
	private Xnpl xnpl;
	private Author author;
	private Title title;
	private HashMap matchElements;
	
	public Document(int supplierId, String an, String doi, String xnpl, String author, String title) throws IOException {
		matchElements = new HashMap();
		
		this.supplierId=supplierId;
		this.an=an;

		if(null!=doi) {
			this.doi=new Doi(doi);
			matchElements.put(99, doi);
		} else {
			this.xnpl=new Xnpl(xnpl);
			this.title=new Title(title);
			this.author=new Author(author);
		}
		
		
	}
	
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public String getAn() {
		return an;
	}
	public void setAn(String an) {
		this.an = an;
	}
	public void setDoi(Doi doi) {
		this.doi = doi;
	}
	public Doi getDoi() {
		return doi;
	}
	public void setXnpl(Xnpl xnpl) {
		this.xnpl = xnpl;
	}
	public Xnpl getXnpl() {
		return xnpl;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public Author getAuthor() {
		return author;
	}
	public void setTitle(Title title) {
		this.title = title;
	}
	public Title getTitle() {
		return title;
	}

	
	
}
