package edt.textui;

import static pt.utl.ist.po.ui.UserInteraction.IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import pt.utl.ist.po.ui.Menu;
import edt.core.Document;
import edt.textui.main.MainMenu;
import edt.utils.Parser;

public class Editor {

	private Document    _doc;
	private Parser      _par;

	public Editor() {
		this._par = new Parser();
		createDocument();
	}

	/**
	 * Metodo que cria um novo documento.
	 */
	public void createDocument() {
		this._doc = new Document("", "");
	}

	/**
	 * Le o documento.
	 * 
	 * @param filename
	 * @throws IOException
	 */
	public void loadDocument (String filename) throws IOException{
		_doc = _par.parse(filename);	
			
	}

	/**
	 * Metodo que escreve os dados dos objetos doc num ficheiro.
	 * 
	 * @param filename nome do ficheiro onde esta o objeto serializado.
	 * @throws IOException
	 */
	public void save(String filename) throws IOException {

		this._doc.setFilename(filename);

		FileOutputStream fos = new FileOutputStream(filename);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(_doc);

		oos.close();
	}
	

	/**
	 * Metodo que le os dados do ficheiro selecionado pelo utilizador e 
	 * serializa o objecto.
	 * 
	 * @param filename
	 * @throws IOException
	 */
	public void load(String filename) throws IOException {

		FileInputStream fis = new FileInputStream(filename);
		ObjectInputStream ois = new ObjectInputStream(fis);

		try {
			this._doc = (Document)ois.readObject();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		ois.close();
	}

	public Document getDoc() {
		return _doc;
	}

	public void setDoc(Document doc) {
		this._doc = doc;
	}


	
	/**
	 * Main
	 * @param args
	 */
	public static void main(String[] args) {


		Editor edt = new Editor();

		/* Read an Import file, if any */
		String filename = System.getProperty("import");
		
		if (filename != null)
		{
			try {
				edt.loadDocument(filename);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		

		/* Start the user interface with the Editor instance */
		Menu m = new MainMenu(edt);
		m.open();

		IO.close();

	}
	
	


}
