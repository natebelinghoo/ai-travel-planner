# AI Travel Planner 环境配置说明

本文档详细说明了 AI Travel Planner 项目的多环境配置策略。

## 📁 配置文件结构

```
src/main/resources/
├── application.yml          # 基础配置，包含通用设置
├── application-dev.yml      # 开发环境配置
├── application-pre.yml      # 预发环境配置
└── application-prod.yml     # 生产环境配置
```

## 🎯 环境配置概览

### 开发环境 (dev)
- **用途**: 本地开发和调试
- **特点**: 详细日志、开放所有端点、允许跨域、使用测试API Key
- **启动方式**: `./mvnw spring-boot:run -Dspring.profiles.active=dev`

### 预发环境 (pre)
- **用途**: 功能测试和性能验证
- **特点**: 适中日志、限制端点、使用正式API Key、性能优化
- **启动方式**: `./mvnw spring-boot:run -Dspring.profiles.active=pre`

### 生产环境 (prod)
- **用途**: 正式生产部署
- **特点**: 精简日志、最小化端点、严格安全控制、高性能配置
- **启动方式**: `./mvnw spring-boot:run -Dspring.profiles.active=prod`

## 🔧 环境变量配置

### 必需的环境变量

```bash
# 通义千问 API Key
export DASHSCOPE_API_KEY=your-dashscope-api-key

# 高德地图 API Key
export AMAP_API_KEY=your-amap-api-key

# Tavily 搜索 API Key
export TAVILY_API_KEY=your-tavily-api-key
```

### 环境特定配置

#### 开发环境
```bash
# 开发环境可以使用测试API Key
export DASHSCOPE_API_KEY=dev-test-key
export AMAP_API_KEY=dev-amap-test-key
export TAVILY_API_KEY=dev-tavily-test-key
```

#### 预发/生产环境
```bash
# 预发和生产环境必须使用正式API Key
export DASHSCOPE_API_KEY=your-real-dashscope-key
export AMAP_API_KEY=your-real-amap-key
export TAVILY_API_KEY=your-real-tavily-key
```

## 📊 配置对比表

| 配置项 | 开发环境 | 预发环境 | 生产环境 |
|--------|----------|----------|----------|
| **AI模型** | qwen-turbo | qwen-plus | qwen-max |
| **温度** | 0.8 | 0.7 | 0.6 |
| **最大Token** | 1000 | 3000 | 4000 |
| **重试次数** | 2 | 3 | 5 |
| **日志级别** | DEBUG | INFO | WARN |
| **管理端点** | 全部开放 | 部分开放 | 最小化 |
| **跨域设置** | 允许所有 | 限制域名 | 严格控制 |
| **缓存TTL** | 无 | 1小时 | 2小时 |
| **限流** | 无 | 100/分钟 | 200/分钟 |

## 🚀 启动命令

### 本地开发
```bash
# 使用默认开发环境
./mvnw spring-boot:run

# 明确指定开发环境
./mvnw spring-boot:run -Dspring.profiles.active=dev
```

### 预发环境
```bash
./mvnw spring-boot:run -Dspring.profiles.active=pre
```

### 生产环境
```bash
./mvnw spring-boot:run -Dspring.profiles.active=prod
```

### JAR包部署
```bash
# 开发环境
java -jar ai-travel-planner.jar --spring.profiles.active=dev

# 预发环境
java -jar ai-travel-planner.jar --spring.profiles.active=pre

# 生产环境
java -jar ai-travel-planner.jar --spring.profiles.active=prod
```

## 🔍 配置验证

### 检查当前激活的环境
```bash
curl http://localhost:8080/api/actuator/env | grep "spring.profiles.active"
```

### 查看配置信息
```bash
# 开发环境 - 显示所有配置
curl http://localhost:8080/api/actuator/configprops

# 预发/生产环境 - 显示基本信息
curl http://localhost:8080/api/actuator/info
```

## 📝 最佳实践

### 1. 环境隔离
- 每个环境使用独立的API Key
- 数据库和缓存使用不同实例
- 日志文件分别存储

### 2. 安全配置
- 生产环境禁用敏感端点
- 使用HTTPS和安全的CORS设置
- 启用安全认证和授权

### 3. 性能优化
- 生产环境启用缓存和限流
- 调整线程池和连接池参数
- 配置日志轮转和压缩

### 4. 监控和告警
- 生产环境启用指标收集
- 配置健康检查和告警
- 设置日志监控和分析

## 🛠️ 故障排除

### 常见问题

1. **环境变量未设置**
   ```
   错误: Could not resolve placeholder 'DASHSCOPE_API_KEY'
   解决: 设置相应的环境变量
   ```

2. **配置文件未找到**
   ```
   错误: Could not find property file
   解决: 确保配置文件在正确位置
   ```

3. **端口冲突**
   ```
   错误: Port 8080 was already in use
   解决: 修改端口或停止占用端口的进程
   ```

### 调试技巧

1. **查看激活的配置**
   ```bash
   ./mvnw spring-boot:run -Ddebug=true
   ```

2. **验证配置加载**
   ```bash
   curl http://localhost:8080/api/actuator/env
   ```

3. **检查日志输出**
   ```bash
   tail -f logs/{env}/ai-travel-planner.log
   ```

通过遵循本配置指南，您可以确保 AI Travel Planner 在不同环境中正确运行。🎉
