package nl.rijksoverheid.minienw.travelvalidation.api.data

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.google.gson.annotations.SerializedName
import nl.rijksoverheid.minienw.travelvalidation.Constants
import nl.rijksoverheid.minienw.travelvalidation.api.data.token.ValidationType
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull

/**
* 3.8.4.3 Validation Access Token Payload
* The Token Replay section regarding replay mitigation is in section 3.8.4.3 ->
* this must refer to <see cref="nl.rijksoverheid.minienw.travelvalidation.validationservice.api.ValidationAccessTokenPayload.TokenIdentifier"/> and <see cref="nl.rijksoverheid.minienw.travelvalidation.validationservice.api.ValidationAccessTokenPayload.WhenExpires"/>
 *
*/
class ValidationAccessTokenPayload {

    @JsonCreator
    constructor(
        jsonTokenIdentifier: String,
        serviceProvider: String,
        subject: String,
        subjectUri: String,
        whenExpires: Long,
        ValidationType: ValidationType,
        ValidationVersion: String,
        ValidationCondition: ValidationAccessTokenPayloadCondition,
        whenIssued: Long
    )
    {
        this.jti = jsonTokenIdentifier
        this.iss = serviceProvider
        this.sub = subject
        this.aud = subjectUri
        this.iat = whenIssued
        this.exp = whenExpires
        this.t = ValidationType
        this.v = ValidationVersion
        this.vc = ValidationCondition
    }

    /**
     * id
     */
    @NotNull
    //@Size(min = 32, max = 32)
    //@Pattern(regexp = Constants.GuidAsHexRegexPattern)
    @JsonProperty("jti")
    @SerializedName("jti")
    var jti: String

    /**
     * issuingServiceProvider
     * https://serviceprovider
     * id (uri?) of identity document
     */
    //@NotBlank
    @JsonProperty("iss")
    @SerializedName("iss")
    var iss: String

    /**
     * whenIssued
     * Unix epoch time
     */
    @Min(Constants.LowestPossibleTime)
    @JsonProperty("iat")
    @SerializedName("iat")
    var iat: Long

    /**
     * subject - airline identifier of booking/traveller
     * TODO "Value of the Initialisation"
     * e.g. ADEDDDDDDDDDDDDDDD
     */
    //@Pattern(regexp = Constants.GuidAsHexRegexPattern)
    @JsonProperty("sub")
    @SerializedName("sub")
    var sub: String

    /**
     * validationUrl
     * Value of the Initialisation (must match to validationservice endpoint “ValidationService”)
     * e.g. https://validationprovider/validate/{subject}
     * Audience
     */
    //@NotBlank
    //TODO additional Uri.parse...
    @JsonProperty("aud")
    @SerializedName("aud")
    var aud: String

    /**
     * whenExpires
     * Epoch time
     */
    @Min(Constants.LowestPossibleTime)
    //TODO also max
    @JsonProperty("exp")
    @SerializedName("exp")
    var exp: Long

    /**
     * validationType
     * This is the type discriminator for the condition and governs the mandatory fields
     * NB Must be 2 for this type of validation
     * Depth of probing for the DCC during verification
     */
    //@NotBlank //TODO regex or code?
    @JsonProperty("t")
    @SerializedName("t")
    var t: ValidationType

    /**
     * validationVersion
     * TODO what is this used for?
     * e.g. 1.0
     */
    //@NotBlank //TODO regex or code?
    @JsonProperty("v")
    @SerializedName("v")
    var v: String

    /**
     * validationCondition
     * Validation Conditions
     * (optional, depending on Type = Full)
     */
    @NotNull
    @JsonProperty("vc")
    @SerializedName("vc")
    var vc: ValidationAccessTokenPayloadCondition
}