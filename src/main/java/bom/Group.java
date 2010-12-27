package bom;

import java.util.List;

public class Group {
	private Doi doi;
	private Xnpl xnpl;
	private Title title;
	private Author author;
	
	private List<Document> groupMembers;

	public Doi getDoi() {
		return doi;
	}

	public void setDoi(Doi doi) {
		this.doi = doi;
	}

	public Xnpl getXnpl() {
		return xnpl;
	}

	public void setXnpl(Xnpl xnpl) {
		this.xnpl = xnpl;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public List<Document> getGroupMembers() {
		return groupMembers;
	}

	public void setGroupMembers(List<Document> groupMembers) {
		this.groupMembers = groupMembers;
	}

	public Group(Doi doi, Xnpl xnpl,  Title title,Author author) {
		this.doi=doi;
		this.xnpl=xnpl;
		this.title=title;
		this.author=author;
	}
	
	public boolean isEmpty() {
		return groupMembers.isEmpty();
	}

}
