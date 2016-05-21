package edt.textui.main;

import pt.utl.ist.po.ui.Command;
import edt.textui.Editor;
import edt.textui.section.EditMenu;


/**
 * Command for editing the current document in the editor.
 */
public class EditSection extends Command<Editor> {

	/**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public EditSection(Editor edt) {
        super(MenuEntry.OPEN_DOCUMENT_EDITOR, edt);
    }
    
    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        EditMenu editmenu = new EditMenu(entity().getDoc(), entity().getDoc());
        editmenu.open();
        
    }
}

