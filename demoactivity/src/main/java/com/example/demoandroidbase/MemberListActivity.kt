package com.example.demoandroidbase

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MemberListActivity : AppCompatActivity(), OnItemClickListener {


    lateinit var mRcvListMember: RecyclerView
    lateinit var listMemberAdapter: MemberListAdapter
    var listMember = arrayListOf<MemberDetail>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_member)
        initView()
    }

    private fun initView() {
        mRcvListMember = findViewById(R.id.rcvListMember)
        listMemberAdapter = MemberListAdapter(this, this)
        listMember.add(MemberDetail(R.drawable.profile_of_gabriel,"Nguyễn Bá Dũng","Android Developer"))
        listMember.add(MemberDetail(R.drawable.profile_of_gabriel,"Nguyễn Bá Dũng","Android Developer"))
        listMember.add(MemberDetail(R.drawable.profile_of_gabriel,"Nguyễn Bá Dũng","Android Developer"))
        listMember.add(MemberDetail(R.drawable.profile_of_gabriel,"Nguyễn Bá Dũng","Android Developer"))
    }

    override fun onItemClick() {

    }
}
