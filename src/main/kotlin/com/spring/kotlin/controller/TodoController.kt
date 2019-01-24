package com.spring.kotlin.controller

import com.spring.kotlin.model.Todo
import com.spring.kotlin.repository.TodoRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("todo")
class TodoController(val todoRepository: TodoRepository) {

    @GetMapping("")
    fun getTodoList(): ResponseEntity<List<Todo>> {
        return ResponseEntity.ok(todoRepository.findAll())
    }

    @GetMapping("/{id}")
    fun getOneTodo(@PathVariable id: Int): ResponseEntity<*> {
        val responseBody = todoRepository.findById(id)
        return ResponseEntity.ok(responseBody)
    }

    @PostMapping("")
    fun createTodo(@RequestBody todo: Todo): ResponseEntity<*> {
        todoRepository.save(todo)
        return ResponseEntity.ok(todo)
    }

    @PutMapping("/{id}")
    fun updateTodo(@PathVariable id: Int, @RequestBody todo: Todo): ResponseEntity<*> {
        val getTodo = todoRepository.findById(id)
        if (getTodo.isPresent) {
            val updateTodo = getTodo.get()
            updateTodo.id = id
            updateTodo.todo = todo.todo
            updateTodo.state = todo.state
            todoRepository.save(updateTodo);
        }
        return ResponseEntity.ok(todo)
    }

    @DeleteMapping("/{id}")
    fun deleteTodo(@PathVariable id: Int): ResponseEntity<*> {
        todoRepository.deleteById(id)
        return ResponseEntity.ok(id)
    }

}

