package com.example.epoxysample.normal

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.epoxysample.R
import com.example.epoxysample.createTitle
import com.example.epoxysample.databinding.ActivityNormalBinding

class NormalActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNormalBinding
    private var normalAdapter: NormalAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_normal)
        binding.lifecycleOwner = this

        bindingUI()
        setItem()
    }

    private fun bindingUI() {
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.normalRecyclerView.layoutManager = layoutManager
        normalAdapter = NormalAdapter(this)
        binding.normalRecyclerView.adapter = normalAdapter
    }

    private fun setItem() {
        normalAdapter!!.setItemList(createTitle(10))
    }
}