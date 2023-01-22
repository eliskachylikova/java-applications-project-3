package cz.mendelu.ja.project3.danceStyles

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("dancestyles")
class DanceStyleController @Autowired constructor(
    private val service: DanceStyleService
) {

    @GetMapping("/")
    fun getAll(): List<DanceStyle> = service.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable("id") id: Long): DanceStyle = service.getById(id)


}