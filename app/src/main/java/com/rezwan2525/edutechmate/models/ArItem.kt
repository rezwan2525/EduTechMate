package com.rezwan2525.edutechmate.models

import java.io.Serializable

data class ArItem(var id: Int, var title: String, var image: String,
                  var modelUrl:String, var isLocked: Boolean, var price: Int,
                  var resouces: String):Serializable