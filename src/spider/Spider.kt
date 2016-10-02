package spider

import oj.*
import java.awt.Color
import java.awt.Frame
import java.awt.GridLayout
import java.awt.TextArea

/**
 * Created by ice1000 on 2016/10/2.
 *
 * @author ice1000
 */

interface Echoer {
	fun echo(string: String)
}

class MyWindow() : Frame("OJ-Spider by ice1000"), Echoer {
	val textArea1: TextArea
	val textArea2: TextArea
	var bool = false

	init {
		textArea1 = TextArea().build()
		textArea2 = TextArea().build()

		setBounds(100, 100, 800, 800)
		layout = GridLayout(1, 2)
		add(textArea1)
		add(textArea2)
		isVisible = true
	}

	private fun TextArea.build(): TextArea {
		background = Color(0x2b2b2b)
		foreground = Color(0xa9b7c6)
		isEditable = false
		return this
	}

	override fun echo(string: String) {
		(if (bool) textArea1 else textArea2).append("$string\n")
		bool = !bool
	}
}

fun main(args: Array<String>) {
	val window = MyWindow()
	OJ.echoer = window
	listOf(
			CodeVS,
			Vijos,
			POJ,
			BZOJ,
			CWOJ,
			HduOJ,
			HOJ,
			FOJ).forEach { oj ->
		oj.go()
	}
}

