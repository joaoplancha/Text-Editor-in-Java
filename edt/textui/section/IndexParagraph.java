package edt.textui.section;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputInteger;
import edt.textui.section.Message;

import edt.core.Section;
import edt.core.Document;

import edt.textui.exception.NoSuchParagraphException;

/**
 * Command for indexing a paragraph (nomear um paragrafo 2.2.9) of the current section.
 */
public class IndexParagraph extends Command<Section> {

    private Document _doc;
   
    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public IndexParagraph(Document doc, Section sec) {
        super(MenuEntry.NAME_PARAGRAPH, sec);
        this._doc = doc;
    }
    
    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() throws NoSuchParagraphException {

        Form f = new Form();
        InputInteger id = new InputInteger(f, Message.requestParagraphId());
        InputString uid = new InputString(f, Message.requestUniqueId());
        f.parse();

        Display display = new Display();

        try {
            if (_doc.getElements().containsValue(entity().getParagraph(id.value()))) {
                _doc.indexElement(uid.value(), entity().getParagraph(id.value()));
                display.addNewLine(Message.paragraphNameChanged());
            }
            _doc.indexElement(uid.value(), entity().getParagraph(id.value()));
        }
        catch (NoSuchParagraphException nspe) {
            display.addNewLine(nspe.getMessage());
        }
        finally {
            display.display();
        }
    }
}