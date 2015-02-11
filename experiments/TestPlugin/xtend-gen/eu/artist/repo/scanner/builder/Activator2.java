package eu.artist.repo.scanner.builder;

import java.io.IOException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.content.IContentDescription;
import org.eclipse.core.runtime.content.IContentType;
import org.eclipse.jgit.events.ConfigChangedEvent;
import org.eclipse.jgit.events.ConfigChangedListener;
import org.eclipse.jgit.events.IndexChangedEvent;
import org.eclipse.jgit.events.IndexChangedListener;
import org.eclipse.jgit.events.ListenerList;
import org.eclipse.jgit.events.RefsChangedEvent;
import org.eclipse.jgit.events.RefsChangedListener;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.osgi.framework.BundleContext;

@SuppressWarnings("all")
public class Activator2 extends AbstractUIPlugin {
  public final static String PLUGIN_ID = "TestPlugin";
  
  private static Activator2 plugin;
  
  private static MessageConsole myConsole;
  
  public Activator2() {
  }
  
  public void start(final BundleContext context) throws Exception {
    super.start(context);
    Activator2.plugin = this;
    MessageConsole _messageConsole = new MessageConsole("My Console", null);
    Activator2.myConsole = _messageConsole;
    ConsolePlugin _default = ConsolePlugin.getDefault();
    IConsoleManager _consoleManager = _default.getConsoleManager();
    final Procedure1<IConsoleManager> _function = new Procedure1<IConsoleManager>() {
      public void apply(final IConsoleManager it) {
        it.addConsoles(new IConsole[] { Activator2.myConsole });
        it.showConsoleView(Activator2.myConsole);
      }
    };
    ObjectExtensions.<IConsoleManager>operator_doubleArrow(_consoleManager, _function);
    this.registerGitListeners();
    this.scanProjects();
    Activator2 _default_1 = Activator2.getDefault();
    _default_1.print("Custom builder initialized.");
  }
  
  private ListenerList registerGitListeners() {
    ListenerList _globalListenerList = Repository.getGlobalListenerList();
    final Procedure1<ListenerList> _function = new Procedure1<ListenerList>() {
      public void apply(final ListenerList it) {
        final IndexChangedListener _function = new IndexChangedListener() {
          public void onIndexChanged(final IndexChangedEvent it) {
            Activator2 _default = Activator2.getDefault();
            String _string = it.toString();
            String _plus = ("Git index changed: " + _string);
            _default.print(_plus);
          }
        };
        it.addIndexChangedListener(_function);
        final ConfigChangedListener _function_1 = new ConfigChangedListener() {
          public void onConfigChanged(final ConfigChangedEvent it) {
            Activator2 _default = Activator2.getDefault();
            String _string = it.toString();
            String _plus = ("Git config changed: " + _string);
            _default.print(_plus);
          }
        };
        it.addConfigChangedListener(_function_1);
        final RefsChangedListener _function_2 = new RefsChangedListener() {
          public void onRefsChanged(final RefsChangedEvent it) {
            Activator2 _default = Activator2.getDefault();
            String _string = it.toString();
            String _plus = ("Git refs changed: " + _string);
            _default.print(_plus);
            Activator2 _default_1 = Activator2.getDefault();
            Repository _repository = it.getRepository();
            String _plus_1 = ("Repository: " + _repository);
            _default_1.print(_plus_1);
          }
        };
        it.addRefsChangedListener(_function_2);
      }
    };
    return ObjectExtensions.<ListenerList>operator_doubleArrow(_globalListenerList, _function);
  }
  
  public void scanProjects() {
    try {
      IWorkspace _workspace = ResourcesPlugin.getWorkspace();
      IWorkspaceRoot _root = _workspace.getRoot();
      IProject[] _projects = _root.getProjects();
      final IProject project = IterableExtensions.<IProject>head(((Iterable<IProject>)Conversions.doWrapArray(_projects)));
      final IResourceVisitor _function = new IResourceVisitor() {
        public boolean visit(final IResource it) throws CoreException {
          boolean _xblockexpression = false;
          {
            boolean _matched = false;
            if (!_matched) {
              if (it instanceof IFile) {
                _matched=true;
                final IFile file = ((IFile) it);
                Activator2 _default = Activator2.getDefault();
                IContentDescription _contentDescription = file.getContentDescription();
                String _string = null;
                if (_contentDescription!=null) {
                  _string=_contentDescription.toString();
                }
                _default.print(_string);
                Activator2 _default_1 = Activator2.getDefault();
                IContentDescription _contentDescription_1 = file.getContentDescription();
                IContentType _contentType = null;
                if (_contentDescription_1!=null) {
                  _contentType=_contentDescription_1.getContentType();
                }
                String _string_1 = null;
                if (_contentType!=null) {
                  _string_1=_contentType.toString();
                }
                _default_1.print(_string_1);
              }
            }
            Activator2 _default = Activator2.getDefault();
            IPath _fullPath = it.getFullPath();
            String _string = _fullPath.toString();
            _default.print(_string);
            _xblockexpression = true;
          }
          return _xblockexpression;
        }
      };
      project.accept(_function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void stop(final BundleContext context) throws Exception {
    Activator2.plugin = null;
    super.stop(context);
  }
  
  public static Activator2 getDefault() {
    return Activator2.plugin;
  }
  
  public void print(final String message) {
    try {
      MessageConsoleStream _newMessageStream = Activator2.myConsole.newMessageStream();
      final Procedure1<MessageConsoleStream> _function = new Procedure1<MessageConsoleStream>() {
        public void apply(final MessageConsoleStream it) {
          try {
            it.setActivateOnWrite(true);
            it.println(message);
            it.close();
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
      ObjectExtensions.<MessageConsoleStream>operator_doubleArrow(_newMessageStream, _function);
    } catch (final Throwable _t) {
      if (_t instanceof IOException) {
        final IOException ex = (IOException)_t;
        InputOutput.<IOException>println(ex);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
}
