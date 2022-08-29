package com.example.epoxysample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.epoxysample.databinding.ActivityMainBinding
import com.example.epoxysample.epoxy.EpoxyController
import com.example.epoxysample.model.Title

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val controller: EpoxyController by lazy { EpoxyController() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this

        init()
        setItem()
    }

    private val dummyData = ArrayList<Title>()
    private fun init() {
        dummyData.add(Title("11"))
        dummyData.add(Title("22"))
        dummyData.add(Title("33"))
        dummyData.add(Title("44"))
        dummyData.add(Title("55"))
    }

    private fun setItem() {
        val linearlayoutManager = LinearLayoutManager(this)

        binding.epoxyRecyclerView.apply {
            // 가로, 세로 설정
            linearlayoutManager.orientation = LinearLayoutManager.VERTICAL
//            linearlayoutManager.orientation = LinearLayoutManager.HORIZONTAL
            layoutManager = linearlayoutManager
            setHasFixedSize(true)
            adapter = controller.adapter
            addItemDecoration(
                DividerItemDecoration(
                    this@MainActivity,
                    linearlayoutManager.orientation
                )
            )

            // DataBinding을 사용하여 Controller, DataModel 없이 사용하는 방법.
            /*withModels {
                dummyData.forEach {
                    dataView {
                        // ERROR : Use the @AutoModel annotation if you want an id to be automatically generated for you.
                        id("addId")
                        title("CustomData : $it")
                    }
                }
            }*/
        }

        controller.requestModelBuild()
        // data를 직접 넣어서 세팅하는 경우 사용.
//        controller.setData(dummyData)
    }
}