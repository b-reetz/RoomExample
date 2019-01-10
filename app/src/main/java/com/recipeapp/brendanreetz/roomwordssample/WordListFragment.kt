package com.recipeapp.brendanreetz.roomwordssample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.recipeapp.brendanreetz.roomwordssample.R.id.newWordFragment2
import com.recipeapp.brendanreetz.roomwordssample.R.layout.fragment_word_list
import com.recipeapp.brendanreetz.roomwordssample.data.db.models.Word
import kotlinx.android.synthetic.main.fragment_word_list.view.*

class WordListFragment : androidx.fragment.app.Fragment() {

    private val wordViewModel: WordViewModel by lazy {
        ViewModelProviders.of(activity!!).get(WordViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(fragment_word_list, container, false)
        view.fab.setOnClickListener(Navigation.createNavigateOnClickListener(newWordFragment2))


        val wordListAdapter = WordListAdapter()
        wordViewModel.allWords.observe(
            this,
            Observer<List<Word>> { words -> wordListAdapter.setWords(words) })

        view.recycler_view?.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = wordListAdapter

        }

        return view
    }
}
