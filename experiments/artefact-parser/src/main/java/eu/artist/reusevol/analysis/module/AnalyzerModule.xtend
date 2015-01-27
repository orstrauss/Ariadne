package eu.artist.reusevol.analysis.module

import com.google.inject.AbstractModule
import com.google.common.eventbus.EventBus
import com.google.inject.matcher.Matchers
import com.google.inject.spi.TypeListener
import com.google.inject.TypeLiteral
import com.google.inject.spi.TypeEncounter
import com.google.inject.spi.InjectionListener

class AnalyzerModule extends AbstractModule {
	val eventBus = new EventBus("Default EventBus")

	override configure() {
		bind(EventBus).toInstance(eventBus);
		
		bindListener(
			Matchers.any(),
			new TypeListener() {
				override <I> void hear(TypeLiteral<I> typeLiteral, TypeEncounter<I> typeEncounter) {
					typeEncounter.register(
						new InjectionListener<I>() {
							override afterInjection(I i) {
								eventBus.register(i)
							}
						})
				}
			}
		)
	}
}
