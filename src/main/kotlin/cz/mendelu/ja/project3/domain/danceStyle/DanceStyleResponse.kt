package cz.mendelu.ja.project3.domain.danceStyle

import io.swagger.v3.oas.annotations.media.Schema

data class DanceStyleResponse(
    @Schema(example = "1")
    var id: Long,

    @Schema(example = "Hip Hop")
    var name: String?,

    @Schema(example = "USA")
    var origin: String?
) {
}