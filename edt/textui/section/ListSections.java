package edt.textui.section;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import edt.core.Section;

/**
 * Command for listing all subsections of the current section.
 */
public class ListSections extends Command<Section> {
 
    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public ListSections(Section sec) {
        super(MenuEntry.LIST_SECTIONS, sec);
    }
 
    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        
        Display display = new Display();
            for(Section s: entity().getSubsections())
                display.addNewLine(s.accept(new ListSectionVisitor()));
            display.display();

    }
    
}