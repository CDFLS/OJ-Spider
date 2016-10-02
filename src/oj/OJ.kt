package oj

import spider.Echoer
import java.io.File
import java.net.URL
import kotlin.concurrent.thread

/**
 * Created by ice1000 on 2016/10/2.
 *
 * @author ice1000
 */
abstract class OJ() {
	abstract fun go()
	private fun checkFile(string: String) {
		File(string).run {
			if (!exists()) mkdir()
		}
	}

	protected fun write100(begin: Int, name: String, url: String) {
		checkFile(name)
		((begin * 20)..(begin * 20 + 19)).forEach { i ->
			try {
				File("$name${File.separator}$name-${(1000 + i)}.html")
						.writeText(URL("$url${1000 + i}").readText())
			} catch (throwable: Throwable) {
			}
			println("$name has downloaded: ${1000 + i}")
		}
	}

	protected fun multiThreadGo(all: Int, name: String, url: String) {
		for (idx in 0..(all * 5)) thread {
			write100(idx, name, url)
		}
	}

	private fun println(string: String) {
		echoer?.echo(string)
	}

	companion object {
		var echoer: Echoer? = null
	}
}

object CodeVS : OJ() {
	override fun go() {
		multiThreadGo(27, "CodeVS", "http://codevs.cn/problem/")
	}
}

object Vijos : OJ() {
	override fun go() {
		multiThreadGo(9, "Vijos", "https://vijos.org/p/")
	}
}

object POJ : OJ() {
	override fun go() {
		multiThreadGo(31, "POJ", "http://poj.org/problem?&lang=zh-CN&change=true&id=")
	}
}

object BZOJ : OJ() {
	override fun go() {
		multiThreadGo(38, "BZOJ", "http://www.lydsy.com/JudgeOnline/problem.php?id=")
	}
}

object CWOJ : OJ() {
	override fun go() {
		multiThreadGo(4, "CWOJ", "https://cwoj.org/problempage.php?problem_id=")
	}
}

object HduOJ : OJ() {
	override fun go() {
		multiThreadGo(50, "HduOJ", "http://acm.hdu.edu.cn/showproblem.php?pid=")
	}
}

object HOJ : OJ() {
	override fun go() {
		multiThreadGo(23, "HOJ", "http://acm.hit.edu.cn/hoj/problem/view?id=")
	}
}

object FOJ : OJ() {
	override fun go() {
		multiThreadGo(13, "FOJ", "http://acm.fzu.edu.cn/problem.php?pid=")
	}
}





