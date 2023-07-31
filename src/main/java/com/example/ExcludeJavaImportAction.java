package com.example;

import com.intellij.find.FindManager;
import com.intellij.find.FindModel;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.psi.PsiElement;


public class ExcludeJavaImportAction extends AnAction {
	@Override
	public void actionPerformed(AnActionEvent e) {
		Project project = e.getProject();
		if (project == null) {
			return;
		}

		// Ottieni l'istanza del FindManager per eseguire la ricerca
		FindManager findManager = FindManager.getInstance(project);

		// Crea un nuovo modello di ricerca (FindModel)
		FindModel findModel = new FindModel();
		// Configura il modello di ricerca in base ai tuoi criteri
		// Ad esempio, puoi configurare i file inclusi, i file esclusi, le parole chiave da cercare, ecc.
		// In questo caso, configureremo il modello di ricerca per escludere gli import Java.
		findModel.setStringToFind("import java");
		findModel.setCaseSensitive(false);

		// Esegui la ricerca utilizzando il modello configurato
		ApplicationManager.getApplication().runReadAction(() -> {
			findManager.findUsages( (PsiElement) findModel );
		});
	}
}
