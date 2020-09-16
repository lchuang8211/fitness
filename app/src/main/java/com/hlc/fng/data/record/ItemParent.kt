package com.hlc.fng.data.record

data class ItemParent(
    var id: String,
    var vis: Boolean
//, var itemChild:ItemChild
) {
    data class ItemChild(
        var cid: String
    )
}