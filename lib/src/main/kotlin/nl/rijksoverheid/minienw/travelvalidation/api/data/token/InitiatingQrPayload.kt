package nl.rijksoverheid.minienw.travelvalidation.api.data.token

import com.google.gson.annotations.SerializedName



import com.fasterxml.jackson.annotation.JsonProperty
data class InitiatingQrTokenPayload
    (
    val issuer:String,

    @JsonProperty("iat")
    @SerializedName("iat")
    val whenIssued:Long,

    @JsonProperty("exp")
    @SerializedName("exp")
    val whenExpires: Long,

    @JsonProperty("sub")
    @SerializedName("sub")
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
    var protocol:String = "DCCVALIDATION",

    /// <summary>
    /// SemVer version number
    /// </summary>
    val protocolVersion :String = "2.00",

    /// <summary>
    /// </summary>
    val serviceIdentity :String,

    /// <summary>
    /// A separate privacy statement url with additional data processing information.
    /// TODO who writes and hosts this?
    /// </summary>
    val privacyUrl :String,

    /// <summary>
    /// This token is generated to access the Validation Decorator endpoints and contains the information about the booking.
    /// TODO JWT or JWK RFC7517 ?
    /// <see cref="SubjectValidationDecoratorAccessToken" />
    /// </summary>
    val token :String,

    /// <summary>
    /// Consent text which is shown to the user by the wallet app
    /// </summary>
    val consent :String,

    ///<summary>
    // e.g. Booking Nr.1234
    // Plain text
    ///</summary>
    val subject :String,

    /// <summary>
    /// e.g. Airline name
    /// </summary>
    val serviceProvider :String
)