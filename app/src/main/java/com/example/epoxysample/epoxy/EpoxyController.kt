package com.example.epoxysample.epoxy

import android.util.Log
import com.airbnb.epoxy.EpoxyController
import com.example.epoxysample.dataView
import com.example.epoxysample.model.Title

/*
class EpoxyController : EpoxyController()*//*TypedEpoxyController<ArrayList<Title>>()*//* {
    private val insertData = ArrayList<Title>()

    init {
        insertData.add(Title("1"))
        insertData.add(Title("2"))
        insertData.add(Title("3"))
        insertData.add(Title("4"))
        insertData.add(Title("5"))
    }

    override fun buildModels() {
        Log.d("dataCheck", "data ? $insertData")
        var index = 0
        insertData.forEach {
            Log.d("dataCheck", "forEach[$index] ? ${insertData[index].title}")
            EpoxyDataModel_()
                .id(index) // ERROR : Use the @AutoModel annotation if you want an id to be automatically generated for you.
                .title("it : $it")
                .addTo(this)
            index++
        }
    }

    *//*override fun buildModels(data: ArrayList<Title>?) {
        Log.d("dataCheck", "data ? $data")
        var index = 0
        data?.forEach {
            Log.d("dataCheck", "forEach[$index] ? ${data[index].title}")
            EpoxyDataModel_()
                .id(index)
                .title("it : $it")
                .addTo(this)
            index++
        }
    }*//*
}
*/
