package eu.artist.reusevol.analysis.parser;

import com.google.common.base.Objects;
import com.google.common.base.Splitter;
import eu.artist.reusevol.analysis.parser.XMIAnalysisResult;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Functions.Function0;

@SuppressWarnings("all")
public class XMIAnalyser {
  private final XMLInputFactory factory = new Function0<XMLInputFactory>() {
    public XMLInputFactory apply() {
      try {
        XMLInputFactory _newInstance = XMLInputFactory.newInstance();
        return _newInstance;
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    }
  }.apply();
  
  public XMIAnalyser() {
  }
  
  public XMIAnalysisResult parse(final File input) {
    try {
      XMIAnalysisResult _xblockexpression = null;
      {
        final FileInputStream in = new FileInputStream(input);
        final XMLStreamReader parser = this.factory.createXMLStreamReader(in);
        final XMIAnalysisResult result = new XMIAnalysisResult(input);
        final List<String> path = CollectionLiterals.<String>newLinkedList();
        while (parser.hasNext()) {
          {
            int _eventType = parser.getEventType();
            switch (_eventType) {
              case XMLStreamConstants.START_DOCUMENT:
                break;
              case XMLStreamConstants.END_DOCUMENT:
                parser.close();
                break;
              case XMLStreamConstants.NAMESPACE:
                break;
              case XMLStreamConstants.START_ELEMENT:
                String _localName = parser.getLocalName();
                path.add(_localName);
                int _namespaceCount = parser.getNamespaceCount();
                boolean _greaterThan = (_namespaceCount > 0);
                if (_greaterThan) {
                  int _namespaceCount_1 = parser.getNamespaceCount();
                  ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _namespaceCount_1, true);
                  for (final Integer i : _doubleDotLessThan) {
                    Map<String, String> _nsMapping = result.getNsMapping();
                    String _namespacePrefix = parser.getNamespacePrefix((i).intValue());
                    String _namespaceURI = parser.getNamespaceURI((i).intValue());
                    _nsMapping.put(_namespacePrefix, _namespaceURI);
                  }
                }
                int _attributeCount = parser.getAttributeCount();
                ExclusiveRange _doubleDotLessThan_1 = new ExclusiveRange(0, _attributeCount, true);
                for (final Integer i_1 : _doubleDotLessThan_1) {
                  String _attributeLocalName = parser.getAttributeLocalName((i_1).intValue());
                  String _string = _attributeLocalName.toString();
                  String _attributeValue = parser.getAttributeValue((i_1).intValue());
                  this.processAttribute(_string, _attributeValue, result);
                }
                break;
              case XMLStreamConstants.CHARACTERS:
                break;
              case XMLStreamConstants.END_ELEMENT:
                int _length = ((Object[])Conversions.unwrapArray(path, Object.class)).length;
                int _minus = (_length - 1);
                path.remove(_minus);
                break;
            }
            parser.next();
          }
        }
        _xblockexpression = result;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public Map<String, String> processSchemaLocation(final String mapping) {
    Map<String, String> _xblockexpression = null;
    {
      final Map<String, String> schemas = CollectionLiterals.<String, String>newHashMap();
      Splitter _on = Splitter.on(" ");
      Iterable<String> _split = _on.split(mapping);
      final Iterator<String> parts = _split.iterator();
      while (parts.hasNext()) {
        String _next = parts.next();
        String _next_1 = parts.next();
        schemas.put(_next, _next_1);
      }
      _xblockexpression = schemas;
    }
    return _xblockexpression;
  }
  
  public Boolean processAttribute(final String name, final String value, final XMIAnalysisResult result) {
    boolean _switchResult = false;
    String _lowerCase = name.toLowerCase();
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(_lowerCase, "href")) {
        _matched=true;
        Set<String> _references = result.getReferences();
        _switchResult = _references.add(value);
      }
    }
    if (!_matched) {
      if (Objects.equal(_lowerCase, "schemalocation")) {
        _matched=true;
        Map<String, String> _schemaMapping = result.getSchemaMapping();
        Map<String, String> _processSchemaLocation = this.processSchemaLocation(value);
        _schemaMapping.putAll(_processSchemaLocation);
      }
    }
    return Boolean.valueOf(_switchResult);
  }
}
