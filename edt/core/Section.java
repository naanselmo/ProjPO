package edt.core;

public class Section extends TextElement{

	private String _title;

	public Section(String title){}

	public String getContent(){}
	
	public void  addSection(Section section, int index){}
	
	public boolean containsSection(int index){}
	
	public void renameSection(Document document, int index, String id){}

	public void removeSection(Document document, int index){}

	public int getSectionsCount(){}

	public void addParagraph(Paragraph paragraph,int index){}

	public boolean containsParagraph(int index){}
	
	public void renameParagraph(Document document, int index, String id){}
	
	public void removeParagraph(Document document, int index){}
	
	public int getParagraphsCount(){}

	public void setTitle(String title){}

	public Section getSection(int index){}
	
	public Paragraph etParagraph(int index){}

	public Iterator<Paragraph> getParagraphs(){}

	public Iterator<Section> getSections(){}
	
	public String getTitle(){}
}