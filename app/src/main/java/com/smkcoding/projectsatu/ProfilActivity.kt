package com.smkcoding.projectsatu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_profil.*

class ProfilActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)


        ambilData()


    }
    private fun ambilData(){
        val bundle = intent.extras
        val nama = bundle.getString("nama")
        val gender = bundle.getString("gender")
        val umur = bundle.getString("umur")
        val email = bundle.getString("email")
        val telp = bundle.getString("telp")
        val alamat = bundle.getString("alamat")
        txtName.text = nama
        jenis_kelamin.text = gender
        txtUmur.text = umur
        txtEmail.text = email
        txtTlp.text = telp
        txtAlamat.text = alamat
    }
}
