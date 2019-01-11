package com.recipeapp.brendanreetz.roomwordssample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.recipeapp.brendanreetz.roomwordssample.R.layout.recycler_view_item
import com.recipeapp.brendanreetz.roomwordssample.data.db.models.Word
import kotlinx.android.synthetic.main.recycler_view_item.view.*

class WordListAdapter : RecyclerView.Adapter<WordListAdapter.WordViewHolder>() {

    private var listOfWords = emptyList<Word>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        WordViewHolder(LayoutInflater.from(parent.context).inflate(recycler_view_item, parent, false))

    override fun getItemCount() = listOfWords.size

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.textView.text = listOfWords[position].word
    }

    fun setWords(words: List<Word>) {
        listOfWords = words
        notifyDataSetChanged()
    }

    class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.textView
    }
}