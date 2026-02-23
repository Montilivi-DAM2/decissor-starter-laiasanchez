package cat.montilivi.decissorviewmodel25.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import cat.institutmontivi.decissorviewmodel25.navegacio.DestinacioOracleResposta
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ViewModelOracleResposta(
    savedStateHandle: SavedStateHandle
): ViewModel(){
    var estat by mutableStateOf(OracleRespostaEstat())
        private set

    init {
        val arg = savedStateHandle.toRoute<DestinacioOracleResposta>()
        estat = estat.copy(
            pregunta = arg.pregunta,
            resposta = ""
        )
    }
    val respostes = listOf<String>(
        "Sí, definitivament.",
        "No, ni parlar-ne",
        "Potser sí",
        "Perquè no?",
        "Ni de conya",
        "Hi pots comptar",
        "Jo què sé!",
    )

    fun respon()
    {
        viewModelScope.launch {
            delay(500L)
            estat = estat.copy(
                resposta = respostes.random()
            )
        }
    }

    data class OracleRespostaEstat(
        val pregunta: String = "",
        val resposta: String = "",
    )
}