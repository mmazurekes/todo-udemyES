package mazurek.run.todoudemy.controller;

import mazurek.run.todoudemy.model.SQLTaskRepository;
import mazurek.run.todoudemy.model.TaskRepository;
import mazurek.run.todoudemy.model.Task;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class TaskController {
    public static final Logger logger = LoggerFactory.getLogger(TaskController.class);
    @Autowired
    TaskRepository repository;
    @Autowired
    SQLTaskRepository sqlrepository;
/*
    public TaskController(TaskRepository repository, SQLTaskRepository sqlrepository) {
        this.sqlrepository = sqlrepository;
        this.repository = repository;
    }
*/
    @RequestMapping(method = RequestMethod.GET, path = "/tasks", params = {"!sort","!page","!size"})
    ResponseEntity<?> readAllTasks(){
        logger.warn("Uwaga!!!!!!");
        //logger.warn(repository.findAll(page).toString());
        return ResponseEntity.ok( sqlrepository.findAll() );
    }

    @RequestMapping(method = RequestMethod.GET, path = "/tasks")
    ResponseEntity<?> readAllTasksX(Pageable page) {
        logger.info("Pagable!!!!!!");
        return ResponseEntity.ok( repository.findAll(page) );
    }
    @GetMapping("/tasks/{id}")
    ResponseEntity<?> readTask(@PathVariable int id){
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/tasks/{id}")
    ResponseEntity<?> updateTask(@PathVariable int id ,@RequestBody @Valid Task toUpdate){
        toUpdate.setId(id);
        repository.save(toUpdate);
        return ResponseEntity.noContent().build();
    }
    @PostMapping(path = "/tasks")
    ResponseEntity<?> insertTask(@RequestBody @Valid Task toCreate){
        repository.save(toCreate);
        return ResponseEntity.ok( toCreate );
    }



}
