# API Key 配置指南

本文档说明如何在 AI Travel Planner 项目中配置 API Key。

## 🔑 配置方式对比

### 方式一：直接在 YAML 文件中填写（推荐开发环境）

```yaml
# application-dev.yml
spring:
  ai:
    alibaba:
      dashscope:
        api-key: sk-your-actual-dashscope-key-here

app:
  api-keys:
    amap: your-actual-amap-key-here
    tavily: your-actual-tavily-key-here
```

**优点：**
- ✅ 简单直接，无需设置环境变量
- ✅ 适合本地开发
- ✅ 配置集中管理

**缺点：**
- ❌ API Key 会提交到代码仓库
- ❌ 安全性较低
- ❌ 不适合生产环境

### 方式二：使用环境变量（推荐生产环境）

```yaml
# application-prod.yml
spring:
  ai:
    alibaba:
      dashscope:
        api-key: ${DASHSCOPE_API_KEY}

app:
  api-keys:
    amap: ${AMAP_API_KEY}
    tavily: ${TAVILY_API_KEY}
```

**优点：**
- ✅ 安全性高，API Key 不存储在代码中
- ✅ 适合生产环境
- ✅ 支持不同环境使用不同 Key

**缺点：**
- ❌ 需要设置环境变量
- ❌ 配置相对复杂

### 方式三：混合使用（最佳实践）

```yaml
# 开发环境 - 直接填写
spring:
  ai:
    alibaba:
      dashscope:
        api-key: sk-your-actual-dashscope-key-here

# 生产环境 - 使用环境变量
# spring:
#   ai:
#     alibaba:
#       dashscope:
#         api-key: ${DASHSCOPE_API_KEY}
```

## 🛠️ 具体配置步骤

### 步骤1：获取 API Key

1. **通义千问 API Key**
   - 访问：https://dashscope.console.aliyun.com/
   - 创建 API Key
   - 格式：`sk-xxxxxxxxxxxxxxxx`

2. **高德地图 API Key**
   - 访问：https://lbs.amap.com/
   - 申请 Web 服务 API Key
   - 格式：`xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx`

3. **Tavily 搜索 API Key**
   - 访问：https://tavily.com/
   - 注册并获取 API Key
   - 格式：`tvly-xxxxxxxxxxxxxxxx`

### 步骤2：配置开发环境

编辑 `application-dev.yml`：

```yaml
spring:
  ai:
    alibaba:
      dashscope:
        api-key: sk-your-actual-dashscope-key-here

app:
  api-keys:
    amap: your-actual-amap-key-here
    tavily: your-actual-tavily-key-here
```

### 步骤3：配置生产环境

编辑 `application-prod.yml`：

```yaml
spring:
  ai:
    alibaba:
      dashscope:
        api-key: ${DASHSCOPE_API_KEY}

app:
  api-keys:
    amap: ${AMAP_API_KEY}
    tavily: ${TAVILY_API_KEY}
```

### 步骤4：设置环境变量（仅生产环境）

```bash
# 生产环境设置环境变量
export DASHSCOPE_API_KEY=sk-your-actual-dashscope-key
export AMAP_API_KEY=your-actual-amap-key
export TAVILY_API_KEY=your-actual-tavily-key
```

## 🔒 安全建议

### 开发环境
- ✅ 可以直接在 YAML 文件中填写
- ✅ 使用测试 API Key
- ✅ 限制 API 调用频率

### 生产环境
- ✅ 必须使用环境变量
- ✅ 使用正式 API Key
- ✅ 定期轮换 API Key
- ✅ 监控 API 使用情况

### 代码安全
- ✅ 将 `application-prod.yml` 添加到 `.gitignore`
- ✅ 使用 `.env` 文件管理环境变量
- ✅ 不要在代码中硬编码 API Key

## 🚀 启动验证

### 检查配置是否正确

```bash
# 启动应用
./mvnw spring-boot:run

# 检查 API Key 配置
curl http://localhost:8080/api/actuator/env | grep -i "api-key"
```

### 测试 API 连接

```bash
# 测试通义千问连接
curl -X POST http://localhost:8080/api/chat \
  -H "Content-Type: application/json" \
  -d '{"message": "你好"}'

# 测试高德地图连接
curl "http://localhost:8080/api/geocode?address=北京"
```

## 📝 常见问题

### Q1: API Key 格式错误
```
错误: Invalid API key format
解决: 检查 API Key 格式是否正确
```

### Q2: 环境变量未设置
```
错误: Could not resolve placeholder 'DASHSCOPE_API_KEY'
解决: 设置环境变量或使用默认值
```

### Q3: API 调用失败
```
错误: API request failed
解决: 检查 API Key 是否有效，网络是否正常
```

## 🎯 推荐配置

### 开发环境
- 直接填写 API Key 到 YAML 文件
- 使用测试 API Key
- 启用详细日志

### 生产环境
- 使用环境变量
- 使用正式 API Key
- 启用安全配置

通过遵循本指南，您可以安全、高效地配置 AI Travel Planner 的 API Key。🎉
