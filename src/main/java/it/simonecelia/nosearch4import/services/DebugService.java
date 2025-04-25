package it.simonecelia.nosearch4import.services;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.Service;
import com.intellij.openapi.diagnostic.Logger;


@Service
public final class DebugService {

	private static final Logger LOG = Logger.getInstance ( DebugService.class );

	public DebugService () {
		LOG.warn ( "DebugService inizializzato - plugin caricato!" );
	}

	public static DebugService getInstance () {
		return ApplicationManager.getApplication ().getService ( DebugService.class );
	}
}