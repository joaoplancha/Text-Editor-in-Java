package edt.textui.section;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;
import edt.textui.section.Message;

import edt.core.Section;
import edt.core.Document;

import edt.textui.exception.NoSuchSectionException;
/**
 * Command for selecting a subsection of the current section and edit it.
 */
public class SelectSection extends Command<Section> {
 
    private Document _doc;

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public SelectSection(Document doc, Section sec) {
        super(MenuEntry.SELECT_SECTION, sec);
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
        f.parse();

        Display display = new Display ();

        try {
            entity().getSection(id.value());
            display.addNewLine(Message.newActiveSection(id.value()));
            display.display();
            EditMenu editmenu = new EditMenu(_doc, entity().getSection(id.value()));
            editmenu.open();
        }
        catch (NoSuchSectionException nsse) {
            display.addNewLine(nsse.getMessage());
            display.display();
        }

    }
}