package edt.core;

public interface Visitor {
	
	public String visit(Document d);
	
	public String visit(Section s);
	
	public String visit(Paragraph p);

}