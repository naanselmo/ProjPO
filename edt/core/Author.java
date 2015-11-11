package edt.core;

public class Author{
	private String _name;
	private String _email;

	public Author(String name, String email){
		_name = name;
		_email = email;
	}

	public void setName(String name){
		_name = name;
	}

	public void setEmail(String email){
		_email = email;
	}

	public String getName(){
		return _name;
	}

	public String getEmail(){
		return _email;
	}

	@Override
	public boolean equals(Object object){
		if( object instanceof Author){
			Author author = (author) object;
			return _name.equals(author.getName()) && _email.equals(author.getEmail());	
		}
		return super.equals(object);
	}

	@Override
	public int hashCode(){
		return (_name + "//" + _email).hashcode();	
	}

	@Override
	public int toCompare(Author author){
		return _name.toCompare(author.getName());
	}
}
