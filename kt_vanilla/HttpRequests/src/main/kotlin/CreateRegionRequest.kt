
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable


@Serializable
data class CreateRegionRequest(
    var name: String,
    var establishedDate: Instant = Clock.System.now(),
    var startDate: Instant = Clock.System.now(),
    var endDate: Instant = Clock.System.now(),
    var users: List<String>
)