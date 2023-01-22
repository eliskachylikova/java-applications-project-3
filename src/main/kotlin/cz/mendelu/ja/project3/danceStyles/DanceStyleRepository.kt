package cz.mendelu.ja.project3.danceStyles

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DanceStyleRepository : JpaRepository<DanceStyle, Long> {

}