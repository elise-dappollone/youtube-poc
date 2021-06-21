package com.edapp.youtubepoc.youtubeapi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.edapp.youtubepoc.R
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerSupportFragment


class YouTubeFragment : Fragment() {
    lateinit var youTubePlayer: YouTubePlayer

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val youTubePlayerFragment = YouTubePlayerSupportFragment()
        val transaction = childFragmentManager.beginTransaction()
        transaction.add(R.layout.youtube_fragment, youTubePlayerFragment).commit()

        youTubePlayerFragment.initialize(
            "DEVELOPER_KEY",
            object : YouTubePlayer.OnInitializedListener {
                override fun onInitializationSuccess(
                    provider: YouTubePlayer.Provider?,
                    player: YouTubePlayer?,
                    p2: Boolean
                ) {
                    if (!p2) {
                        if (player != null) {
                            youTubePlayer = player
                        }
                        youTubePlayer.loadVideo("2zNSgSzhBfM", 0)
                        youTubePlayer.play()
                    }
                }

                override fun onInitializationFailure(
                    provider: YouTubePlayer.Provider?,
                    initializationResult: YouTubeInitializationResult?
                ) {
                    TODO("Not yet implemented")
                }
            })

        return inflater.inflate(R.layout.youtube_fragment, container, false)
    }

    companion object {
        const val YoutubeDeveloperKey = "AIzaSyBaQ3L5xjhT9IW4wDWgRbenUQXSXaRAhOs"
    }

}