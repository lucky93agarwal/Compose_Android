data class UserData(
    val id: Int,
    val email: String,
    val firstName: String,
    val lastName: String,
    val avatar: String
)

data class ApiResponse(
    val page: Int,
    val perPage: Int,
    val total: Int,
    val totalPages: Int,
    val data: List<UserData>,
    val support: Support
)

data class Support(
    val url: String,
    val text: String
)