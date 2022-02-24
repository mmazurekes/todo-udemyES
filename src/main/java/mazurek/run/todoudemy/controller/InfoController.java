package mazurek.run.todoudemy.controller;

import mazurek.run.todoudemy.TaskConfigurationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
public class InfoController {

    public InfoController(final TaskConfigurationProperties myProp) {
        this.myProp = myProp;
    }

    private TaskConfigurationProperties myProp;

    @GetMapping("/info")
    boolean myInfo(){
        return myProp.isAllowMultipleTasksFromTemplate();
    }

}
