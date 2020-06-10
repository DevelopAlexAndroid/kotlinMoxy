package dev.moxy.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.moxy.R
import dev.moxy.repository.model.mNote
import kotlinx.android.synthetic.main.added_word_item.view.*

class AddedWordAdapter(private val items: List<mNote>) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(p0.context).inflate(R.layout.added_word_item, p0, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, pos: Int) {
        val item = items[pos]
        holder.word.text = item.text
        holder.translate.text = item.translate
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val word: TextView = view.word
    val translate: TextView = view.word_translate
    val butReplace: Button = view.but_replace
}
