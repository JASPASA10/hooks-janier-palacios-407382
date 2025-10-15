import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {

    companion object {
        private const val TAG = "MainActivityLifecycle"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate - La actividad se está creando o recreando.")
        setContent { MyComposableScreen() }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart - La actividad se está haciendo visible.")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume - La actividad está lista para interactuar.")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause - Otra actividad está en primer plano o es un diálogo.")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop - La actividad ya no es visible.")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart - La actividad se ha detenido y se está reiniciando.")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy - La actividad está a punto de ser destruida.")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "onSaveInstanceState - Guardando el estado antes de la destrucción potencial.")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(TAG, "onRestoreInstanceState - Restaurando el estado de la actividad recreada.")
    }
}

@Composable
fun MyComposableScreen() {
    var count by rememberSaveable { mutableStateOf(0) }

    Scaffold(
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Button(onClick = { count++ }) {
                    Text("Contador: $count")
                }
            }
        }
    )
}
