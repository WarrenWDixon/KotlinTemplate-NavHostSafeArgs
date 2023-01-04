package com.warrendixon.kotlinnavigationsafeargsdemo

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController

/**
 * A simple [Fragment] subclass.
 * Use the [TitleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TitleFragment : Fragment() {
    private lateinit var startButton : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        var view : View = inflater.inflate(R.layout.fragment_title, container, false)
        startButton = view.findViewById<Button>(R.id.start_button)
        Log.d("WWD", "title fragment onCreateView")
        startButton.setOnClickListener {
            Log.d("WWD", "title fragment start button clicked")
            view.findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToGameFragment())
            Log.d("WWD", "title fragment stasrt button clicked after navigate")
        }
        return view
    }

}