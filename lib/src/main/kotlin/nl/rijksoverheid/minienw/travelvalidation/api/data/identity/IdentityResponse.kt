package nl.rijksoverheid.minienw.travelvalidation.api.data.identity

import com.fasterxml.jackson.annotation.JsonProperty
import com.google.gson.annotations.SerializedName
import io.swagger.annotations.ApiModelProperty

class IdentityResponse
(
    @JsonProperty("id")
    @SerializedName("id")
    @ApiModelProperty(required = true)
    val id: String,

    /**
    TODO name should be plural
     */
    @JsonProperty("verificationMethod")
    @SerializedName("verificationMethod")
    @ApiModelProperty(required = true, notes="Verification methods - effectively a list of public keys to check signatures with. However, also contains public RSA encryption keys e.g. for DCC encryption.")
    val verificationMethod :  Array<VerificationMethod>,

    /** TODO name should be plural*/
    @JsonProperty("service")
    @SerializedName("service")
    @ApiModelProperty(required = true, notes="Services available, their endpoints and verification methods.")
    val service : Array<Service>
)