package nl.rijksoverheid.minienw.travelvalidation.api.data.token

import io.swagger.annotations.ApiModelProperty

class TokenRequestBody (
    @ApiModelProperty(required = true, notes="See ValidationInitializeRequestBody.pubKey.")
    val pubKey: String,
    @ApiModelProperty(required = true, notes="See ValidationInitializeRequestBody.alg.")
    val alg: String,
)