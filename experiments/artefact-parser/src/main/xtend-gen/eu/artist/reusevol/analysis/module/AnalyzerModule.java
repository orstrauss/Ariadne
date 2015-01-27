package eu.artist.reusevol.analysis.module;

import com.google.common.eventbus.EventBus;
import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.binder.AnnotatedBindingBuilder;
import com.google.inject.matcher.Matcher;
import com.google.inject.matcher.Matchers;
import com.google.inject.spi.InjectionListener;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;

@SuppressWarnings("all")
public class AnalyzerModule extends AbstractModule {
  private final EventBus eventBus = new EventBus("Default EventBus");
  
  public void configure() {
    AnnotatedBindingBuilder<EventBus> _bind = this.<EventBus>bind(EventBus.class);
    _bind.toInstance(this.eventBus);
    Matcher<Object> _any = Matchers.any();
    this.bindListener(_any, 
      new TypeListener() {
        public <I extends Object> void hear(final TypeLiteral<I> typeLiteral, final TypeEncounter<I> typeEncounter) {
          typeEncounter.register(
            new InjectionListener<I>() {
              public void afterInjection(final I i) {
                AnalyzerModule.this.eventBus.register(i);
              }
            });
        }
      });
  }
}
