package cz.mendelu.ja.project3.danceStyles

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("dancestyles")
class DanceStyleController @Autowired constructor(
    private val repository: DanceStyleRepository
) {

    @GetMapping("/")
    fun getAll(): MutableIterable<DanceStyle> = repository.findAll()
    


}