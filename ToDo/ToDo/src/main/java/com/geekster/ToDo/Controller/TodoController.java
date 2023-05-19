package com.geekster.ToDo.Controller;

import com.geekster.ToDo.Service.Model.Todo;
import com.geekster.ToDo.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    @Autowired
    TodoService todoService;
// get me all the Todos in my present todolist
    @GetMapping(value="/getAllTodos")
    public List<Todo> getAllTodos(){
        // object under Autowired of service
      return  todoService.getAllTodos();
    }
    @GetMapping(value="getTodosByUserStatus") ///request param
    public List<Todo> getTodoByStatus(@RequestParam String status){
        return todoService.getTodosByUserStatus(status);

    }



    @PostMapping(value="/addTodo")
    public String addTodo(@RequestBody Todo todo){
      return  todoService.addMyTodo(todo);
    }
    @RequestMapping(value="/getTodoById/{id}",method=RequestMethod.GET)
    public Todo getTodoById(@PathVariable String id){
   return todoService.getTodoBasedOnId(id);

    }
     // create delete end point
    @DeleteMapping(value="/deleteTodoById/{id}")
    public String deleteTodoById(@PathVariable String id){
        return todoService.removeTodoById(id);
    }
    //update
    @PutMapping(value ="/updateTodoById/{id}/{status}")
    public String updateTodoStatusById(@PathVariable String id,@PathVariable String status){
        return todoService.updateTodoStatusById(id,status);
    }


}
