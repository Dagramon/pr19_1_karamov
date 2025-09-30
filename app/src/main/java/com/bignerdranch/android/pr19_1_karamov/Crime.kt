package com.bignerdranch.android.pr19_1_karamov

import java.util.Date
import java.util.UUID

data class Crime(var id: UUID = UUID.randomUUID(), var title: String, val date: String = "WED NOV 07.15.19.13 EST 2018", var solved: Boolean) {

}