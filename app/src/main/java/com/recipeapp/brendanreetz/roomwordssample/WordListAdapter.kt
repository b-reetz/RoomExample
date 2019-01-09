package com.recipeapp.brendanreetz.roomwordssample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.recipeapp.brendanreetz.roomwordssample.data.db.models.Word

class WordListAdapter(private val context: Context) : RecyclerView.Adapter<WordListAdapter.WordViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)
    private lateinit var listOfWords: List<Word>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder =
        WordViewHolder(layoutInflater.inflate(R.layout.recycler_view_item, parent, false))

    override fun getItemCount(): Int = if (this::listOfWords.isInitialized) listOfWords.size else 0

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        if (this::listOfWords.isInitialized)
            holder.textView.text = listOfWords[position].word
        else
            holder.textView.text = context.getString(R.string.no_word)
    }

    fun setWords(words: List<Word>) {
        listOfWords = words
        notifyDataSetChanged()
    }

    class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.textView)
    }
}