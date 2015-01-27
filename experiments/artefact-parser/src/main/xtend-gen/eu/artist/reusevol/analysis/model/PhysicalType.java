package eu.artist.reusevol.analysis.model;

import java.util.ArrayList;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

@Data
@SuppressWarnings("all")
public class PhysicalType {
  private final String _name;
  
  private final String _mimetype;
  
  private final PhysicalType _parent;
  
  private final ArrayList<PhysicalType> _subtypes = CollectionLiterals.<PhysicalType>newArrayList();
  
  public boolean addSubtype(final String name, final String mimetype) {
    ArrayList<PhysicalType> _subtypes = this.getSubtypes();
    PhysicalType _physicalType = new PhysicalType(name, mimetype, this);
    return _subtypes.add(_physicalType);
  }
  
  public PhysicalType(final String name, final String mimetype, final PhysicalType parent) {
    super();
    this._name = name;
    this._mimetype = mimetype;
    this._parent = parent;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this._name== null) ? 0 : this._name.hashCode());
    result = prime * result + ((this._mimetype== null) ? 0 : this._mimetype.hashCode());
    result = prime * result + ((this._parent== null) ? 0 : this._parent.hashCode());
    result = prime * result + ((this._subtypes== null) ? 0 : this._subtypes.hashCode());
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
    PhysicalType other = (PhysicalType) obj;
    if (this._name == null) {
      if (other._name != null)
        return false;
    } else if (!this._name.equals(other._name))
      return false;
    if (this._mimetype == null) {
      if (other._mimetype != null)
        return false;
    } else if (!this._mimetype.equals(other._mimetype))
      return false;
    if (this._parent == null) {
      if (other._parent != null)
        return false;
    } else if (!this._parent.equals(other._parent))
      return false;
    if (this._subtypes == null) {
      if (other._subtypes != null)
        return false;
    } else if (!this._subtypes.equals(other._subtypes))
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
  public String getName() {
    return this._name;
  }
  
  @Pure
  public String getMimetype() {
    return this._mimetype;
  }
  
  @Pure
  public PhysicalType getParent() {
    return this._parent;
  }
  
  @Pure
  public ArrayList<PhysicalType> getSubtypes() {
    return this._subtypes;
  }
}
