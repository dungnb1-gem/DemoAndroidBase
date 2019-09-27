package com.example.demoandroidbase

class MemberDetail {
    var name: String = ""
    var title: String = "Developer"
    var favorite: String = "Football, travel ..."

    var mName: String
        get() {
            return name
        }
        set(value) {
            this.name = value
        }

    var mTitle: String
        get() {
            return title
        }
        set(value) {
            this.title = value
        }

    var mFavorite: String
        get() {
            return favorite
        }
        set(value) {
            this.favorite = value
        }
}