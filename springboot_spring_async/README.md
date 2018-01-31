概要说明
在此篇文章中，我们根据使用@Async注解进行探索Spring对异步执行的支持。

简单的把@Async注解放到Bean的方法上就会使用不同的线程运行，也就是说，调用者执行此方法不用一直等待整个方法执行完毕。

在Spring中比较有趣的一点就是事件机制也支持异步处理，如果你想这样使用的话。

配置并开启@Async扫描支持
让我们开始使用JAVA的注解配置开启异步处理机制，只需要简单的加上@EnableAsync注解到配置类上即可。

@Configuration
@EnableAsync
public class SpringAsyncConfig { ... }
1
2
3
通过加上简单的注解基本就满足需要了，但如果你有其它需要，依然也有几种简单选项供你设置：

annotation - 默认情况下, @EnableAsync 会扫描使用了Spring @Async与EJB 3.1 javax.ejb.Asynchronous的方法；此选项也可以用来扫描其他的，如用户自定义的注解类型；
mode - 指定应该使用哪种AOP进行切面处理 - JAVA代理或AspectJ；
proxyTargetClass - 指定应该使用哪种代理类 - CGLIB或JDK;此属性只有当mode设置成AdviceMode.PROXY才会产生效果。
order - 设置AsyncAnnotationBeanPostProcessor执行顺序(生命周期有关);默认情况下会最后一个执行，所以这样就能顾及到所有已存在的代理。
异步处理方式配置也可以使用XML进行配置，通过使用task的namespace。

<task:executor id="myexecutor" pool-size="5"  />
<task:annotation-driven executor="myexecutor"/>
1
2
关于@Async注解
首先 - 让我们来了解一些规则 - @Async有两点局限性（无法正常工作）。

方法名必须是public进行修饰的
必须不能在同一个类中调用异步方法
原因很简单 - 方法名必须用public修饰才能被进行代理;而同一个类中调用方法的话会略过代理进行直接调用。

方法无返回值
下例就是一个简单的无返回值的异步运行方法:

@Async
public void asyncMethodWithVoidReturnType() {
    System.out.println("Execute method asynchronously. "
      + Thread.currentThread().getName());
}
1
2
3
4
5
方法有返回值
@Async 注解的方法也可以指定返回类型 - 只需在Future的泛型中指定所需要返回的类型即可。

@Async
public Future<String> asyncMethodWithReturnType() {
    System.out.println("Execute method asynchronously - "
      + Thread.currentThread().getName());
    try {
        Thread.sleep(5000);
        return new AsyncResult<String>("hello world !!!!");
    } catch (InterruptedException e) {
        //
    }

    return null;
}
1
2
3
4
5
6
7
8
9
10
11
12
13
Spring 同样也提供了一个Future的实现类叫AsyncResult，此类可以用来跟踪异步方法调用结果。 
现在,让我们来调用上面的方法并通过Future进行获取到异步处理的结果。

public void testAsyncAnnotationForMethodsWithReturnType()
  throws InterruptedException, ExecutionException {
    System.out.println("Invoking an asynchronous method. "
      + Thread.currentThread().getName());
    Future<String> future = asyncAnnotationExample.asyncMethodWithReturnType();

    while (true) {
        if (future.isDone()) {
            System.out.println("Result from asynchronous process - " + future.get());
            break;
        }
        System.out.println("Continue doing something else. ");
        Thread.sleep(1000);
    }
}
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
关于Executor
默认情况下,Spring使用SimpleAsyncTaskExecutor来运行这些异步方法,默认的设置方式可以在两个层级上面进行覆盖 - 在应用全局配置上或在单独的方法上。

单独的方法上覆盖Executor
在配置类中配置所需的executor:

@Configuration
@EnableAsync
public class SpringAsyncConfig {

    @Bean(name = "threadPoolTaskExecutor")
    public Executor threadPoolTaskExecutor() {
        return new ThreadPoolTaskExecutor();
    }
}
1
2
3
4
5
6
7
8
9
然后,在@Async注解属性中使用executor的名称:

@Async("threadPoolTaskExecutor")
public void asyncMethodWithConfiguredExecutor() {
    System.out.println("Execute method with configured executor - "
      + Thread.currentThread().getName());
}
1
2
3
4
5
应用全局配置上覆盖Executor
配置类应该实现AsyncConfigurer接口 - 意思是getAsyncExecutor方法需要我们自己来进行实现，会返回Executor给整个应用实例使用 - 意味着现在充当默认的Executor去运行加了@Async注解的方法。

@Configuration
@EnableAsync
public class SpringAsyncConfig implements AsyncConfigurer {

    @Override
    public Executor getAsyncExecutor() {
        return new ThreadPoolTaskExecutor();
    }

}
1
2
3
4
5
6
7
8
9
10
异常处理
由于返回值类型是Future，异常处理就简单了 - Future.get()会抛出异常。 
但是,如果返回类型是void,异常将无法正常传送到调用的线程. 因此，我们需要添加一些额外的配置来处理异常。 
我们创建一个实现了AsyncUncaughtExceptionHandler接口的自定义异步异常处理类.一旦任意未捕获的异常产生后都会调用handleUncaughtException()方法。

public class CustomAsyncExceptionHandler
  implements AsyncUncaughtExceptionHandler {

    @Override
    public void handleUncaughtException(
      Throwable throwable, Method method, Object... obj) {

        System.out.println("Exception message - " + throwable.getMessage());
        System.out.println("Method name - " + method.getName());
        for (Object param : obj) {
            System.out.println("Parameter value - " + param);
        }
    }

}
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
在上一个代码段中,我们看到配置类实现了AsyncConfigurer接口.根据其中的部分，我们同样也需要实现getAsyncUncaughtExceptionHandler()方法来自定义我们的异步异常处理类:

@Override
public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
    return new CustomAsyncExceptionHandler();
}
1
2
3
4
结论
在本章中，我们看到利用Spring运行一个异步任务只需要配置一些很简单的内容就可以达到效果了，但我们同样也看到更多高级的配置用法，如：自定义Executor或自定义异常处理策略。 
然后，和往常一样，本文中出现的代码在Github中可以查看，点击这里。

原文出处
http://www.baeldung.com/spring-async