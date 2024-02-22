package com.felipegandra.calculodejuros.juros

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.felipegandra.calculodejuros.calculos.calcularJuros
import com.felipegandra.calculodejuros.calculos.calcularMontante

class JurosScreenViewModel : ViewModel() {

    private val _capital = MutableLiveData<String>()
    val capital: LiveData<String> = _capital
    fun onCapitalChanged(newCapital : String) { _capital.value = newCapital }



    private val _taxa = MutableLiveData<String>()
    val taxa: LiveData<String> = _taxa
    fun onTaxaChanged(newTaxa : String) { _taxa.value = newTaxa }



    private val _tempo = MutableLiveData<String>()
    val tempo: LiveData<String> = _tempo
    fun onTempoChanged(newTempo : String) { _tempo.value = newTempo }



    private val _juros = MutableLiveData<Double>()
    val juros: LiveData<Double> = _juros
    fun calcularJurosViewModel() { _juros.value = calcularJuros(capital.value!!.toDouble(), taxa.value!!.toDouble(), tempo.value!!.toDouble()) }



    private val _montante = MutableLiveData<Double>()
    val montante: LiveData<Double> = _montante
    fun calcularMontanteViewModel() { _montante.value = calcularMontante(capital.value!!.toDouble(), juros.value!!.toDouble()) }

}