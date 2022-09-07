package com.example.epoxysample.normal

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.epoxysample.R
import com.example.epoxysample.databinding.EpoxyDataViewBinding
import com.example.epoxysample.databinding.HorizontalRecyclerviewBinding
import com.example.epoxysample.model.Title

class NormalAdapter(private val lifecycleOwner: LifecycleOwner) :
    RecyclerView.Adapter<BaseViewHolder>() {

    private val list: ArrayList<Title> = ArrayList()
    private val subItem: ArrayList<Title> = ArrayList()
    private val itemIndex = 5

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return when (viewType) {
            R.layout.epoxy_data_view -> {
                NormalHolder(
                    DataBindingUtil.inflate(inflater, R.layout.epoxy_data_view, parent, false),
                    lifecycleOwner
                )
            }
            R.layout.horizontal_recyclerview -> {
                HorizontalHolder(
                    DataBindingUtil.inflate(
                        inflater,
                        R.layout.horizontal_recyclerview,
                        parent,
                        false
                    ),
                    lifecycleOwner
                )
            }
            else -> {
                NormalHolder(
                    DataBindingUtil.inflate(inflater, R.layout.epoxy_data_view, parent, false),
                    lifecycleOwner
                )
            }
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val item = list[position]

        when (holder) {
            is NormalHolder -> {
                holder.dataBind(item)
            }
            is HorizontalHolder -> {
                holder.dataBind(item)
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (position < itemIndex) {
            R.layout.epoxy_data_view
        } else {
            R.layout.horizontal_recyclerview
        }
    }

    fun setItemList(list: ArrayList<Title>) {
        this.list.addAll(list)
        notifyItemRangeInserted(0, list.size)
    }

    inner class NormalHolder(
        private val binding: EpoxyDataViewBinding,
        lifecycleOwner: LifecycleOwner
    ) : BaseViewHolder(binding, lifecycleOwner) {

        fun dataBind(data: Title) {
            data.apply {
                binding.epoxyTitle.text = title
            }
        }
    }

    inner class HorizontalHolder(
        private val binding: HorizontalRecyclerviewBinding,
        lifecycleOwner: LifecycleOwner
    ) : BaseViewHolder(binding, lifecycleOwner) {


        fun dataBind(data: Title) {
            subItem.add(data)

            if (subItem.size == itemIndex) {
                val layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                val horizontalAdapter = HorizontalAdapter(binding.lifecycleOwner!!)

                binding.innerRecyclerView.layoutManager = layoutManager
                binding.innerRecyclerView.adapter = horizontalAdapter

                horizontalAdapter.setItemList(subItem)
            }
        }
    }
}