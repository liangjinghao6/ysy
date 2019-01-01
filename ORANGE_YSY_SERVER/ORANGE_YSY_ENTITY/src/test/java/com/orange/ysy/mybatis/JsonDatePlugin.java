package com.orange.ysy.mybatis;

import java.util.List;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.Plugin;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;

public class JsonDatePlugin extends PluginAdapter {
	@Override
	public boolean validate(List<String> list) {
		return true;
	}

	@Override
	public boolean modelGetterMethodGenerated(Method method, TopLevelClass topLevelClass,
			IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable,
			Plugin.ModelClassType modelClassType) {
		String jsonFormatAnnotationPackage = this.properties.getProperty("jsonFormatAnnotationPackage");
		if (null == jsonFormatAnnotationPackage)
			jsonFormatAnnotationPackage = "com.fasterxml.jackson.annotation.JsonFormat";

		topLevelClass.addImportedType(jsonFormatAnnotationPackage);


		if("java.util.Date".equals(method.getReturnType().toString())) {
			method.addAnnotation("@JsonFormat(pattern = \"yyyy-MM-dd HH:mm:ss\", timezone=\"GMT+8\")");
		}
		return super.modelGetterMethodGenerated(method, topLevelClass, introspectedColumn, introspectedTable,
				modelClassType);
	}

//	@Override
//	public boolean modelSetterMethodGenerated(Method method, TopLevelClass topLevelClass,
//			IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable,
//			Plugin.ModelClassType modelClassType) {
//
//		String dateTimeFormatAnnotationPackage = this.properties.getProperty("dateTimeFormatAnnotationPackage");
//		if (null == dateTimeFormatAnnotationPackage)
//			dateTimeFormatAnnotationPackage = "org.springframework.format.annotation.DateTimeFormat";
//
//		topLevelClass.addImportedType(dateTimeFormatAnnotationPackage);
//
//		if("java.util.Date".equals(method.getParameters().get(0).getType().toString())) {
//			method.addAnnotation("@DateTimeFormat(pattern=\"yyyy-MM-dd hh:mm:ss\")");
//		}
//		return super.modelSetterMethodGenerated(method, topLevelClass, introspectedColumn, introspectedTable,
//				modelClassType);
//	}
}