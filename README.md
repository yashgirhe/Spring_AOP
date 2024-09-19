## Key concepts in AOP -
1. Aspect: an aspect is a module that encapsulates a single cross-cutting concern. Example - class created for logging aspect
2. Join Point: These are specific points in your program where you might want to inject additional behavior or logic. Example - methods, constructors
3. Advice: It’s the code associated with an aspect that gets executed when a specific join point is reached. Example - implementing logging/security for any method. 
4. Pointcut: They are expressions that match certain join points.

## Types of advices -
1. @Before - executes before method execution
2. @After - executes after method execution
3. @AfterReturning - similar to @After but it runs only after a normal execution of the method(no exception). This can also be used to access the returning object.
4. @AfterThrowing - similar to @After but it runs only after an exception is thrown.
5. @Around

## Types of pointcuts -
1. execution - It allows you to target method executions in your classes.
2. within - Use within() when you want to limit the advice to a particular class or package, without focusing on specific methods. This pointcut applies to any join point within the package, including methods, fields, and constructors.
3. annotation - Use @annotation() when you want to apply advice to methods annotated with a particular annotation.
