package SPU.oop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //включается в build
@Target(ElementType.TYPE) // действует на классы и интерфейсы

public @interface Periodic {
}
// Анотации - аналог атрибутов в С
// разновидность интерфейса-маркера, которые могут добавлять метаданные
// не только классам а и их состовляющим частям (поля методы и т.д.)