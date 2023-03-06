package com.example.noteapprebuild3.screens.start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapprebuild3.CONST.KEY
import com.example.noteapprebuild3.R
import com.example.noteapprebuild3.adapter.NoteAdapter
import com.example.noteapprebuild3.databinding.FragmentStartBinding
import com.example.noteapprebuild3.model.NoteModel


class StartFragment : Fragment() {

    private lateinit var binding: FragmentStartBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: NoteAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //заполняем список
        init()

    }


    private fun init() {
        //Инициализируем viewModel
        val viewModel: StartViewModel by viewModels()
        viewModel.initDatabase()
        //Инициализируем RecyclerView
        recyclerView = binding.recyclerView
        adapter = NoteAdapter(this::onNoteClick)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        //подписываем RecyclerView на liveData
        viewModel.getAllNotes().observe(viewLifecycleOwner) {
            adapter.updateList(it.asReversed())
        }

        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.action_startFragment_to_addNoteFragment)
        }
    }

    //передаем данные выбраного элемента списка
    private fun onNoteClick(noteModel: NoteModel) {
        val bundle = Bundle()

        bundle.putParcelable(KEY, noteModel)
        findNavController().navigate(R.id.detailFragment, bundle)
    }

}