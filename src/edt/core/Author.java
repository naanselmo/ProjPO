package edt.core;

import java.io.Serializable;

public class Author implements Comparable<Author>, Serializable {

    private String _name;
    private String _email;

/**
 * Author Constructor
 * @param  name  receives the author's name
 * @param  email  receives the author's email
 */
    public Author(String name, String email) {
        _name = name;
        _email = email;
    }

/**
 * Getter method for the name attribute 
 * @return name's attribute value
 */
    public String getName() {
        return _name;
    }

/**
 * Getter method for the email attribute
 * @return email's attribute value
 */
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
