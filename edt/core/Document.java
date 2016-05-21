package edt.core;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import edt.textui.exception.NoTextElementException;


/**
 * Representa um Documento. Um documento tem uma estrutura
 * interna, correspondente a organizacao do seu conteudo,
 * sendo possivel alterar este conteudo. <p>
 *
 * @author Joao, Marco e Vasco.
 * @version $Id: 1.0
 * @see <a href="http://http://docs.oracle.com/javase/7/docs/api/java/io/Serializable.html">Serializable interface</a>
 */

public class Document extends Section implements Dimension, Serializable {

	/**
     * Necessario para que se saiba
     * o estado de cada objeto em cada momento
     * que se inicializa a app
     */
	private static final long serialVersionUID = -8792036648944805378L;

	/******************* ATRIBUTOS ************************/
    private String                    _filename;
    private Map<String, TextElement>  _elements;
    private Set<Author>               _writers;

    
    
    /******************* CONSTRUTOR ***********************/
    public Document(String title, String filename) {
        super(title);
        
        this._filename  = filename;
        this._elements  = new TreeMap<>();
        this._writers   = new TreeSet<>();
    }
    
    
    /***************** OUTROS METODOS **********************/
    public void removeFromIndex(TextElement ele) {
        this._elements.remove(ele.getKey());
    }
    
    public void addAuthor(Author aut) {
        this._writers.add(aut);
    }
    
    
    /* Tenho de ler o projeto este metodo nao faz sentido mas nao apagar porque criei um
     * construtor especial que recebe um id - perguntar prof
     */
    public void indexElement(String id, TextElement ele) {
        //Se ja existir a key, tem que ser removida do mapa e posta a "" na key do TextElement
        if(this._elements.containsKey(id)) {
            _elements.get(id).setKey("");
            this._elements.remove(id);
        }
        //E atribuido o uid ao elemento ele
        if(ele.isIndexed())
            this._elements.remove(ele.getKey());
        ele.setKey(id);
        this._elements.put(id, ele);
        ele.setKey(id);
        
    }
    
    
    /****************** GETTERS e SETTERS *****************/
    public String getHeadLine()                         {return this.getTitle();}
    
    public String getFilename()                         {return _filename;}
    
    public TextElement getTextElement(String id)  throws NoTextElementException {
        if (!_elements.containsKey(id))
            throw new NoTextElementException(id);

        return _elements.get(id);
    }
    
    public Map<String, TextElement> getElements()       {return _elements;}
    
    public Set<Author> getAuthors()                     {return _writers;}
    
    public void setFilename(String filename)            {this._filename = filename;}
    
    
    public String getContent() {
        
        String content = getTitle();

        for(Paragraph p: getParagraphs()) { 
            content += p.getContent();
        }

        for(Section s: getSubsections()) {
            content += s.getContent();
        }

        return content;
    }

    @Override
    public String accept(Visitor v) {
        
        return v.visit(this);
    }

   
    public String toString() {
        return _elements.get(0).toString();
    }
}
