package edt.core;

/**
 * Representa um conteudo do tipo elemento de texto.
 * Esta e uma subclasse da super classe Text Element
 * {@link edt.core.TextElement}, e
 * modela os conteudos de texto, operacoes entre 
 * conteudos de paragrafos. <p>
 *
 * @author Grupo 83 - Joao, Marco e Vasco.
 * @version $Id: 1.0
 * @see <a href="http://http://docs.oracle.com/javase/7/docs/api/java/io/Serializable.html">Serializable interface</a>
 */

public class Paragraph extends TextElement {
	
	/**
     * Necessario para que se saiba
     * o estado de cada objeto em cada momento
     * que se inicializa a app
     */
    private static final long serialVersionUID = -1004470134613332869L;
    
    /******************* ATRIBUTOS ************************/
    private String _text;
    
    
    /****************** CONSTRUTOR ***********************/
    public Paragraph(String content) {
       
        this._text = content;
    }
    
    
    /*************** GETTERS e SETTERS **********************/
    public void setText(String text) {
        this._text = text;
    }
    
    
    /*************** METODOS DA CLASSE PAI ******************/
    
    /**
     * Getter do conteudo do Paragrafo.
     * 
     * @return String conteudo do paragrafo.
     */
    @Override
    public String getContent() {return _text;}
    
    /**
     * Metodo To String retorna o texto
     * do paragrafo sob forma de string.
     */
    public String toString() {
        return _text.toString();
    }
    
    
    @Override
    public int getDimension() {
        return getContent().length();
    }

    @Override
    public String accept(Visitor v) {
        
        return v.visit(this);
    }

}
