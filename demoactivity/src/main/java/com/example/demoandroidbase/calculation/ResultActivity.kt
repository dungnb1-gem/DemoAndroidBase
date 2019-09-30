package com.example.demoandroidbase

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main_calculation.*

class ResultActivity : AppCompatActivity() {

    companion object {
        val RESULT: String = "RESULT"
        val RESULT_CODE_CALCULATION = 19
        val REQUEST_CODE_CALCULATION = 96
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_calculation)
        initView()
        setEvent()

    }

    override fun onStart() {
        super.onStart()
    }

    private fun initView() {

    }

    private fun setEvent() {
        btn_calculation.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                var intent = Intent(this@ResultActivity, CalculationActivity::class.java)
                startActivityForResult(intent, REQUEST_CODE_CALCULATION)
            }

        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (REQUEST_CODE_CALCULATION == requestCode
            && RESULT_CODE_CALCULATION == resultCode
        ) {
            data?.getIntExtra(RESULT,0)?.let { tv_result.setText(it.toString()) }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
