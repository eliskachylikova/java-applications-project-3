package cz.mendelu.ja.project3.domain.danceStyle

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

    fun create(danceStyle: DanceStyle): DanceStyle = repository.save(danceStyle)

    fun update(id: Long, danceStyle: DanceStyle): DanceStyle {
        return if (repository.existsById(id)) {
            repository.save(
                DanceStyle(
                    id = id,
                    name = danceStyle.name,
                    origin = danceStyle.origin
                )
            )
        } else throw DanceStyleNotFoundException()
    }

    fun delete(id: Long) {
        return if (repository.existsById(id)) {
            repository.deleteById(id)
        } else throw DanceStyleNotFoundException()
    }

}