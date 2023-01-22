package cz.mendelu.ja.project3.danceStyles

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface DanceStyleRepository : CrudRepository<DanceStyle, Long> {

}