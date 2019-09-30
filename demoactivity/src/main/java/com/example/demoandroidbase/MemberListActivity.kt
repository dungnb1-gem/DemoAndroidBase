package com.example.demoandroidbase

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MemberListActivity : AppCompatActivity(), OnItemClickListener {
    companion object {
        val MEMBER_DETAIL = "MEMBER_DETAIL"
    }

    lateinit var mRcvListMember: RecyclerView
    lateinit var listMemberAdapter: MemberListAdapter
    var listMember = arrayListOf<MemberDetail>()
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.e("Gabriel", "MemberListActivity: onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_member)
        initView()
    }

    override fun onStart() {
        Log.e("Gabriel", "MemberListActivity: onStart")
        super.onStart()
    }

    override fun onRestart() {
        Log.e("Gabriel", "MemberListActivity: onRestart")
        super.onRestart()
    }

    override fun onResume() {
        Log.e("Gabriel", "MemberListActivity: onResume")
        super.onResume()
    }

    private fun initView() {
        mRcvListMember = findViewById(R.id.rcvListMember)
        listMemberAdapter = MemberListAdapter(this, this)
        listMember.add(
            MemberDetail(
                R.drawable.profile_of_nguyen_tien_hoang,
                "Nguyễn Tiến Hoàng",
                "Project Manager",
                "Rủ team đi retro"
            )
        )
        listMember.add(MemberDetail(R.drawable.profile_of_tam_nguyen, "Nguyễn Thị Tâm", "Quality Assurance", "Ăn uống"))
        listMember.add(
            MemberDetail(
                R.drawable.profile_of_tai_handsome,
                "Nguyễn Đình Tài",
                "Android Developer",
                "Đi sapa"
            )
        )
        listMember.add(
            MemberDetail(
                R.drawable.profile_of_vu_tien_dat,
                "Vũ Tiến Đạt",
                "Android Developer",
                "Đổi người yêu"
            )
        )
        listMember.add(MemberDetail(R.drawable.profile_of_gabriel, "Nguyễn Bá Dũng", "Android Developer", "Nghe nhạc"))
        mRcvListMember.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        mRcvListMember.adapter = listMemberAdapter
        listMemberAdapter.refreshData(listMember)
    }

    override fun onItemClick(memberDetail: MemberDetail) {
        var intent = Intent(this@MemberListActivity, DialogDetailActivity::class.java)
        intent.putExtra(MEMBER_DETAIL, memberDetail)
        startActivity(intent)
    }

    override fun onPause() {
        Log.e("Gabriel", "MemberListActivity: onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.e("Gabriel", "MemberListActivity: onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.e("Gabriel", "MemberListActivity: onDestroy")
        super.onDestroy()
    }
}
