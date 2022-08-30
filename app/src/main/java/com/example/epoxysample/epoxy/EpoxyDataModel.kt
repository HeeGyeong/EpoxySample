package com.example.epoxysample.epoxy

import android.view.View
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.example.epoxysample.R
/*
@EpoxyModelClass(layout = R.layout.epoxy_data_view)
abstract class EpoxyDataModel : EpoxyModelWithHolder<EpoxyDataModel.TitleHolder>() {

    @EpoxyAttribute
    var title: String? = ""

    override fun bind(holder: TitleHolder) {
        holder.textView.text = title
    }

    inner class TitleHolder : EpoxyHolder() {
        lateinit var textView: TextView
        override fun bindView(itemView: View) {
            textView = itemView.findViewById(R.id.epoxyTitle)
        }
    }
}*/
