package com.warrendixon.kotlinnavigationsafeargsdemo

import android.os.Bundle
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
 * Use the [ScoreFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ScoreFragment : Fragment() {
    private lateinit var finalScore : TextView
    private lateinit var exitButton : Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        (activity as AppCompatActivity?)?.supportActionBar?.title = "SAFE ARGS3"
        val view: View =  inflater.inflate(R.layout.fragment_score, container, false)
        //(activity as AppCompatActivity?)?.supportActionBar?.title = "SAFE ARGS"
        // get score from game fragment and display
        val args = ScoreFragmentArgs.fromBundle(requireArguments())
        val score: Int = args.score
        finalScore = view.findViewById<TextView>(R.id.final_score)
        finalScore.text = "You Clicked $score Times"

        exitButton = view.findViewById(R.id.exit_button)
        exitButton.setOnClickListener { v ->
            v.findNavController().navigate(ScoreFragmentDirections.actionScoreFragmentToTitleFragment())
        }

        return view
    }

    override fun onResume() {
        super.onResume()
    }

}