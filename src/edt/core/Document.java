package edt.core;

import java.io.Serializable;
import java.util.*;

public class Document extends Section implements Serializable {

    private String _path;
    private SortedSet<Author> _authors;
    private Map<String, TextElement> _textElements;

    public Document() {
        _authors = new TreeSet<>();
        _textElements = new HashMap<>();
    }

    public void putTextElement(TextElement textElement) {
        _textElements.put(textElement.getId(), textElement);
    }

    public boolean containsTextElement(String id) {
        return _textElements.containsKey(id);
    }

    public void removeTextElement(String id) {
        _textElements.remove(id);
    }

    public TextElement getTextElement(String id) {
        return _textElements.get(id);
    }

    public int getTextElementsCount() {
        return _textElements.size();
    }

    public int getDocumentLength() {
        int counter = 0;
        for (TextElement element : _textElements.values()) {
            counter += element.getSize();
        }
        return counter;
    }

    public void addAuthor(Author author) {
        _authors.add(author);
    }

    public void saveDocument() {
        /* FIXME: Serialize document */
    }

    public void loadDocument() {
        /* FIXME: Un-serialize document */
    }

    public Iterator<Author> getAuthors() {
        return _authors.iterator();
    }

    @Override
    public String getHeadline() {
        return "{" + getTitle() + "}";
    }

    public String getPath() {
        return _path;
    }

    public void setPath(String _path) {
        this._path = _path;
    }
}
