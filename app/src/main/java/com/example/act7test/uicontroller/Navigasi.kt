import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.act7test.model.DataJK.JenisK
import com.example.act7test.view.TampilData
import com.example.act7test.view.Formulir
import com.example.act7test.viewmodel.SiswaViewModel

enum class Navigasi {
    Formulir,
    Detail
}

@Composable
fun DataApp(
    viewModel: SiswaViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    Scaffold { isiRuang ->
        val uiState = viewModel.statusUI.collectAsState()
        NavHost(
            navController = navController,
            startDestination = Navigasi.Formulir.name,
            modifier = Modifier.padding(isiRuang)
        ) {
            composable(route = Navigasi.Formulir.name) {
                val konteks = LocalContext.current
                Formulir(
                    pilihanJK = JenisK,
                    viewModel = viewModel,
                    onSubmitButtonClicked = {
                        viewModel.setSiswa(it)
                        navController.navigate(route = Navigasi.Detail.name)
                    }
                )
            }
            composable(route = Navigasi.Detail.name) {
                TampilData(
                    statusUiSiswa = uiState.value,
                    viewModel = viewModel,
                    onBackButtonClicked = { cancelAndBackToFormulir(navController) }
                )
            }
        }
    }
}

private fun cancelAndBackToFormulir(
    navController: NavHostController
): Boolean {
    return navController.popBackStack(
        route = Navigasi.Formulir.name,
        inclusive = false
    )
}
