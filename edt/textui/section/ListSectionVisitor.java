package edt.textui.section;

import edt.core.Visitor;
import edt.core.Document;
import edt.core.Section;
import edt.core.Paragraph;

public class ListSectionVisitor implements Visitor {

	@Override
	public String visit(Document doc) {
		
		String content = "{" + doc.getTitle() + "}";
		content += doc.getContent();
		
		return content;
	}

	@Override
	public String visit(Section sec) {
		
		String content = "[" + sec.getKey() + "]" + " " + "{" + sec.getTitle() + "}";
		for(Section s: sec.getSubsections())
			content += "\n" + s.accept(this);
		
		return content;
	}

	@Override
	public String visit(Paragraph par) {
		return par.getContent();
	}
}