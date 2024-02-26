
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.msl.myfirstcomposeproject.LoginActivity
import com.msl.myfirstcomposeproject.SplashActivity

@Composable
fun AppNavigator(navController: NavHostController) {
    NavHost(navController, startDestination = "splash") {
        composable("splash") {
            // Content of screen 1
            SplashCom(navController)
        }
        composable("login") {
            // Content of screen 2
            LoginCom(navController)
        }
    }
}