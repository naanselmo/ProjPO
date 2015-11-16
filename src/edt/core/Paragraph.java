package edt.core;

import java.io.Serializable;
import java.security.MessageDigest;

/**
 * Paragraph class. Represents a paragraph.
 */
public class Paragraph extends TextElement implements Serializable {

    private String _text;

    /**
     * Initializes a new Paragraph.
     *
     * @param text Paragraph's text.
     */
    public Paragraph(String text) {
        _text = text;
    }

    /**
     * Returns the paragraph's content.
     *
     * @return The content of this paragraph.
     */
    public String getContent() {
        return getText();
    }

    /**
     * Returns the paragraph's size.
     *
     * @return The size of this paragraph.
     */
    @Override
    public int getSize() {
        return getText().length();
    }

    /**
     * Returns the paragraph's text.
     *
     * @return The text of this paragraph.
     */
    public String getText() {
        return _text;
    }

    /**
     * Sets the paragraph's text.
     *
     * @param text The new text of this paragraph.
     */
    public void setText(String text) {
        _text = text;
    }

    /**
     * Equality test between the Paragraph and a given object. This will only be true if the object given is a Paragraph,
     * and if the text is internally the same. Also both have to have the same identifiers or no identifiers at all.
     *
     * @param object Object to compare this section to.
     * @return {@code true} if the object given is internally equal to this paragraph.
     */
    @Override
    public boolean equals(Object object) {
        if(!(object instanceof Paragraph))
            return false;

        Paragraph paragraph = (Paragraph) object;
        return (hasId() ? getId().equals(paragraph.getId()) : !paragraph.hasId())
                && getText().equals(paragraph.getText());
    }

    /**
     * Returns the hashCode of the paragraph.
     * @return The hashCode of this paragraph.
     */
    @Override
    public int hashCode() {
        int result = hasId() ? getId().hashCode() : 0;
        result = 31 * result + getText().hashCode();
        return result;
    }

     /**
      * Returns the checksum of the document.
      *
      * @return The checksum of this document.
      */
      public String getChecksum() {
          StringBuilder toHash = new StringBuilder();

          toHash.append(getText());

          if(hasId())
            toHash.append(getId());

          try{
              MessageDigest md = MessageDigest.getInstance("SHA-256");
              md.update(toHash.toString().getBytes());
              return new String(md.digest());
          } catch(Exception ex){
              ex.printStackTrace();
          }
      }
}
