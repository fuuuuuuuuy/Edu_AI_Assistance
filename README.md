# AI教育辅助系统

## 项目概述
本项目是一个基于SpringBoot + Vue的AI教育辅助系统，集成了Ollama + Qwen大语言模型，为用户提供智能化的学习体验。

## 技术栈
### 后端
- SpringBoot
- MySQL
- MyBatis
- Ollama + Qwen (AI模型集成)

### 前端
- Vue.js
- Element UI
- Axios
- Vuex

## 功能规划

### 第一阶段：个性化推荐系统（优先级最高）
1. 数据收集模块
   - 用户行为数据收集（课程浏览、完成度、评分等）
   - 用户画像构建
   - 课程特征提取

2. AI推荐引擎
   - Ollama + Qwen模型集成
   - 推荐算法实现
   - 实时推荐服务

3. 推荐展示模块
   - 课程推荐页面
   - 个性化推荐展示
   - 推荐反馈机制

### 第二阶段：学习体验优化
1. 学习进度追踪
   - 课程完成度统计
   - 学习时间分析
   - 进度可视化

2. AI辅助学习
   - 课程笔记生成
   - 知识点总结
   - 智能问答

### 第三阶段：社交与互动
1. 学习社区
   - 课程讨论区
   - 学习小组
   - 学习伙伴匹配

2. 激励机制
   - 学习成就系统
   - 积分奖励
   - 排行榜

## 数据库设计
### 现有表结构
- users（用户信息表）
- courses（课程信息表）
- user_courses（用户课程关联表）

### 需要新增的表
1. user_behavior（用户行为表）
```sql
CREATE TABLE user_behavior (
    behavior_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    course_id INT NOT NULL,
    behavior_type VARCHAR(20) NOT NULL, -- 行为类型：浏览、完成、评分等
    behavior_value DECIMAL(5,2), -- 行为值（如评分）
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (course_id) REFERENCES courses(course_id)
) COMMENT='用户行为记录表';
```

2. course_features（课程特征表）
```sql
CREATE TABLE course_features (
    feature_id INT AUTO_INCREMENT PRIMARY KEY,
    course_id INT NOT NULL,
    feature_name VARCHAR(50) NOT NULL,
    feature_value TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (course_id) REFERENCES courses(course_id)
) COMMENT='课程特征表';
```

3. user_preferences（用户偏好表）
```sql
CREATE TABLE user_preferences (
    preference_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    preference_type VARCHAR(50) NOT NULL,
    preference_value TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
) COMMENT='用户偏好表';
```

## 项目进度规划
1. 第一阶段（预计2周）
   - 数据库表结构更新
   - 后端API开发
   - 前端界面实现
   - AI模型集成

2. 第二阶段（预计2周）
   - 学习进度追踪功能
   - AI辅助学习功能
   - 系统优化

3. 第三阶段（预计2周）
   - 社交功能实现
   - 激励机制开发
   - 系统测试与优化

## 注意事项
1. AI模型集成
   - 需要确认Ollama + Qwen的具体部署方案
   - 评估模型性能和资源需求
   - 制定模型调用策略

2. 数据安全
   - 用户数据加密存储
   - 访问权限控制
   - 数据备份策略

3. 系统性能
   - 推荐系统响应时间优化
   - 数据库查询优化
   - 缓存策略制定

## 待确认事项
1. Ollama + Qwen模型的具体部署方案和资源需求
2. 推荐系统的具体算法选择
3. 系统的并发用户规模预估
4. 服务器资源规划 