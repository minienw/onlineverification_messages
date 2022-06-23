package nl.rijksoverheid.minienw.travelvalidation.api.data

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.google.gson.annotations.SerializedName
import io.swagger.annotations.ApiModelProperty
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
    @ApiModelProperty(required = true, notes="")
    var jti: String

    /**
     * issuingServiceProvider
     * https://serviceprovider
     * id (uri?) of identity document
     */
    //@NotBlank
    @JsonProperty("iss")
    @SerializedName("iss")
    @ApiModelProperty(required = true, notes="Uri of the identity document of the issuing service.")
    var iss: String

    /**
     * whenIssued
     * Unix epoch time
     */
    @Min(Constants.LowestPossibleTime)
    @JsonProperty("iat")
    @SerializedName("iat")
    @ApiModelProperty(required = true, notes="Time of issue in Unix epoch time.")
    var iat: Long

    /**
     * subject - airline identifier of booking/traveller
     * TODO "Value of the Initialisation"
     * e.g. ADEDDDDDDDDDDDDDDD
     */
    //@Pattern(regexp = Constants.GuidAsHexRegexPattern)
    @JsonProperty("sub")
    @SerializedName("sub")
    @ApiModelProperty(required = true, notes = "Service provider (airline) identifier for the trip/traveller. GUID formatted as hex (no hyphens).")
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
    @ApiModelProperty(required = true, notes="Uri of the validation service extracted from the services identity document, with the subject appended e.g. https://validationprovider/validate/AAAAAAAAAABBBBBBBBBB")
    var aud: String

    /**
     * whenExpires
     * Epoch time
     */
    @Min(Constants.LowestPossibleTime)
    //TODO also max
    @JsonProperty("exp")
    @SerializedName("exp")
    @ApiModelProperty(required = true, notes="Time of expiry in Unix epoch time.")
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
    @ApiModelProperty(required = true, notes="Always 2.")
    var t: ValidationType

    /**
     * validationVersion
     * TODO what is this used for?
     * e.g. 1.0
     */
    //@NotBlank //TODO regex or code?
    @JsonProperty("v")
    @SerializedName("v")
    @ApiModelProperty(required = true, notes = "TBD. Reflect the protocol version? e.g. 2.00.")
    var v: String

    /**
     * validationCondition
     * Validation Conditions
     * (optional, depending on Type = Full)
     */
    @NotNull
    @JsonProperty("vc")
    @SerializedName("vc")
    @ApiModelProperty(required = true, notes="TDB...")
    var vc: ValidationAccessTokenPayloadCondition
}