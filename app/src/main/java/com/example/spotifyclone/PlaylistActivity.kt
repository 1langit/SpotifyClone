package com.example.spotifyclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.spotifyclone.databinding.ActivityPlaylistBinding
import com.example.spotifyclone.HomeActivity.Companion.EXTRA_INDEX
import com.example.spotifyclone.HomeActivity.Companion.EXTRA_TITLE
import java.text.NumberFormat
import kotlin.random.Random

class PlaylistActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlaylistBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlaylistBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val extraIndex = intent.getIntExtra(EXTRA_INDEX, 0)
        val extraTitle = intent.getStringExtra(EXTRA_TITLE)
        val imageArray = arrayOf(
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6,
            R.drawable.img7,
            R.drawable.img8,
            R.drawable.img9,
            R.drawable.img10,
            R.drawable.img11,
            R.drawable.img12,
            R.drawable.img13,
            R.drawable.img14,
            R.drawable.img15,
            R.drawable.img16,
            R.drawable.img17,
            R.drawable.img18,
            R.drawable.img19,
            R.drawable.img20
        )
        val songArray = resources.getStringArray(R.array.songs)
        val artistArray = resources.getStringArray(R.array.artists)


        with(binding) {

            val songCoverArray = arrayOf(img1, img2, img3, img4, img5, img6)
            val viewTitleArray = arrayOf(txtTitle1, txtTitle2, txtTitle3, txtTitle4, txtTitle5, txtArtist6)
            val viewArtistArray = arrayOf(txtArtist1, txtArtist2, txtArtist3, txtArtist4, txtArtist5, txtArtist6)

            imgAlbumCover.setImageResource(imageArray[extraIndex])
            txtTitle.text = extraTitle
            var likes = NumberFormat.getNumberInstance().format(Random.nextInt(30000000) + 20000000)
            txtLikes.text = "$likes likes"

            val randomIndexes = List(6) { Random.nextInt(20) }.toSet()
            randomIndexes.forEachIndexed { index, randomIndex ->
                songCoverArray[index].setImageResource(imageArray[extraIndex])
                viewTitleArray[index].text = songArray[randomIndex]
                viewArtistArray[index].text = artistArray[randomIndex]
            }

            btnBack.setOnClickListener {
                finish()
            }

            btnLike.setOnClickListener {
                btnLike.showNext()
            }
        }
    }
}