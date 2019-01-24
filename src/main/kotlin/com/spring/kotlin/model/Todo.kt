package com.spring.kotlin.model

import org.springframework.data.annotation.PersistenceConstructor
import javax.persistence.*

@Entity
data class Todo @PersistenceConstructor constructor(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Int,
        var todo: String,
        var state: Boolean

)