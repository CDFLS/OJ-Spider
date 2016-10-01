package oj

import java.io.File
import java.net.URL

/**
 * Created by ice1000 on 2016/10/2.
 *
 * @author ice1000
 */

abstract class OJ {
	abstract fun go()
	protected fun checkFile(string: String) {
		File(string).run {
			if (!exists()) mkdir()
		}
	}

	protected fun write100(begin: Int, name: String, url: String) {
		checkFile(name)
		((begin * 100)..(begin * 100 + 99)).forEach { i ->
			try {
				File("$name${File.separator}$name-${(1000 + i)}.html")
						.writeText(URL("$url${1000 + i}").readText())
			} catch (throwable: Throwable) {
			}
			println("$name has downloaded: ${1000 + i}")
		}
	}
}

object CodeVS : OJ() {
	override fun go() {
		for (idx in 0..27) Thread({
			write100(idx, "CodeVS", "http://codevs.cn/problem/")
		}).start()
	}
}

object Vijos : OJ() {
	override fun go() {
		for (idx in 0..9) Thread({
			write100(idx, "Vijos", "https://vijos.org/p/")
		}).start()
	}
}

object POJ : OJ() {
	override fun go() {
		for (idx in 0..31) Thread({
			write100(idx, "POJ", "http://poj.org/problem?&lang=zh-CN&change=true&id=")
		}).start()
	}
}

object BZOJ : OJ() {
	override fun go() {
		for (idx in 0..38) Thread({
			write100(idx, "BZOJ", "http://www.lydsy.com/JudgeOnline/problem.php?id=")
		}).start()
	}
}

object CWOJ : OJ() {
	override fun go() {
		for (idx in 0..4) Thread({
			write100(idx, "CWOJ", "https://cwoj.org/problempage.php?problem_id=")
		}).start()
	}
}

object HduOJ : OJ() {
	override fun go() {
		for (idx in 0..50) Thread({
			write100(idx, "HduOJ", "http://acm.hdu.edu.cn/showproblem.php?pid=")
		}).start()
	}
}

object HOJ : OJ() {
	override fun go() {
		for (idx in 0..23) Thread({
			write100(idx, "HOJ", "http://acm.hit.edu.cn/hoj/problem/view?id=")
		}).start()
	}
}

object FOJ : OJ() {
	override fun go() {
		for (idx in 0..13) Thread({
			write100(idx, "FOJ", "http://acm.fzu.edu.cn/problem.php?pid=")
		}).start()
	}
}





