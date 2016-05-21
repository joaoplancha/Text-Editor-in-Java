package edt.textui.section;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;
import edt.textui.section.Message;

import edt.core.Section;
import edt.core.Document;

import edt.textui.exception.NoSuchSectionException;


/**
 * Command for removing a subsection of the current section.
 */
public class RemoveSection extends Command<Section> {
    private Document _doc;
    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public RemoveSection(Document doc, Section sec) {
        super(MenuEntry.REMOVE_SECTION, sec);
        this._doc = doc;
    }
 
    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() throws NoSuchSectionException{
        Form f = new Form();
        InputInteger id = new InputInteger(f, Message.requestSectionId());    
        f.parse();
        
        try{
            _doc.removeFromIndex(entity().getSection(id.value()));
            entity().removeSection(id.value(), _doc);
        }
        catch (NoSuchSectionException e) {
            //nothing to do here...
        }



    }
}