package com.wujun.mybatis;

import org.mybatis.generator.api.GeneratedXmlFile;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.codegen.mybatis3.IntrospectedTableMyBatis3Impl;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujun
 * @description
 * @date 18/1/11.
 */
public class IntrospectedTableMyBatis3ImplExt extends IntrospectedTableMyBatis3Impl {

    public IntrospectedTableMyBatis3ImplExt() {
    }

    @Override
    public List<GeneratedXmlFile> getGeneratedXmlFiles() {
        ArrayList answer = new ArrayList();
        if (this.xmlMapperGenerator != null) {
            Document document = this.xmlMapperGenerator.getDocument();
            boolean mergeable = false;
            if ("true".equalsIgnoreCase(this.context.getProperty("mergeable"))) {
                mergeable = true;
            }

            GeneratedXmlFile gxf = new GeneratedXmlFile(document, this.getMyBatis3XmlMapperFileName(), this.getMyBatis3XmlMapperPackage(), this.context.getSqlMapGeneratorConfiguration().getTargetProject(), mergeable, this.context.getXmlFormatter());
            if (this.context.getPlugins().sqlMapGenerated(gxf, this)) {
                answer.add(gxf);
            }
        }

        return answer;
    }
}
