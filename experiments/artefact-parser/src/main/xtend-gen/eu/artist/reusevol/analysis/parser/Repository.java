package eu.artist.reusevol.analysis.parser;

import eu.artist.reusevol.analysis.parser.Relationship;
import eu.artist.reusevol.analysis.parser.Representation;
import java.util.List;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

@Data
@SuppressWarnings("all")
public class Repository {
  private final List<Representation> _artefacts = CollectionLiterals.<Representation>newArrayList();
  
  private final List<Relationship> _relations = CollectionLiterals.<Relationship>newArrayList();
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this._artefacts== null) ? 0 : this._artefacts.hashCode());
    result = prime * result + ((this._relations== null) ? 0 : this._relations.hashCode());
    return result;
  }
  
  @Override
  @Pure
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Repository other = (Repository) obj;
    if (this._artefacts == null) {
      if (other._artefacts != null)
        return false;
    } else if (!this._artefacts.equals(other._artefacts))
      return false;
    if (this._relations == null) {
      if (other._relations != null)
        return false;
    } else if (!this._relations.equals(other._relations))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
  
  @Pure
  public List<Representation> getArtefacts() {
    return this._artefacts;
  }
  
  @Pure
  public List<Relationship> getRelations() {
    return this._relations;
  }
}
