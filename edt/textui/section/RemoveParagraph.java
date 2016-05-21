package edt.textui.section;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;
import edt.textui.section.Message;

import edt.core.Section;
import edt.core.Document;

import edt.textui.exception.NoSuchParagraphException;
/**
 * Command for removing a paragraph of the current section.
 */
public class RemoveParagraph extends Command<Section> {
    private Document _doc;
    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public RemoveParagraph(Document doc, Section sec) {
        super(MenuEntry.REMOVE_PARAGRAPH, sec);
        this._doc = doc;
    }
 
    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() throws NoSuchParagraphException{
        Form f = new Form();
        InputInteger id = new InputInteger(f, Message.requestParagraphId());    
        f.parse();
        
        try{
            _doc.removeFromIndex(entity().getParagraph(id.value()));
            entity().removeParagraph(id.value(), _doc);
        }
        catch (NoSuchParagraphException nspe) {
            Display display = new Display();
            display.addNewLine(nspe.getMessage());
            display.display();
       }
  
    }
}