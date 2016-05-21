package edt.textui.main;

import java.io.IOException;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;
import edt.textui.Editor;

/**
 * Command for saving the current document in the editor.
 */
public class SaveDocument extends Command<Editor> {

	/**
     * Constructor.
     * 
     * @param ent the target entity.
     */
  public SaveDocument(Editor edt) {
    super(MenuEntry.SAVE, edt);
  }
  
    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() throws InvalidOperation {
     
      if (entity().getDoc().getFilename() == "") {
       
       
        Form f = new Form(title());
        InputString filename = new InputString(f, Message.newSaveAs());
        f.parse();
        
        try {
          entity().save(filename.value());
          
        } catch (IOException e) {
          
          e.printStackTrace();
        }
      } else {
        
       try {
         entity().save(entity().getDoc().getFilename());
       } catch (IOException e) {
         
         e.printStackTrace();
       }
     }
   }
   
 }
