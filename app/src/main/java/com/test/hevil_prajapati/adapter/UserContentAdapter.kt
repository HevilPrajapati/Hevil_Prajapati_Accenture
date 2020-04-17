package com.test.hevil_prajapati.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.test.hevil_prajapati.R
import com.test.hevil_prajapati.model.Row

class UserContentAdapter(
    private val context: Context,
    private val listDropBoxUserContent: List<Row>
) : RecyclerView.Adapter<UserContentAdapter.UserContentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserContentViewHolder {
        val v = LayoutInflater.from(context)
            .inflate(R.layout.main_user_content_items, parent, false)
        return UserContentViewHolder(v)
    }

    override fun getItemCount() = listDropBoxUserContent.size

    override fun onBindViewHolder(holder: UserContentViewHolder, position: Int) {
        val userContent = listDropBoxUserContent.get(position)

        holder.title.text = userContent.title
        holder.description.text = userContent.description
        Glide.with(context)
            .load(userContent.imageHref)
            .placeholder(R.mipmap.ic_launcher)
            .into(holder.image)
    }

    inner class UserContentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.findViewById<AppCompatTextView>(R.id.txtTitle)
        val description = itemView.findViewById<AppCompatTextView>(R.id.txtDescription)
        val image = itemView.findViewById<AppCompatImageView>(R.id.imgUserImage)
    }
}
