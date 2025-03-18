spring mvc xml 项目种默认使用 XmlWebApplicationContext 上下文容器

```java
// import org.springframework.web.servlet.FrameworkServlet;

public static final Class<?> DEFAULT_CONTEXT_CLASS = XmlWebApplicationContext.class;

private Class<?> contextClass = DEFAULT_CONTEXT_CLASS;

public Class<?> getContextClass() {
    return this.contextClass;
}

protected WebApplicationContext createWebApplicationContext(@Nullable ApplicationContext parent) {
    Class<?> contextClass = getContextClass();
    if (!ConfigurableWebApplicationContext.class.isAssignableFrom(contextClass)) {
        throw new ApplicationContextException(
                "Fatal initialization error in servlet with name '" + getServletName() +
                        "': custom WebApplicationContext class [" + contextClass.getName() +
                        "] is not of type ConfigurableWebApplicationContext");
    }
    ConfigurableWebApplicationContext wac =
            (ConfigurableWebApplicationContext) BeanUtils.instantiateClass(contextClass);

    wac.setEnvironment(getEnvironment());
    wac.setParent(parent);
    String configLocation = getContextConfigLocation();
    if (configLocation != null) {
        wac.setConfigLocation(configLocation);
    }
    configureAndRefreshWebApplicationContext(wac);

    return wac;
}
```