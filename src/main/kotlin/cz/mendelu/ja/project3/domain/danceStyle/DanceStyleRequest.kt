package cz.mendelu.ja.project3.domain.danceStyle

import io.swagger.v3.oas.annotations.media.Schema

data class DanceStyleRequest (

    @Schema(example = "Hip Hop")
    var name: String?,

    @Schema(example = "USA")
    var origin: String?

)



