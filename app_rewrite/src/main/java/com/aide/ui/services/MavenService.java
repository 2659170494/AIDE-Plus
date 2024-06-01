package com.aide.ui.services;

import com.aide.ui.util.BuildGradle;
import io.github.zeroaicy.aide.ui.services.ZeroAicyMavenService;
import java.util.List;
import java.util.Map;
import com.aide.ui.util.BuildGradle.MavenDependency;
import io.github.zeroaicy.aide.ui.services.ZeroAicyMavenService;
import androidx.annotation.Keep;

/**
 * 所有在此类重复声明的函数
 * 是为了底包2.2做准备
 * 一旦更新2.2底包后，直接删除这些混淆的方法
 * @Keep为未修的[不知道为啥漏了]
 */
// 底包对MavenService的全部引用
public class MavenService {
	// 全都是在主线程的耗时任务
	// 主要是Lcom/aide/ui/project/AndroidProjectSupport;的调用
	// 全部改成阻塞主线程并线程池异步
	// 阻塞主线程等待线程池解析结果
	// 将解析任务分解 循环和递归都用 线程池任务
	// 需要考虑对字段的并发操作
	
	//
	
	
	ZeroAicyMavenService proxy = new ZeroAicyMavenService();
	
	// refreshing maven cache
	// @Override
	public final void refreshMavenCache() {
		proxy.refreshMavenCache();
	}
	
	// resolvingDependency AndroidProjectSupport->ca(String,HashSet<String>)
	/*public final void v5(BuildGradle.MavenDependency dependency){
		// resolvingMavenDependency
		this.resolvingMavenDependency(dependency);
	}*/
	// @Override
	public final void resolvingMavenDependency(BuildGradle.MavenDependency dependency) {
		proxy.resolvingDependency(dependency);
	}
	
	@Keep
	// 计算并返回dependency在maven缓存仓库中的路径
	public final String u7(BuildGradle.MavenDependency dependency){
		return this.resolveMavenDepPath(dependency);
	}
	// @Override
	public final String resolveMavenDepPath(BuildGradle.MavenDependency dependency) {
		return proxy.resolveMavenDepPath(dependency);
	}
	
	// 返回本地缓存不存在的依赖
	/*public final List<BuildGradle.MavenDependency> er(Map<String, String> flatRepoPathMap, BuildGradle.MavenDependency dependency){
		return this.getNotExistsLocalCache(flatRepoPathMap, dependency);
	}*/
	public final List<BuildGradle.MavenDependency> getNotExistsLocalCache(Map<String, String> flatRepoPathMap, BuildGradle.MavenDependency dependency) {
		return proxy.getNotExistsLocalCache(flatRepoPathMap, dependency);
	}
	
	/**
	 * 从给定的依赖路径，返回其自己及子依赖路径
	 * 递归3层
	 */
	@Keep
	public final List<String> J0(String depPath){
		return this.resolveFullDependencyTree(depPath);
	}

	// @Override
	public final List<String> resolveFullDependencyTree(String depPath) {
		return proxy.resolveFullDependencyTree(depPath);
	}

	// 解析dependency并返回依赖树集合
	// 会优先从flatRepositoryPath中查找
	/*public final List<String> J8(Map<String, String> flatRepositoryPathMap, BuildGradle.MavenDependency dependency){
		return this.resolveFullDependencyTree(flatRepositoryPathMap, dependency);
	}*/
	// @Override
	public final List<String> resolveFullDependencyTree(Map<String, String> flatRepositoryPathMap, BuildGradle.MavenDependency dep) {
		return proxy.resolveFullDependencyTree(flatRepositoryPathMap, dep);
	}
	/*
	// 依赖存在本地缓存
	public final boolean BT(Map<String, String> flatRepoPathMap, BuildGradle.MavenDependency dependency){
		return this.existsLocalMavenCache(flatRepoPathMap, dependency);
	}*/
	// @Override
	public final boolean existsLocalMavenCache(Map<String, String> flatRepoPathMap, BuildGradle.MavenDependency dependency) {
		return proxy.existsLocalMavenCache(flatRepoPathMap, dependency);
	}
	
	// 重置依赖在maven缓存路径中的映射
	/*public final void FH(){
		this.resetDepPathMap();
	}*/
	// @Override
	public final void resetDepPathMap() {
		proxy.resetDepPathMap();
	}
	
	/*
	//重置当前服务的依赖记录
	// resetDepMap
	public final void ei(){
		this.resetDepMap();
	}*/
	// @Override
	public final void resetDepMap() {
		proxy.resetDepMap();
	}
	
	/*
	// MavenService2.dependencyPathMap字段
	public static Map j6(MavenService mavenService){
		return getDepPathMapping(mavenService);
	}*/
	public static Map getDepPathMapping(MavenService mavenService) {
		return ZeroAicyMavenService.getDepPathMapping(mavenService.proxy);
	}
	
	//  getDefaulRepositoriePath
	/**
	 * 默认下载maven仓库路径
	 */
	/*
	public static String DW(){
		return getDefaulRepositoriePath();
	}*/
	public static String getDefaulRepositoriePath() {
        return ZeroAicyMavenService.getDefaulRepositoriePath();
    }
	
	// getMetadataUrl
	/*public static String rN(BuildGradle.RemoteRepository remoteRepository, BuildGradle.MavenDependency dependency) {
		return getMetadataUrl(remoteRepository, dependency);
	}*/
	public static String getMetadataUrl(BuildGradle.RemoteRepository remoteRepository, BuildGradle.MavenDependency dependency) {
		return ZeroAicyMavenService.getMetadataUrl(remoteRepository, dependency);
	}
	
	// getMetadataPath
	/*public static String lg(BuildGradle.RemoteRepository remoteRepository, BuildGradle.MavenDependency dependency) {
		return getMetadataPath(remoteRepository, dependency);
	}*/
	public static String getMetadataPath(BuildGradle.RemoteRepository remoteRepository, BuildGradle.MavenDependency dependency) {
		return ZeroAicyMavenService.getMetadataPath(remoteRepository, dependency);
	}
	
	// getArtifactPath
	/*public static String XL(BuildGradle.RemoteRepository remoteRepository, BuildGradle.MavenDependency dependency, String version, String type) {
		return getArtifactPath(remoteRepository, dependency, version, type);
	}*/
	public static String getArtifactPath(BuildGradle.RemoteRepository remoteRepository, BuildGradle.MavenDependency dependency, String version, String type) {
		return ZeroAicyMavenService.getArtifactPath(remoteRepository, dependency, version, type);
	}
	
	public static String getArtifactUrl(BuildGradle.RemoteRepository remoteRepository, BuildGradle.MavenDependency dependency, String version, String type) {
		return ZeroAicyMavenService.getArtifactUrl(remoteRepository, dependency, version, type);
	}
}
