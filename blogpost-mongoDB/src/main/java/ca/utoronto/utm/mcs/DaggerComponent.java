package ca.utoronto.utm.mcs;

import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(modules = DaggerModule.class)
public interface DaggerComponent {

	public Dagger buildMongoHttp();
}
