package ca.bc.gov.shcdecoder

import ca.bc.gov.shcdecoder.model.DefaultJWKSKeys
import ca.bc.gov.shcdecoder.model.JwksKey
import ca.bc.gov.shcdecoder.model.Rule

internal const val VALID_FULLY_IMMUNIZED_SHC_URI = "shc:/5676290952432060346029243740446031222959532654603460292540772804336028702864716745222809286133314564376531415906402203064504590856435503414245413640370636654171372412363803043756220467374075323239254334433260573601104128125312707425357469745673363745252404076371614204366629033029240527745835041226387507445520406869553635001261102939672426386742702531683972107103555636000553682438630372754325762839456421225824680926317036044040334408766112280634102908097663033508055022776568664444323766396827723059290960005076242528060670383469440844625306597406080565236929557576676121686311763064555721522853413832057032032035394162660831095668595024324562685605407376405762620725761077322156726303505623533936632330557558035609645606230940550560583566712652046675325607200054624540276953120977442027576340760726277761352043617033112163636709225860615530702104547239557667624275681131340321337229401242302404502964203924456342566307284339253505692043757266413557505752657577337429441105543709272661302824364559772043444367336255314161372937425769586465623272625345063774672724286254066609572656554372433410076940563725404000220745742654645320660408226035264025097474047253307130743126370739047541684050300443666976245254703427563158455034676821716361706631324556043924272971110753116933256055270845317137665554761257117535566373094064503553724100103569397228557110751268566125500930572535057250325660564006395374016252660645212843592075501033007006357640103269773827707035385327442245370076773240693939123468412500574144555039656944755544436943343838565225521200377400760061653506263374"

internal const val TEST_UNSIGNED_PAYLOAD = "eyJ6aXAiOiJERUYiLCJhbGciOiJFUzI1NiIsImtpZCI6IjNLZmRnLVh3UC03Z1h5eXd0VWZVQUR3QnVtRE9QS01ReC1pRUxMMTFXOXMifQ.7VI9b9swFPwrwevQRZFE14ltjW1QoJ0KJE2HwgP19GSx4YdAUqrdQP-9j7JTpEGSpWsFLqTu7t0deQ-2bqESl0uxXFyITZmBCgEq6GLsQ1UUNY5yj9I3O7J56yl0P52_CznqoYYMRoTqHuKhJ6i-_yEFI33sSOrY5Ykb3hw352nDrJdxypjBql8yKmdfBaIbVSM2sM0APTVko5L6eqh_EMZkqe2UvyUfkk4Fy7zMBeul0_eDbTQlDKdxg0e6me3D6Ud2igPotGa1oxMe4A-ckZUHrb96zYAHflUy4GHzjPAXjsN8Bllp6CgijdKsB1cuTdypkWxq8LO0BNuJU9WKE1_JmATEZlWel4IXTFP2rAXxuoVPf_fanxzNwJY82cR6HGjKIEQZhzAXYXpNkdLVjRJRWfrgmnkMukbZ3RwpHEIkc3o6fGedXuXO74rUeRFUU-C4ZwGcmbAo15CiPGUF6ww1ubKtKwLGR4T1xVqU_K1XoryEacsOHeLgZ_OpqBtljsoLMZe1TEHJt84b8rNFidH5ZLtRodcy9f8xPelv6Um_PbuV-7PrTuIdt7x9qejF_6KfFP2u_MeieU3Tbw"
internal const val TEST_JWK_SIGNATURE = "kao3ZBIXhAx_7N-s3PyU7MrzSHssPSbHYCZR-yzMUrTT9OqVF-fVYd_TnrYxdYXrXOSSeaFa9-Rw-y-jnP3GNw"

internal const val SUFFIX_JWKS_JSON = "/.well-known/jwks.json"
internal const val SUFFIX_ISSUERS = "issuers.json"

internal const val TEST_ISS = "https://bcvaxcardgen.freshworks.club"
internal const val TEST_ISS_WITH_SUFFIX = "https://bcvaxcardgen.freshworks.club$SUFFIX_JWKS_JSON"
internal const val TEST_KID = "3Kfdg-XwP-7gXyywtUfUADwBumDOPKMQx-iELL11W9s"

internal val defaultRule = Rule(
    daysSinceLastInterval = 21,
    intervalRequired = true,
    mixTypesAllowed = false,
    mixTypesRuRequired = 3,
    ruRequired = 2,
    ruleTarget = TEST_ISS_WITH_SUFFIX,
    version = "V1",
    vaccinationRules = emptyList(),
    exemptions = emptyList()
)

internal val defaultKey = JwksKey(
    kty = "EC",
    kid = "3Kfdg-XwP-7gXyywtUfUADwBumDOPKMQx-iELL11W9s",
    use = "sig",
    alg = "ES256",
    crv = "P-256",
    x = "11XvRWy1I2S0EyJlyf_bWfw_TQ5CJJNLw78bHXNxcgw",
    y = "eZXwxvO1hvCY0KucrPfKo7yAyMT6Ajc3N7OkAB6VYy8",
    x5c = emptyList()
)

internal val config = SHCConfig(
    "https://phsasmarthealthcard-dev.azurewebsites.net/v1/trusted/.well-known/issuers.json",
    "https://ds9mwekyyprcy.cloudfront.net/rules.json",
    listOf(
        DefaultJWKSKeys(
            iss = TEST_ISS,
            jwksKeys = listOf(defaultKey)
        )
    ),
    listOf(
        defaultRule
    ),
    120000L
)
