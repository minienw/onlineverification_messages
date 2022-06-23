package nl.rijksoverheid.minienw.travelvalidation.api.data.callback

import com.fasterxml.jackson.annotation.JsonProperty
import com.google.gson.annotations.SerializedName
import io.swagger.annotations.ApiModelProperty
import nl.rijksoverheid.minienw.travelvalidation.api.data.validate.DccExtract

/**
* 3.8.5.3
* <see cref="nl.rijksoverheid.minienw.travelvalidation.service.api.data.callback.ResultTokenPayload.Confirmation" />
*/
class ConfirmationTokenPayload
    (
    /**
    * Unique Identifier of the confirmation token
    * GUID
    * TODO <see href="https://docs.microsoft.com/en-us/dotnet/api/system.guid.tostring?view=net-6.0">What format? No example given</see>
    * Not <see cref="nl.rijksoverheid.minienw.validationservice.airlinestub.data.ValidationAccessTokenPayload.TokenIdentifier">!!!!!
    */

    @SerializedName("jti")
    @JsonProperty("jti")
    @ApiModelProperty(required = true, notes = "Unique identifier of the confirmation token - GUID.")
    var id : String,

    /**
    * Value of the access token
    * e.g. ADEDDDDDDDDDDDDDDD
    * TODO this looks like hex rather than base64??
    * <see cref="nl.rijksoverheid.minienw.validationservice.airlinestub.data.ValidationAccessTokenPayload.TokenIdentifier">
    */
    @SerializedName("sub")
    @JsonProperty("sub")
    @ApiModelProperty(required = true, notes = "Service provider (airline) identifier for the trip/traveller. GUID formatted as hex (no hyphens).")
    var subject : String,

    /**
    * TODO of what? This confirmation or is this copied from the validation request payload?
    * Unix epoch time
    */
    @SerializedName("iat")
    @JsonProperty("iat")
    @ApiModelProperty(required = true, notes="Time of issue in Unix epoch time.")
    var whenIssued: Long,

    /**
    * Epoch time
    * TODO of what? This confirmation or is this copied from the validation request payload?
    */
    @SerializedName("exp")
    @JsonProperty("exp")
    @ApiModelProperty(required = true, notes="Time of expiry in Unix epoch time.")
    var whenExpires : Long,

    /**
    * e.g. Inter-Flight, Concert, Domestic, MassEvent > 1000, etc.
    * Category which  shall be reflected in the Validation by additional rules/logic. If null, Standard Business Rule Check will apply.
    * Default: “Standard”
    * For 2
    */
    @SerializedName("category")
    @JsonProperty("category")
    @ApiModelProperty(required = true, notes = "e.g. Inter-Flight, Concert, Domestic, MassEvent > 1000, etc. Category which shall be reflected in the validation by additional rules/logic. If null, Standard Business Rule Check will apply. Default: Standard", example = "Standard")
    var category : Array<String>,

    /**
    * Final result of the evaluation.
    * OK = Passed
    * NOK = Fail
    * CHK = Cross Check(OPEN)
    */
    @ApiModelProperty(required = true, notes="Final result of the evaluation.\n" +
            "OK = Passed\n" +
            "NOK = Fail\n" +
            "CHK = Cross Check(OPEN)")
    var result : String,

    //V2 Extra
    @SerializedName("poa")
    @JsonProperty("poa")
    @ApiModelProperty(required = true, notes="Port of arrival, TBD Code standard is?")
    var portOfArrival : String,

    @SerializedName("pod")
    @JsonProperty("pod")
    @ApiModelProperty(required = true, notes="Port of departure, TBD Code standard is?")
    var portOfDeparture : String,

    /**
     * V2 Extra
     *  DCC must be valid from this date.
     * ISO8601 with time and offset e.g. 2021-01-29T12:00:00+01:00
     * For 0,1,2
     */
    @SerializedName("validfrom")
    @JsonProperty("validfrom")
    @ApiModelProperty(required = true,notes="DCC must be valid from this date. ISO8601 with time and offset e.g. 2021-01-29T12:00:00+01:00.")
    var whenValidStart : String,

    /**
     * V2 Extra
     * DCC must be valid minimum to this date.
     * ISO8601 with time and offset e.g. 2021-01-29T12:00:00+01:00
     * For 0,1,2
     */
    @SerializedName("validTo")
    @JsonProperty("validTo")
    @ApiModelProperty(required = true,notes="DCC must be valid up to this date. ISO8601 with time and offset e.g. 2021-01-29T12:00:00+01:00.")
    var whenValidEnd : String,

    /**
     * V2 Extra
     * Date where the DCC must be validatable.
     * ISO8601 with time and offset e.g. 2021-01-29T12:00:00+01:00
     * For 1,2
     */
    @SerializedName("validationclock")
    @JsonProperty("validationclock")
    @ApiModelProperty(required = true, notes = "Date where the DCC must be validatable. ISO8601 with time and offset e.g. 2021-01-29T12:00:00+01:00.")
    var validationClock : String,

    // V2 Extra
    @SerializedName("personalinfodccextract")
    @JsonProperty("personalinfodccextract")
    @ApiModelProperty(required = true)
    var dccExtract: DccExtract
)