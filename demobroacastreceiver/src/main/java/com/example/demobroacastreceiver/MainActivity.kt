package com.example.demobroacastreceiver

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BroadcastCalculation.OnSendDataListener {
    override fun sendData(result: Int) {
        tv_result.setText(result.toString())
    }

    lateinit var mBroadcastAirPlaneMode: BroadcastAirPlaneMode
    lateinit var mBroadcastCalculation: BroadcastCalculation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        setEvent()

    }

    override fun onStart() {
        super.onStart()
        mBroadcastAirPlaneMode = BroadcastAirPlaneMode()
        var filter = IntentFilter("android.intent.action.AIRPLANE_MODE")
        registerReceiver(mBroadcastAirPlaneMode, filter)

        mBroadcastCalculation = BroadcastCalculation(this)
        var filter1 = IntentFilter("calculation")
        registerReceiver(mBroadcastCalculation, filter1)
    }

    private fun initView() {

    }

    private fun setEvent() {
        btn_calculation.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                var intent = Intent(this@MainActivity, CalculationActivity::class.java)
                startActivity(intent)
            }

        })
    }

    override fun onDestroy() {
        unregisterReceiver(mBroadcastAirPlaneMode)
        unregisterReceiver(mBroadcastCalculation)
        super.onDestroy()
    }
}
