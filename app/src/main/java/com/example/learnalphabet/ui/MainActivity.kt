package com.example.learnalphabet.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.learnalphabet.R
import com.example.learnalphabet.adapter.LetterAdapter
import com.example.learnalphabet.fragment.LetterFragment

class MainActivity : AppCompatActivity(), LetterAdapter.LetterClickListener {
    private lateinit var fragmentContainer: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentContainer = findViewById(R.id.fragment_container)

        val letters = ('A'..'Z').map { it.toString() }
        val letterAdapter = LetterAdapter(this, letters)
        val recyclerView=findViewById<RecyclerView>(R.id.letters_recycler_view)
        recyclerView.apply {
          layoutManager=LinearLayoutManager(this@MainActivity)
            adapter=letterAdapter
        }
    }

    override fun onLetterClicked(letter: String) {
        val fragment = LetterFragment.newInstance(letter)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
