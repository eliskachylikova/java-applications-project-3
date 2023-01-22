package cz.mendelu.ja.project3.domain.danceStyle

fun DanceStyleRequest.toDanceStyle(): DanceStyle = DanceStyle(
    this.name,
    this.origin
)

fun DanceStyle.toResponse(): DanceStyleResponse = DanceStyleResponse(
    this.id,
    this.name,
    this.origin
)