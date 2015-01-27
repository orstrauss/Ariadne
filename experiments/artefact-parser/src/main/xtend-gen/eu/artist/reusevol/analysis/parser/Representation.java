package eu.artist.reusevol.analysis.parser;

import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

@Data
@SuppressWarnings("all")
public class Representation {
  private final String _format;
  
  private final String _location;
  
  public Representation(final String format, final String location) {
    super();
    this._format = format;
    this._location = location;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this._format== null) ? 0 : this._format.hashCode());
    result = prime * result + ((this._location== null) ? 0 : this._location.hashCode());
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
    Representation other = (Representation) obj;
    if (this._format == null) {
      if (other._format != null)
        return false;
    } else if (!this._format.equals(other._format))
      return false;
    if (this._location == null) {
      if (other._location != null)
        return false;
    } else if (!this._location.equals(other._location))
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
  public String getFormat() {
    return this._format;
  }
  
  @Pure
  public String getLocation() {
    return this._location;
  }
}
