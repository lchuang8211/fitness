package com.hlc.fng.data.record

data class ItemParent(
    var id: String,
    var vis: Boolean
) {
    data class ItemChild(
        var cid: String
    )
}