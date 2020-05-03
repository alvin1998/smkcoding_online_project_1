package com.smkcoding.projectsatu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val intentData = intent.extras
        val namaUser = intentData.getString("nama")
        val emailUser = intentData.getString("email")
        val tlpUser = intentData.getString("tlp")
        val alamtUser = intentData.getString("alamat")

        Nama.setText(namaUser)
        Email.setText(emailUser)
        Tlp.setText(tlpUser)
        Alamat.setText(alamtUser)
    }
}
