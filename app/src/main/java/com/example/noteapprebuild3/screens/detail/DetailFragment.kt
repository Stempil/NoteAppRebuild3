package com.example.noteapprebuild3.screens.detail

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.noteapprebuild3.CONST.KEY
import com.example.noteapprebuild3.R
import com.example.noteapprebuild3.databinding.FragmentDetailBinding
import com.example.noteapprebuild3.model.NoteModel


class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private lateinit var currentNote: NoteModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)

        //получаем данные из выбранного элемента
        fun getParcel(): NoteModel {
            return if (Build.VERSION.SDK_INT >= 33) {
                arguments?.getParcelable(KEY, NoteModel::class.java) as NoteModel
            } else {
                arguments?.getParcelable(KEY)!!
            }
        }

        currentNote = getParcel()

        return binding.root


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()


    }

    //заполняем экран и вешаем слушатели на кнопки
    private fun init() {
        val viewModel: DetailViewModel by viewModels()
        binding.etTitle.text = currentNote.title
        binding.etDesc.text = currentNote.description

        binding.btnDelete.setOnClickListener {
            viewModel.deleteNote(currentNote) {}
            findNavController().navigate(R.id.action_detailFragment_to_startFragment)
        }

        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_detailFragment_to_startFragment)
        }
    }

}