package com.example.android.guesstheword.screens.game

import android.util.Log
import androidx.lifecycle.ViewModel

class GameViewModel: ViewModel() {
    init {
        Log.i("Game view model","gameviewModel Created")
    }
    override fun onCleared() {
        super.onCleared()
        Log.i("Game View Model","game view model destroy")
    }
}