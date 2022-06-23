package nl.rijksoverheid.minienw.travelvalidation.api.data

import io.swagger.annotations.ApiModelProperty

data class JwtHeader(
    @ApiModelProperty(required = true)
    val kid: String,
    @ApiModelProperty(required = true)
    val alg: String,
)