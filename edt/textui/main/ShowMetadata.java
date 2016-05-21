package edt.textui.main;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import edt.core.Author;
import edt.core.TextElement;
import edt.textui.Editor;

/**
 * Command for showing the metadata of the current document in the editor.
 */
public class ShowMetadata extends Command<Editor> {

	/**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public ShowMetadata(Editor edt) {
        super(MenuEntry.SHOW_METADATA, edt);
    }
    
    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
      
        Display display = new Display();
        
        /* Apresentacao da funcionalidade: Show Metadata */
        display.addNewLine(Message.documentTitle(this.entity().getDoc().getTitle()));
        getAuthors(display);
        display.addNewLine(Message.documentSections(this.entity().getDoc().getSubsections().size()));
        display.addNewLine(Message.documentBytes(this.entity().getDoc().getDimension()));
        display.addNewLine(Message.documentIdentifiers(getElements()));
        
        display.display();
        
    }
    
    /**
     * Metodo auxiliar que imprime os autores
     * na forma establecida.
     * 
     * @param display.
     */
    private void getAuthors(Display disp) {
      
        Set<Author> _writers = this.entity().getDoc().getAuthors();
        Iterator<Author> iterator = _writers.iterator();
        Author aut = null;
        
        while(iterator.hasNext()) {
         aut = iterator.next();
         disp.addNewLine(Message.author(aut.getName(),aut.getEmail()));
         
     }
 }
 
    /**
     * Metodo auxiliar que conta o numero
     * de elementos com key diferente de null.
     * 
     * @return numero de elementos.
     */
    private int getElements() {
      
        Map<String, TextElement> elements = this.entity().getDoc().getElements();
        
        int counter = 0;
        for ( Map.Entry<String, TextElement> entry: elements.entrySet() ) {
            if(entry.getKey() != null)
                counter++;
        }
        
        return counter;
    }
    
}
