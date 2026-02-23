package cat.montilivi.decissorviewmodel25.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ViewModelTriaNumero: ViewModel() {
    var estat by mutableStateOf(TriaNumeroEstat())
    private set

    init {
        estat = TriaNumeroEstat(
            minim = 0,
            maxim = 999,
            resultat = 555,
            tempsEspera = 1000,
            estaSortejant = false
        )
    }

    fun SortejaNumero(minim:Int, maxim:Int, tempsEspera:Long)
    {
        viewModelScope.launch {
            estat = estat.copy(
                minim = minim,
                maxim = maxim,
                tempsEspera = tempsEspera,
                estaSortejant = true
            )
            delay(tempsEspera)
            estat = estat.copy(
                resultat = (minim.. maxim).random(),
                estaSortejant = false
            )
        }

    }


    data class TriaNumeroEstat(
        val minim:Int = 0,
        val maxim:Int = 999,
        val resultat:Int = 555,
        val tempsEspera: Long = 1000,
        val estaSortejant: Boolean = false,
    )
}