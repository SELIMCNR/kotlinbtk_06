package com.example.kotlinbtk_06

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlinbtk_06.databinding.ActivityTanitimAktivitesiBinding

class TanitimAktivitesi : AppCompatActivity() {
    private  lateinit var  binding : ActivityTanitimAktivitesiBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTanitimAktivitesiBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        enableEdgeToEdge()
           ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    /* intent ile veri gönder

        val adapterdenGelenIntent = intent
        //   val secilenKahraman= adapterdenGelenIntent.getSerializableExtra("secilenKahraman",SuperKahraman::class.java)  , 5SENE SONRA BU
        val secilenKahraman = adapterdenGelenIntent.getSerializableExtra("secilenKahraman") as SuperKahraman  // ŞİMDİLİK BU
       */

        val secilenKahraman = MySıngleton.secilenSuperKahraman

        secilenKahraman?.let {
            binding.imageResim.setImageResource(secilenKahraman.gorsel)
            binding.isimText.text = secilenKahraman.isim
            binding.meslekText.text = secilenKahraman.meslek
            binding.imageViewicon.setImageResource(secilenKahraman.gorselıcon)

        }


    }
}