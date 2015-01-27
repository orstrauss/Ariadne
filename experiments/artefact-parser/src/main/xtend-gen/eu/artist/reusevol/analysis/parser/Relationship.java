package eu.artist.reusevol.analysis.parser;

import eu.artist.reusevol.analysis.parser.Representation;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.EqualsHashCode;
import org.eclipse.xtend.lib.annotations.ToString;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Accessors
@ToString
@EqualsHashCode
@SuppressWarnings("all")
public class Relationship {
  private final Representation source;
  
  private final Representation target;
  
  private final String type;
  
  public Relationship(final Representation source, final Representation target, final String type) {
    super();
    this.source = source;
    this.target = target;
    this.type = type;
  }
  
  @Pure
  public Representation getSource() {
    return this.source;
  }
  
  @Pure
  public Representation getTarget() {
    return this.target;
  }
  
  @Pure
  public String getType() {
    return this.type;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("source", this.source);
    b.add("target", this.target);
    b.add("type", this.type);
    return b.toString();
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
    Relationship other = (Relationship) obj;
    if (this.source == null) {
      if (other.source != null)
        return false;
    } else if (!this.source.equals(other.source))
      return false;
    if (this.target == null) {
      if (other.target != null)
        return false;
    } else if (!this.target.equals(other.target))
      return false;
    if (this.type == null) {
      if (other.type != null)
        return false;
    } else if (!this.type.equals(other.type))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.source== null) ? 0 : this.source.hashCode());
    result = prime * result + ((this.target== null) ? 0 : this.target.hashCode());
    result = prime * result + ((this.type== null) ? 0 : this.type.hashCode());
    return result;
  }
}
