package eu.artist.repo.scanner.builder;

import java.io.IOException;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jgit.events.ConfigChangedEvent;
import org.eclipse.jgit.events.ConfigChangedListener;
import org.eclipse.jgit.events.IndexChangedEvent;
import org.eclipse.jgit.events.IndexChangedListener;
import org.eclipse.jgit.events.RefsChangedEvent;
import org.eclipse.jgit.events.RefsChangedListener;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "TestPlugin"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;
	
	private static MessageConsole myConsole;
	
	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		
        myConsole = new MessageConsole("My Console", null);
        //myConsole.activate();
        ConsolePlugin.getDefault().getConsoleManager().addConsoles(new IConsole[]{ myConsole });
        ConsolePlugin.getDefault().getConsoleManager().showConsoleView(myConsole);
		
		Repository.getGlobalListenerList().addIndexChangedListener(new MyIndexChangedListener());
		Repository.getGlobalListenerList().addConfigChangedListener(new MyConfigChangedListener());
		Repository.getGlobalListenerList().addRefsChangedListener(new MyRefsChangedListener());
		
        Activator.getDefault().print("Custom builder initialized.");
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}
	
	public void print(String message) {
		try {
	        final MessageConsoleStream stream = myConsole.newMessageStream();
	        stream.setActivateOnWrite(true);
	        stream.println(message);
	        stream.close();
		} catch(IOException ex) {
			System.out.println(ex);
		}
	}

	/**
	 * Returns an image descriptor for the image file at the given
	 * plug-in relative path
	 *
	 * @param path the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}
}

class MyIndexChangedListener implements IndexChangedListener {

	@Override
	public void onIndexChanged(IndexChangedEvent event) {
		Activator.getDefault().print("Git index changed: " + event.toString());		
	}
	
}

class MyConfigChangedListener implements ConfigChangedListener {

	@Override
	public void onConfigChanged(ConfigChangedEvent event) {
		Activator.getDefault().print("Git config changed: " + event.toString());
	}

}

class MyRefsChangedListener implements RefsChangedListener {

	@Override
	public void onRefsChanged(RefsChangedEvent event) {
		Activator.getDefault().print("Git refs changed: " + event.toString());
	}

}
