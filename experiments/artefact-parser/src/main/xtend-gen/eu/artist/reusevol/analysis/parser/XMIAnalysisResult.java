package eu.artist.reusevol.analysis.parser;

import com.google.common.collect.Iterables;
import java.io.File;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

@Data
@SuppressWarnings("all")
public class XMIAnalysisResult {
  private final File _file;
  
  private final Map<String, String> _nsMapping = CollectionLiterals.<String, String>newHashMap();
  
  private final Map<String, String> _schemaMapping = CollectionLiterals.<String, String>newHashMap();
  
  private final Set<String> _references = CollectionLiterals.<String>newHashSet();
  
  public Set<String> refSet() {
    Set<String> _xblockexpression = null;
    {
      final Set<String> allRefs = CollectionLiterals.<String>newHashSet();
      Set<String> _references = this.getReferences();
      final Function1<String, String> _function = new Function1<String, String>() {
        public String apply(final String it) {
          String[] _split = it.split("#");
          Iterator<String> _iterator = ((List<String>)Conversions.doWrapArray(_split)).iterator();
          return _iterator.next();
        }
      };
      Iterable<String> _map = IterableExtensions.<String, String>map(_references, _function);
      Iterables.<String>addAll(allRefs, _map);
      Map<String, String> _schemaMapping = this.getSchemaMapping();
      Collection<String> _values = _schemaMapping.values();
      final Function1<String, String> _function_1 = new Function1<String, String>() {
        public String apply(final String it) {
          String[] _split = it.split("#");
          Iterator<String> _iterator = ((List<String>)Conversions.doWrapArray(_split)).iterator();
          return _iterator.next();
        }
      };
      Iterable<String> _map_1 = IterableExtensions.<String, String>map(_values, _function_1);
      Iterables.<String>addAll(allRefs, _map_1);
      _xblockexpression = allRefs;
    }
    return _xblockexpression;
  }
  
  public Iterable<File> fileReferences() {
    Set<String> _refSet = this.refSet();
    final Function1<String, Boolean> _function = new Function1<String, Boolean>() {
      public Boolean apply(final String it) {
        boolean _or = false;
        boolean _startsWith = it.startsWith("http");
        if (_startsWith) {
          _or = true;
        } else {
          boolean _startsWith_1 = it.startsWith("pathmap");
          _or = _startsWith_1;
        }
        return Boolean.valueOf((!_or));
      }
    };
    Iterable<String> _filter = IterableExtensions.<String>filter(_refSet, _function);
    final Function1<String, File> _function_1 = new Function1<String, File>() {
      public File apply(final String it) {
        File _xblockexpression = null;
        {
          File _file = XMIAnalysisResult.this.getFile();
          String _parent = _file.getParent();
          String _plus = (_parent + File.separator);
          String[] _split = it.split("#");
          Iterator<String> _iterator = ((List<String>)Conversions.doWrapArray(_split)).iterator();
          String _next = _iterator.next();
          String _plus_1 = (_plus + _next);
          File _file_1 = new File(_plus_1);
          Path _path = _file_1.toPath();
          Path _normalize = _path.normalize();
          final String path = _normalize.toString();
          _xblockexpression = new File(path);
        }
        return _xblockexpression;
      }
    };
    return IterableExtensions.<String, File>map(_filter, _function_1);
  }
  
  public Iterable<String> externalReferences() {
    Set<String> _refSet = this.refSet();
    final Function1<String, Boolean> _function = new Function1<String, Boolean>() {
      public Boolean apply(final String it) {
        return Boolean.valueOf(it.startsWith("http"));
      }
    };
    return IterableExtensions.<String>filter(_refSet, _function);
  }
  
  public Iterable<String> internalReferences() {
    Set<String> _refSet = this.refSet();
    final Function1<String, Boolean> _function = new Function1<String, Boolean>() {
      public Boolean apply(final String it) {
        return Boolean.valueOf(it.startsWith("pathmap"));
      }
    };
    return IterableExtensions.<String>filter(_refSet, _function);
  }
  
  public String toString() {
    String _xblockexpression = null;
    {
      final StringBuilder result = new StringBuilder();
      StringBuilder _append = result.append("<File: ");
      File _file = this.getFile();
      String _name = _file.getName();
      _append.append(_name);
      Map<String, String> _nsMapping = this.getNsMapping();
      final BiConsumer<String, String> _function = new BiConsumer<String, String>() {
        public void accept(final String key, final String value) {
          StringBuilder _append = result.append("\n  Namespace ");
          StringBuilder _append_1 = _append.append(key);
          StringBuilder _append_2 = _append_1.append(" -> ");
          _append_2.append(value);
        }
      };
      _nsMapping.forEach(_function);
      Map<String, String> _schemaMapping = this.getSchemaMapping();
      final BiConsumer<String, String> _function_1 = new BiConsumer<String, String>() {
        public void accept(final String key, final String value) {
          StringBuilder _append = result.append("\n  Schema    ");
          StringBuilder _append_1 = _append.append(key);
          StringBuilder _append_2 = _append_1.append(" -> ");
          _append_2.append(value);
        }
      };
      _schemaMapping.forEach(_function_1);
      Iterable<File> _fileReferences = this.fileReferences();
      final Consumer<File> _function_2 = new Consumer<File>() {
        public void accept(final File key) {
          StringBuilder _append = result.append("\n  Local     ");
          _append.append(key);
        }
      };
      _fileReferences.forEach(_function_2);
      Iterable<String> _externalReferences = this.externalReferences();
      final Consumer<String> _function_3 = new Consumer<String>() {
        public void accept(final String key) {
          StringBuilder _append = result.append("\n  Extern    ");
          _append.append(key);
        }
      };
      _externalReferences.forEach(_function_3);
      Iterable<String> _internalReferences = this.internalReferences();
      final Consumer<String> _function_4 = new Consumer<String>() {
        public void accept(final String key) {
          StringBuilder _append = result.append("\n  Intern    ");
          _append.append(key);
        }
      };
      _internalReferences.forEach(_function_4);
      result.append("\n");
      _xblockexpression = result.toString();
    }
    return _xblockexpression;
  }
  
  public XMIAnalysisResult(final File file) {
    super();
    this._file = file;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this._file== null) ? 0 : this._file.hashCode());
    result = prime * result + ((this._nsMapping== null) ? 0 : this._nsMapping.hashCode());
    result = prime * result + ((this._schemaMapping== null) ? 0 : this._schemaMapping.hashCode());
    result = prime * result + ((this._references== null) ? 0 : this._references.hashCode());
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
    XMIAnalysisResult other = (XMIAnalysisResult) obj;
    if (this._file == null) {
      if (other._file != null)
        return false;
    } else if (!this._file.equals(other._file))
      return false;
    if (this._nsMapping == null) {
      if (other._nsMapping != null)
        return false;
    } else if (!this._nsMapping.equals(other._nsMapping))
      return false;
    if (this._schemaMapping == null) {
      if (other._schemaMapping != null)
        return false;
    } else if (!this._schemaMapping.equals(other._schemaMapping))
      return false;
    if (this._references == null) {
      if (other._references != null)
        return false;
    } else if (!this._references.equals(other._references))
      return false;
    return true;
  }
  
  @Pure
  public File getFile() {
    return this._file;
  }
  
  @Pure
  public Map<String, String> getNsMapping() {
    return this._nsMapping;
  }
  
  @Pure
  public Map<String, String> getSchemaMapping() {
    return this._schemaMapping;
  }
  
  @Pure
  public Set<String> getReferences() {
    return this._references;
  }
}
