package com.geekster.ToDo.Service;

import com.geekster.ToDo.Repository.TodoDao;
import com.geekster.ToDo.Service.Model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TodoService {

    @Autowired
    TodoDao todoDao;

    public List<Todo> getAllTodos() {
        // return todoDao use under autowired of service
        
        return todoDao.getAllTodosFromDataSources();
    }
    public String addMyTodo(Todo todo){

       boolean insertionStatus= todoDao.save(todo);
       if(insertionStatus){
           return "Todo Add Successfully....";     // in our case always true
        }
       else{
           return "failed....Todo not Possible";    // in case of Database error ...will see later
       }
    }
    public List<Todo> getTodosByUserStatus(String status){
        List<Todo> todoListRightNow = todoDao.getAllTodosFromDataSources();
        List<Todo> todoListStatusBased= new ArrayList<>();
        for(Todo todo : todoListRightNow ){
            if(todo.getTodoStatus()== Boolean.parseBoolean(status)){
                todoListStatusBased.add(todo);
            }
        }
        return todoListStatusBased;

    }
    public Todo getTodoBasedOnId(String id) {
        List<Todo> todoListRightNow = todoDao.getAllTodosFromDataSources();

        for (Todo todo : todoListRightNow)
            if (todo.getId().equals(id)) {
                return todo;
            }
        return null;
    }
    public String removeTodoById(String id){
        boolean deleteResponse=false;
        String status;
        if(id != null) {
            List<Todo> todoListRightNow = todoDao.getAllTodosFromDataSources();

            for (Todo todo : todoListRightNow) {
                if (todo.getId().equals(id)) {
                    deleteResponse= todoDao.remove(todo);
                    if(deleteResponse){
                        status="todo with id"+id+" was deleted...!!!";
                    }
                    else{
                        status="todo with id"+id+" was  not deleted...!!!";
                    }
                    return status;
                }


            }
            return "todo with id"+id+" does not exist...!!!";
        }
        else{
            return "return id .....cant accept null id ...!";
        }
    }

    public String updateTodoStatusById(String id, String status) {
        boolean updateStatus= todoDao.update(id,Boolean.parseBoolean(status));

            if(updateStatus){
                return "todo with id "+id+" was updated";
            }
            else{
                return "todo with id "+id+" was not updated";
            }

    }


}
