package com.chenmaide.mymemory

import android.app.ActionBar
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.min
class MemoryBoardAdapter(private val context: Context, private val numPiece : Int) :
    RecyclerView.Adapter<MemoryBoardAdapter.ViewHolder>() {

    companion object{
        private const val MARGIN_SIZE = 10
        private const val TAG = "MemoryBoardAdapter"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var cardHeight = parent.height / 4 - (2 * MARGIN_SIZE)
        var cardWidth = parent.width / 2 - (2 * MARGIN_SIZE)
        var cardSideLenght = min(cardWidth,cardHeight)
        val view = LayoutInflater.from(context).inflate(R.layout.memory_card,parent,false)
        var layoutpams = view.findViewById<CardView>(R.id.cardView).layoutParams as ViewGroup.MarginLayoutParams
        layoutpams.setMargins(MARGIN_SIZE, MARGIN_SIZE, MARGIN_SIZE, MARGIN_SIZE)
        layoutpams.width = cardSideLenght
        layoutpams.height = cardSideLenght

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount() = numPiece


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageButton = itemView.findViewById<ImageButton>(R.id.imageButton)
        fun bind(position: Int) {
            imageButton.setOnClickListener{
                Log.i(TAG, "Current Position $position ")
            }
        }
    }
}
