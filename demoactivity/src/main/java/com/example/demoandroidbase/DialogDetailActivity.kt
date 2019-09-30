package com.example.demoandroidbase

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.dialog_detail.*

class DialogDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_detail)
        setUpData()
    }

    private fun setUpData() {
        var member_detail = intent.getSerializableExtra(MemberListActivity.MEMBER_DETAIL) as MemberDetail
        member_detail.mImgProfile?.let { img_profile.setImageResource(it) }
        tv_name.setText(member_detail.mName)
        tv_title.setText(member_detail.mTitle)
        tv_favorite.setText(member_detail.mFavorite)
    }
}