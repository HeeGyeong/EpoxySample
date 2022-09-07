package com.example.epoxysample.normal

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.epoxysample.R
import com.example.epoxysample.databinding.EpoxyChildViewBinding
import com.example.epoxysample.model.Title

class HorizontalAdapter(private val lifecycleOwner: LifecycleOwner) :
    RecyclerView.Adapter<BaseViewHolder>() {

    var list: ArrayList<Title> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return SubItemHolder(
            DataBindingUtil.inflate(inflater, R.layout.epoxy_child_view, parent, false),
            lifecycleOwner
        )
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        when (holder) {
            is SubItemHolder -> {
                holder.dataBind(list[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.epoxy_child_view
    }

    fun setItemList(list: ArrayList<Title>) {
        this.list.addAll(list)
        notifyItemRangeInserted(0, list.size)
    }

    inner class SubItemHolder(
        private val binding: EpoxyChildViewBinding,
        lifecycleOwner: LifecycleOwner
    ) : BaseViewHolder(binding, lifecycleOwner) {

        fun dataBind(data: Title) {
            data.apply {
                binding.epoxySubItem.text = title
            }
        }
    }
}