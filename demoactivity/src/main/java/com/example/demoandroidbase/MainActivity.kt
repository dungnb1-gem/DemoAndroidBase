package com.example.demoandroidbase

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var mBtnGotToListMember: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.e("Gabriel","MainActivity: onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        setEvent()
    }

    override fun onStart() {
        Log.e("Gabriel","MainActivity: onStart")
        super.onStart()
    }

    override fun onRestart() {
        Log.e("Gabriel","MainActivity: onRestart")
        super.onRestart()
    }

    override fun onResume() {
        Log.e("Gabriel","MainActivity: onResume")
        super.onResume()
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

    override fun onPause() {
        Log.e("Gabriel","MainActivity: onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.e("Gabriel","MainActivity: onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.e("Gabriel","MainActivity: onDestroy")
        super.onDestroy()
    }
}
