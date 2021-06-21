package com.edapp.youtubepoc.library

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.edapp.youtubepoc.R
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerFullScreenListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options.IFramePlayerOptions
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.loadOrCueVideo
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView


class YouTubeFragment : Fragment(), YouTubePlayerListener, YouTubePlayerFullScreenListener {

    lateinit var videoPlayer: YouTubePlayer
    lateinit var viewModel: YouTubePlayerViewModel
    val videoId = "R9QNrYgeZyQ"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_you_tube, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val youTubePlayerView = view.findViewById<YouTubePlayerView>(R.id.youtube_player_view)
        youTubePlayerView.addFullScreenListener(this)
        lifecycle.addObserver(youTubePlayerView)

        val uiController = youTubePlayerView.getPlayerUiController()
        uiController.showFullscreenButton(true)

        val iFramePlayerOptions =
            IFramePlayerOptions.Builder()
                .controls(0)
                .build()

        youTubePlayerView.initialize(this, false, iFramePlayerOptions)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = ViewModelProvider(this).get(YouTubePlayerViewModel::class.java)
    }

    override fun onApiChange(youTubePlayer: YouTubePlayer) {}

    override fun onCurrentSecond(youTubePlayer: YouTubePlayer, second: Float) {}

    override fun onError(youTubePlayer: YouTubePlayer, error: PlayerConstants.PlayerError) {}

    override fun onPlaybackQualityChange(
        youTubePlayer: YouTubePlayer,
        playbackQuality: PlayerConstants.PlaybackQuality) {}

    override fun onPlaybackRateChange(
        youTubePlayer: YouTubePlayer,
        playbackRate: PlayerConstants.PlaybackRate) {}

    //Called when video is ready to play
    override fun onReady(youTubePlayer: YouTubePlayer) {
        videoPlayer = youTubePlayer
        youTubePlayer.loadOrCueVideo(this.lifecycle, videoId, viewModel.currentTime.value ?: 0f)
        videoPlayer.addListener(this@YouTubeFragment)
    }

    // Called every time the state of the player changes.
    //      Possible States:
    //              UNKNOWN
    //              UNSTARTED
    //              ENDED
    //              PLAYING
    //              PAUSED
    //              BUFFERING
    //              VIDEO_CUED
    override fun onStateChange(youTubePlayer: YouTubePlayer, state: PlayerConstants.PlayerState) {}

    // Called when the total duration of the video is loaded.
    override fun onVideoDuration(youTubePlayer: YouTubePlayer, duration: Float) {}

    override fun onVideoId(youTubePlayer: YouTubePlayer, videoId: String) {}

    // Called periodically by the player, the argument is the percentage of the video that has been buffered.
    override fun onVideoLoadedFraction(youTubePlayer: YouTubePlayer, loadedFraction: Float) {}

    override fun onYouTubePlayerEnterFullScreen() {}

    override fun onYouTubePlayerExitFullScreen() {}
}