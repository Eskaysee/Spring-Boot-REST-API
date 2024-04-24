package SpringBootFramwork.RESTAPI.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    //url versioning        --- used by Twitter
    @GetMapping("/v1/person")
    public PersonV1 getV1PersonURI(){
        return new PersonV1("Name Surname");
    }

    @GetMapping("/v2/person")
    public PersonV2 getV2PersonURI(){
        return new PersonV2(new Name("Name", "Surname"));
    }

    //request parameter versioning      --used by Amazon
    @GetMapping(path = "/person", params = "version=2")
    public PersonV1 getV1Person(){
        return new PersonV1("Request Parameter");
    }

    @GetMapping(path = "/person", params = "version=1")
    public PersonV2 getV2Person(){
        return new PersonV2(new Name("Request", "Parameter"));
    }

    //headers versioning        -- used by Microsoft
    @GetMapping(path = "/person", headers = "X-API-VERSION=1")
    public PersonV1 getV1PersonHeader(){
        return new PersonV1("Custom Header");
    }

    @GetMapping(path = "/person", headers = "X-API-VERSION=2")
    public PersonV2 getV2PersonHeader(){
        return new PersonV2(new Name("Custom", "Header"));
    }

    //media type versioning (accept header)     -- used by GitHub
    @GetMapping(path = "/person", produces = "application/vnd.company.app-v1+json")
    public PersonV1 getV1PersonAcceptHeader(){
        return new PersonV1("Media Type");
    }

    @GetMapping(path = "/person", produces = "application/vnd.company.app-v2+json")
    public PersonV2 getV2PersonAcceptHeader(){
        return new PersonV2(new Name("Media", "Type"));
    }
}
