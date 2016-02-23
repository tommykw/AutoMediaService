package tokyo.tommykw.automediaservice

import android.media.browse.MediaBrowser.MediaItem
import android.media.session.MediaSession
import android.os.Bundle
import android.service.media.MediaBrowserService

class MyMusicService : MediaBrowserService() {
    private lateinit var session: MediaSession

    override fun onCreate() {
        super.onCreate()
        session = MediaSession(this, "MyMusicService")
        sessionToken = session.sessionToken

        with (session) {
            setCallback(MediaSessionCallback())
            setFlags(MediaSession.FLAG_HANDLES_MEDIA_BUTTONS or MediaSession.FLAG_HANDLES_TRANSPORT_CONTROLS)
        }
    }

    override fun onDestroy() = session.release()

    override fun onGetRoot(clientPackageName: String, clientUid: Int, rootHints: Bundle?): MediaBrowserService.BrowserRoot?
            = MediaBrowserService.BrowserRoot("root", null)

    override fun onLoadChildren(parentMediaId: String, result: MediaBrowserService.Result<List<MediaItem>>)
            = result.sendResult(arrayListOf())

    private inner class MediaSessionCallback : MediaSession.Callback() {
        override fun onPlay() {
        }

        override fun onSkipToQueueItem(queueId: Long) {
        }

        override fun onSeekTo(position: Long) {
        }

        override fun onPlayFromMediaId(mediaId: String, extras: Bundle) {
        }

        override fun onPause() {
        }

        override fun onStop() {
        }

        override fun onSkipToNext() {
        }

        override fun onSkipToPrevious() {
        }

        override fun onCustomAction(action: String, extras: Bundle?) {
        }

        override fun onPlayFromSearch(query: String, extras: Bundle) {
        }
    }
}
