package nl.rijksoverheid.minienw.travelvalidation.api.data.validate

import com.fasterxml.jackson.annotation.JsonProperty
import com.google.gson.annotations.SerializedName
import io.swagger.annotations.ApiModelProperty

/**
* 3.8.5.3
*/
class ResultTokenPayload(
    /**
     * https://serviceprovider
     * id (uri?) of identity document
     */
    @SerializedName("iss")
    @JsonProperty("iss")
    @ApiModelProperty(required = true, notes="Uri of the identity document for the issuing validation service.")
    var serviceProviderUri: String,

    //Claim added by token builder

    /**
     * Unix epoch time
     */
    @SerializedName("iat")
    @JsonProperty("iat")
    @ApiModelProperty(required = true, notes="Time of issue in Unix epoch time.")
    var whenIssued: Long,

    /**
     * Epoch time
     */
    @SerializedName("exp")
    @JsonProperty("exp")
    @ApiModelProperty(required = true, notes="Time of expiry in Unix epoch time.")
    var whenExpires: Long,

    /**
     * e.g. Inter-Flight, Concert, Domestic, MassEvent > 1000, etc.
     * Category which  shall be reflected in the Validation by additional rules/logic. If null, Standard Business Rule Check will apply.
     * Default: “Standard”
     * For 2
     * @return list of categories
     */
    @ApiModelProperty(required = true, notes = "e.g. Inter-Flight, Concert, Domestic, MassEvent > 1000, etc. Category which shall be reflected in the validation by additional rules/logic. If null, Standard Business Rule Check will apply. Default: Standard", example = "Standard")
    var category: Array<String>,

    /**
     * TODO "Value of the Initialisation"
     * e.g. ADEDDDDDDDDDDDDDDD
     */
    @SerializedName("sub")
    @JsonProperty("sub")
    @ApiModelProperty(required = true, notes = "Service provider (airline) identifier for the trip/traveller. GUID formatted as hex (no hyphens).")
    var subject: String,

    /**
     * Final result of the evaluation.
     * OK = Passed
     * NOK = Fail
     * CHK = Cross Check(OPEN)
     */
    @ApiModelProperty(required = true, notes="Final result of the evaluation - OK = Passed, NOK = Fail, CHK = Cross Check(OPEN)")
    var result: String, //TODO ResultTokenPayloadResult?

    @ApiModelProperty(required = true, notes="Results of the business rules evaluation.")
    var results: Array<DCCFailableItem>,

    /**
     * The one to send to the airline
     */
    @ApiModelProperty(required = false, notes="JWT of ConfirmationTokenPayload - The one to send to the airline.")
    var confirmation: String?,

    // V2 Extra
    @SerializedName("personalinfodccextract")
    @JsonProperty("personalinfodccextract")
    @ApiModelProperty(required = false, notes="Names and date of birth extracted from the DCC.")
    var dccExtract: DccExtract?
)