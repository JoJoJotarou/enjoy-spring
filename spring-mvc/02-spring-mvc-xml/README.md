MySQL 数据源配置

```xml

<bean id="dataSource" class="com.mysql.cj.jdbc.MysqlDataSource">
    <property name="url" value="jdbc:mysql://localhost:3306/test" />
    <property name="user" value="root" />
    <property name="password" value="password" />
</bean>
```

HikariCP 连接池配置

```xml

<bean id="dataSource" class="com.zaxxer.hikari.HikariDataSource">
    <!-- 基本的数据库连接信息 -->
    <property name="driverClassName" value="com.mysql.cj.jdbc.Driver" />
    <property name="jdbcUrl" value="jdbc:mysql://localhost:3306/test" />
    <property name="username" value="root" />
    <property name="password" value="password" />

    <!-- 连接池大小等其他 HikariCP 配置 -->
    <property name="maximumPoolSize" value="10" /> <!-- 最大连接数 -->
    <property name="connectionTimeout" value="30000" />  <!-- 连接超时时间 -->
    <property name="idleTimeout" value="600000" />  <!-- 空闲超时 -->
    <property name="maxLifetime" value="1800000" /> <!-- 最大生命周期 -->
</bean>
```

H2 内嵌数据库配置

```xml

<jdbc:embedded-database id="dataSource" generate-name="true" database-name="test" type="H2">
    <jdbc:script location="classpath:h2/data.sql" />
</jdbc:embedded-database>
```