package cz.mendelu.ja.project3.danceStyles

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "dance_style")
data class DanceStyle (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    @Column(name = "name", nullable = true)
    val name: String?,
    @Column(name = "origin", nullable = true)
    val origin: String?
) {
    constructor() : this(-1, "", "")
}