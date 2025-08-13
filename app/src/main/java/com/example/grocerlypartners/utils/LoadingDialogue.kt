package com.example.grocerlypartners.utils

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.Window
import com.example.grocerlypartners.R


class LoadingDialogue(private val context: Context) {

    private var dialogue:Dialog ?= null


    fun show(){

        dialogue = Dialog(context).apply {

            requestWindowFeature(Window.FEATURE_NO_TITLE)
            setCancelable(false)


            setContentView(
                LayoutInflater.from(context).inflate(
                    R.layout.custom_loading_screen,
                    findViewById(android.R.id.content),
                    false
                )
            )

            window?.apply {
                setLayout(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
                setBackgroundDrawableResource(android.R.color.transparent)
            }
        }
        dialogue?.show()
    }


    fun dismiss(){
        dialogue?.dismiss()
        dialogue = null
    }

}