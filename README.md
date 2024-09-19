## Key concepts in AOP
1. Aspect: an aspect is a module that encapsulates a single cross-cutting concern. Example - class created for logging aspect
2. Join Point: These are specific points in your program where you might want to inject additional behavior or logic. Example - methods, constructors
3. Advice: It’s the code associated with an aspect that gets executed when a specific join point is reached. Example - implementing logging/security for any method. 
4. Pointcut: They are expressions that match certain join points.

## Types of advices
1. @Before - executes before method execution
2. @After - executes after method execution
3. @AfterReturning - similar to @After but it runs only after a normal execution of the method(no exception). This can also be used to access the returning object.
4. @AfterThrowing - similar to @After but it runs only after an exception is thrown.
5. @Around - This annotation allows us to take actions either before or after a JoinPoint method is run. We can use it to return a custom value or throw an exception or simply let the method run and return normally.

## Types of pointcuts
1. execution - It allows you to target method executions in your classes.
2. within - Use within() when you want to limit the advice to a particular class or package, without focusing on specific methods. This pointcut applies to any join point within the package, including methods, fields, and constructors.
3. annotation - Use @annotation() when you want to apply advice to methods annotated with a particular annotation.

## Pointcut declaration
The pointcut is defined separately using @Pointcut and then referenced bythe advice annotations. Example -
![image](https://github.com/user-attachments/assets/a4238998-5186-45ec-9f46-6b9bba4bdd05)
![image](https://github.com/user-attachments/assets/89d71ad2-f5cb-4b2b-a65e-65bebc2a15c4)

## Example Breakdown
*- any return type <br/>
orderPackage - any method in application by this name <br/>
orderPackage(..) - takes any parameters <br/>
should execute advice before/after <method> which takes (..) parameter and has * return type <br/>
![image](https://github.com/user-attachments/assets/5be44575-e1bc-44bd-b094-41cee379c848)

## JoinPoint and ProceedingJoinPoint
In Spring AOP, both JoinPoint and ProceedingJoinPoint are used to capture details about a point in the program's execution where an aspect is applied, but they serve slightly different purposes.
1. JoinPoint -
* It is used in advice types such as @Before, @After, and @AfterThrowing.
* Key methods -
  * getSignature() - Provides details about the intercepted method (e.g., name, return type, etc.).
  * getArgs(): Retrieves the arguments passed to the method.
  * getTarget(): Returns the target object on which the method is called.
2. ProceedingJoinPoint -
* It is a subclass of JoinPoint and is used specifically in @Around advice. It provides the ability to control the execution of the method being intercepted — it allows you to "proceed" with the method call or even modify its behavior.
* Key method -
  * proceed(): This method is used to continue the execution of the method or the next advice in the chain. You can also control when or if the method proceeds, and even change the return value.
* Use Case: Essential for @Around advice, where you might want to execute custom logic before and after a method call, or even skip method execution altogether.
