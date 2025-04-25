package it.simonecelia.nosearch4import.filters;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiImportStatement;
import com.intellij.psi.PsiImportStaticStatement;
import com.intellij.usages.Usage;
import com.intellij.usages.rules.PsiElementUsage;
import com.intellij.usages.rules.UsageFilteringRule;
import org.jetbrains.annotations.NotNull;


public class ExceptImportUsageFilter implements UsageFilteringRule {

	@Override
	public boolean isVisible ( @NotNull Usage usage ) {
		if ( !( usage instanceof PsiElementUsage ) ) {
			return true;
		}
		PsiElement element = ( (PsiElementUsage) usage ).getElement ();
		PsiElement current = element;
		while ( current != null ) {
			if ( current instanceof PsiImportStatement || current instanceof PsiImportStaticStatement ) {
				return false;
			}
			current = current.getParent ();
		}
		return true;
	}
}