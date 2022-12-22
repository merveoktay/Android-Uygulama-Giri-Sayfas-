package com.example.kullanicigirissayfasi

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.kullanicigirissayfasi.databinding.ActivityMainBinding
import com.example.kullanicigirissayfasi.databinding.ActivityMainHosgeldinizBinding

class MainHosgeldiniz : AppCompatActivity() {
    lateinit var preferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       val binding=ActivityMainHosgeldinizBinding.inflate(layoutInflater)
        setContentView(binding.root)
        preferences=getSharedPreferences("bilgiler", MODE_PRIVATE)
        var kayitliKullanici=preferences.getString("kullanici","")
        var kayitliparola=preferences.getString("parola","")
        binding.kullaniciBilgisi.text="Kullanıcı Adı : "+kayitliKullanici
        binding.kullaniciParola.text="Kullanıcı Parola : "+kayitliparola

        binding.btnCikisYap.setOnClickListener {
            intent= Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)

        }
    }
}


