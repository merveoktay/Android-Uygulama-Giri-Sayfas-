package com.example.kullanicigirissayfasi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kullanicigirissayfasi.databinding.ActivityMainKayitOlBinding

class MainKayitOl : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityMainKayitOlBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnGiriseDon.setOnClickListener {
            intent= Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
        }
        binding.btnKaydet.setOnClickListener {
            var kullaniciBilgisi=binding.kayitKullaniciAdi.text.toString()
            var kullaniciParola=binding.kayitParola.text.toString()
            var sharedPreferences=this.getSharedPreferences("bilgiler", MODE_PRIVATE)
            var editor=sharedPreferences.edit()
            if((kullaniciBilgisi !="") && (kullaniciParola !="")) {
                editor.putString("kullanici", "$kullaniciBilgisi").apply()
                editor.putString("parola", "$kullaniciParola").apply()
                Toast.makeText(applicationContext, "Kayıt Başarılı", Toast.LENGTH_LONG).show()
                binding.kayitKullaniciAdi.text.clear()
                binding.kayitParola.text.clear()
            }
            else{
                Toast.makeText(applicationContext, "Bilgilerden Biri Veya İkisi Eksik !", Toast.LENGTH_SHORT).show()
            }
        }
    }
}