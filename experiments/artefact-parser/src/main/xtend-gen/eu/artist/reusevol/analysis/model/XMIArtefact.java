package eu.artist.reusevol.analysis.model;

import eu.artist.reusevol.analysis.model.UMLElement;
import eu.artist.reusevol.analysis.model.XMLArtefact;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.function.Consumer;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@SuppressWarnings("all")
public class XMIArtefact extends XMLArtefact {
  private final List<String> references = CollectionLiterals.<String>newArrayList();
  
  private boolean xmiRootElement;
  
  private final List<UMLElement> classes = CollectionLiterals.<UMLElement>newArrayList();
  
  private final Stack<UMLElement> uml = new Stack<UMLElement>();
  
  public XMIArtefact(final String filename, final String localPath) {
    super(filename, localPath);
    this.xmiRootElement = false;
  }
  
  public List<String> getReferences() {
    return this.references;
  }
  
  public List<UMLElement> getClasses() {
    return this.classes;
  }
  
  public Stack<UMLElement> getUMLStack() {
    return this.uml;
  }
  
  public boolean hasXmiRootElement() {
    return this.xmiRootElement;
  }
  
  public boolean setXmiRootElement(final boolean xmi) {
    return this.xmiRootElement = xmi;
  }
  
  public Set<String> getSysIdReferences() {
    return this.getReferencesWithPrefix("http://");
  }
  
  public Set<String> getLocalReferences() {
    Set<String> _xblockexpression = null;
    {
      final Set<String> localIds = CollectionLiterals.<String>newHashSet();
      final Consumer<String> _function = new Consumer<String>() {
        public void accept(final String it) {
          String[] _split = it.split("#");
          final String mainPart = _split[0];
          boolean _contains = mainPart.contains("://");
          boolean _not = (!_contains);
          if (_not) {
            localIds.add(mainPart);
          }
        }
      };
      this.references.forEach(_function);
      _xblockexpression = localIds;
    }
    return _xblockexpression;
  }
  
  public Set<String> getReferencesWithPrefix(final String prefix) {
    Set<String> _xblockexpression = null;
    {
      final Set<String> ids = CollectionLiterals.<String>newHashSet();
      final Consumer<String> _function = new Consumer<String>() {
        public void accept(final String it) {
          String[] _split = it.split("#");
          final String mainPart = _split[0];
          boolean _startsWith = mainPart.startsWith(prefix);
          if (_startsWith) {
            ids.add(mainPart);
          }
        }
      };
      this.references.forEach(_function);
      _xblockexpression = ids;
    }
    return _xblockexpression;
  }
}
