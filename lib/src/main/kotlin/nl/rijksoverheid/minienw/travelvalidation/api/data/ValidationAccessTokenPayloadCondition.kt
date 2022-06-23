package nl.rijksoverheid.minienw.travelvalidation.api.data

import com.fasterxml.jackson.annotation.JsonProperty
import com.google.gson.annotations.SerializedName
import io.swagger.annotations.ApiModelProperty

/**
 *
* 3.8.4.3 Validation Access Token Payload Condition Structure
* The validation condition structure is embedded in the validation access token to fulfil two things:
* a) The validation validationservice knows the selected conditions by the validationservice provider/validation validationservice user
* b) The wallet app can select an appropriate certificate for the user with reference to the conditions
*/
data class ValidationAccessTokenPayloadCondition
    (
//    /**
//    * TODO Hex or base64?
//    * Not applicable for Type 1,2
//    */
//    @JsonProperty("hash")
//    var DccHash : String?,

    /**
    * ISO 639-1 standard language codes???
    * For the wallet display language??
    */
    @JsonProperty("lang")
    @SerializedName("lang")
    @ApiModelProperty(required = true, notes="Display language to use in wallet. Currently ignored by wallet. Use ISO 639-1 standard language codes?")
    var lang : String,

    /**
     * Family name transliterated
    * ICAO 9303 transliterated
    * For 1 and 2
    */
    @JsonProperty("fnt")
    @SerializedName("fnt")
    @ApiModelProperty(required = false, notes="Unused. Remove.")
    var fnt : String?,

    /**
     * Given name transliterated
    * ICAO 9303 transliterated
    * For 1 and 2
    */
    @JsonProperty("gnt")
    @SerializedName("gnt")
    @ApiModelProperty(required = false, notes="Unused. Remove.")
    var gnt : String?,

    /**
    * Various formats:
    * 1979-04-14 or 1901-08 or 1950
    * For 1 and 2
    */
    @JsonProperty("dob")
    @SerializedName("dob")
    @ApiModelProperty(required = false, notes="Unused. Remove.")
    var dob : String?,

    /**
     * portOfArrival
     * */
    @JsonProperty("poa")
    @SerializedName("poa")
    @ApiModelProperty(required = true, notes="Port of arrival - which standard?")
    var poa : String,

    /**
    * portOfDeparture
    */
    @JsonProperty("pod")
    @SerializedName("pod")
    @ApiModelProperty(required = true, notes="Port of departure - which standard?")
    var pod : String,

    /**
     * countryOfArrival
    * ISO 3166-1 alpha-2
    * For 2
    * e.g. NL
     *
    */
    @JsonProperty("coa")
    @SerializedName("coa")
    @ApiModelProperty(required = true, notes="Country of arrival - ISO 3166-1 alpha-2 e.g. NL")
    var coa:String,

    /**
     * countryOfDeparture
    * ISO 3166-1 alpha-2
    * For 2
    * e.g. NL
    */
    @JsonProperty("cod")
    @SerializedName("cod")
    @ApiModelProperty(required = true, notes="Country of departure - ISO 3166-1 alpha-2 e.g. NL")
    var cod : String,

    /**
     * regionOfArrival
    * ISO 3166-2 without Country
    * For 2
    * e.g. NL
    */
    @JsonProperty("roa")
    @SerializedName("roa")
    @ApiModelProperty(required = true, notes="Country of arrival - ISO 3166-2 without country.")
    var roa : String,

    /**
     * regionOfDeparture
    * ISO 3166-2 without Country
    * For 2
    * e.g. NL
    */
    @JsonProperty("rod")
    @SerializedName("rod")
    @ApiModelProperty(required = true, notes="Country of departure - ISO 3166-2 without country.")
    var rod : String,

    /**
     * dccTypes
    * Type of DCC
    * For 0,1,2
    * Values v, t, r, tp, tr
     * NB! Has tp
    */
    @JsonProperty("type")
    @SerializedName("type")
    @ApiModelProperty(required = true, notes="TBD. Unused?")
    var type : Array<String>,

    /**
     * categories
    * e.g. Inter-Flight, Concert, Domestic, MassEvent > 1000, etc.
    * Category which  shall be reflected in the Validation by additional rules/logic. If null, Standard Business Rule Check will apply.
    * Default: “Standard”
    * For 2
    */
    @JsonProperty("category")
    @SerializedName("category")
    @ApiModelProperty(required = true, notes = "e.g. Inter-Flight, Concert, Domestic, MassEvent > 1000, etc. Category which shall be reflected in the validation by additional rules/logic. If null, Standard Business Rule Check will apply. Default: Standard", example = "Standard")
    var category : Array<String>,

    /**
    * Date where the DCC must be validatable.
    * ISO8601 with time and offset e.g. 2021-01-29T12:00:00+01:00
    * For 1,2
    */
    @ApiModelProperty(required = true, notes = "Date where the DCC must be validatable. ISO8601 with time and offset e.g. 2021-01-29T12:00:00+01:00.")
    var validationClock : String,

    /**
     * whenValidStart
    *  DCC must be valid from this date.
    * ISO8601 with time and offset e.g. 2021-01-29T12:00:00+01:00
    * For 0,1,2
    */
    @JsonProperty("validfrom")
    @SerializedName("validfrom")
    @ApiModelProperty(required = true,notes="DCC must be valid from this date. ISO8601 with time and offset e.g. 2021-01-29T12:00:00+01:00.")
    var validfrom : String,

    /**
     * whenValidEnd
    * DCC must be valid minimum to this date.
    * ISO8601 with time and offset e.g. 2021-01-29T12:00:00+01:00
    * For 0,1,2
    */
    @JsonProperty("validTo")
    @SerializedName("validTo")
    @ApiModelProperty(required = true,notes="DCC must be valid up to this date. ISO8601 with time and offset e.g. 2021-01-29T12:00:00+01:00.")
    var validTo : String
)