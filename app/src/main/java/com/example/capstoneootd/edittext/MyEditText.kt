package com.example.capstoneootd.edittext

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.util.Log
import androidx.appcompat.widget.AppCompatEditText

class MyEditText : AppCompatEditText{

    constructor(context: Context):super(context){
        init()
    }
    constructor(context: Context, attrs: AttributeSet): super(context, attrs){
        init()
    }
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int): super(context, attrs, defStyleAttr){
        init()
    }
    private fun init(){
        Log.d("Cheking Code for Input Type", inputType.toString())

        addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int){

            }
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (inputType.toString().equals("129")) {
                    if (s.toString().length < 8) {
                        setError(
                            "The password must be 8 characters or more", null)
                    } else {
                        error = null
                    }
                }else if (inputType.toString().equals("33")){
                    if (!s.toString().contains("@")) {
                        setError("Must Be Used @ ", null)
                    } else {
                        error = null
                    }
                }
            }
            override fun afterTextChanged(s: Editable) {
            }
        })

    }
}