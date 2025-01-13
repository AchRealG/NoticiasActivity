package com.example.noticiasactivity

import NoticiasAdapter
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practica3.R
import com.example.practica3.databinding.ActivityMainBinding
import java.util.prefs.Preferences

class NoticiasActivity : AppCompatActivity(), OnClickListener {
    private lateinit var noticiaAdapter: NoticiasAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager

    private lateinit var binding: ActivityMainBinding

    private lateinit var preferences: Preferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        noticiaAdapter = NoticiasAdapter(generateNoticiasList(), this)
        linearLayoutManager = LinearLayoutManager(this)
        binding.recyclerView.apply {
            layoutManager = linearLayoutManager
            adapter = noticiaAdapter
        }

        val preferences = getPreferences(Context.MODE_PRIVATE)
        val lastTitle = preferences.getString(getString(R.string.last_new), "")

        if (lastTitle != "") {
            Toast.makeText(this, lastTitle, Toast.LENGTH_SHORT).show()
        }
    }
    private fun generateNoticiasList(): List<Noticias> {
        return listOf(
                    Noticias(
                        id = 1,
                        titulo = "NASA's Perseverance rover has started its second science campaign on Mars.",
                        resumen = "Nasa perseverancia",
                        fecha = "2023-10-01",
                        imagen = "https://mars.nasa.gov/system/news_items/main_images/10030_PIA25533-web.jpg",
                        enlace = "https://mars.nasa.gov/news/10030/nasas-perseverance-rover-begins-mission-2-on-mars/"
                    ),
                    Noticias(
                        id = 2,
                        titulo = "Apple Unveils New iPhone 15",
                        resumen = "Apple iPhone 15",
                        fecha = "2023-09-20",
                        imagen = "https://www.apple.com/newsroom/images/product/iphone/standard/Apple_iPhone-15_09122023.jpg",
                        enlace = "https://www.apple.com/newsroom/2023/09/apple-unveils-new-iphone-15/"
                    ),
                    Noticias(
                        id = 3,
                        titulo = "Google AI Achieves Breakthrough in Quantum Computing",
                        resumen = "Google AI Quantum",
                        fecha = "2023-08-15",
                        imagen = "https://www.blog.google/static/blogv2/images/google-200x200.png",
                        enlace = "https://blog.google/technology/ai/google-ai-achieves-breakthrough-in-quantum-computing/"
                    ),
                    Noticias(
                        id = 4,
                        titulo = "Climate Change: Global Temperatures Hit Record Highs",
                        resumen = "Climate Change",
                        fecha = "2023-07-30",
                        imagen = "https://www.climate.gov/sites/default/files/styles/featured_image/public/2023-07/2023-07-30-global-temperatures.jpg",
                        enlace = "https://www.climate.gov/news-features/understanding-climate/climate-change-global-temperatures-hit-record-highs"
                    ),
                    Noticias(
                        id = 5,
                        titulo = "Tesla Announces New Electric Truck",
                        resumen = "Tesla Electric Truck",
                        fecha = "2023-06-25",
                        imagen = "https://www.tesla.com/sites/default/files/images/blogs/tesla-truck.jpg",
                        enlace = "https://www.tesla.com/blog/tesla-announces-new-electric-truck"
                    ),
                    Noticias(
                        id = 6,
                        titulo = "Microsoft Acquires Major Gaming Company",
                        resumen = "Microsoft Gaming",
                        fecha = "2023-05-10",
                        imagen = "https://news.microsoft.com/wp-content/uploads/prod/sites/1/2023/05/microsoft-gaming.jpg",
                        enlace = "https://news.microsoft.com/2023/05/10/microsoft-acquires-major-gaming-company/"
                    ),
                    Noticias(
                        id = 7,
                        titulo = "Amazon Launches New Delivery Drone",
                        resumen = "Amazon Delivery Drone",
                        fecha = "2023-04-15",
                        imagen = "https://www.aboutamazon.com/news/transportation/amazon-launches-new-delivery-drone.jpg",
                        enlace = "https://www.aboutamazon.com/news/transportation/amazon-launches-new-delivery-drone"
                    ),
                    Noticias(
                        id = 8,
                        titulo = "Facebook Introduces New Privacy Features",
                        resumen = "Facebook Privacy",
                        fecha = "2023-03-20",
                        imagen = "https://about.fb.com/wp-content/uploads/2023/03/facebook-privacy.jpg",
                        enlace = "https://about.fb.com/news/2023/03/facebook-introduces-new-privacy-features/"
                    ),
                    Noticias(
                        id = 9,
                        titulo = "SpaceX Successfully Launches New Rocket",
                        resumen = "SpaceX Rocket",
                        fecha = "2023-02-10",
                        imagen = "https://www.spacex.com/static/images/share.jpg",
                        enlace = "https://www.spacex.com/news/2023/02/10/spacex-successfully-launches-new-rocket"
                    ),
                    Noticias(
                        id = 10,
                        titulo = "Netflix Releases New Original Series",
                        resumen = "Netflix Series",
                        fecha = "2023-01-05",
                        imagen = "https://assets.nflxext.com/us/ffe/siteui/acquisition/ourStory/fuji/desktop/tv.png",
                        enlace = "https://www.netflix.com/title/81040344"
                    )
                )
            }



        override fun onClick(new: Noticias, position: Int) {
            val preferences = getPreferences(Context.MODE_PRIVATE)
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(new.enlace)

            preferences.edit().putString(getString(R.string.last_new), new.titulo).apply()

            startActivity(intent)
        }
}
