package eu.artist.reusevol.analysis.model;

import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

@Data
@SuppressWarnings("all")
public class FileArtefact {
  private final String _filename;
  
  private final String _localPath;
  
  public FileArtefact(final String filename, final String localPath) {
    super();
    this._filename = filename;
    this._localPath = localPath;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this._filename== null) ? 0 : this._filename.hashCode());
    result = prime * result + ((this._localPath== null) ? 0 : this._localPath.hashCode());
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
    FileArtefact other = (FileArtefact) obj;
    if (this._filename == null) {
      if (other._filename != null)
        return false;
    } else if (!this._filename.equals(other._filename))
      return false;
    if (this._localPath == null) {
      if (other._localPath != null)
        return false;
    } else if (!this._localPath.equals(other._localPath))
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
  public String getFilename() {
    return this._filename;
  }
  
  @Pure
  public String getLocalPath() {
    return this._localPath;
  }
}
