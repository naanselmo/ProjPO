package edt.core;

import java.io.Serializable;
import java.util.*;

public class Document extends Section implements Serializable {

    private String _path;
    private SortedSet<Author> _authors;
    private Map<String, TextElement> _textElements;

    public Document(String title) {
        super(title);
        _authors = new TreeSet<>();
        _textElements = new HashMap<>();
    }

    public void indexTextElement(TextElement textElement) {
        _textElements.put(textElement.getId(), textElement);
    }

    public boolean containsTextElement(String id) {
        return _textElements.containsKey(id);
    }

    public void renameTextElement(TextElement element, String id) {
        if (containsTextElement(id))
            removeTextElement(getTextElement(id));
        element.setId(id);
        indexTextElement(element);
    }

    public void removeTextElement(TextElement element) {
        _textElements.remove(element.getId()).removeId();
    }

    public TextElement getTextElement(String id) {
        return _textElements.get(id);
    }

    public int getTextElementsCount() {
        return _textElements.size();
    }

    @Override
    public String getHeadline() {
        return "{" + getTitle() + "}";
    }

    public int getDocumentLength() {
        return getSize();
    }

    public void addAuthor(Author author) {
        _authors.add(author);
    }

    public Iterator<Author> getAuthors() {
        return _authors.iterator();
    }

    public String getPath() {
        return _path;
    }

    public boolean hasPath(){
        return _path != null;
    }

    public void setPath(String _path) {
        this._path = _path;
    }
}
