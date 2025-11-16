# Spring AI Alibaba 配置指南

## 概述
本指南详细说明了如何正确配置 Spring AI Alibaba 项目，避免常见的依赖配置错误。

## 成功配置的关键要点

### 1. 使用正确的依赖坐标
❌ **错误配置**：
```xml
<dependency>
    <groupId>com.alibaba.cloud</groupId>
    <artifactId>spring-ai-alibaba-starter</artifactId>
    <version>1.0.0.2</version>
</dependency>
```

✅ **正确配置**：
```xml
<dependency>
    <groupId>com.alibaba.cloud.ai</groupId>
    <artifactId>spring-ai-alibaba-starter-dashscope</artifactId>
</dependency>
```

### 2. 必须使用 BOM 依赖管理
这是最关键的配置，必须按照官方文档的完整结构：

```xml
<properties>
    <java.version>21</java.version>
    <spring-ai.version>1.0.0</spring-ai.version>
    <spring-ai-alibaba.version>1.0.0.2</spring-ai-alibaba.version>
    <spring-boot.version>3.4.5</spring-boot.version>
</properties>

<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>com.alibaba.cloud.ai</groupId>
            <artifactId>spring-ai-alibaba-bom</artifactId>
            <version>${spring-ai-alibaba.version}</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-dependencies</artifactId>
            <version>${spring-boot.version}</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.ai</groupId>
            <artifactId>spring-ai-bom</artifactId>
            <version>${spring-ai.version}</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
```

### 3. 添加必要的仓库配置
```xml
<repositories>
    <repository>
        <id>spring-milestones</id>
        <name>Spring Milestones</name>
        <url>https://repo.spring.io/milestone</url>
        <snapshots>
            <enabled>false</enabled>
        </snapshots>
    </repository>
    <repository>
        <id>spring-snapshots</id>
        <name>Spring Snapshots</name>
        <url>https://repo.spring.io/snapshot</url>
        <releases>
            <enabled>false</enabled>
        </releases>
    </repository>
    <repository>
        <id>aliyun-maven</id>
        <name>Aliyun Maven</name>
        <url>https://maven.aliyun.com/repository/public</url>
        <releases>
            <enabled>true</enabled>
        </releases>
        <snapshots>
            <enabled>true</enabled>
        </snapshots>
    </repository>
</repositories>
```

### 4. 完整的依赖配置
```xml
<dependencies>
    <!-- Spring Boot 基础框架 -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    
    <!-- Spring AI Alibaba DashScope 启动器 -->
    <dependency>
        <groupId>com.alibaba.cloud.ai</groupId>
        <artifactId>spring-ai-alibaba-starter-dashscope</artifactId>
    </dependency>
    
    <!-- HTTP 客户端 -->
    <dependency>
        <groupId>com.squareup.okhttp3</groupId>
        <artifactId>okhttp</artifactId>
        <version>4.12.0</version>
    </dependency>
    
    <!-- 开发者工具 -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
    
    <!-- 测试框架 -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```

## 常见错误及解决方案

### 错误1：依赖找不到
**错误信息**：
```
Could not find artifact com.alibaba.cloud:spring-ai-alibaba-starter:jar:1.0.0.2
```

**解决方案**：
- 使用正确的 groupId：`com.alibaba.cloud.ai`
- 使用正确的 artifactId：`spring-ai-alibaba-starter-dashscope`
- 确保添加了 Spring 仓库配置

### 错误2：版本冲突
**错误信息**：
```
Non-resolvable import POM: Could not find artifact com.alibaba.cloud:spring-ai-alibaba-dependencies
```

**解决方案**：
- 使用完整的 BOM 依赖管理配置
- 确保版本号匹配：`spring-ai-alibaba==1.0.0.2, spring-ai==1.0.0, springboot==3.4.5`

### 错误3：仓库访问问题
**解决方案**：
- 添加阿里云 Maven 仓库作为备用
- 确保网络可以访问 Spring 官方仓库
- 检查 Maven 设置文件中的镜像配置

## 版本兼容性

| Spring AI Alibaba | Spring AI | Spring Boot | Java |
|-------------------|------------|-------------|------|
| 1.0.0.2          | 1.0.0      | 3.4.5       | 21   |

## 验证配置

运行以下命令验证配置是否正确：

```bash
./mvnw clean compile
```

如果看到 `BUILD SUCCESS`，说明配置正确。

## 下一步

配置成功后，您可以：

1. **添加记忆功能**（可选）：
```xml
<dependency>
    <groupId>com.alibaba.cloud.ai</groupId>
    <artifactId>spring-ai-alibaba-starter-memory-jdbc</artifactId>
    <version>1.0.0.2</version>
</dependency>
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.32</version>
</dependency>
```

2. **配置数据库连接**（如果使用记忆功能）：
```yaml
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/chatMemory?useUnicode=true&characterEncoding=UTF-8
    username: root
    password: root
```

3. **开始开发 AI 功能**：
   - 配置通义千问 API Key
   - 创建 ChatClient 和 ChatModel 实例
   - 实现智能对话功能

## 总结

成功配置的关键：
1. ✅ 使用正确的依赖坐标
2. ✅ 必须配置 BOM 依赖管理
3. ✅ 添加必要的仓库配置
4. ✅ 确保版本兼容性
5. ✅ 验证构建成功

按照这个指南配置，可以避免大部分常见的依赖问题。
