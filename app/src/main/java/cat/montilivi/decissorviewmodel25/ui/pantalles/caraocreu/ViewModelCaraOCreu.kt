package cat.montilivi.decissorviewmodel25.ui.pantalles.caraocreu

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CaraoCreuViewModel: ViewModel(){

    var estat by mutableStateOf(CaraOCreuEstat())
        private set

    init {

        estat = CaraOCreuEstat(resultat = 0, estaSortejant = false)

    }

    fun Sorteja (tempsEspera: Long)
    {
        estat = estat.copy(estaSortejant = true)
        viewModelScope.launch(Dispatchers.IO){
            estat = estat.copy(resultat = 0)
            delay(tempsEspera)
            estat = estat.copy(resultat = (1..2).random(), estaSortejant = false)
        }

    }
}

data class CaraOCreuEstat(

    val estaSortejant: Boolean = false,
    val resultat: Int = 0,
)