package com.fmaldonado.listaanimes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fmaldonado.listaanimes.adapters.AnimeAdapter
import com.fmaldonado.listaanimes.databinding.ActivityMainBinding
import com.fmaldonado.listaanimes.models.Anime
import com.fmaldonado.listaanimes.providers.AnimeProvider
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    var page = 1
    var animes = mutableListOf<Anime>()
    var isLoading = false

    lateinit var adapter: AnimeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        getAnimes()

        binding.animeList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy < 0)
                    return

                val lm = recyclerView.layoutManager as GridLayoutManager
                val visibleItems = recyclerView.childCount
                val pastItems = lm.findFirstCompletelyVisibleItemPosition()

                if(visibleItems + pastItems >= animes.size && !isLoading)
                    getAnimes()
            }
        })

    }

    fun getAnimes() {
        lifecycleScope.launch {
            isLoading = true
            val res = AnimeProvider.animeService.getAnimeList(page)
            animes.addAll(res.top)
            setupRecycler()
            isLoading = false
            page++
        }
    }

    fun setupRecycler() {

        if (::adapter.isInitialized) {
            adapter.notifyDataSetChanged()
        } else {
            adapter = AnimeAdapter(animes)
            binding.animeList.adapter = adapter
        }

    }
}