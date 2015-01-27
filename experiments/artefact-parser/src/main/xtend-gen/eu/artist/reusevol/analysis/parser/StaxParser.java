package eu.artist.reusevol.analysis.parser;

import com.google.common.base.Objects;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import eu.artist.reusevol.analysis.model.UMLClass;
import eu.artist.reusevol.analysis.model.UMLContainer;
import eu.artist.reusevol.analysis.model.UMLElement;
import eu.artist.reusevol.analysis.model.UMLModel;
import eu.artist.reusevol.analysis.model.UMLPackage;
import eu.artist.reusevol.analysis.model.XMIArtefact;
import eu.artist.reusevol.analysis.parser.RecordingXMLResolver;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.Namespace;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import org.codehaus.stax2.XMLInputFactory2;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class StaxParser {
  private final String filename;
  
  private final XMLStreamReader parser;
  
  private final Set<String> hrefs;
  
  private final Map<String, String> schemas;
  
  private final List<String> path = CollectionLiterals.<String>newLinkedList();
  
  private final Stack<XMLEvent> stack = new Stack<XMLEvent>();
  
  public StaxParser(final String filename) {
    try {
      this.filename = filename;
      HashSet<String> _hashSet = new HashSet<String>();
      this.hrefs = _hashSet;
      HashMap<String, String> _hashMap = new HashMap<String, String>();
      this.schemas = _hashMap;
      final FileInputStream in = new FileInputStream(filename);
      final XMLInputFactory factory = XMLInputFactory.newInstance();
      XMLStreamReader _createXMLStreamReader = factory.createXMLStreamReader(in);
      this.parser = _createXMLStreamReader;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public Set<String> parseWithEvents(final String filename) {
    try {
      Set<String> _xblockexpression = null;
      {
        final File input = new File(filename);
        final FileInputStream in = new FileInputStream(input);
        final XMLInputFactory factory = XMLInputFactory2.newInstance();
        final RecordingXMLResolver references = new RecordingXMLResolver();
        factory.setXMLResolver(references);
        final XMLEventReader events = factory.createXMLEventReader(in);
        String _name = input.getName();
        String _absolutePath = input.getAbsolutePath();
        final XMIArtefact context = new XMIArtefact(_name, _absolutePath);
        while (events.hasNext()) {
          {
            final XMLEvent event = events.nextEvent();
            int _eventType = event.getEventType();
            switch (_eventType) {
              case XMLEvent.START_ELEMENT:
                StartElement _asStartElement = event.asStartElement();
                this.processEvent(_asStartElement, context);
                break;
              case XMLEvent.END_ELEMENT:
                EndElement _asEndElement = event.asEndElement();
                this.processEvent(_asEndElement, context);
                break;
            }
          }
        }
        InputOutput.<XMIArtefact>println(context);
        Set<String> _sysIdReferences = context.getSysIdReferences();
        InputOutput.<Set<String>>println(_sysIdReferences);
        Set<String> _localReferences = context.getLocalReferences();
        InputOutput.<Set<String>>println(_localReferences);
        Set<String> _referencesWithPrefix = context.getReferencesWithPrefix("pathmap://");
        _xblockexpression = InputOutput.<Set<String>>println(_referencesWithPrefix);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void processEvent(final StartElement event, final XMIArtefact ctx) {
    this.stack.push(event);
    boolean _and = false;
    boolean _and_1 = false;
    QName _name = event.getName();
    String _localPart = _name.getLocalPart();
    boolean _equalsIgnoreCase = _localPart.equalsIgnoreCase("xmi");
    if (!_equalsIgnoreCase) {
      _and_1 = false;
    } else {
      String _namespaceURI = event.getNamespaceURI("xmi");
      boolean _notEquals = (!Objects.equal(_namespaceURI, null));
      _and_1 = _notEquals;
    }
    if (!_and_1) {
      _and = false;
    } else {
      String _namespaceURI_1 = event.getNamespaceURI("xmi");
      boolean _startsWith = _namespaceURI_1.startsWith("http://www.omg.org/spec/XMI");
      _and = _startsWith;
    }
    if (_and) {
      ctx.setXmiRootElement(true);
      InputOutput.<String>println(":XMI Root Element");
    }
    Iterator _namespaces = event.getNamespaces();
    boolean _isEmpty = IteratorExtensions.isEmpty(_namespaces);
    boolean _not = (!_isEmpty);
    if (_not) {
      Iterator _namespaces_1 = event.getNamespaces();
      List<Namespace> _list = IteratorExtensions.<Namespace>toList(_namespaces_1);
      final Consumer<Namespace> _function = new Consumer<Namespace>() {
        public void accept(final Namespace a) {
          Map<String, String> _nsMapping = ctx.getNsMapping();
          QName _name = a.getName();
          String _localPart = _name.getLocalPart();
          String _value = a.getValue();
          _nsMapping.put(_localPart, _value);
        }
      };
      _list.forEach(_function);
      Map<String, String> _nsMapping = ctx.getNsMapping();
      String _plus = (":Namespaces " + _nsMapping);
      InputOutput.<String>println(_plus);
    }
    String _namespaceURI_2 = event.getNamespaceURI("xsi");
    QName _qName = new QName(_namespaceURI_2, "schemaLocation");
    final Attribute location = event.getAttributeByName(_qName);
    boolean _notEquals_1 = (!Objects.equal(location, null));
    if (_notEquals_1) {
      String _value = location.getValue();
      String[] _split = _value.split(" ");
      final Iterator<String> parts = ((List<String>)Conversions.doWrapArray(_split)).iterator();
      while (parts.hasNext()) {
        {
          final String source = parts.next();
          final String dest = parts.next();
          Map<String, String> _schemaLocation = ctx.getSchemaLocation();
          _schemaLocation.put(source, dest);
          List<String> _references = ctx.getReferences();
          _references.add(dest);
        }
      }
      Map<String, String> _schemaLocation = ctx.getSchemaLocation();
      String _plus_1 = (":SchemaLocation " + _schemaLocation);
      InputOutput.<String>println(_plus_1);
    }
    QName _qName_1 = new QName("href");
    final Attribute href = event.getAttributeByName(_qName_1);
    boolean _notEquals_2 = (!Objects.equal(href, null));
    if (_notEquals_2) {
      List<String> _references = ctx.getReferences();
      String _value_1 = href.getValue();
      _references.add(_value_1);
    }
    QName _name_1 = event.getName();
    String _plus_2 = ("Event: " + _name_1);
    String _plus_3 = (_plus_2 + " - ");
    String _breadcrumps = this.breadcrumps();
    String _plus_4 = (_plus_3 + _breadcrumps);
    InputOutput.<String>println(_plus_4);
    this.breadcrumps();
    Iterator _attributes = event.getAttributes();
    List<Attribute> _list_1 = IteratorExtensions.<Attribute>toList(_attributes);
    final Function1<Attribute, String> _function_1 = new Function1<Attribute, String>() {
      public String apply(final Attribute a) {
        QName _name = a.getName();
        String _localPart = _name.getLocalPart();
        String _plus = (_localPart + "=");
        String _value = a.getValue();
        return (_plus + _value);
      }
    };
    List<String> _map = ListExtensions.<Attribute, String>map(_list_1, _function_1);
    String _plus_5 = ("  att: " + _map);
    InputOutput.<String>println(_plus_5);
    boolean _and_2 = false;
    QName _name_2 = event.getName();
    String _prefix = _name_2.getPrefix();
    boolean _equalsIgnoreCase_1 = _prefix.equalsIgnoreCase("uml");
    if (!_equalsIgnoreCase_1) {
      _and_2 = false;
    } else {
      QName _name_3 = event.getName();
      String _localPart_1 = _name_3.getLocalPart();
      boolean _equalsIgnoreCase_2 = _localPart_1.equalsIgnoreCase("model");
      _and_2 = _equalsIgnoreCase_2;
    }
    if (_and_2) {
      String _namespaceURI_3 = event.getNamespaceURI("xmi");
      QName _qName_2 = new QName(_namespaceURI_3, "id");
      final Attribute id = event.getAttributeByName(_qName_2);
      QName _qName_3 = new QName("name");
      final Attribute name = event.getAttributeByName(_qName_3);
      String _value_2 = null;
      if (name!=null) {
        _value_2=name.getValue();
      }
      String _value_3 = null;
      if (id!=null) {
        _value_3=id.getValue();
      }
      final UMLModel element = new UMLModel(_value_2, _value_3);
      List<UMLElement> _classes = ctx.getClasses();
      _classes.add(element);
      Stack<UMLElement> _uMLStack = ctx.getUMLStack();
      _uMLStack.push(element);
    }
    boolean _or = false;
    QName _name_4 = event.getName();
    String _localPart_2 = _name_4.getLocalPart();
    boolean _equalsIgnoreCase_3 = _localPart_2.equalsIgnoreCase("packagedElement");
    if (_equalsIgnoreCase_3) {
      _or = true;
    } else {
      QName _name_5 = event.getName();
      String _localPart_3 = _name_5.getLocalPart();
      boolean _equalsIgnoreCase_4 = _localPart_3.equalsIgnoreCase("ownedAttribute");
      _or = _equalsIgnoreCase_4;
    }
    if (_or) {
      this.processUML(event, ctx);
    }
  }
  
  public void processUML(final StartElement event, final XMIArtefact ctx) {
    String _namespaceURI = event.getNamespaceURI("xmi");
    QName _qName = new QName(_namespaceURI, "type");
    final Attribute type = event.getAttributeByName(_qName);
    boolean _equals = Objects.equal(type, null);
    if (_equals) {
      return;
    }
    QName _qName_1 = new QName("name");
    final Attribute name = event.getAttributeByName(_qName_1);
    boolean _notEquals = (!Objects.equal(name, null));
    if (_notEquals) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("*** Found UML element \'");
      String _value = name.getValue();
      _builder.append(_value, "");
      _builder.append("\' of type ");
      String _value_1 = type.getValue();
      _builder.append(_value_1, "");
      _builder.append(".");
      InputOutput.<String>println(_builder.toString());
      final Stack<UMLElement> stack = ctx.getUMLStack();
      String _value_2 = type.getValue();
      String _lowerCase = _value_2.toLowerCase();
      boolean _matched = false;
      if (!_matched) {
        if (Objects.equal(_lowerCase, "uml:package")) {
          _matched=true;
          String _namespaceURI_1 = event.getNamespaceURI("xmi");
          QName _qName_2 = new QName(_namespaceURI_1, "id");
          final Attribute id = event.getAttributeByName(_qName_2);
          String _value_3 = name.getValue();
          String _value_4 = null;
          if (id!=null) {
            _value_4=id.getValue();
          }
          final UMLPackage element = new UMLPackage(_value_3, _value_4);
          UMLElement _peek = stack.peek();
          List<UMLElement> _content = ((UMLContainer) _peek).getContent();
          _content.add(element);
          stack.push(element);
        }
      }
      if (!_matched) {
        if (Objects.equal(_lowerCase, "uml:class")) {
          _matched=true;
          String _namespaceURI_2 = event.getNamespaceURI("xmi");
          QName _qName_3 = new QName(_namespaceURI_2, "id");
          final Attribute id_1 = event.getAttributeByName(_qName_3);
          String _value_5 = name.getValue();
          String _value_6 = null;
          if (id_1!=null) {
            _value_6=id_1.getValue();
          }
          final UMLClass element_1 = new UMLClass(_value_5, _value_6);
          UMLElement _peek_1 = stack.peek();
          List<UMLElement> _content_1 = ((UMLContainer) _peek_1).getContent();
          _content_1.add(element_1);
        }
      }
      if (!_matched) {
        if (Objects.equal(_lowerCase, "uml:property")) {
          _matched=true;
        }
      }
    }
  }
  
  public XMLEvent processEvent(final EndElement event, final XMIArtefact ctx) {
    XMLEvent _xblockexpression = null;
    {
      QName _name = event.getName();
      String _plus = ("--- EndEvent: " + _name);
      InputOutput.<String>println(_plus);
      Iterator _namespaces = event.getNamespaces();
      List<Namespace> _list = IteratorExtensions.<Namespace>toList(_namespaces);
      final Function1<Namespace, String> _function = new Function1<Namespace, String>() {
        public String apply(final Namespace a) {
          QName _name = a.getName();
          String _localPart = _name.getLocalPart();
          String _plus = (_localPart + "=");
          String _value = a.getValue();
          return (_plus + _value);
        }
      };
      List<String> _map = ListExtensions.<Namespace, String>map(_list, _function);
      String _plus_1 = ("  nss: " + _map);
      InputOutput.<String>println(_plus_1);
      _xblockexpression = this.stack.pop();
    }
    return _xblockexpression;
  }
  
  public String processEvent(final Characters event) {
    String _data = event.getData();
    String _plus = ("===: " + _data);
    return InputOutput.<String>println(_plus);
  }
  
  public String breadcrumps() {
    final Function1<XMLEvent, String> _function = new Function1<XMLEvent, String>() {
      public String apply(final XMLEvent e) {
        QName _name = ((StartElement) e).getName();
        return _name.getLocalPart();
      }
    };
    List<String> _map = ListExtensions.<XMLEvent, String>map(this.stack, _function);
    return IterableExtensions.join(_map, "/");
  }
  
  public void parseWithCursor() {
    try {
      while (this.parser.hasNext()) {
        {
          int _eventType = this.parser.getEventType();
          switch (_eventType) {
            case XMLStreamConstants.START_DOCUMENT:
              String _version = this.parser.getVersion();
              String _plus = ("START_DOCUMENT: " + _version);
              InputOutput.<String>println(_plus);
              break;
            case XMLStreamConstants.END_DOCUMENT:
              InputOutput.<String>println("END_DOCUMENT: ");
              this.parser.close();
              break;
            case XMLStreamConstants.NAMESPACE:
              String _namespaceURI = this.parser.getNamespaceURI();
              String _plus_1 = ("NAMESPACE: " + _namespaceURI);
              InputOutput.<String>println(_plus_1);
              break;
            case XMLStreamConstants.START_ELEMENT:
              String _localName = this.parser.getLocalName();
              this.path.add(_localName);
              String _localName_1 = this.parser.getLocalName();
              String _plus_2 = ("START_ELEMENT: " + _localName_1);
              InputOutput.<String>println(_plus_2);
              String _join = IterableExtensions.join(this.path, "->");
              String _plus_3 = ("  PATH: " + _join);
              InputOutput.<String>println(_plus_3);
              this.printNamespaceInfo();
              int _attributeCount = this.parser.getAttributeCount();
              ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _attributeCount, true);
              for (final Integer i : _doubleDotLessThan) {
                {
                  String _attributeLocalName = this.parser.getAttributeLocalName((i).intValue());
                  String _string = _attributeLocalName.toString();
                  String _lowerCase = _string.toLowerCase();
                  boolean _matched = false;
                  if (!_matched) {
                    if (Objects.equal(_lowerCase, "href")) {
                      _matched=true;
                      String _attributeValue = this.parser.getAttributeValue((i).intValue());
                      String _localName_2 = this.parser.getLocalName();
                      this.processHref(_attributeValue, _localName_2);
                    }
                  }
                  if (!_matched) {
                    if (Objects.equal(_lowerCase, "source")) {
                      _matched=true;
                      String _attributeValue_1 = this.parser.getAttributeValue((i).intValue());
                      String _localName_3 = this.parser.getLocalName();
                      this.processHref(_attributeValue_1, _localName_3);
                    }
                  }
                  if (!_matched) {
                    if (Objects.equal(_lowerCase, "schemalocation")) {
                      _matched=true;
                      String _attributeValue_2 = this.parser.getAttributeValue((i).intValue());
                      this.processSchemaLocation(_attributeValue_2);
                    }
                  }
                  StringConcatenation _builder = new StringConcatenation();
                  _builder.append("  ");
                  _builder.append("Attribut ");
                  String _attributeLocalName_1 = this.parser.getAttributeLocalName((i).intValue());
                  _builder.append(_attributeLocalName_1, "  ");
                  _builder.append(" = \'");
                  String _attributeValue_3 = this.parser.getAttributeValue((i).intValue());
                  _builder.append(_attributeValue_3, "  ");
                  _builder.append("\' ");
                  InputOutput.<String>println(_builder.toString());
                }
              }
              break;
            case XMLStreamConstants.CHARACTERS:
              boolean _isWhiteSpace = this.parser.isWhiteSpace();
              boolean _not = (!_isWhiteSpace);
              if (_not) {
                String _text = this.parser.getText();
                String _plus_4 = ("  CHARACTERS: " + _text);
                InputOutput.<String>println(_plus_4);
              }
              break;
            case XMLStreamConstants.END_ELEMENT:
              int _length = ((Object[])Conversions.unwrapArray(this.path, Object.class)).length;
              int _minus = (_length - 1);
              this.path.remove(_minus);
              String _localName_2 = this.parser.getLocalName();
              String _plus_5 = ("END_ELEMENT: " + _localName_2);
              InputOutput.<String>println(_plus_5);
              break;
          }
          this.parser.next();
        }
      }
      final Consumer<String> _function = new Consumer<String>() {
        public void accept(final String it) {
          InputOutput.<String>println((" - Link: " + it));
        }
      };
      this.hrefs.forEach(_function);
      final BiConsumer<String, String> _function_1 = new BiConsumer<String, String>() {
        public void accept(final String k, final String v) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append(" ");
          _builder.append("- Mapping ");
          _builder.append(k, " ");
          _builder.append(" -> ");
          _builder.append(v, " ");
          InputOutput.<String>println(_builder.toString());
        }
      };
      this.schemas.forEach(_function_1);
      this.files();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void printNamespaceInfo() {
    String _prefix = this.parser.getPrefix();
    boolean _isNullOrEmpty = Strings.isNullOrEmpty(_prefix);
    boolean _not = (!_isNullOrEmpty);
    if (_not) {
      String _prefix_1 = this.parser.getPrefix();
      String _plus = ("  Namespace prefix: " + _prefix_1);
      InputOutput.<String>println(_plus);
    }
    int _namespaceCount = this.parser.getNamespaceCount();
    boolean _greaterThan = (_namespaceCount > 0);
    if (_greaterThan) {
      int _namespaceCount_1 = this.parser.getNamespaceCount();
      String _plus_1 = ("  Namespace declarations: " + Integer.valueOf(_namespaceCount_1));
      InputOutput.<String>println(_plus_1);
      int _namespaceCount_2 = this.parser.getNamespaceCount();
      ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _namespaceCount_2, true);
      for (final Integer i : _doubleDotLessThan) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("    ");
        _builder.append("Namespace ");
        _builder.append(i, "    ");
        _builder.append(": ");
        String _namespacePrefix = this.parser.getNamespacePrefix((i).intValue());
        _builder.append(_namespacePrefix, "    ");
        _builder.append(" -> ");
        String _namespaceURI = this.parser.getNamespaceURI((i).intValue());
        _builder.append(_namespaceURI, "    ");
        InputOutput.<String>println(_builder.toString());
      }
    }
  }
  
  public boolean processHref(final String link, final String tag) {
    boolean _xblockexpression = false;
    {
      boolean _matched = false;
      if (!_matched) {
        if (Objects.equal(tag, "importedPackage")) {
          _matched=true;
          InputOutput.<String>println(("    Package import from " + link));
        }
      }
      if (!_matched) {
        if (Objects.equal(tag, "type")) {
          _matched=true;
          InputOutput.<String>println(("    Type reference to " + link));
        }
      }
      if (!_matched) {
        InputOutput.<String>println(("    href in tag " + tag));
      }
      _xblockexpression = this.hrefs.add(link);
    }
    return _xblockexpression;
  }
  
  public void processSchemaLocation(final String mapping) {
    InputOutput.<String>println("--- SchemaLocation ---");
    Splitter _on = Splitter.on(" ");
    Iterable<String> _split = _on.split(mapping);
    final Iterator<String> parts = _split.iterator();
    while (parts.hasNext()) {
      String _next = parts.next();
      String _next_1 = parts.next();
      this.schemas.put(_next, _next_1);
    }
  }
  
  public void files() {
    final Splitter splitter = Splitter.on("#");
    final HashSet<String> files = new HashSet<String>();
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
    Iterable<String> _filter = IterableExtensions.<String>filter(this.hrefs, _function);
    final Consumer<String> _function_1 = new Consumer<String>() {
      public void accept(final String it) {
        Iterable<String> _split = splitter.split(it);
        Iterator<String> _iterator = _split.iterator();
        String _next = _iterator.next();
        files.add(_next);
      }
    };
    _filter.forEach(_function_1);
    final BiConsumer<String, String> _function_2 = new BiConsumer<String, String>() {
      public void accept(final String k, final String v) {
        Iterable<String> _split = splitter.split(v);
        Iterator<String> _iterator = _split.iterator();
        String _next = _iterator.next();
        files.add(_next);
      }
    };
    this.schemas.forEach(_function_2);
    final Function1<String, String> _function_3 = new Function1<String, String>() {
      public String apply(final String it) {
        return it;
      }
    };
    List<String> _sortBy = IterableExtensions.<String, String>sortBy(files, _function_3);
    final Consumer<String> _function_4 = new Consumer<String>() {
      public void accept(final String it) {
        try {
          File _file = new File(it);
          String _canonicalPath = _file.getCanonicalPath();
          String _plus = (" - File: " + _canonicalPath);
          InputOutput.<String>println(_plus);
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      }
    };
    _sortBy.forEach(_function_4);
    final Function1<String, Boolean> _function_5 = new Function1<String, Boolean>() {
      public Boolean apply(final String it) {
        return Boolean.valueOf(it.startsWith("http"));
      }
    };
    Iterable<String> _filter_1 = IterableExtensions.<String>filter(this.hrefs, _function_5);
    final Consumer<String> _function_6 = new Consumer<String>() {
      public void accept(final String it) {
        InputOutput.<String>println((" - Webref: " + it));
      }
    };
    _filter_1.forEach(_function_6);
    final Function1<String, Boolean> _function_7 = new Function1<String, Boolean>() {
      public Boolean apply(final String it) {
        return Boolean.valueOf(it.startsWith("pathmap"));
      }
    };
    Iterable<String> _filter_2 = IterableExtensions.<String>filter(this.hrefs, _function_7);
    final Consumer<String> _function_8 = new Consumer<String>() {
      public void accept(final String it) {
        InputOutput.<String>println((" - Localref: " + it));
      }
    };
    _filter_2.forEach(_function_8);
  }
}
