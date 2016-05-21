package edt.core;

import java.util.ArrayList;
import java.util.List;
import edt.core.Document;

import edt.textui.exception.NoSuchParagraphException;
import edt.textui.exception.NoSuchSectionException;

/**
 * Representa um conteudo do tipo elemento de texto.
 * Esta e uma subclasse da super classe Text Element
 * {@link edt.core.TextElement}, e
 * tem com subclasse a classe Document
 * {@link edt.core.Document},
 * modela os conteudos de texto, operacoes entre 
 * conteudos de Section. Note-se que a superclasse
 * {@link edt.core.TextElement} Text Element, implementa
 * as interfaces Serializable e Dimension. <p>
 *
 * @author Joao, Marco e Vasco.
 * @version $Id: 1.0
 * @see <a href="http://http://docs.oracle.com/javase/7/docs/api/java/io/Serializable.html">Serializable interface</a>
 */

public class Section extends TextElement {
	
	/**
     * Necessario para que se saiba
     * o estado de cada objeto em cada momento
     * que se inicializa a app
     */
    private static final long serialVersionUID = -3978300725323731527L;

    
    /* Titulo do documento. */
    private String			_title;
    
    /* Lista de Subseccoes */
    private List<Section> 	_subSections;
    
    /* Lista de Paragrafos */
    private List<Paragraph> _paragraphs;

    /**
     * Contrutor do documento.
     * Recebe o tiulo do documento.
     * 
     * @param title titulo do documento.
     */
    public Section(String title) {
        this._title         = title;
        this._subSections   = new ArrayList<>();
        this._paragraphs    = new ArrayList<>();

    }
     
    /**
     * Getter do titulo do doc.
     * 
     * @return titulo do documento.
     */
    public String getTitle()  {return _title;}

    /**
     * Dado um idx retorna a seccao pedida.
     * 
     * @param idx inteiro que representa o id da seccao.
     * @return seccao pedida.
     */
    public Section getSection(int idx) throws NoSuchSectionException {
        if(idx >= _subSections.size() || idx < 0)
            throw new NoSuchSectionException(idx);

        return _subSections.get(idx);

    }//Cuidado tem de ser alterado perguntar prof.

    /**
     * Getter da lista de Subseccoes
     * 
     * @return lista de subseccoes.
     */
    public List<Section> getSubsections() {return _subSections;}

    /**
     * Devolve o paragrafo pedido.
     * 
     * @param idx chave do paragrafo.
     * @return paragrafo.
     */
    public Paragraph getParagraph(int idx) throws NoSuchParagraphException {
        if(idx >= _paragraphs.size() || idx < 0)
            throw new NoSuchParagraphException(idx);
        return _paragraphs.get(idx);
    }
    
    /**
     * Devolve lista de paragrafos.
     * 
     * @return paragrafos.
     */
    public List<Paragraph> getParagraphs() {return _paragraphs;}
    
    /**
     * Atribui titulo a seccao.
     * 
     * @param title titulo da seccao.
     */
    public void setTitle(String title) {this._title = title;}



    /***************** OUTROS METODOS **********************/
    
    /**
     * Adiciona uma secao ao final lista de subseccoes.
     * 
     * @param sec Seccao a adicionar.
     */
    public void addSection(Section sec) {
        this._subSections.add(sec);
        sec.setKey("");
    }

  /**
     * Adiciona uma secao a lista de subseccoes.
     * 
     * @param idx chave da seccao.
     * @param sec Seccao a adicionar.
     */
  public void addSection(int idx, Section sec) throws NoSuchSectionException {
    if(idx > _subSections.size() || idx < 0)
        throw new NoSuchSectionException(idx);
    this._subSections.add(idx, sec);
    sec.setKey("");
}

    /**
     * Adiciona um paragrafo ao final da lista de paragrafos.
     * 
     * @param par paragrafo a adicionar.
     */
    public void addParagraph(Paragraph par)  {
        this._paragraphs.add(par);
        par.setKey("");
    }

    /**
     * Adiciona um paragrafo a lista de paragrafos.
     * 
     * @param idx chave do paragrafo.
     * @param par paragrafo a adicionar.
     */
    public void addParagraph(int idx, Paragraph par) throws NoSuchParagraphException {
        if(idx > _paragraphs.size() || idx < 0)
            throw new NoSuchParagraphException(idx);
        this._paragraphs.add(idx, par);
        par.setKey("");
    }

    /**
     * Remove seccao da lista de subseccoes.
     * 
     * @param idx chave do text element.
     * @param doc documento que contem as subseccoes.
     * @return true se a seccao tiver sido removida.
     */
    public boolean removeSection(int idx, Document doc) {
        this._subSections.remove(idx);
        return !doc.getSubsections().contains(idx);
    } // REPOR QUANDO CRIADO - Testar true.

    /**
     * Remove paragrafo da lista de paragrafos.
     * 
     * @param idx chave do text element.
     * @param doc documento que contem os paragrafos.
     * @return true se o paragrafo tiver sido removido.
     */
    public boolean removeParagraph(int idx, Document doc) {
        this._paragraphs.remove(idx);
        return !_paragraphs.contains(idx);
    } // REPOR QUANDO CRIADO - Testar true.



    /*************** METODOS DA CLASSE PAI ******************/

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

    /**
     * Este metodo invoca o metodo
     * {@link #getSize() getSize}. 
     * 
     * @return tamanho da seccao.
     */
    @Override
    public int getDimension() {
        return getContent().length();
    }

    /**
     * to string.
     * 
     * @return titulo da seccao.
     */
    public String toString() {
        return _title;
    }

    @Override
    public String accept(Visitor v) {
        
        return v.visit(this);
    }

}
