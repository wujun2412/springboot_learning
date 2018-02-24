通常情况下，Spring Boot的自动配置是符合我们大多数需求的。
在你既需要保留Spring Boot提供的便利，又需要增加自己的额外的配置的时候，可以定义一个配置类并继承WebMvcConfigurerAdapter,无需使用@EnableWebMvc注解。
参考：https://note.youdao.com/share/index.html?id=bace84b1f9865f426a605e9e514c39f2&type=note#/


