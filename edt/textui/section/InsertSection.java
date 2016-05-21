package edt.textui.section;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputInteger;
import edt.textui.section.Message;

import edt.core.Section;

import edt.textui.exception.NoSuchSectionException;

public class InsertSection extends Command<Section> {
	 
    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public InsertSection(Section sec) {
        super(MenuEntry.INSERT_SECTION, sec);
    }
 
    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() throws NoSuchSectionException{
        Form f = new Form();
        InputInteger id = new InputInteger(f, Message.requestSectionId());
        InputString title = new InputString(f, Message.requestSectionTitle());
        f.parse();
        
        Section section = new Section(title.value());
        try {
            entity().addSection(id.value(),section);
        }
        catch (NoSuchSectionException nsse) {
            entity().addSection(section);
        }

    }
}
