package it.simonecelia.nosearch4import.scopes;

import com.intellij.openapi.project.Project;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.search.SearchScope;
import com.intellij.psi.search.scope.packageSet.CustomScopesProvider;
import com.intellij.psi.search.scope.packageSet.NamedScope;
import com.intellij.psi.search.scope.packageSet.PackageSetFactory;
import com.intellij.psi.search.scope.packageSet.ParsingException;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;


public class ExceptImportScopeProvider implements CustomScopesProvider {

	@Override
	public @NotNull List<NamedScope> getCustomScopes () {
		try {
			return Collections.singletonList (
							new NamedScope ( "Except Import", PackageSetFactory.getInstance ().compile ( "!file:*.java||file[*]:*/import/*" ) )
			);
		} catch ( ParsingException e ) {
			throw new RuntimeException ( e );
		}
	}

	@NotNull
	public SearchScope getScope ( @NotNull Project project ) {
		System.out.println ( "getScope" );
		return GlobalSearchScope.allScope ( project ).intersectWith (
						GlobalSearchScope.notScope (
										GlobalSearchScope.getScopeRestrictedByFileTypes (
														GlobalSearchScope.allScope ( project ),
														null /* qui i tipi di file da escludere */
										)
						)
		);
	}
}