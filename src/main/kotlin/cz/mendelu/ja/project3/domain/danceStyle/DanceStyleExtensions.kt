package cz.mendelu.ja.project3.domain.danceStyle

/**
 * Creates a DanceStyle from a DanceStyleRequest.
 */
internal fun DanceStyleRequest.toDanceStyle(): DanceStyle = DanceStyle(
    this.name,
    this.origin
)

/**
 * Creates a DanceStyleResponse from a DanceStyle.
 */
internal fun DanceStyle.toResponse(): DanceStyleResponse = DanceStyleResponse(
    this.id,
    this.name,
    this.origin
)

/**
 * Creates a list of DanceStyleResponses from a list of DanceStyles.
 */
internal fun List<DanceStyle>.toResponses(): List<DanceStyleResponse> = this.map { it.toResponse() }