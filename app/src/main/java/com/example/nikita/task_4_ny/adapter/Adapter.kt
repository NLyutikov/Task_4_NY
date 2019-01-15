package com.example.nikita.task_4_ny.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.BitmapDrawable
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.nikita.task_4_ny.R
import com.example.nikita.task_4_ny.WebActivity
import com.example.nikita.task_4_ny.enities.ClassInfo

class Adapter(var data: List<ClassInfo>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    private val original = data

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.list_item, p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, idx: Int) {
        holder.title.text = data[idx].name
        holder.image.background = BitmapDrawable(data[idx].imageLogo)
        holder.author.text = data[idx].author
        holder.release.text = data[idx].release.toString()
        holder.paradigm.text = data[idx].paradigm?.joinToString()
        holder.rating.text = "${data[idx].rating}%"
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView
        val image: ImageView
        val author: TextView
        val release: TextView
        val paradigm: TextView
        val rating: TextView

        init {
            title = view.findViewById(R.id.title)
            view.setOnClickListener {
                val intent = Intent(view.context, WebActivity::class.java)
                intent.putExtra("item_url", data[adapterPosition].link)
                view.context.startActivity(intent)
            }
            image = view.findViewById(R.id.logo)
            author = view.findViewById(R.id.author)
            release = view.findViewById(R.id.release)
            paradigm = view.findViewById(R.id.paradigm)
            rating = view.findViewById(R.id.rating)

        }


    }

    fun filter(filter: String?) {
        data = original.filter {
            if (filter != null) it.paradigm.orEmpty().contains(filter) else true
        }
        notifyDataSetChanged()
    }

}