package edt.textui.section;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputInteger;
import edt.textui.section.Message;

import edt.core.Section;
import edt.core.Paragraph;

import edt.textui.exception.NoSuchParagraphException;
/**
 * Command for adding a paragraph to the current section.
 */
public class InsertParagraph extends Command<Section> {
   
    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public InsertParagraph(Section sec) {
        super(MenuEntry.INSERT_PARAGRAPH, sec);
    }
    
    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() throws NoSuchParagraphException{
        Form f = new Form();
        InputInteger id = new InputInteger(f, Message.requestParagraphId());
        InputString content = new InputString(f, Message.requestParagraphContent());
        f.parse();

        Paragraph par = new Paragraph(content.value());
        try {
            entity().addParagraph(id.value(),par);
        }
        catch (NoSuchParagraphException nspe) {
            entity().addParagraph(par);
        }
    }
}