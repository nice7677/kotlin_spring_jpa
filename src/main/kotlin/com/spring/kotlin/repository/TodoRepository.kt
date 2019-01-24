package com.spring.kotlin.repository

import com.spring.kotlin.model.Todo
import org.springframework.data.domain.Page
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TodoRepository : JpaRepository<Todo, Int> {

    fun findById(id: String): Todo

}