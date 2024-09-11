package com.example.kotlinbtk_06

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinbtk_06.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var superKahramanListesi:ArrayList<SuperKahraman>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val superman = SuperKahraman("Superman","Gazeteci",R.drawable.superman,R.drawable.superman_icon)
        val batman = SuperKahraman("Batman","Patron",R.drawable.batman,R.drawable.batman_icon)
        val ironman = SuperKahraman("Ironman","Holding Sahibi",R.drawable.ironman,R.drawable.iron_man_icon)
        val spiderman = SuperKahraman("Spiderman","Kral",R.drawable.spiderman,R.drawable.spiderman_icon)
        superKahramanListesi = arrayListOf(superman,batman,ironman,spiderman)


        val adapter = SuperKahramanAdapter(superKahramanListesi)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

    }
}