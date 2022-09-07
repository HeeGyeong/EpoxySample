package com.example.epoxysample.normal

import android.content.Context
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder(binding: ViewDataBinding, lifecycleOwner: LifecycleOwner) :
    RecyclerView.ViewHolder(binding.root) {

    val context: Context = binding.root.context

    init {
        binding.lifecycleOwner = lifecycleOwner
    }
}
