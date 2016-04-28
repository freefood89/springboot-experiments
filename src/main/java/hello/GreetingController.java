package hello;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private final ArrayList<Greeting> greetingList = new ArrayList<Greeting>();
    
    @RequestMapping(value="/greeting", method=RequestMethod.GET)
    public Greeting greeting(@RequestParam(value="id", defaultValue="0") long id) {
    	try {
    		return greetingList.get((int)id);
    	}
    	catch (IndexOutOfBoundsException e) {
    		throw new EntityNotFoundException();
    	}
    }
    
    @RequestMapping(value="/greeting", method=RequestMethod.POST)
    public void greeting(@RequestBody Greeting greeting) {
    	long id = greetingList.size();
        greetingList.add(new Greeting(id, greeting.getContent()));
    	return;
    }
}
