package edt.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Document extends Section{
	private List<Author> _authors;
	private List<TextElement> _textelements;

	public Document(){
		_autors = new ArrayList<Author>();
		_textelements = new ArrayList<TextElement>();
	} 

	public void putTextElement(TextElement textelement){
		_textelement.add(textelement);
	}

	public boolean containsTextElement(String id){
		Iterator i = _textelements.iterator();
		while(i.hasNext()){
			if(i.next().getId().equals(id))
				return true;
		}
		return false;
	}

	public void removeTextElement(String id){
		Iterator i = _textelements.iterator();
		while(i.hasNext()){
			TextElement e = i.next;
			if(e.getId().equals(id))
				_textelements.remove(e);	
		}
	}

	public TextElement getTextElement(String id){
		Iterator i = _textelements.iterator();
		while(i.hasNext()){
			TextElement e = i.next;
			if(e.getId().equals(id))
				return e;
		}
		return null;
	}

	public int getElementsCount(){
		return _textelements.size();
	}	

	public int getDocumentLenght(){
		Iterator i = _textelements.iterator();
		int counter = 0;
		while(i.hasNext()){
			String str = i.next().getContent();
			counter += str.length();
		}
		return counter;
	}

	public void addAuthor(Author author){
		_authors.add(author);
	}

	public Iterator<Author> getAuthors(){
		Iterator i = _authors.iterator();
		return i;
	}
}
