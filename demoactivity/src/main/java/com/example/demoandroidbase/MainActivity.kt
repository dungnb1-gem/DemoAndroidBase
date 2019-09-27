package com.example.demoandroidbase

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var mBtnGotToListMember: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        setEvent()
    }

    private fun setEvent() {
        mBtnGotToListMember.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                intent = Intent(this@MainActivity, MemberListActivity::class.java)
                startActivity(intent)
            }
        })
    }

    private fun initView() {
        mBtnGotToListMember = findViewById(R.id.btnGoToList)
    }
}
