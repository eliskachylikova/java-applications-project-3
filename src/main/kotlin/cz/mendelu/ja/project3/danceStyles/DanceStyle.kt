package cz.mendelu.ja.project3.danceStyles

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "dance_style")
class DanceStyle (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int,
    val name: String,
    val origin: String
) {
    constructor() : this(-1, "", "")
}