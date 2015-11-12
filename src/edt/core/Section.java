package edt.core;

import java.util.Iterator;
import java.util.List;

public class Section extends TextElement {

    private String _title;
    private List<Paragraph> _paragraphs;
    private List<Section> _sections;

    public Section(String title) {
        _title = title;
        _paragraphs = new ArrayList<Paragraph>();
        _sections = new ArrayList<Section>();
    }

    public Section() {
        this(null);
    }

    public String getContent() {
        return null;
    }

    @Override
    public int getSize() {
        return -1;
    }

    public String getHeadline() {
        return null;
    }

    public void addSection(Section section, int index) {
        _sections.add(index, section);
    }

    public boolean containsSection(int index) {
        return index < _section.size() && index >= 0;
    }

    public void renameSection(Document document, int index, String id) {
    }

    public void removeSection(Document document, int index) {
    }

    public int getSectionsCount() {
        return _sections.size();
    }

    public void addParagraph(Paragraph paragraph, int index) {
        _paragraphs.add(index, paragraph);
    }

    public boolean containsParagraph(int index) {
        return index < _paragraphs.size() && index >= 0;
    }

    public void renameParagraph(Document document, int index, String id) {
    }

    public void removeParagraph(Document document, int index) {
    }

    public int getParagraphsCount() {
        return _paragraphs.size();
    }

    public Section getSection(int index) {
      if containsSection(index)
          return _sections.get(index)
      else
          return null;
    }

    public Paragraph getParagraph(int index) {
      if containsParagraph(index)
          return _paragraphs.get(index)
      else
          return null;
    }

    public Iterator<Paragraph> getParagraphs() {
        return _paragraphs.iterator();
    }

    public Iterator<Section> getSections() {
        return _sections.iterator();
    }

    public String getTitle() {
        return _title;
    }

    public void setTitle(String title) {
        _title = title;
    }

}
