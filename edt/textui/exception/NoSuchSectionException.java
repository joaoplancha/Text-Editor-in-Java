package edt.textui.exception;

import pt.utl.ist.po.ui.InvalidOperation;
import edt.textui.section.Message;


public class NoSuchSectionException extends InvalidOperation{

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
	public NoSuchSectionException(int id) {
		super(Message.noSuchSection(id));
	}

}