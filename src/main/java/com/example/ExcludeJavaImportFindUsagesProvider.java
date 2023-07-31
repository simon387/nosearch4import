package com.example;

import com.intellij.lang.findUsages.FindUsagesProvider;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public class ExcludeJavaImportFindUsagesProvider implements FindUsagesProvider {

	@Override public boolean canFindUsagesFor ( @NotNull PsiElement psiElement ) {
		return false;
	}

	@Override public @Nullable @NonNls String getHelpId ( @NotNull PsiElement psiElement ) {
		return null;
	}

	@Override public @Nls @NotNull String getType ( @NotNull PsiElement element ) {
		return null;
	}

	@Override public @Nls @NotNull String getDescriptiveName ( @NotNull PsiElement element ) {
		return null;
	}

	@Override public @Nls @NotNull String getNodeText ( @NotNull PsiElement element, boolean useFullName ) {
		return null;
	}
}
