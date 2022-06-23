package nl.rijksoverheid.minienw.travelvalidation.api.data.token

import com.google.gson.annotations.SerializedName



import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.annotations.ApiModelProperty

data class InitiatingQrTokenPayload
(
    @JsonProperty("iss")
    @SerializedName("iss")
    @ApiModelProperty(required = true, notes="Url of the airline/service provider. TBD should be identity document of issuing service?")
    val issuer:String,

    @JsonProperty("iat")
    @SerializedName("iat")
    @ApiModelProperty(required = true, notes="Time of issue in Unix epoch time.")
    val whenIssued:Long,

    @JsonProperty("exp")
    @SerializedName("exp")
    @ApiModelProperty(required = true, notes="Time of expiry in Unix epoch time.")
    val whenExpires: Long,

    @JsonProperty("sub")
    @SerializedName("sub")
    @ApiModelProperty(required = true, notes = "Service provider (airline) identifier for the trip/traveller. GUID formatted as hex (no hyphens).")
    val subject:String,
)

/// <summary>
/// 3.8.1 Initialization QR Code Content
/// Called InitializationQrCodeContent in another doc/code
/// </summary>
data class InitiatingQrPayload
    (
    /// <summary>
    /// Type of the requested protocol
    /// </summary>
    @ApiModelProperty(required = true, notes = "Name of protocol.")
    var protocol:String = "DCCVALIDATION",

    /// <summary>
    /// SemVer version number
    /// </summary>
    @ApiModelProperty(required = true, notes="Protocol version - use this value in any required header named 'x-version'.")
    val protocolVersion :String = "2.00",

    /// <summary>
    /// </summary>
    @ApiModelProperty(required = true, notes="TBD...")
    val serviceIdentity :String,

    /// <summary>
    /// A separate privacy statement url with additional data processing information.
    /// </summary>
    @ApiModelProperty(required = true, notes="Url hosted by the airline/service provider of a separate privacy statement url with additional data processing information.")
    val privacyUrl :String,

    /// <summary>
    /// This token is generated to access the Validation Decorator endpoints and contains the information about the booking.
    /// <see cref="SubjectValidationDecoratorAccessToken" />
    /// </summary>
    @ApiModelProperty(required = true, notes="JWT of InitiatingQrTokenPayload.")
    val token :String,

    /// <summary>
    /// Consent text which is shown to the user by the wallet app
    /// </summary>
    @ApiModelProperty(required = true, notes="Two items of plain text given the consent text to use in the wallet for 1) at the point of sending a DCC 2) at the point of sending the result back.")
    val consent :String,

    ///<summary>
    // e.g. Booking Nr.1234
    // Plain text
    ///</summary>
    @ApiModelProperty(required = true, notes="Plain text of trip identifer e.g. Booking Nr.1234.")
    val subject :String,

    /// <summary>
    /// e.g. Airline name
    /// </summary>
    @ApiModelProperty(required = true, notes="Plain text of service provider's name.")
    val serviceProvider :String
)