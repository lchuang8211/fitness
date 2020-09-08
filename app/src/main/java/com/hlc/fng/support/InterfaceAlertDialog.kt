package com.hlc.fng.support

interface InterfaceAlertDialog {

    interface OnClickListener {
        fun onClick(interfaceDialog: InterfaceAlertDialog)
    }

    interface OnClickListener1 {
        fun onLongClick()
    }

    fun dismiss()

}