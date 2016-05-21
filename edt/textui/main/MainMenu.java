package edt.textui.main;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Menu;
import edt.textui.Editor;

/**
 * Represents the main menu of this application. This is the first menu
 * shown to the users.
 ***/

public class MainMenu extends Menu {

	public MainMenu(Editor edt) {
		super(MenuEntry.TITLE,
			new Command<?>[] { 
				new NewDocument(edt),
				new OpenDocument(edt),
				new SaveDocument(edt),
				new ShowMetadata(edt),
				new AddAuthor(edt),
				new ListTopSections(edt),
				new ShowTextElement(edt),
				new EditSection(edt),
			});
	}
}
