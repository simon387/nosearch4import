package it.simonecelia.nosearch4import.actions;

import com.intellij.find.FindManager;
import com.intellij.find.FindModel;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;

public class MyFindInFileAction extends AnAction {
	@Override
	public void actionPerformed(AnActionEvent e) {
		Project project = e.getProject();
		if (project == null) {
			return;
		}
		FindModel findModel = FindManager.getInstance(project).getFindInFileModel();
		findModel.setFileFilter("*.txt");
		//super.actionPerformed(e);

	}
}
