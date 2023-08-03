package view

import model.applicationfunctions.SwingModel
import java.awt.GridLayout
import javax.swing.JButton
import javax.swing.JLabel
import javax.swing.JPanel

class HeaderPanel(model: SwingModel): JPanel() {
	init {
		layout = GridLayout(2,1)

		add(createTopLayer())
		add(MessageLabel(model))
	}

	private fun createTitleLabel():JLabel {
		val res = JLabel(
			StringsManager.get("application_title")
		)
		res.isEnabled = true
		return res
	}

	private fun createRepositoryButton(): JButton {
		val res = JButton(
			StringsManager.get("go_to_repository")
		)

		val repositoryUrl = "https://github.com/MaxBuster380/OneShot-Color-Filter"

		res.isEnabled = true

		res.addActionListener {
			val rt = Runtime.getRuntime()
			rt.exec("rundll32 url.dll,FileProtocolHandler $repositoryUrl")

		}

		return res
	}

	private fun createTopLayer():JPanel {
		val res = JPanel()

		res.layout = GridLayout(1,3)

		add(createTitleLabel())
		add(JPanel())
		add(createRepositoryButton())

		return res
	}
}