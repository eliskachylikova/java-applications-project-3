package cz.mendelu.ja.project3.domain.danceStyle

import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("dancestyles")
class DanceStyleController @Autowired constructor(
    private val service: DanceStyleService
) {

    @GetMapping("/")
    fun getAll(): List<DanceStyle> = service.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable("id") id: Long): DanceStyle = service.getById(id)

    @PostMapping("/")
    fun add(@RequestBody body: DanceStyleRequest): DanceStyle = service.create(body.toDanceStyle())

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ApiResponses(
        ApiResponse(responseCode = "404", description = "DanceStyle Not Found"),
        ApiResponse(responseCode = "202", description = "Accepted"),
        ApiResponse(responseCode = "400", description = "Bad Request"),
        )
    fun update(@PathVariable("id") id: Long, @RequestBody body: DanceStyleRequest): DanceStyleResponse = service.update(id, body.toDanceStyle()).toResponse()

}