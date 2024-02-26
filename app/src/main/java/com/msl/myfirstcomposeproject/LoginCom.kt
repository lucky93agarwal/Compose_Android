import android.widget.Toast
import androidx.activity.OnBackPressedDispatcherOwner
import androidx.activity.addCallback
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController

@Composable
fun LoginCom(navController: NavHostController) {
    val context = LocalContext.current
    val onBackPressedDispatcher =
        (LocalOnBackPressedDispatcherOwner.current as OnBackPressedDispatcherOwner).onBackPressedDispatcher

    // Custom back press handler
    DisposableEffect(context) {
        val callback = onBackPressedDispatcher.addCallback {
            Toast.makeText(context, "onBack", Toast.LENGTH_SHORT).show()

        }

        onDispose {
            callback.remove()
        }
    }
    Text(
        text = "Hello Login!",

        )
}

@Composable
fun UserList(userViewModel: ApiViewModel = viewModel()) {
    val userData by userViewModel.userData.observeAsState(emptyList())

    LazyColumn {
        items(userData) { user ->
            UserListItem(user)
        }
    }
}

@Composable
fun UserListItem(user: UserData) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.Gray)
            .padding(16.dp)
    ) {
        Text(text = "ID: ${user.id}", fontWeight = FontWeight.Bold)
        Text(text = "Email: ${user.email}")
        Text(text = "First Name: ${user.firstName}")
        Text(text = "Last Name: ${user.lastName}")
        // You can load the image using a library like Coil or Picasso
        // For simplicity, we are not loading the image in this example
        Text(text = "Avatar: ${user.avatar}")
    }
}