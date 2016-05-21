package edt.core;

import java.io.Serializable;;



/**
 * Representa um conteudo do tipo elemento de texto.
 * Esta superclasse abestracta tem como subclasses:
 * {@link edt.core.Section},
 * {@link edt.core.Document},
 * {@link edt.core.Paragraph} e
 * modela os conteudos de texto, operacoes entre 
 * conteudos de Elementos de texto. <p>
 *
 * @author Joao, Marco e Vasco.
 * @version $Id: 1.0
 * @see <a href="http://http://docs.oracle.com/javase/7/docs/api/java/io/Serializable.html">Serializable interface</a>
 */

public abstract class TextElement implements Dimension, Serializable {
	
	 /**
     * Necessario para que se saiba
     * o estado de cada objeto em cada momento
     * que se inicializa a app
     */
     private static final long serialVersionUID = 7013396300438873511L;
     
     /******************* ATRIBUTOS ************************/
    private String _key;        // Chave do text element
    
    
    /******************* CONSTRUTORES *********************/
    public TextElement() {
        this._key = "";       
    }
    
    
    /***************** OUTROS METODOS **********************/
    
    //mudei para public para poder chamar o metodo em IndexSection e IndexParagraph
    public boolean isIndexed() {
        return !_key.equals("");
    }
    
    
    /****************** GETTERS e SETTERS *****************/
    public String getKey() {return _key;}
    
    public String setKey(String id) {return this._key = id;}
    
    public abstract String getContent() ;
    
    public abstract String accept(Visitor v);
    
}
