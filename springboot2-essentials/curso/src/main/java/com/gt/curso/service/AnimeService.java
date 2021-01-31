package com.gt.curso.service;

import com.gt.curso.domain.Anime;
import com.gt.curso.exception.BadRequestException;
import com.gt.curso.maper.AnimeMapper;
import com.gt.curso.repository.AnimeRepository;
import com.gt.curso.request.AnimePostResquesBody;
import com.gt.curso.request.AnimePutResquesBody;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimeService {

    private final AnimeRepository animeRepository;

    // private final AnimeRepository animeRepository;
    public List<Anime> listAll() {
        return animeRepository.findAll();
    }

    public Anime findByIdOrThrowBadRequestException(long id) {
        return animeRepository.findById(id).orElseThrow(() -> new BadRequestException("Anime not Found"));
    }

    @Transactional
    public Anime save(AnimePostResquesBody animePostRequestBody) {
        return animeRepository.save(AnimeMapper.INSTANCE.toAnime(animePostRequestBody));
    }

    public void delete(long id) {
        animeRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(AnimePutResquesBody animePutResquesBody) {
        Anime savedAnime = findByIdOrThrowBadRequestException(animePutResquesBody.getId());
        Anime anime = AnimeMapper.INSTANCE.toAnime(animePutResquesBody);
        anime.setId(savedAnime.getId());
        animeRepository.save(anime);
    }

    public List<Anime> findByName(String name) {
        return animeRepository.findByName(name);
    }

}
