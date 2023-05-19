package com.geekster.ToDo.Service.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Todo {
    private String id;
   // @JsonProperty("todoname")  // new edited name of todoName  we use @JsonProperty
    private String todoName;
    private Boolean todoStatus;

    public Todo(String id, String todoName, Boolean status) {
        this.id = id;
        this.todoName = todoName;
        this.todoStatus = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTodoName() {
        return todoName;
    }

    public void setTodoName(String todoName) {
        this.todoName = todoName;
    }

    public Boolean getTodoStatus() {
        return todoStatus;
    }

    public void setTodoStatus(Boolean todoStatus) {
        this.todoStatus = todoStatus;
    }
}
