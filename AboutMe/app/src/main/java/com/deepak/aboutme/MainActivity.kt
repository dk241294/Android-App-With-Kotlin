package com.deepak.aboutme

import android.content.Context
import android.inputmethodservice.InputMethodService
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.view.isGone
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val doneButton:Button =findViewById(R.id.done_button)
        doneButton.setOnClickListener{
           addNickname(it)
        }

    }
    private  fun addNickname(view: View){
        val nickname:EditText=findViewById(R.id.nickname_edit_text)
        val nicknameTextView:TextView=findViewById(R.id.nickname_text_view)
        nicknameTextView.text=nickname.text
        nickname.visibility=View.GONE
        nicknameTextView.visibility=View.VISIBLE

        val imm=getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)
    }
}
