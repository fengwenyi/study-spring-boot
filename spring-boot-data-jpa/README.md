# JPA

## 枚举

@Enumerated(EnumType.STRING)

EnumType.STRING  枚举的名称

EnumType.ORDINAL  枚举的序号

默认为枚举的序号

## 时间处理

数据库的字段类型有date、time、datetime
而Temporal注解的作用就是帮Java的Date类型进行格式化，一共有三种注解值：

第一种：@Temporal(TemporalType.DATE)——>实体类会封装成日期“yyyy-MM-dd”的 Date类型。

第二种：@Temporal(TemporalType.TIME)——>实体类会封装成时间“hh-MM-ss”的 Date类型。

第三种：@Temporal(TemporalType.TIMESTAMP)——>实体类会封装成完整的时间“yyyy-MM-dd hh:MM:ss”的 Date类型。

