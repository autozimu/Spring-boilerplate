package hello;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Resource
    TodoRepository repository;

    AtomicLong counter = new AtomicLong();

    @RequestMapping(method = RequestMethod.GET)
    public List<Todo> list() {
        return this.repository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Todo create(@RequestBody Todo todo) {
        return this.repository.save(todo);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Todo get(@PathVariable long id) {
        return this.repository.findOne(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Todo update(@PathVariable long id, @RequestBody Todo todo) {
        return this.repository.save(todo);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        this.repository.delete(id);
    }
}
