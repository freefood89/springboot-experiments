package hello;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Greeting {

	@Id
	@GeneratedValue
    private long id;
    private String content;

    public Greeting(long id, String content) {
    	this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }
    
    public void setId() {
    	this.id = id;
    }

    public String getContent() {
        return content;
    }
    
//    public void setContent(String content){
//    	this.content = content;
//    }
    
    public Greeting() {
    }
}
