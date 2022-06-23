package nl.rijksoverheid.minienw.travelvalidation.api.data.validate

import com.fasterxml.jackson.annotation.JsonProperty
import com.google.gson.annotations.SerializedName
import io.swagger.annotations.ApiModelProperty

class DccExtract
(
/**
 * ICAO 9303 transliterated
 * For 1 and 2
 */
@SerializedName("fnt")
@JsonProperty("fnt")
@ApiModelProperty(required = true, notes="Surname value (ICAO 9303 transliterated) extracted from DCC.")
var surnameTransliterated : String?,

/**
 * ICAO 9303 transliterated
 * For 1 and 2
 */
@SerializedName("gnt")
@JsonProperty("gnt")
@ApiModelProperty(required = true, notes="Given name value (ICAO 9303 transliterated) extracted from DCC.")
var givenNameTransliterated : String?,

/**
 * Various formats:
 * 1979-04-14 or 1901-08 or 1950
 * For 1 and 2
 */
@SerializedName("dob")
@JsonProperty("dob")
@ApiModelProperty(required = true, notes="Date of birth value extracted from DCC e.g. 1979-04-14, 1901-08, 1950 etc.")
var dateOfBirth : String?,
)