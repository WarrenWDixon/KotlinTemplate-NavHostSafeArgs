package com.warrendixon.kotlinnavigationsafeargsdemo

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController

/**
 * A simple [Fragment] subclass.
 * Use the [GameFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GameFragment : Fragment() {
    private lateinit var countButton : Button
    private lateinit var endButton: Button
    private lateinit var currentScoreText : TextView
    private var score = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        (activity as AppCompatActivity?)?.supportActionBar?.title = "SAFE ARGS DEMO2"
        var view = inflater.inflate(R.layout.fragment_game, container, false)
        Log.d("WWD", "game fragment onCreateView")
        countButton = view.findViewById<Button>(R.id.count_button)
        currentScoreText   = view.findViewById(R.id.current_score)
        countButton.setOnClickListener {
            score++
            currentScoreText.text = score.toString();
            Log.d("WWD", "the score is $score")
        }
        endButton = view.findViewById(R.id.end_button)
        endButton.setOnClickListener { v ->
            v.findNavController().navigate(GameFragmentDirections.actionGameFragmentToScoreFragment(score))
        }

        return view
    }


}