package nl.rijksoverheid.minienw.travelvalidation.api.data

data class JwtHeader(
    val kid: String,
    val alg: String,
)