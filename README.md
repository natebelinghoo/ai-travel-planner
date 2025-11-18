# AI智能旅行规划系统

[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.5-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Spring AI](https://img.shields.io/badge/Spring%20AI-1.0.0-blue.svg)](https://spring.io/projects/spring-ai)
[![Elasticsearch](https://img.shields.io/badge/Elasticsearch-8.x-yellow.svg)](https://www.elastic.co/)
[![Netty](https://img.shields.io/badge/Netty-4.x-green.svg)](https://netty.io/)

基于Spring AI框架构建的企业级智能旅行规划平台，采用多Agent协作架构和双层应用模型，为多租户SaaS场景提供个性化的旅行行程规划服务。

## 项目简介

AI智能旅行规划系统是一个企业级智能旅行助手平台，整合了向量检索、AI大模型、高并发实时通信、多租户安全等企业级技术。系统通过三个专业Agent（本地探索、交通规划、行程生成）协同工作，实现从目的地探索到完整行程生成的智能化流程。

## 核心特性

- 🏢 **企业级RAG引擎** - 基于SpringAI+Elasticsearch的向量检索系统，支持多格式文档智能解析
- 🤖 **AI Agent服务平台** - Application与AgentInst双层架构模型，支持Agent状态管理和生命周期管控
- ⚡ **高并发实时通信** - 基于Netty构建WebSocket服务器，支持万级并发连接
- 🔐 **多租户安全体系** - 基于JWT + RequestContext的认证授权，支持企业级SaaS场景
- 📊 **全链路可观测** - 集成阿里云ARMS和SLS，构建全链路可观测体系
- 🧠 **AI驱动** - 集成通义千问大模型，通过Spring AI框架实现统一的Chat和Embedding服务抽象

## 技术栈

### 后端
- **核心框架**: Java 21, Spring Boot 3.4.5, Spring AI 1.0.0
- **AI服务**: 通义千问(Qwen), Spring AI Alibaba
- **数据持久化**: MySQL 8.0, Redis 7.0, MyBatis-Plus
- **向量检索**: Elasticsearch 8.x, Spring AI Elasticsearch
- **实时通信**: Netty 4.x (WebSocket)
- **安全认证**: JWT, RequestContext
- **外部服务**: 高德地图API, Tavily Search API
- **监控运维**: 阿里云ARMS, 阿里云SLS, Spring Boot Actuator
- **工具**: Lombok, OkHttp, Bean Validation

### 前端 (规划中)
- Vue 3, TypeScript, Element Plus, Axios, Vite, Pinia

## 系统架构

### 企业级整体架构

```
┌─────────────────────────────────────────────────────────┐
│  前端层 (Vue 3) + WebSocket实时通信                       │
└────────────────────┬────────────────────────────────────┘
                     │ HTTP/REST API + WebSocket
┌────────────────────┴────────────────────────────────────┐
│  API网关层 (Nginx)                                       │
└────────────────────┬────────────────────────────────────┘
                     │
┌────────────────────┴────────────────────────────────────┐
│  应用服务层 (Spring Boot)                                │
│  ├─ 安全认证层 (JWT + RequestContext)                    │
│  ├─ AI Agent服务平台 (双层架构)                          │
│  │   ├─ Application层 (应用配置管理)                     │
│  │   └─ AgentInst层 (Agent实例管理)                      │
│  ├─ Workflow层 (工作流编排)                              │
│  ├─ Agent层 (多Agent协作)                                │
│  ├─ Service层 (业务服务)                                 │
│  └─ 实时通信层 (Netty WebSocket)                         │
└────────────────────┬────────────────────────────────────┘
                     │
┌────────────────────┴────────────────────────────────────┐
│  数据与外部服务层                                         │
│  MySQL | Redis | Elasticsearch | 高德地图API | 通义千问  │
└─────────────────────────────────────────────────────────┘
```

## 核心功能

### 1. 企业级RAG引擎架构
- **向量检索系统**: 基于SpringAI+Elasticsearch，支持多格式文档智能解析
- **知识库版本管理**: Agent实例与应用配置的原子性创建与回滚
- **语义检索**: 为景点、餐厅推荐提供智能检索能力

### 2. AI Agent服务平台
- **双层架构模型**: Application与AgentInst分离，支持灵活的配置管理
- **统一AI服务抽象**: 通过Spring AI框架实现统一的Chat和Embedding服务
- **Agent状态管理**: online/offline/rest状态管理和生命周期管控

### 3. 高并发实时通信系统
- **Netty WebSocket服务器**: 支持万级并发连接的实时消息推送
- **分布式会话管理**: Redis实现连接状态同步和故障自动恢复
- **自定义消息路由**: 支持文本、图片、文件等多媒体消息类型

### 4. 多租户安全体系
- **JWT认证授权**: 基于JWT + RequestContext的无状态认证
- **数据隔离**: 多租户数据隔离与权限管控，支持企业级SaaS场景
- **全链路可观测**: 集成阿里云ARMS和SLS，构建全链路可观测体系

### 5. 智能行程规划
- **目的地探索**: 基于向量语义检索和实时网络搜索
- **交通规划**: 集成高德地图API，提供多方式路径规划
- **AI行程生成**: 利用通义千问大模型，生成详细的日度行程计划

## 快速开始

### 环境要求
- JDK 21+
- Maven 3.6+
- MySQL 8.0+
- Redis 7.0+
- Elasticsearch 8.x (规划中)

### 配置说明

1. 配置API密钥（参考 `API_KEY_CONFIG.md`）
   - 高德地图API Key
   - Tavily Search API Key
   - 通义千问API Key

2. 配置环境变量或修改 `application.yml`

### 运行项目

```bash
# 编译项目
mvn clean compile

# 运行项目
mvn spring-boot:run
```

## 项目结构

```
ai-travel-planner/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── io/github/xyt662/aitravelplanner/
│   │   │       ├── agent/          # Agent层
│   │   │       ├── config/         # 配置类
│   │   │       ├── controller/     # 控制器层
│   │   │       ├── model/          # 数据模型
│   │   │       ├── service/        # 服务层
│   │   │       └── workflow/       # 工作流管理
│   │   └── resources/
│   │       └── application*.yml    # 配置文件
│   └── test/                       # 测试代码
├── pom.xml                         # Maven配置
├── PROJECT_PLAN.md                 # 项目规划文档
└── RESUME_PROJECT.md               # 简历项目描述
```

## 开发计划

### 已完成
- [x] 项目基础架构搭建
- [x] Spring AI集成
- [x] 多Agent架构设计
- [x] 高德地图API集成
- [x] Tavily搜索API集成

### 进行中
- [ ] 完整的行程生成逻辑实现
- [ ] 企业级RAG引擎（Elasticsearch向量检索）
- [ ] AI Agent服务平台（双层架构模型）
- [ ] 高并发实时通信系统（Netty WebSocket）
- [ ] 多租户安全体系（JWT + RequestContext）
- [ ] 数据持久化层（MySQL + Redis + MyBatis-Plus）
- [ ] 全链路可观测体系（ARMS + SLS）

### 规划中
- [ ] 前端界面开发（Vue 3）
- [ ] Docker容器化部署
- [ ] CI/CD自动化部署

详细开发计划请参考 [PROJECT_PLAN.md](./PROJECT_PLAN.md)

## 文档

- [项目规划文档](./PROJECT_PLAN.md) - 详细的技术栈规划和功能设计
- [简历项目描述](./RESUME_PROJECT.md) - 适合简历的项目描述
- [API密钥配置指南](./API_KEY_CONFIG.md) - API密钥配置说明
- [环境配置指南](./ENVIRONMENT_CONFIG.md) - 环境配置说明
- [Spring AI配置指南](./SPRING_AI_CONFIG_GUIDE.md) - Spring AI配置说明

## 贡献

欢迎提交Issue和Pull Request！

## 许可证

本项目采用 [LICENSE](./LICENSE) 许可证。

## 联系方式

如有问题或建议，欢迎通过Issue联系。

