package com.kolumbo.chinesefoodrecipes.ui.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import java.lang.reflect.Type

/**
 * использовать для всех списков чтобы постоянно не создовать новый адаптары
 * IT - Модель элементов в списке
 * */
class BaseRecyclerViewAdapter<IT>(@LayoutRes val resId: Int) :
    RecyclerView.Adapter<BaseViewHolder<IT>>() {

    private var items = arrayListOf<IT>()
    private var listener: OnItemClickListener<IT>? = null

    /**
     * Если нужно поставить клик листенер то просто вызвать этот метод у адаптера
     * @see [BaseRecyclerViewAdapter.setOnItemClickListener]
     * */
    interface OnItemClickListener<T> {
        fun onItemClick(item: T)
        fun omItemLongClick(item: T) {}
    }

    fun setOnItemClickListener(itemClickListener: OnItemClickListener<IT>) {
        this.listener = itemClickListener
    }

    /**
     * Вызывать когда нужно за сетить итемы в recyclerView
     * @param withPagination передавать true если использовать с погинацией
     * */
    fun setItems(items: List<IT>, withPagination: Boolean = false) {
        if (!withPagination)
            this.items.clear()
        items.map {
            if (!this.items.contains(it)) {
                this.items.add(it)
                notifyItemInserted(this.items.size - 1)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<IT> {
        val view = LayoutInflater.from(parent.context).inflate(resId, parent, false)
        return BaseViewHolder(view)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<IT>, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount() = items.size
}


/**
 * наследовать все viewHolders от этого базового viewHolder'а
 * IT - Модель элементов в списке
 * @param listener передать листенер елси будет опработка клика
 * */
open class BaseViewHolder<IT>(itemView: View,
                              val listener: BaseRecyclerViewAdapter.OnItemClickListener<IT>? = null) : RecyclerView.ViewHolder(itemView) {
    open fun bind(item: IT) {
        itemView.setOnClickListener {
            listener?.onItemClick(item)
        }
        itemView.setOnLongClickListener {
            listener?.omItemLongClick(item)
            true
        }
    }
}