package com.mt99.service.process;

import java.util.List;

/**
 *	Interface for processing a list of object T.
 **/
public interface Processable<T> {
	/**	Process a list of object T.
	 *	@param	list	List of object T to be processed
	 *	@return	A new processed list.	**/
	public List<T> process(List<T> list);
}	// interface Processable