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
 * Use the [GameFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GameFragment : Fragment() {
    private lateinit var gameButton : Button
    private var score = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_game, container, false)
        Log.d("WWD", "game fragment onCreateView")
        gameButton = view.findViewById<Button>(R.id.game_button)
        gameButton.setOnClickListener {
            score++
            Log.d("WWD", "the score is $score")
            if (score > 3) {
                view.findNavController().navigate(GameFragmentDirections.actionGameFragmentToScoreFragment())
            }
        }
        return view
    }
}