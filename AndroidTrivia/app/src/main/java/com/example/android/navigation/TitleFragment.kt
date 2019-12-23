package com.example.android.navigation


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.android.navigation.databinding.FragmentTitleBinding
class TitleFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding =DataBindingUtil.inflate<FragmentTitleBinding>(inflater,R.layout.fragment_title,container,false)
        binding.playButton.setOnClickListener{
           // it.findNavController().navigate(R.id.action_titleFragment_to_gameFragment)
            Navigation.findNavController(it).navigate(R.id.action_titleFragment_to_gameFragment  )
            Toast.makeText(context,"clicked",Toast.LENGTH_SHORT).show()
         //   Navigation.createNavigateOnClickListener(R.id.action_titleFragment_to_gameFragment)
        }
        return binding.root
    }


}
