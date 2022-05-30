package nl.rijksoverheid.minienw.travelvalidation.api.data.identity

import com.fasterxml.jackson.annotation.JsonProperty
import com.google.gson.annotations.SerializedName

class IdentityResponse
(
    @JsonProperty("id")
    @SerializedName("id")
    val id: String,

    /**
    TODO name should be plural
     */
    @JsonProperty("verificationMethod")
    @SerializedName("verificationMethod")
    val verificationMethod :  Array<VerificationMethod>,

    /** TODO name should be plural*/
    @JsonProperty("service")
    @SerializedName("service")
    val service : Array<Service>
)