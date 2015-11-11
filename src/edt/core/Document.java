package edt.core;

import java.util.*;

public class Document extends Section {

    private SortedSet<Author> _authors;
    private List<TextElement> _textElements;

    public Document() {
        _authors = new TreeSet<>();
        _textElements = new ArrayList<TextElement>();
    }

    public void putTextElement(TextElement textelement) {
        _textElements.add(textelement);
    }

    public boolean containsTextElement(String id) {
        return getTextElement(id) != null;
    }

    public void removeTextElement(String id) {
        TextElement element = getTextElement(id);
        if (element != null)
            _textElements.remove(element);
    }

    public TextElement getTextElement(String id) {
        for (TextElement element : _textElements) {
            if (element.getId().equals(id))
                return element;
        }
        return null;
    }

    public int getElementsCount() {
        return _textElements.size();
    }

    public int getDocumentLenght() {
        int counter = 0;
        for (TextElement element : _textElements) {
            counter += element.getSize();
        }
        return counter;
    }

    public void addAuthor(Author author) {
        _authors.add(author);
    }

    public Iterator<Author> getAuthors() {
        return _authors.iterator();
    }
}
