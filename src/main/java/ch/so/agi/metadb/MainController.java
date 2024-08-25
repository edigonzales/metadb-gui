package ch.so.agi.metadb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        return new ResponseEntity<String>("metadb-gui", HttpStatus.OK);
    }
        

}
