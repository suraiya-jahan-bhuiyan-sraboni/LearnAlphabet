package com.example.learnalphabet.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.learnalphabet.R

class LetterAdapter(
    private val clickListener: LetterClickListener,
    private val letters: List<String>
) : RecyclerView.Adapter<LetterAdapter.LetterViewHolder>() {

    interface LetterClickListener {
        fun onLetterClicked(letter: String)
    }

    class LetterViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val button:Button=itemView.findViewById(R.id.letter_button)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LetterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_letter, parent, false)
        return LetterViewHolder(view)
    }

    override fun onBindViewHolder(holder: LetterViewHolder, position: Int) {
        val letter = letters[position]
        holder.button.text=letter
        //holder.bind(letter, clickListener)
        // holder.button.text = letter
        holder.button.setOnClickListener { clickListener.onLetterClicked(letter) }

    }

    override fun getItemCount(): Int = letters.size
}


