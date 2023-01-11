package it.simonecelia;

import com.intellij.find.FindManager;
import com.intellij.find.FindModel;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.LangDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.InputValidatorEx;
import com.intellij.openapi.ui.Messages;


public class NewFileSearchFilter extends AnAction {

	@Override  public void actionPerformed(AnActionEvent e) {
		Project project = e.getProject();
		if (project == null) {
			return;
		}

		// Ottieni l'istanza della classe FindModel
		FindModel findModel = FindManager.getInstance(project).getFindInFileModel();
		// Prompt dell'utente per inserire un nuovo filtro
		String newFilter = Messages.showInputDialog("Inserisci il nuovo filtro di ricerca:", "Nuovo filtro di ricerca", Messages.getQuestionIcon(), "", new InputValidatorEx() {
			@Override
			public String getErrorText(String s) {
				if (s.isEmpty()) {
					return "Il filtro non può essere vuoto";
				}
				return null;
			}

			@Override
			public boolean checkInput(String s) {
				return !s.isEmpty();
			}

			@Override
			public boolean canClose(String s) {
				return checkInput(s);
			}
		});

		if (newFilter != null) {
			// Aggiungi il nuovo filtro alla ricerca "Trova in file"
			findModel.setFileFilter(newFilter);
		}
	}

	@Override public boolean isDumbAware () {
		return super.isDumbAware ();
	}
}
