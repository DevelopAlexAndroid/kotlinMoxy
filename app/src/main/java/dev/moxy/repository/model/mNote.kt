package dev.moxy.repository.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
class mNote (@PrimaryKey(autoGenerate = true)
             var id: Int? = null,
             var head: String,
             var text: String)