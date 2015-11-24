package edt.core;

import edt.textui.main.Message;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class MetadataPrinter implements Visitor{

	private List<String> content;

	public MetadataPrinter(){
		content = new ArrayList<>();
	}

	public void visit(Section section){

	}

	public void visit(Paragraph paragraph){

	}

   	public void visit(Document document){
   		content.add(Message.documentTitle(document.getTitle()));
   		Iterator<Author> iterator = document.getAuthors();
   		while(iterator.hasNext()){
   			Author author = iterator.next();
   			author.accept(this);
   		}
   		content.add(Message.documentSections(document.getSectionsCount()));
   		content.add(Message.documentBytes(document.getSize()));
   		content.add(Message.documentIdentifiers(document.getTextElementsCount()));
   	}

	public void visit(TextElement element){

	}

    	public void visit(Author author){
    		content.add(Message.author(author.getName(), author.getEmail()));
    	}

    	public List<String> getContent(){
    		return content;
    	}
}