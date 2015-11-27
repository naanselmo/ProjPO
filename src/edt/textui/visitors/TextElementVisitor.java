package edt.textui.visitors;

import edt.core.*;
import edt.textui.main.Message;

import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

public class TextElementVisitor extends FormaterVisiter {
	
	public void visit(Document document){
	} 
	
	public void visit(Author author){
	}
	
	public void visit(TextElement element){
		element.accept(this);
	}
	
	public void visit(Section section){
		 if(section.hasId()) 
           			 _content.add(Message.sectionIndexEntry(section.getId(),section.getTitle()));
       		 else
            		_content.add(Message.sectionIndexEntry("",section.getTitle()));

		Iterator<Paragraph> paragraphIterator = section.getParagraphs();
		while(paragraphIterator.hasNext()){
			paragraphIterator.next().accept(this);
		}
		Iterator<Section> sectionIterator = section.getSections();
		while(sectionIterator.hasNext()){
			sectionIterator.next().accept(this);
		}
	}
	
	public void visit(Paragraph paragraph){
		_content.add(paragraph.getText());
	}
	
}