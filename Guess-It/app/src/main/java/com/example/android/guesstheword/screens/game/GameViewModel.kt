package com.example.android.guesstheword.screens.game

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.NavHostFragment

class GameViewModel: ViewModel() {
    // The current word
     val word = MutableLiveData<String>()

    // The current score
    var score = MutableLiveData<Int>()

    // The list of words - the front of the list is the next word to guess
    private lateinit var wordList: MutableList<String>
    init {
        Log.i("Game view model","gameviewModel Created")
        resetList()
        nextWord()
        score.value=0
    }
    override fun onCleared() {
        super.onCleared()
        Log.i("Game View Model","game view model destroy")
    }
    /**
     * Resets the list of words and randomizes the order
     */
    private fun resetList() {
        wordList = mutableListOf(
                "queen",
                "hospital",
                "basketball",
                "cat",
                "change",
                "snail",
                "soup",
                "calendar",
                "sad",
                "desk",
                "guitar",
                "home",
                "railway",
                "zebra",
                "jelly",
                "car",
                "crow",
                "trade",
                "bag",
                "roll",
                "bubble"
        )
        wordList.shuffle()
    }


    /**
     * Moves to the next word in the list
     */
    private fun nextWord() {
        //Select and remove a word from the list
        if (wordList.isEmpty()) {
          //  gameFinished()
        } else {
            word.value = wordList.removeAt(0)
        }

    }

    /** Methods for buttons presses **/

     fun onSkip() {
        score.value = (score.value)?.minus(1)
        nextWord()
    }
     fun onCorrect() {
         score.value = (score.value)?.plus(1)
         nextWord()
     }

}