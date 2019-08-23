package dev.moxy.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.moxy.R
import dev.moxy.repository.model.mNote
import kotlinx.android.synthetic.main.added_word_item.view.*

class AddedWordAdapter(private val items: List<mNote>) : RecyclerView.Adapter<ViewHolder>() {


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.added_word_item, p0,false))
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.word.setText("ete")
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

class ViewHolder(val view: View): RecyclerView.ViewHolder(view) {
    val word = view.word
    val translate = view.word_translate
    val butSave = view.but_save
}
