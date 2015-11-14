package edt.core;

import java.io.Serializable;

public class Author implements Comparable<Author>, Serializable {

    private String _name;
    private String _email;

    public Author(String name, String email) {
        _name = name;
        _email = email;
    }

    public String getName() {
        return _name;
    }

    public String getEmail() {
        return _email;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Author) {
            Author author = (Author) object;
            return getName().equals(author.getName());
        }
        return super.equals(object);
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }

    @Override
    public int compareTo(Author author) {
        return getName().compareTo(author.getName());
    }

}
