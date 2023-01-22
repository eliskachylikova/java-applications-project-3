package cz.mendelu.ja.project3.danceStyles

import cz.mendelu.ja.project3.utils.exceptions.DanceStyleNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class DanceStyleService @Autowired constructor (
    private val repository: DanceStyleRepository
) {
    fun getAll(): List<DanceStyle> = repository.findAll()

    fun getById(id: Long): DanceStyle = repository.findById(id).orElseThrow{
        DanceStyleNotFoundException(
            HttpStatus.NOT_FOUND,
            "No dance style was found."
        )}
}