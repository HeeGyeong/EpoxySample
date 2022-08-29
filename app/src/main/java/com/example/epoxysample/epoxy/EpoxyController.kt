package com.example.epoxysample.epoxy

import android.util.Log
import com.airbnb.epoxy.EpoxyController
import com.example.epoxysample.model.Title
import com.example.epoxysample.dataView

// 주석 처리된 부분은 직접 데이터를 입력하는 경우 사용.
class EpoxyController : EpoxyController()/*TypedEpoxyController<ArrayList<Title>>()*/ {
    private val insertData = ArrayList<Title>()

    init {
        insertData.add(Title("1"))
        insertData.add(Title("2"))
        insertData.add(Title("3"))
        insertData.add(Title("4"))
        insertData.add(Title("5"))
    }

    override fun buildModels() {
        Log.d("dataCheck" , "data ? $insertData")
        var index = 0
        insertData.forEach {
            Log.d("dataCheck" , "forEach[$index] ? ${insertData[index].title}")
            dataView {
                // ERROR : Use the @AutoModel annotation if you want an id to be automatically generated for you.
                id(index)
                title("it : $it")
            }
            index++
        }
    }

    // TypedEpoxyController를 사용하여 데이터를 받아서 setting하는 경우 사용.
    // Typed2EpoxyController를 사용하면 인자로 받는 데이터는 2개.
    /*override fun buildModels(data: ArrayList<Title>?) {
        Log.d("dataCheck" , "data ? $data")
        var index = 0
        data?.forEach {
            Log.d("dataCheck" , "forEach[$index] ? ${data[index].title}")
            dataView {
                // ERROR : Use the @AutoModel annotation if you want an id to be automatically generated for you.
                id(index)
                title("it : $it")
            }
            index++
        }
    }*/
}
