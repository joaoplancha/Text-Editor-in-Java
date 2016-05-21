package edt.core;

import java.io.Serializable;

/**
 * Representa um Autor. Um documento tem uma estrutura
 * interna, correspondente a organizacao do seu conteudo,
 * sendo possivel alterar este conteudo. <p>
 *
 * @author Joao, Marco e Vasco.
 * @version $Id: 1.0
 * @see <a href="http://http://docs.oracle.com/javase/7/docs/api/java/io/Serializable.html">Serializable interface</a>
 */

public class Author implements Comparable<Author>, Serializable{
	
	/******************* ATRIBUTOS ************************/
    private String _name;
    private String _email;
    
    
    public Author(String name, String email) {
       
        this._name   = name;
        this._email  = email;
    }
    
    
    /****************** GETTERS e SETTERS *****************/
    public String getName()             {return _name;}
    
    public String getEmail()            {return _email;}
    
    /**
     * Redefinicao do metodo equals
     */
    public boolean equals(Object obj) {
        if (!(obj instanceof Author))
            return false;
        return true;
        
    }
    
    /**
     * Metodo compare to compara o nome
     * de 2 autores e ordena alfabeticamente.
     * 
     * @param Author aut autor a comparar.
     * @return fazer depois
     */
    @Override
    public int compareTo(Author aut) {
        return _name.compareTo(aut._name);
    }
    
    
}
