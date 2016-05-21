package edt.textui.section;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputInteger;
import edt.textui.section.Message;

import edt.core.Section;
import edt.core.Document;

import edt.textui.exception.NoSuchSectionException;


/**
 * Command for indexing ia subsection (nomear seccao 2.2.6) the current section .
 */
public class IndexSection extends Command<Section> {
   private Document _doc;
    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public IndexSection(Document doc, Section sec) {
        super(MenuEntry.NAME_SECTION, sec);
        this._doc = doc;

    }
    
    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() throws NoSuchSectionException {

        Form f = new Form();
        InputInteger id = new InputInteger(f, Message.requestSectionId());
        InputString uid = new InputString(f, Message.requestUniqueId());
        f.parse();

        Display display = new Display();

        try {
            if (_doc.getElements().containsValue(entity().getSection(id.value()))){
                _doc.indexElement(uid.value(), entity().getSection(id.value()));
                display.addNewLine(Message.sectionNameChanged());
            }
            _doc.indexElement(uid.value(), entity().getSection(id.value()));
            

        }
        catch (NoSuchSectionException nsse) {
            display.addNewLine(nsse.getMessage());
        }
        finally {
            display.display();
        }
        
    }
}