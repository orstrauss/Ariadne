package eu.artist.reusevol.analysis.parser;

import com.google.common.collect.Iterables;
import eu.artist.reusevol.analysis.parser.XMIAnalyser;
import eu.artist.reusevol.analysis.parser.XMIAnalysisResult;
import java.io.File;
import java.util.Set;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class Analyser {
  private final Set<File> toDo = CollectionLiterals.<File>newHashSet();
  
  private final Set<File> processed = CollectionLiterals.<File>newHashSet();
  
  private final Set<XMIAnalysisResult> closure = CollectionLiterals.<XMIAnalysisResult>newHashSet();
  
  private final XMIAnalyser xmi = new XMIAnalyser();
  
  public Analyser(final File start) {
    this.toDo.add(start);
  }
  
  public Set<XMIAnalysisResult> run() {
    Set<XMIAnalysisResult> _xblockexpression = null;
    {
      while ((!this.toDo.isEmpty())) {
        {
          final File current = ((File[])Conversions.unwrapArray(this.toDo, File.class))[0];
          String _absolutePath = current.getAbsolutePath();
          String _plus = ("Analysing file " + _absolutePath);
          InputOutput.<String>println(_plus);
          this.analyseFile(current);
          this.toDo.remove(current);
          this.processed.add(current);
        }
      }
      _xblockexpression = InputOutput.<Set<XMIAnalysisResult>>println(this.closure);
    }
    return _xblockexpression;
  }
  
  public boolean analyseFile(final File file) {
    boolean _xblockexpression = false;
    {
      final XMIAnalysisResult result = this.xmi.parse(file);
      this.closure.add(result);
      Iterable<File> _fileReferences = result.fileReferences();
      final Function1<File, Boolean> _function = new Function1<File, Boolean>() {
        public Boolean apply(final File it) {
          boolean _contains = Analyser.this.processed.contains(it);
          return Boolean.valueOf((!_contains));
        }
      };
      Iterable<File> _filter = IterableExtensions.<File>filter(_fileReferences, _function);
      _xblockexpression = Iterables.<File>addAll(this.toDo, _filter);
    }
    return _xblockexpression;
  }
}
