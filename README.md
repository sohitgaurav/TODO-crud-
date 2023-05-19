# TODO-crud-
java project using all get todo , post todo , update , delete

## Framework and language used
* Springboot
* java

## dependency used
 * dev
 * web
 * lombok
 * h2-database
 * jpa
 * spring boot starter data jpa 

## Data Flow

### Model
* todo
   *  String id
   *  String todoname
   *  boolean status
   

### Controller
  * TodoController
* @GetMapping  
    * getAllTodos
    * getTodosByUserStatus
    * getTodoById
    
* @PostMapping
    * addTodo
* @DeleteMapping
   * deleteTodoById

*  @Putmapping 
    * updateTodoStatusById

### TodoService
 *  getAllTodos
 *  addMyTodo
 *  getTodosByUserStatus
 *  getTodoBasedOnId
 *  removeTodoById
 *  updateTodoStatusById

### TodoRepository
* getAllTodosFromDataSources
* save
* remove
* update


### Database used
* List datbase 

##  About Project
* this Project is the about to perforn crud operation in an application
* 
