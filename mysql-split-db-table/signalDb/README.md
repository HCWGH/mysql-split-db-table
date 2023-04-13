# 基于Sharding-jdbc、mysql、mybatisPlus单库分表示例

### demo
#### 1.配置文件
spring.shardingsphere.datasource.names=ds
spring.shardingsphere.datasource.ds.type=com.zaxxer.hikari.HikariDataSource
spring.shardingsphere.datasource.ds.driver-class-name=com.mysql.cj.jdbc.Driver
spring.shardingsphere.datasource.ds.jdbc-url=jdbc:mysql://localhost:3306/test_db_sharding?allowPublicKeyRetrieval=true&useSSL=false&autoReconnect=true&characterEncoding=utf8
spring.shardingsphere.datasource.ds.username=root
spring.shardingsphere.datasource.ds.password=root
######tb_user
spring.shardingsphere.sharding.tables.tb_user.actual-data-nodes=ds.tb_user_$->{0..1}
spring.shardingsphere.sharding.tables.tb_user.table-strategy.inline.sharding-column=id
spring.shardingsphere.sharding.tables.tb_user.table-strategy.inline.algorithm-expression=tb_user_$->{id % 2}
spring.shardingsphere.sharding.tables.tb_user.key-generator.column=id
spring.shardingsphere.sharding.tables.tb_user.key-generator.type=SNOWFLAKE
spring.shardingsphere.sharding.tables.tb_user.key-generator.props.worker.id=123
#####tb_role
spring.shardingsphere.sharding.tables.tb_role.actual-data-nodes=ds.tb_role_$->{0..1}
spring.shardingsphere.sharding.tables.tb_role.table-strategy.inline.sharding-column=id
spring.shardingsphere.sharding.tables.tb_role.table-strategy.inline.algorithm-expression=tb_role_$->{id % 2}
spring.shardingsphere.sharding.tables.tb_role.key-generator.column=id
spring.shardingsphere.sharding.tables.tb_role.key-generator.type=SNOWFLAKE
spring.shardingsphere.sharding.tables.tb_role.key-generator.props.worker.id=123
######tb_user_role
spring.shardingsphere.sharding.tables.tb_user_role.actual-data-nodes=ds.tb_user_role_$->{0..1}
spring.shardingsphere.sharding.tables.tb_user_role.table-strategy.inline.sharding-column=id
spring.shardingsphere.sharding.tables.tb_user_role.table-strategy.inline.algorithm-expression=tb_user_role_$->{id % 2}
spring.shardingsphere.sharding.tables.tb_user_role.key-generator.column=id
spring.shardingsphere.sharding.tables.tb_user_role.key-generator.type=SNOWFLAKE
spring.shardingsphere.sharding.tables.tb_user_role.key-generator.props.worker.id=123
spring.shardingsphere.sharding.binding-tables=tb_user,tb_role,tb_user_role

######mybatis
mybatis-plus.mapper-locations=classpath*:mapping/*.xml
mybatis-plus.typeAliasesPackage=
mybatis-plus.global-config.id-type=1
mybatis-plus.global-config.db-column-underline=false
mybatis-plus.global-config.refresh-mapper=true
mybatis-plus.configuration.map-underscore-to-camel-case=true
mybatis-plus.configuration.cache-enabled=true
mybatis-plus.configuration.lazyLoadingEnabled=true
mybatis-plus.configuration.multipleResultSetsEnabled=true

