package com.example.cantus.ui

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import com.example.cantus.R

enum class ContentType(val displayName: Int) {
    Hymn(R.string.hymn),
    Psalm(R.string.psalm),
    SpiritualSong(R.string.spiritual_song)
}

@Composable
fun SongDetailsScreen() {

}