package com.example.demoandroidbase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_calculation.*

class CalculationActivity : AppCompatActivity() {
    var operator = ""
    var resultCal = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculation)
        btn_sum.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                operator = "sum"
                setUpOperatorButton(
                    R.drawable.shape_bg_active,
                    R.drawable.shape_bg_inactive,
                    R.drawable.shape_bg_inactive,
                    R.drawable.shape_bg_inactive
                )
            }
        })

        btn_minus.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                operator = "minus"
                setUpOperatorButton(
                    R.drawable.shape_bg_inactive,
                    R.drawable.shape_bg_active,
                    R.drawable.shape_bg_inactive,
                    R.drawable.shape_bg_inactive
                )
            }

        })

        btn_multi.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                operator = "multi"
                setUpOperatorButton(
                    R.drawable.shape_bg_inactive,
                    R.drawable.shape_bg_inactive,
                    R.drawable.shape_bg_active,
                    R.drawable.shape_bg_inactive
                )
            }


        })

        btn_dive.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                operator = "dive"
                setUpOperatorButton(
                    R.drawable.shape_bg_inactive,
                    R.drawable.shape_bg_inactive,
                    R.drawable.shape_bg_inactive,
                    R.drawable.shape_bg_active
                )
            }

        })

        btn_get_result.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                if (!edt_value_a.text.isEmpty()
                    && !edt_value_b.text.isEmpty()
                    && !operator.isEmpty()
                ) {
                    if (operator.equals("sum")) {
                        resultCal = edt_value_a.text.toString().toInt() + edt_value_b.text.toString().toInt()
                    } else if (operator.equals("minus")) {
                        resultCal = edt_value_a.text.toString().toInt() - edt_value_b.text.toString().toInt()

                    } else if (operator.equals("multi")) {
                        resultCal = edt_value_a.text.toString().toInt() * edt_value_b.text.toString().toInt()

                    } else if (operator.equals("dive")) {
                        resultCal = edt_value_a.text.toString().toInt() / edt_value_b.text.toString().toInt()
                    }
                    var intent = Intent()
                    intent.putExtra(ResultActivity.RESULT, resultCal)
                    setResult(ResultActivity.RESULT_CODE_CALCULATION,intent)
                    finish()
                } else {
                    Toast.makeText(
                        this@CalculationActivity,
                        "Please input number a or number b or choose operator !",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

        })

    }

    private fun setUpOperatorButton(bg_sum: Int, bg_minus: Int, bg_multi: Int, bg_dive: Int) {
        btn_sum.setBackgroundResource(bg_sum)
        btn_minus.setBackgroundResource(bg_minus)
        btn_multi.setBackgroundResource(bg_multi)
        btn_dive.setBackgroundResource(bg_dive)
    }
}
