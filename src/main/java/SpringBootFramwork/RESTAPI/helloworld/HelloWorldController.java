package SpringBootFramwork.RESTAPI.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Exposes this as a REST API
@RestController
public class HelloWorldController {

    //Provides a URL for this method
    //@RequestMapping(method = RequestMethod.GET, path = "/hello-world") //Equivalent to the below
    @GetMapping(path = "/hello-world")
    public String helloWorld() {
        return "Hello World";
    }
}
