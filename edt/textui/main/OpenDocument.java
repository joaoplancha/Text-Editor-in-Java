package edt.textui.main;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;
import pt.utl.ist.po.ui.Display;

import edt.textui.Editor;

/**
 * Command for opening an existing document in the editor.
 */
public class OpenDocument extends Command<Editor> {

	/**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public OpenDocument(Editor edt) {
        super(MenuEntry.OPEN, edt);
    }
    
    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() throws InvalidOperation {
        Form f = new Form(title());
        InputString filename = new InputString(f, Message.openFile());
        f.parse();
        Display display = new Display();
        
        try {
            entity().load(filename.value());
            entity().getDoc().setFilename(filename.value());
            
        } catch (Exception e) {
            display.addNewLine(Message.fileNotFound(filename.value()));
            display.display();
        }
    }
}
