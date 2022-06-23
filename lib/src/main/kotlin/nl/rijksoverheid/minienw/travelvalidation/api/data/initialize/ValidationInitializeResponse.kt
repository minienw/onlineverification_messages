package nl.rijksoverheid.minienw.travelvalidation.api.data.initialize

import com.fasterxml.jackson.annotation.JsonProperty
import com.google.gson.annotations.SerializedName
import io.swagger.annotations.ApiModelProperty
import nl.rijksoverheid.minienw.travelvalidation.api.data.*

/**
    * 3.8.3
    * The validation initialisation response delivers a JSON with a unique subject ID, which identifies the
    * occurrence in the validation validationservice.Next to the unique subject, a var key and an expiration date
    * for the occurrence are attached.The var key must be unique for each subject for maximum data
    * privacy.
    */
class ValidationInitializeResponse(
    /**
     * hexadecimal-encoded value
     * Traveller or whole trip?
     */
    @SerializedName("sub")
    @JsonProperty("sub")
    @ApiModelProperty(required = true, notes = "Service provider (airline) identifier for the trip/traveller. GUID formatted as hex (no hyphens).")
    var subjectId: String,

    /**
     * Unix epoch time
     * Expiry
     */
    @SerializedName("exp")
    @JsonProperty("exp")
    @ApiModelProperty(required = true, notes="Time of expiry in Unix epoch time.")
    var whenExpires: Long,

    /**
     * E.g. https://validationprovider/validate/{subject}
     */
    @SerializedName("aud")
    @JsonProperty("aud")
    @ApiModelProperty(required = true, notes="Uri of the validation service extracted from the services identity document, with the subject appended e.g. https://validationprovider/validate/AAAAAAAAAABBBBBBBBBB")
    var validationUrl: String,

    /**
     * "Optional var Key for Encryption of Validation nl.rijksoverheid.minienw.travelvalidation.validationservice.api.data.identity.Service."
     */
    @SerializedName("encKey")
    @JsonProperty("encKey")
    @ApiModelProperty(required = true, notes="Unused for some reason. See response headers.")
    var validationServiceEncryptionKey: PublicKeyJwk?,

    /**
     * "Optional var Key for Signing of Validation nl.rijksoverheid.minienw.travelvalidation.validationservice.api.data.identity.Service."
     * See encKey...
     */
    @SerializedName("signKey")
    @JsonProperty("signKey")
    @ApiModelProperty(required = true, notes="Unused for some reason. See response headers.")
    var signKey: PublicKeyJwk?,
)
