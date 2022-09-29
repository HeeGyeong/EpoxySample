package com.example.epoxysample

import com.example.epoxysample.model.Title

fun createTitle(count: Int): ArrayList<Title> {
    val dummyData = ArrayList<Title>()

    for (index in 0..count) {
        dummyData.add(Title("$index"))
    }

    return dummyData
}