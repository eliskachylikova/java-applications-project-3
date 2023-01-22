package cz.mendelu.ja.project3.domain.danceStyle

import cz.mendelu.ja.project3.utils.exceptions.DanceStyleNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class DanceStyleService @Autowired constructor (
    private val repository: DanceStyleRepository
) {
    /**
     * Returns all Dance Styles.
     * @return list of dance styles
     */
    internal fun getAll(): List<DanceStyle> = repository.findAll()

    /**
     * Finds a Dance Style in database by its ID.
     * @return found dance style
     * @throws DanceStyleNotFoundException when it does not found matching dance style by id
     */
    internal fun getById(id: Long): DanceStyle = repository.findById(id).orElseThrow{DanceStyleNotFoundException()}

    /**
     * Adds a new Dance Style to a database.
     * @return created dance style
     */
    internal fun create(danceStyle: DanceStyle): DanceStyle = repository.save(danceStyle)

    /**
     * Updates a Dance Style by its ID.
     * @return updated dance style
     * @throws DanceStyleNotFoundException when it does not found matching dance style by id
     */
    internal fun update(id: Long, danceStyle: DanceStyle): DanceStyle {
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

    /**
     * Deletes a Dance Style by its ID.
     * @throws DanceStyleNotFoundException when it does not found matching dance style by id
     */
    internal fun delete(id: Long) {
        return if (repository.existsById(id)) {
            repository.deleteById(id)
        } else throw DanceStyleNotFoundException()
    }

}