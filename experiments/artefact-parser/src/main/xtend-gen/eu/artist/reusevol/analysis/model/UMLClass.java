package eu.artist.reusevol.analysis.model;

import eu.artist.reusevol.analysis.model.UMLElement;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@SuppressWarnings("all")
public class UMLClass extends UMLElement {
  private final List<String> methods = CollectionLiterals.<String>newArrayList();
  
  public UMLClass(final String name, final String id) {
    super(name, id);
  }
  
  public List<String> getMethods() {
    return this.methods;
  }
}
