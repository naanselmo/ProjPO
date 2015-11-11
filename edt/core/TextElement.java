package edt.core;

public abstract class TextElement{
	private String _id;

	abstract public String getContent();
	abstract public boolean hasId();
	abstract public void removeId();
	public void setId(String id){
		_id = id;
	}
	public String getId(){
		return _id;
	}
}
    
