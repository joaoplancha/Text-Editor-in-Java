package edt.textui.main;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import edt.core.Author;
import edt.textui.Editor;
import edt.textui.main.Message;
import edt.textui.exception.ExistingAuthorException;

/**
 * Command for adding an author to the current document in the editor.
 */
public class AddAuthor extends Command<Editor> {

	/**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public AddAuthor(Editor edt) {
        super(MenuEntry.ADD_AUTHOR, edt);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() throws ExistingAuthorException {
        Form f = new Form();
        InputString name = new InputString(f, Message.requestAuthorName());
        InputString email = new InputString(f, Message.requestEmail());
        f.parse();
        
        
        Author aut = new Author(name.value(), email.value());
        
        try {
            if (entity().getDoc().getAuthors().contains(aut))
                throw new ExistingAuthorException(name.value());
            else 
                entity().getDoc().addAuthor(aut);
        }
        catch(ExistingAuthorException eae) {
            Display display = new Display();
            display.addNewLine (eae.getMessage());
            display.display();
        }


    }


   

}