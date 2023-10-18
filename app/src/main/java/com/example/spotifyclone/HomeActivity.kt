package com.example.spotifyclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.spotifyclone.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHomeBinding
    companion object {
        const val EXTRA_INDEX = "index"
        const val EXTRA_TITLE = "name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {

            var albums = arrayOf(
                album1,
                album2,
                album3,
                album4,
                album5,
                album6,
                album7,
                album8,
                album9,
                album10,
                album11,
                album12,
                album13,
                album14,
                album15,
                album16,
                album17,
                album18,
                album19,
                album20
            )

            for ((index, album) in albums.withIndex()) {
                album.setOnClickListener {
                    val txtview = album.getChildAt(1) as? TextView
                    val title = txtview?.text.toString()
                    val intentToPlaylistActivity = Intent(this@HomeActivity, PlaylistActivity::class.java)
                    intentToPlaylistActivity.putExtra(EXTRA_INDEX, index)
                    intentToPlaylistActivity.putExtra(EXTRA_TITLE, title)
                    startActivity(intentToPlaylistActivity)
                }
            }
        }
    }
}