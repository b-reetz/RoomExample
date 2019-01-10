package com.recipeapp.brendanreetz.roomwordssample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.recipeapp.brendanreetz.roomwordssample.R.layout.fragment_new_word
import com.recipeapp.brendanreetz.roomwordssample.data.db.models.Word
import kotlinx.android.synthetic.main.fragment_new_word.*
import kotlinx.android.synthetic.main.fragment_new_word.view.*

class NewWordFragment : androidx.fragment.app.Fragment() {

    private val wordViewModel: WordViewModel by lazy {
        ViewModelProviders.of(activity!!).get(WordViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(fragment_new_word, container, false)

        view.button_save.setOnClickListener {
            if (edit_word.text.toString().isNotBlank()) {
                wordViewModel.insert(Word(word = edit_word.text.toString()))
                findNavController().navigateUp()
            } else {
                Toast.makeText(activity, "Needs to have some characters", Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }
}
