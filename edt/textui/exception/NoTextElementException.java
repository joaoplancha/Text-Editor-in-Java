package edt.textui.exception;

import pt.utl.ist.po.ui.InvalidOperation;
import edt.textui.main.Message;


public class NoTextElementException extends InvalidOperation{

	/**
	 * Serial number.
	 */
	private static final long serialVersionUID = -8217117068709156897L;
	
	/**
	 * Construtor passa a excepcao para
	 * a classe pai InvalidOperation.
	 * 
	 * @param id
	 */
	public NoTextElementException(String id) {
		super(Message.noSuchTextElement(id));
	}

}