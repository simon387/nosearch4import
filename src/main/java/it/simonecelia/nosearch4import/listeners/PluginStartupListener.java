package it.simonecelia.nosearch4import.listeners;

import com.intellij.ide.AppLifecycleListener;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.Nullable;


public class PluginStartupListener implements AppLifecycleListener {

	private static final Logger LOG = Logger.getInstance ( PluginStartupListener.class );

	@Override
	public void appStarted () {
		LOG.info ( "Plugin NoSearch4Import avviato correttamente" );
	}

	public void projectOpened ( @Nullable Project project ) {
		if ( project != null ) {
			LOG.info ( "Progetto aperto: " + project.getName () );
		}
	}
}