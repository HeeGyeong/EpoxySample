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

class EpoxyActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEpoxyBinding
//    private val controller: EpoxyController by lazy { EpoxyController() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_epoxy)
        binding.lifecycleOwner = this

        setItem()
    }

    private val dummyData = createTitle(5)

    private fun setItem() {
        val linearlayoutManager = LinearLayoutManager(this)
//        linearlayoutManager.orientation = LinearLayoutManager.VERTICAL
//            linearlayoutManager.orientation = LinearLayoutManager.HORIZONTAL

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

                // carousel ??? ????????? ?????? ???????????? ????????????.
                // ????????? ??? ??????, ????????? ??? ?????? ???????????? ???????????? ?????? ??????.
                carousel {
                    id("carousel")
                    models(dummyModel)
                }
            }
        }

        val gridLayoutManager = GridLayoutManager(this, 2)

        binding.epoxyRecyclerView3.apply {
//            gridLayoutManager.orientation = GridLayoutManager.HORIZONTAL

            // spanSizeLookup ????????? ????????? ??????. model ???????????? spanSizeOverride??? ?????? ?????? ???????????? ???.
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

        // data??? ?????? ????????? ???????????? ?????? ??????.
//        controller.setData(dummyData)
//        controller.requestModelBuild()
    }
}