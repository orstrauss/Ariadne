package eu.artist.repo.scanner.builder

import java.io.IOException
import org.eclipse.jgit.lib.Repository
import org.eclipse.ui.console.ConsolePlugin
import org.eclipse.ui.console.MessageConsole
import org.eclipse.ui.plugin.AbstractUIPlugin
import org.osgi.framework.BundleContext
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IResource
import org.eclipse.core.resources.IFile

class Activator2 extends AbstractUIPlugin {
	val public static String PLUGIN_ID = "TestPlugin";
	var static Activator2 plugin
	var static MessageConsole myConsole

	new() {
	}

	override void start(BundleContext context) throws Exception {
		super.start(context)
		plugin = this

		myConsole = new MessageConsole("My Console", null)
		ConsolePlugin.getDefault().getConsoleManager() => [
			addConsoles(#[myConsole])
			showConsoleView(myConsole)
		]

		registerGitListeners
		scanProjects

		Activator2.^default.print("Custom builder initialized.");
	}

	private def registerGitListeners() {

		Repository.globalListenerList => [
			addIndexChangedListener [
				Activator2.^default.print("Git index changed: " + toString())
			]
			addConfigChangedListener [
				Activator2.^default.print("Git config changed: " + toString())
			]
			addRefsChangedListener [
				Activator2.^default.print("Git refs changed: " + toString())
				Activator2.^default.print("Repository: " + repository)
			]
		]
	}
	
	def void scanProjects() {
		val IProject project = ResourcesPlugin.workspace.root.projects.head
		project.accept [
			switch it {
				IFile: {
					val file = it as IFile
					Activator2.^default.print(file.contentDescription?.toString)
					Activator2.^default.print(file.contentDescription?.contentType?.toString)
				}
			}
			Activator2.^default.print(it.fullPath.toString)
			true
		]
	}

	override void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	static def Activator2 getDefault() {
		plugin;
	}

	def void print(String message) {
		try {
			myConsole.newMessageStream() => [
				setActivateOnWrite(true)
				println(message)
				close()
			]
		} catch (IOException ex) {
			println(ex);
		}
	}
}
