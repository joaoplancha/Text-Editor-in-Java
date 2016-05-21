package edt.textui.main;

import edt.core.Visitor;
import edt.core.Document;
import edt.core.Section;
import edt.core.Paragraph;

public class ShowContentVisitor implements Visitor {
    @Override
	public String visit(Document doc) {
		
		String content = "{" + doc.getTitle() + "}";
		
		for(Paragraph p: doc.getParagraphs())
			content += "\n" + p.accept(this);
		
		for(Section s: doc.getSubsections())
			content += "\n" + s.accept(this);
		
		return content;
	}

	@Override
	public String visit(Section sec) {
		
		String content = "[" + sec.getKey() + "]" + " " + "{" + sec.getTitle() + "}";
		
		for(Paragraph p: sec.getParagraphs())
			content += "\n" + p.accept(this);
		
		for(Section s: sec.getSubsections())
			content += "\n" + s.accept(this);
			
		
		return content;
	}

	@Override
	public String visit(Paragraph par) {
		return par.getContent();
	}

}