package com.example.epoxysample.epoxy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.airbnb.epoxy.carousel
import com.example.epoxysample.*
import com.example.epoxysample.databinding.ActivityEpoxyBinding
import com.example.epoxysample.model.Title

class EpoxyActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEpoxyBinding
//    private val controller: EpoxyController by lazy { EpoxyController() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_epoxy)
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
//        linearlayoutManager.orientation = LinearLayoutManager.HORIZONTAL

        val sampleLayoutManager = LinearLayoutManager(this)
        sampleLayoutManager.orientation = LinearLayoutManager.HORIZONTAL

        binding.epoxyRecyclerView.apply {
            layoutManager = linearlayoutManager
            setHasFixedSize(true)
//            adapter = controller.adapter
            addItemDecoration(
                DividerItemDecoration(
                    this@EpoxyActivity,
                    linearlayoutManager.orientation
                )
            )

            withModels {
                dummyData.forEach {
                    dataView {
                        // ERROR : Use the @AutoModel annotation if you want an id to be automatically generated for you.
                        id("addId")
                        title("V : $it")
                    }
                }

                val dummyModel = dummyData.map {
                    ChildViewBindingModel_()
                        .id("dummy")
                        .subItem("carousel V $it")
                }
                carousel {
                    numViewsToShowOnScreen(4f)
                    id("carousel")
                    models(dummyModel)
                }

                /*dummyData.forEach {
                    dataView {
                        id("addId")
                        title("V22 : $it")
                    }
                }*/
            }
        }

        val linearlayoutManager2 = LinearLayoutManager(this)
        linearlayoutManager2.orientation = LinearLayoutManager.HORIZONTAL
        binding.epoxyRecyclerView2.apply {
            layoutManager = linearlayoutManager2
            setHasFixedSize(true)
            addItemDecoration(
                DividerItemDecoration(
                    this@EpoxyActivity,
                    linearlayoutManager2.orientation
                )
            )

            withModels {
                dummyData.forEach {
                    dataView {
                        id("addId")
                        title("H : $it")
                    }
                }

                val dummyModel = dummyData.map {
                    ChildViewBindingModel_()
                        .id("dummy")
                        .subItem("carousel H $it")
                }

                // carousel 는 무조건 가로 방향으로 배치된다.
                // 세로일 때 가로, 가로일 때 세로 형식으로 변환되는 것이 아님.
                carousel {
                    id("carousel")
                    models(dummyModel)
                }
            }
        }

        val gridLayoutManager = GridLayoutManager(this, 2)

        binding.epoxyRecyclerView3.apply {
//            gridLayoutManager.orientation = GridLayoutManager.HORIZONTAL

            // spanSizeLookup 적용이 제대로 안됨. model 내부에서 spanSizeOverride를 통해 작업 수행해야 함.
            /*gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int {
                    Log.d("getSpanSize", "position ? $position")
                    return 2
                }
            }*/


            layoutManager = gridLayoutManager
            setHasFixedSize(true)
            addItemDecoration(
                DividerItemDecoration(
                    this@EpoxyActivity,
                    gridLayoutManager.orientation
                )
            )

            withModels {
                dummyData.forEach {
                    childView {
                        spanSizeOverride { _, index, _ ->
                            if (index == 0) {
                                2
                            } else {
                                1
                            }
                        }

                        id("addId")
                        subItem("G2 : $it")
                    }
                }
            }

            /*withModels {
                dummyData.forEachIndexed { index, it ->
                    if (index == 0) {
                        dataView {
                            spanSizeOverride { _, _, _ -> 2}

                            id("addId")
                            title("G2 : $it")
                        }
                    } else {
                        childView {
                            spanSizeOverride { _, _, _ -> 1}

                            id("addId")
                            subItem("G2 : $it")
                        }
                    }
                }
            }*/
        }

        // data를 직접 넣어서 세팅하는 경우 사용.
//        controller.setData(dummyData)
//        controller.requestModelBuild()
    }
}