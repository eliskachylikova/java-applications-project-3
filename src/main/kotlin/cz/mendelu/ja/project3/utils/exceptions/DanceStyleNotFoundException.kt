package cz.mendelu.ja.project3.utils.exceptions

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value = HttpStatus.NOT_FOUND)
class DanceStyleNotFoundException(
    val statusCode: HttpStatus,
    val reason: String
) : NotFoundException()