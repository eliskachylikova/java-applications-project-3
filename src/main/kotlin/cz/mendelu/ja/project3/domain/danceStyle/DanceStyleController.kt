package cz.mendelu.ja.project3.domain.danceStyle

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("dancestyles")
@Tag(name = "Dance Style")
class DanceStyleController @Autowired constructor(
    private val service: DanceStyleService
) {

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Returns all dance styles")
    fun getAll(): List<DanceStyleResponse> = service.getAll().toResponses()

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Returns one dance style by its id")
    fun getById(@PathVariable("id") id: Long): DanceStyleResponse = service.getById(id).toResponse()

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Adds new dance style")
    fun add(@RequestBody body: DanceStyleRequest): DanceStyleResponse = service.create(body.toDanceStyle()).toResponse()

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ApiResponses(
        ApiResponse(responseCode = "404", description = "DanceStyle Not Found"),
        ApiResponse(responseCode = "202", description = "Accepted"),
        ApiResponse(responseCode = "400", description = "Bad Request"),
        )
    @Operation(summary = "Updates a dance style by its id")
    fun update(@PathVariable("id") id: Long, @RequestBody body: DanceStyleRequest): DanceStyleResponse = service.update(id, body.toDanceStyle()).toResponse()

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiResponses(
        ApiResponse(responseCode = "404", description = "DanceStyle Not Found")
    )
    @Operation(summary = "Deletes a dance style by its id")
    fun delete(@PathVariable("id") id: Long): Unit = service.delete(id)

}