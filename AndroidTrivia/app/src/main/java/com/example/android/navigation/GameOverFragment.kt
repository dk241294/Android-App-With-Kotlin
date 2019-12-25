package com.example.android.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.android.navigation.databinding.FragmentGameOverBinding



class GameOverFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding: FragmentGameOverBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_game_over, container, false)
        binding.tryAgainButton.setOnClickListener { it.findNavController().navigate(GameOverFragmentDirections.actionGameOverFragmentToGameFragment())}
        var args:GameOverFragmentArgs= GameOverFragmentArgs.fromBundle(arguments!!)
        Toast.makeText(context,
                "NumQuestions: ${args.numQuestions},NumCorrect: ${args.numCorrect}",
                Toast.LENGTH_LONG).show()
        return binding.root
    }
}
