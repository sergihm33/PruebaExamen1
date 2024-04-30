package es.unex.pruebaexamen1.data.api

import androidx.room.Entity
import java.io.Serializable

@Entity
data class Issue (
    val number: Int,
    val created: String
) : Serializable