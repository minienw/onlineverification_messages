package nl.rijksoverheid.minienw.travelvalidation.api.data.callback

import io.swagger.annotations.*

data class CallbackRequestBody (
    @ApiModelProperty(required = true, notes="JWT with payload ConfirmationTokenPayload", reference = "ConfirmationTokenPayload")
    var confirmationToken: String
)
