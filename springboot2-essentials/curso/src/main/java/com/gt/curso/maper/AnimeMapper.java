package com.gt.curso.maper;

import com.gt.curso.domain.Anime;
import com.gt.curso.request.AnimePostResquesBody;
import com.gt.curso.request.AnimePutResquesBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class AnimeMapper {

    public static final AnimeMapper INSTANCE = Mappers.getMapper(AnimeMapper.class);

    public  abstract Anime toAnime(AnimePostResquesBody animePostResquesBody);
    public  abstract Anime toAnime(AnimePutResquesBody animePutResquesBody);
}
