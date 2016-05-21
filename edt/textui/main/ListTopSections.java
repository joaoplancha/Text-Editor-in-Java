package edt.textui.main;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import edt.core.Section;
import edt.textui.Editor;


/**
 * Command for showing the top sections of the current document in the editor.
 */
public class ListTopSections extends Command<Editor> {

	 /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
     public ListTopSections(Editor edt) {
        super(MenuEntry.SHOW_INDEX, edt);
    }
    
    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
      
        Display display = new Display();
        
        display.addNewLine("{" + this.entity().getDoc().getTitle() + "}");

        for(Section subsec: entity().getDoc().getSubsections()){
            display.addNewLine(Message.sectionIndexEntry(subsec.getKey(),subsec.toString()));
        }
        
        display.display();
        
    }
}
