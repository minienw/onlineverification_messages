package nl.rijksoverheid.minienw.travelvalidation.api.data.identity

import com.fasterxml.jackson.annotation.JsonProperty
import com.google.gson.annotations.SerializedName
import io.swagger.annotations.ApiModelProperty

/**
 3.8.2.3 nl.rijksoverheid.minienw.travelvalidation.validationservice.api.data.identity.Service
*/
class Service
    (

    /*
    * ValidationService  | Validation nl.rijksoverheid.minienw.travelvalidation.validationservice.api.data.identity.Service | URL of the Validation nl.rijksoverheid.minienw.travelvalidation.validationservice.api.data.identity.Service protected by “ValidationServiceKey-x”
    * AccessTokenService | Validation Decorator | URL of the Access Token nl.rijksoverheid.minienw.travelvalidation.validationservice.api.data.identity.Service Endpoint protected by “AccessTokenServiceKey-x”
    * ServiceProvider  | Validation Decorator  | URL of the nl.rijksoverheid.minienw.travelvalidation.validationservice.api.data.identity.Service Provider protected by “ServiceProviderKey-x”
    * CancellationService  | Validation Decorator | URL of the Cancellation Endpoint protected by “CancellationServiceKey-x”
    * StatusService  | Validation Decorator | URL of the Status Endpoint protected by“StatusServiceKey-x”
    */

    /**
    ID of the Endpoint(must resolve to a Identity Document)
    All id values have to be prefixed by {serviceproviderurl} and a fragment value, e.g. https://servicepovider/validationservice#AccessCredentialService
    */
    @JsonProperty("id")
    @SerializedName("id")
    @ApiModelProperty(required = true, notes = "ID of the Endpoint(must resolve to a Identity Document). All id values have to be prefixed by {serviceproviderurl} and a fragment value, e.g. https://servicepovider/validationservice#AccessCredentialService.")
    var id : String,

    /**
    One of first column from above table
    */
    @JsonProperty("type")
    @SerializedName("type")
    @ApiModelProperty(required = true, notes = "Value from AccessTokenService, ConfirmationService, ServiceProvider, InitializeService or ValidationService.")
    var type : String,

    /**
    Actual Uri
    */
    @JsonProperty("serviceEndpoint")
    @SerializedName("serviceEndpoint")
    @ApiModelProperty(required = true, notes = "Actual URI of endpoint.")
    var serviceEndpoint : String,

    /**
    "Human readable"
    */
    @JsonProperty("name")
    @SerializedName("name")
    @ApiModelProperty(required = true, notes="'Human-readable' name of service.")
    var name : String?,
)