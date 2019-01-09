package com.recipeapp.brendanreetz.roomwordssample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.recipeapp.brendanreetz.roomwordssample.data.db.models.Word
import kotlinx.android.synthetic.main.fragment_new_word.*
import kotlinx.android.synthetic.main.fragment_new_word.view.*

class NewWordFragment : androidx.fragment.app.Fragment() {

    private lateinit var wordViewModel: WordViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        wordViewModel = ViewModelProviders.of(this).get(WordViewModel::class.java)

        val view = inflater.inflate(R.layout.fragment_new_word, container, false)

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
