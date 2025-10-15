# Proyecto Hooks – Ciclo de Vida y Gestión de Estado

**Autor:** Janier Palacios  
**Código:** 407382  
**Curso:** Programación Móvil con Android  
**Repositorio:** hooks-janier-palacios-407382

---

## Objetivo General
Implementar los **Hooks del Ciclo de Vida** de una actividad en Android y registrar cada evento en la consola (**Logcat**), además de usar **`rememberSaveable`** para mantener el estado tras cambios de configuración (por ejemplo, al rotar la pantalla).

---

## Estructura del Proyecto

| Rama | Descripción |
|------|--------------|
| `hook-activity-2-01` | Registro de cada ciclo de vida (`onCreate`, `onStart`, etc.) con `Log.d` |
| `hook-activity-2-02` | Implementación básica de `rememberSaveable` |
| `hook-activity-2-03` | Conservación del estado al rotar la pantalla |
| `hook-activity-2-04` | Añadir contador persistente |
| `hook-activity-2-05` | Mostrar valor guardado en consola |
| `hook-activity-2-06` | Versión final con todos los hooks y estado persistente |

---

## Código Base – `MainActivity.kt`

```kotlin
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.*

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
        content = {
            Button(onClick = { count++ }) {
                Text("Contador: $count")
            }
        }
    )
}
```

---

## Instrucciones de Uso

1. **Abrir el proyecto:** Importa el proyecto en Android Studio
2. **Ejecutar la aplicación:** Compila y ejecuta en un dispositivo o emulador
3. **Observar los logs:** Abre Logcat y filtra por el tag "MainActivityLifecycle"
4. **Probar el ciclo de vida:** 
   - Minimiza y restaura la aplicación
   - Rota la pantalla
   - Observa cómo se mantiene el contador

---

## Funcionalidades Implementadas

-  **Ciclo de vida completo:** Todos los métodos del ciclo de vida están implementados
-  **Logging detallado:** Cada evento se registra en Logcat con descripciones en español
-  **Estado persistente:** El contador se mantiene al rotar la pantalla usando `rememberSaveable`
-  **Interfaz simple:** Botón que incrementa un contador para probar la persistencia

---


## Tecnologías Utilizadas

- **Kotlin** - Lenguaje de programación
- **Jetpack Compose** - Framework de UI moderna
- **Material Design 3** - Sistema de diseño
- **Android Activity Lifecycle** - Gestión del ciclo de vida
- **rememberSaveable** - Persistencia de estado en Compose
