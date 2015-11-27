package edt.textui.visitors;

import edt.core.*;
import edt.textui.main.Message;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListSectionsVisitor extends FormaterVisiter {

	@Override
	public void visit(Document document) {
	}

	@Override
	public void visit(Author author) {
	}

	@Override
	public void visit(TextElement element) {
	}

	@Override
	public void visit(Section section) {
		if(section.hasId()){
			_content.add(Message.sectionIndexEntry(section.getId(),section.getTitle()));
		}
		else
	    		_content.add(Message.sectionIndexEntry("",section.getTitle()));

		Iterator<Section> sectionIterator = section.getSections();
		while(sectionIterator.hasNext()){
			sectionIterator.next().accept(this);	
		}
	}

	@Override
	public void visit(Paragraph paragraph) {
	}

}