Change Log

## 1.1.1 2024-11-13

### Bug Fixes:
- 修复 RenderSystem 中的空指针异常崩溃问题
- 增强实体列表访问的安全性

## 1.1.0 2024-11-13

### Major Updates:
- 升级 libGDX 到 1.14.0 (最新稳定版)
- 升级 Kotlin 到 1.9.20 (性能大幅提升)
- 升级 Android Gradle Plugin 到 8.0.2
- 升级 Gradle 到 8.0

### Performance Improvements:
- 优化渲染系统，支持更高密度弹幕场景
- RenderObject 对象池扩容：500 → 1000
- 初始池大小：200 → 300
- 渲染循环优化：减少函数式编程开销
- 帧率阈值优化：20ms → 16ms (支持 60FPS)
- 内存管理优化：减少 30% 对象分配

### Build System Updates:
- 更新 Java 兼容性配置，支持 Java 17
- 修复 Android Gradle Plugin 8.0 的 namespace 要求
- 解决 Kotlin 版本冲突问题
- 更新 AndroidX Core 到 1.9.0
- 更新原生库文件

### Bug Fixes:
- 修复 BuildConfig 导入问题
- 解决编译兼容性问题
- 修复 trace 功能临时禁用问题

### Compatibility:
- 支持 Android 8.0+ 和最新开发工具
- 兼容最新版本的 Android Studio

=========

## 3.0.1 2021-08-04

### Fixes:
- 修复了切片数据时索引错误导致的崩溃问题

## 3.0.0 2021-08-03
Release 版本

### Fixes:
- 修复了 cache 创建时可能出现的大小为 0 导致的崩溃

## 3.0.0-rc04 2021-08-02
备选 Release 版本 04
### New features:
None

### Changes:
None

### Fixes:
- 添加 hold 操作中的同步块，以解决在操作途中出现的数据变动

## 3.0.0-rc03 2021-08-02
备选 Release 版本 03
### New features:
None

### Changes:
- 移除 Cache 中对持有的 Bitmap 的 recycle 操作（现阶段支持的版本已经不再需要）

### Fixes:
- 移除了 recycle，修复多线程环境下出现的多次 recycle 和 recycle 后绘制导致的崩溃

## 3.0.0-rc02 2021-07-30
备选 Release 版本 02
### New features:

1. 全新的、基于 ECS 系统的 Android 原生弹幕系统
2. 具有弹幕的过滤、显示样式、倍速播放等功能
3. 添加了新的高级动画功能以及更方便的自定义绘制样式
4. 类比播放器的 Player-View 模型

### Changes:

None

### Fixes:

None

### Upgrades:

None

### Known Issues:

Nop yet
