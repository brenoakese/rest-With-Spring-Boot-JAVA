package com.brenoakese.rest_with_spring_curso.mapper;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


public class objectMapper {


    private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    private static Logger logger = LoggerFactory.getLogger(objectMapper.class.getName());

    public static <O, D> D parseObject(O source, Class<D> destinationClass) {
        if (source == null) {
            logger.warn("Can´t parse object from null source, returning null.");
            return null;
        }
        return mapper.map(source, destinationClass);
    }

    public static <O, D> List<D> parseObjectList(List<O> source, Class<D> destinationClass) {
        if(source.isEmpty()){

            logger.warn("can´t parse object list, Source list is empty. returning an empty list.");

            return List.of();
        }

        List<D> destinationList = new ArrayList<D>();

        for (O o : source) {

            destinationList.add(mapper.map(o, destinationClass));

        }

        return destinationList;
    }
}
