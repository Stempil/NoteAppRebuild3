package com.example.noteapprebuild3.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapprebuild3.databinding.ItemLayoutBinding
import com.example.noteapprebuild3.model.NoteModel

class NoteAdapter(val onClick: (NoteModel) -> Unit) :
    RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    private var listNote = emptyList<NoteModel>()


    @SuppressLint("NotifyDataSetChanged")
    fun updateList(list: List<NoteModel>) {
        listNote = list
        notifyDataSetChanged()
    }

    class NoteViewHolder(val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {

        holder.binding.tvNoteTitle.text = listNote[position].title
        //слушатель на нажатие по элементу списка
        holder.binding.listNoteItem.setOnClickListener { onClick(listNote[position]) }
    }


    override fun getItemCount(): Int {
        return listNote.size
    }

}