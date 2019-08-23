package dev.moxy.repository.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class mNote (@PrimaryKey(autoGenerate = true)
             var id: Int? = null,
             var head: String,
             var text: String)