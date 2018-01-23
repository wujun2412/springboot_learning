package com.wujun.common.utils;

import com.wujun.config.ApplicationContextStaticProvider;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.dozer.util.MappingValidator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujun
 * @description
 * @date 18/1/11.
 */
public class DozerUtils {
    private Mapper dozerMapper;

    private DozerUtils(Mapper dozerMapper){
        this.dozerMapper = dozerMapper;
    }

    private DozerUtils(){
        this(ApplicationContextStaticProvider.getBean(DozerBeanMapper.class));
    }

    public static DozerUtils instance(){
        return new DozerUtils();
    }

    /**
     * 可以传入spring配置中的dozerMapper，以支持dozer配置中的特殊列转换
     * @param dozerMapper
     * @return
     */
    public static DozerUtils instance(Mapper dozerMapper){
        return new DozerUtils(dozerMapper);
    }

    /**
     * 数组转数组
     * @param source
     * @param destinationClass
     * @param <T>
     * @return
     */
    public <T> List<T> map(final List source, final Class<T> destinationClass){
        MappingValidator.validateMappingRequest(source,destinationClass);
        List<T> desList = new ArrayList<>(16);
        for (Object src:source){
            T des = dozerMapper.map(src,destinationClass);
            desList.add(des);
        }
        return desList;
    }

}
