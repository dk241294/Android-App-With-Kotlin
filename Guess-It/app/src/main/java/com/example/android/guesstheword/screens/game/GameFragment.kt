package com.example.android.guesstheword.screens.game

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.example.android.guesstheword.R
import com.example.android.guesstheword.databinding.GameFragmentBinding

/**
 * Fragment where the game is played
 */
class GameFragment : Fragment() {
    lateinit var viewModel: GameViewModel


    private lateinit var binding: GameFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
                inflater,
                R.layout.game_fragment,
                container,
                false
        )
        Log.i("GameFragment", "called viewmodelProvider of !")
        viewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)

        /**
         * Called when the game is finished
         */
         fun gameFinished() {
            val action = GameFragmentDirections.actionGameToScore(viewModel.score)
            NavHostFragment.findNavController(this).navigate(action)
        }


        binding.correctButton.setOnClickListener {
            viewModel.onCorrect()
            updateScoreText()
            updateWordText()
        }
        binding.skipButton.setOnClickListener {
            viewModel.onSkip()
            updateScoreText()
            updateWordText()
        }
        updateScoreText()
        updateWordText()
        return binding.root

    }


    /** Methods for updating the UI **/

    fun updateWordText() {
        binding.wordText.text = viewModel.word

    }

    fun updateScoreText() {
        binding.scoreText.text = viewModel.score.toString()
    }
}
