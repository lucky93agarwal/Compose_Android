import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class ApiViewModel : ViewModel() {


    private val _userData = MutableLiveData<List<UserData>>()
    val userData: LiveData<List<UserData>> get() = _userData

    init {
        // Fetch data when the ViewModel is created
        fetchData()
    }

    private fun fetchData() {
        GlobalScope.launch(Dispatchers.IO) {
            try {
                val url = URL("https://reqres.in/api/users?page=1")
                val connection: HttpURLConnection = url.openConnection() as HttpURLConnection
                connection.requestMethod = "GET"
                connection.connect()

                val responseCode: Int = connection.responseCode
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    val inputReader = BufferedReader(InputStreamReader(connection.inputStream))
                    val response = inputReader.readText()

                    // Parse the JSON response using a library like Gson
                    // For simplicity, we're using a simple approach here
                    val apiResponse = parseJsonResponse(response)
                    _userData.postValue(apiResponse?.data)
                }
            } catch (e: Exception) {
                // Handle error
                e.printStackTrace()
            }
        }
    }

    private fun parseJsonResponse(response: String): ApiResponse? {
        return try {
            val gson = Gson()
            gson.fromJson(response, ApiResponse::class.java)
        } catch (e: Exception) {
            // Handle parsing error
            e.printStackTrace()
            null
        }
    }
}