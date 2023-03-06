package com.example.noteapprebuild3.screens.addnote

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.noteapprebuild3.R
import com.example.noteapprebuild3.databinding.FragmentAddNoteBinding
import com.example.noteapprebuild3.model.NoteModel


class AddNoteFragment : Fragment() {

    private lateinit var binding: FragmentAddNoteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()


    }

    private fun init() {
        val viewModel: AddNoteViewModel by viewModels()

        binding.btnSave.setOnClickListener {
            val title = binding.etTitle.text.toString()
            val desc = binding.etDesc.text.toString()
            viewModel.insertNote(NoteModel(title = title, description = desc)) {}
            findNavController().navigate(R.id.action_addNoteFragment_to_startFragment)

        }

        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_addNoteFragment_to_startFragment)
        }
    }
}