
import java.io.File
import java.net.URL
import kotlin.concurrent.thread

/**
 * Created by ice1000 on 2016/10/7.
 */


fun main(args: Array<String>) {
	(631743..631789).forEach { i ->
		print("downloading $i")
		thread {
			File("FullMetal-Alchemist$i.mp4").writeBytes(
					URL("http://www.bilibilijj.com/Files/DownLoad/$i.mp4/www.bilibilijj.com.mp4?mp3=true")
							.readBytes()
			)
		}
	}
}