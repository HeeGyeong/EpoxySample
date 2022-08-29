package com.example.epoxysample.epoxy

import com.airbnb.epoxy.EpoxyDataBindingPattern
import com.example.epoxysample.R

// xml에서 prefix가 epoxy로 시작하는 경우 알아서 Binding
@EpoxyDataBindingPattern(rClass = R::class, layoutPrefix = "epoxy")
object EpoxyDataBinding