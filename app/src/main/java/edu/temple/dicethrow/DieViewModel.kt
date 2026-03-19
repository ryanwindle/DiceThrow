package edu.temple.dicethrow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class DieViewModel: ViewModel() {
    private val dieRoll = MutableLiveData<Int>()
    private var dieSides: Int = 6

    fun setSides(sides: Int){
        dieSides = sides
    }

    fun throwDie(){
        dieRoll.value = Random.nextInt(1, dieSides + 1)
    }

    fun getDieRoll(): LiveData<Int> {
        return dieRoll
    }


}