package edt.textui.main;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import edt.textui.main.Message;
import edt.textui.Editor;

import edt.textui.exception.NoTextElementException;


/**
 * Command for showing the text element with a given identifier of the current document in the editor.
 */
public class ShowTextElement extends Command<Editor> {
   
    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public ShowTextElement(Editor edt) {
        super(MenuEntry.SHOW_TEXT_ELEMENT, edt);
    }
    
    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() throws NoTextElementException{
    
        Form f = new Form();
        InputString id = new InputString(f, Message.requestElementId());
        f.parse();
        Display display = new Display();

        try{
            display.addNewLine(entity().getDoc().getTextElement(id.value()).accept(new ShowContentVisitor()));
        }
        catch (Exception ntee) {
            display.addNewLine(ntee.getMessage());
        }
        finally {
            display.display();
        }


    }
}