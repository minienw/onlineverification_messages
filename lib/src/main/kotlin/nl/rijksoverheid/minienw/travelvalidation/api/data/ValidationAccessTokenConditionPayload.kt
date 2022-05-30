﻿package nl.rijksoverheid.minienw.travelvalidation.api.data

import com.fasterxml.jackson.annotation.JsonProperty
import com.google.gson.annotations.SerializedName

/**
* 3.8.4.3 Validation Access Token Payload Condition Structure
* The validation condition structure is embedded in the validation access token to fulfil two things:
* a) The validation validationservice knows the selected conditions by the validationservice provider/validation validationservice user
* b) The wallet app can select an appropriate certificate for the user with reference to the conditions
*/
data class ValidationAccessTokenConditionPayload
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
    var language : String,

    /**
    * ICAO 9303 transliterated
    * For 1 and 2
    */
    @JsonProperty("fnt")
    @SerializedName("fnt")
    var familyNameTransliterated : String?,

    /**
    * ICAO 9303 transliterated
    * For 1 and 2
    */
    @JsonProperty("gnt")
    @SerializedName("gnt")
    var givenNameTransliterated : String?,

    /**
    * Various formats:
    * 1979-04-14 or 1901-08 or 1950
    * For 1 and 2
    */
    @JsonProperty("dob")
    @SerializedName("dob")
    var dateOfBirth : String?,

    @JsonProperty("poa")
    @SerializedName("poa")
    var portOfArrival : String,

    @JsonProperty("pod")
    @SerializedName("pod")
    var portOfDeparture : String,

    /**
    * ISO 3166-1 alpha-2
    * For 2
    * e.g. NL
     *
    */
    @JsonProperty("coa")
    @SerializedName("coa")
    var countryOfArrival:String,

    /**
    * ISO 3166-1 alpha-2
    * For 2
    * e.g. NL
    */
    @JsonProperty("cod")
    @SerializedName("cod")
    var countryOfDeparture : String,

    /**
    * ISO 3166-2 without Country
    * For 2
    * e.g. NL
    */
    @JsonProperty("roa")
    @SerializedName("roa")
    var regionOfArrival : String,

    /**
    * ISO 3166-2 without Country
    * For 2
    * e.g. NL
    */
    @JsonProperty("rod")
    @SerializedName("rod")
    var regionOfDeparture : String,

    /**
    * Type of DCC
    * For 0,1,2
    * Values v, t, r, tp, tr
     * NB! Has tp
    */
    @JsonProperty("type")
    @SerializedName("type")
    var dccTypes : Array<String>,

    /**
    * e.g. Inter-Flight, Concert, Domestic, MassEvent > 1000, etc.
    * Category which  shall be reflected in the Validation by additional rules/logic. If null, Standard Business Rule Check will apply.
    * Default: “Standard”
    * For 2
    */
    @JsonProperty("category")
    @SerializedName("category")
    var categories : Array<String>,

    /**
    * Date where the DCC must be validatable.
    * ISO8601 with time and offset e.g. 2021-01-29T12:00:00+01:00
    * For 1,2
    */
    var validationClock : String,

    /**
    *  DCC must be valid from this date.
    * ISO8601 with time and offset e.g. 2021-01-29T12:00:00+01:00
    * For 0,1,2
    */
    @JsonProperty("validfrom")
    @SerializedName("validfrom")
    var whenValidStart : String,

    /**
    * DCC must be valid minimum to this date.
    * ISO8601 with time and offset e.g. 2021-01-29T12:00:00+01:00
    * For 0,1,2
    */
    @JsonProperty("validTo")
    @SerializedName("validTo")
    var whenValidEnd : String
)