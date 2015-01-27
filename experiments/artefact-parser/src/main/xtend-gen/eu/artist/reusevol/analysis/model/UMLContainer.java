package eu.artist.reusevol.analysis.model;

import eu.artist.reusevol.analysis.model.UMLElement;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@SuppressWarnings("all")
public class UMLContainer extends UMLElement {
  private final List<UMLElement> content = CollectionLiterals.<UMLElement>newArrayList();
  
  public UMLContainer(final String name, final String id) {
    super(name, id);
  }
  
  public List<UMLElement> getContent() {
    return this.content;
  }
}
