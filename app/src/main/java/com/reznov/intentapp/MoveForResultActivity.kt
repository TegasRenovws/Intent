package com.reznov.intentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioGroup
import kotlinx.android.synthetic.main.activity_move_for_result.*

class MoveForResultActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnChoose:Button
    private lateinit var rgNumber: RadioGroup

    companion object{
        const val EXTRA_SELECTED_VALUE ="extra_selected_value"
        const val RESULT_CODE = 110
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_for_result)

        btnChoose = findViewById(R.id.btn_choose)
        rgNumber = findViewById(R.id.rg_number)

        btnChoose.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.btn_choose){
            var value = 0
            when (rg_number.checkedRadioButtonId){
                R.id.rb_13 -> value = 13
                R.id.rb_23 -> value = 23
                R.id.rb_63 -> value = 63
                R.id.rb_99 -> value = 99
                R.id.rb_1000 -> value= 1000
            }
            val resultIntent = Intent()
            resultIntent.putExtra(EXTRA_SELECTED_VALUE, value)
            setResult(RESULT_CODE, resultIntent)
            finish()
        }
    }
}