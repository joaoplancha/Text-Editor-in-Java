package edt.textui.main;

import pt.utl.ist.po.ui.Command;
import edt.textui.Editor;

/**
 * Command for creating a new document in the editor.
 */
public class NewDocument extends Command<Editor> {

	/**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public NewDocument(Editor edt) {
        super(MenuEntry.NEW, edt);
    }
    
    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        this.entity().createDocument();
    }
}
