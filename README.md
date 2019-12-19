# How to create a Test Data Builder

## Environment

 * Maven
 * Java JDK 11+
 * Lombok plugin
 * Enable _Annotation Processing_
 
## Project Structure
The project structure is described in a logical way showing how is the easiest way to create an object with data to use 
in your test and, at the end, the recommendation using the Test Data Builder. 

### src/main

#### model/plain
The `UserRegistration` class is a plain object with _getters_ and _setters_, _constructor_ and _toString()_.

The `UserRegistrationBuilder` is the Builder pattern applied using the `UserRegistration` class to make easier the object creation.

> :warning: This approach is not recommended but if your not used to create Java classes, this might be helpful.

#### model/lombok
To avoid you to write get, setters, toString and builders you can use Lombok.
On the `UserRegistration` class you can see the `@Data` and `Builder` that, respectively, automatically create the get 
and setters, and the builder.

> :warning: This approach is not recommended. The only difference between this and the plain approach is that now we are 
using less code.

### data
This package contains the Test Data Builder classes.
Both classes on this package uses `UserRegister` object created with Lombok.

The `UserRegistrationFixedData` has all the methods to create different data, but with fixed data, 
which means your tests will have the same data all the time.

The `UserRegistrationData` has all method to create different dynamic data. Faker is being using to generate the data.
Even though you use the same method twice in your test, the data will be different.

### src/test

#### plain
The class `PlainClassTest` shows how is the process to create a test with data to use in your test **in the regular way**.

The class `PlainClassUsingBuilderTest` shows how is the process to create a test with **data using a builder**.

#### lombok
The class `UsingLombokBuilderTest` shows the same approach of the previous one, but using lombok with builder in order to have less code.

#### data
The class `UsingFixedDataTest` shows how is the process to **create a test with the Test Data Builder having fixed data**.

This class is being used on `UsingDynamicDataTest` to show how is the process to **create a test with the Test Data Builder having dynamic data**.

### resources
Log4J2 properties files used to show the log information in the console.
Note that Log4J2 is being using directly on test classes `PlainClassTest`, `PlainClassUsingBuilderTest` and `UsingLombokBuilderTest` but when we 
start using a concrete example of the Test Data Builder the log are is being used on these tests.

I created this approach to add the responsibility of the data longing in the right place: the place they are being generated.

## References
 * https://martinfowler.com/bliki/ObjectMother.html
 * https://reflectoring.io/objectmother-fluent-builder
 * https://blog.codeleak.pl/2014/06/test-data-builders-and-object-mother.html
