package edt.textui.section;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputInteger;
import edt.textui.section.Message;

import edt.core.Section;

import edt.textui.exception.NoSuchParagraphException;

public class ChangeParagraph extends Command<Section> {

	 /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
     public ChangeParagraph(Section sec) {
        super(MenuEntry.EDIT_PARAGRAPH, sec);
    }
    
    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() throws NoSuchParagraphException{
        Form f = new Form();
        InputInteger id = new InputInteger(f, Message.requestParagraphId());
        InputString content = new InputString(f, Message.requestParagraphContent());
        f.parse();

        try{
            entity().getParagraph(id.value()).setText(content.value());
        }
        catch (NoSuchParagraphException nspe){
            Display display = new Display();
            display.addNewLine (nspe.getMessage());
            display.display();
        }

    }
}
