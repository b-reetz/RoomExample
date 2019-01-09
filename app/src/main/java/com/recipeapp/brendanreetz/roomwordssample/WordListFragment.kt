package com.recipeapp.brendanreetz.roomwordssample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.recipeapp.brendanreetz.roomwordssample.data.db.models.Word
import kotlinx.android.synthetic.main.fragment_word_list.view.*

class WordListFragment : androidx.fragment.app.Fragment() {

    private lateinit var wordListAdapter: WordListAdapter
    private lateinit var wordViewModel: WordViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(R.layout.fragment_word_list, container, false)

        view.fab.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.newWordFragment2))

        if (view.id == R.id.fragment_base_layout) {
            wordListAdapter = WordListAdapter(context!!)

            wordViewModel = ViewModelProviders.of(this).get(WordViewModel::class.java)
            wordViewModel.allWords.observe(this, Observer<List<Word>> { words -> wordListAdapter.setWords(words) })

            view.recycler_view.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = wordListAdapter

            }
        }
        return view
    }
}
