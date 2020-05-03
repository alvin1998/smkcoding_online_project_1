package com.smkcoding.projectsatu

import android.app.Activity
import android.content.Intent
import android.net.Uri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_profil.*

class ProfilActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)


        ambilData()

        btn_edit.setOnClickListener { halamEdit()}
        btn_tlp.setOnClickListener { telpon(txtTlp.text.toString())}
        btn_about.setOnClickListener { about()}
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
    companion object {
        val REQUEST_CODE = 100
    }
    private  fun  halamEdit(){
        val intent = Intent(this, EditProfilActivity::class.java)
        val namaUser = txtName.text.toString()
        intent.putExtra("nama", namaUser)
        startActivityForResult(intent, REQUEST_CODE)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data:
    Intent?) {
        if (requestCode == REQUEST_CODE){
            if (resultCode == Activity.RESULT_OK) {
                val result = data?.getStringExtra("nama")
                txtName.text = result
            }else{
                Toast.makeText(this, "Edit Gagal",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun telpon(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL).apply {  data = Uri.parse("tel:$phoneNumber")
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }
    private  fun about(){
        val intent = Intent(this, AboutActivity::class.java)
        val namaUser = txtName.text.toString()
        val emailUser = txtEmail.text.toString()
        val tlpUser = txtTlp.text.toString()
        val alamatUser = txtAlamat.text.toString()
        intent.putExtra("nama", namaUser)
        intent.putExtra("email", emailUser)
        intent.putExtra("tlp", tlpUser)
        intent.putExtra("alamat", alamatUser)
        startActivity(intent)
    }
}
