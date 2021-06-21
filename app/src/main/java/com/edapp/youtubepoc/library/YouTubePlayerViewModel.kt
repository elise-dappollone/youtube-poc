package com.edapp.youtubepoc.library

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.YouTubePlayerTracker

class YouTubePlayerViewModel : ViewModel() {
    val currentTime = MutableLiveData<Float>()
}