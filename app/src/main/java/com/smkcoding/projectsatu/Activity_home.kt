package com.smkcoding.projectsatu


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_main.*



class Activity_home : AppCompatActivity() {

    private var namaInput : String = ""
    private var umurInput : String = ""
    private var emailInput : String = ""
    private var telpInput : String = ""
    private var alamatInput : String = ""
    private var genderInput : String = ""





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setDataSpinnerGender()


        btnsave.setOnClickListener { validasiInput()}
    }
    private fun setDataSpinnerGender(){
        val spinnerGender: Spinner = findViewById(R.id.spn)
        val adapter = ArrayAdapter.createFromResource(this,
            R.array.jenis_kelamin, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerGender.adapter = adapter
    }
    private fun validasiInput() {
        namaInput = nama.text.toString()
        umurInput = umur.text.toString()
        emailInput = email.text.toString()
        telpInput = tlp.text.toString()
        alamatInput = alamat.text.toString()
        genderInput = spn.selectedItem.toString()
        when{
            namaInput.isEmpty() -> nama.error = "Nama tidak boleh kosong"
            umurInput.isEmpty() -> umur.error = "umur tidak boleh kosong"
            emailInput.isEmpty() -> email.error = "email tidak boleh kosong"
            telpInput.isEmpty() -> tlp.error = "tlp tidak boleh kosong"
            alamatInput.isEmpty() -> alamat.error = "alamat tidak boleh kosong"
            genderInput.equals("Pilih Jenis Kelamin", ignoreCase = true) ->
                tampilToast("Jenis Kelamin harus dipilih")
            else -> {
                          goToProfilActivity()
            }

        }
    }
    private fun tampilToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
    private fun goToProfilActivity() {
        val intent = Intent(this, ProfilActivity::class.java)
        val bundle = Bundle()
        bundle.putString("nama", namaInput)
        bundle.putString("umur", umurInput)
        bundle.putString("gender", genderInput)
        bundle.putString("email", emailInput)
        bundle.putString("telp", telpInput)
        bundle.putString("alamat", alamatInput)
        intent.putExtras(bundle)
        startActivity(intent)
    }
}




