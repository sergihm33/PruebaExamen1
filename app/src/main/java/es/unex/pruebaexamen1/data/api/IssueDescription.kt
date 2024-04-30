package es.unex.pruebaexamen1.data.api

import androidx.room.Entity
import java.io.Serializable

@Entity
data class IssueDescription (
    val number: Int,
    val description: String
): Serializable