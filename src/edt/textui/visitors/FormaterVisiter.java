package edt.textui.visitors;

import edt.core.Visitor;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class FormaterVisiter implements Visitor {
	
	protected List<String> _content;

	public FormaterVisiter(){
		this._content = new LinkedList<>();
	}

	public List<String> getLines(){
		return _content;
	}

}