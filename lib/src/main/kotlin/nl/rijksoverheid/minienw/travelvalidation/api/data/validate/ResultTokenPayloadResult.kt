package nl.rijksoverheid.minienw.travelvalidation.api.data.validate

import io.swagger.annotations.ApiModelProperty

/**
 * TODO Map to this is a DCCFailableItem
* 3.8.5.3
* <see cref="nl.rijksoverheid.minienw.travelvalidation.validationservice.api.data.validate.ResultTokenPayload.Results" />
*/
class ResultTokenPayloadResult
    (
    /**
    * Identifier of the check (rule?)
    * e.g.VR-0001, CBOR, SIGNATURE etc.
    */
    @ApiModelProperty(required = true)
    var id : String,

    /**
    * Result of the check
    * OPEN (CHK)
    * FAILED (NOK)
    * PASSED (OK)
    */
    @ApiModelProperty(required = true, notes="Final result of the evaluation - OK = Passed, NOK = Fail, CHK = Cross Check(OPEN)")
    var result : String,

    /**
    * Type of the check
    * Values:
    * Technical Check
    * Issuer Invalidation
    * Destination Acceptance
    * Traveller Acceptance
    */
    @ApiModelProperty(required = true)
    var type : String,

    /**
    * Description of the checkup
    */
    @ApiModelProperty(required = true)
    var details : String,
)
