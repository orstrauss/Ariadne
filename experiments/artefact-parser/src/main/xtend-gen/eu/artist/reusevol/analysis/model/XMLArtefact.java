package eu.artist.reusevol.analysis.model;

import eu.artist.reusevol.analysis.model.FileArtefact;
import java.util.Map;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

@Data
@SuppressWarnings("all")
public class XMLArtefact extends FileArtefact {
  private final Map<String, String> _nsMapping = CollectionLiterals.<String, String>newHashMap();
  
  private final Map<String, String> _schemaLocation = CollectionLiterals.<String, String>newHashMap();
  
  public XMLArtefact(final String filename, final String localPath) {
    super(filename, localPath);
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this._nsMapping== null) ? 0 : this._nsMapping.hashCode());
    result = prime * result + ((this._schemaLocation== null) ? 0 : this._schemaLocation.hashCode());
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
    if (!super.equals(obj))
      return false;
    XMLArtefact other = (XMLArtefact) obj;
    if (this._nsMapping == null) {
      if (other._nsMapping != null)
        return false;
    } else if (!this._nsMapping.equals(other._nsMapping))
      return false;
    if (this._schemaLocation == null) {
      if (other._schemaLocation != null)
        return false;
    } else if (!this._schemaLocation.equals(other._schemaLocation))
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
  public Map<String, String> getNsMapping() {
    return this._nsMapping;
  }
  
  @Pure
  public Map<String, String> getSchemaLocation() {
    return this._schemaLocation;
  }
}
