package com.example.android.navigation


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.navigation.databinding.FragmentTitleBinding

class TitleFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentTitleBinding>(inflater, R.layout.fragment_title, container, false)
        binding.playButton.setOnClickListener {
            // it.findNavController().navigate(R.id.action_titleFragment_to_gameFragment)
            Navigation.findNavController(it).navigate(R.id.action_titleFragment_to_gameFragment)
            Toast.makeText(context, "clicked", Toast.LENGTH_SHORT).show()
            //   Navigation.createNavigateOnClickListener(R.id.action_titleFragment_to_gameFragment)

            // we need to tell Android that our TitleFragment has a menu
            setHasOptionsMenu(true)
        }
        return binding.root
    }

    // we need to override onCreateOptionsMenu and inflate our new menu resource using the provided menu inflater and menu structure.
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    //we need to override onOptionsItemSelected to connect it to our NavigationUI.
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item,
                view!!.findNavController())
                || super.onOptionsItemSelected(item)
    }

}


