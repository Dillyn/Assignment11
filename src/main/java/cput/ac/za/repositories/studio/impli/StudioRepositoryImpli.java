package cput.ac.za.repositories.studio.impli;

import cput.ac.za.domain.studio.Studio;
import cput.ac.za.repositories.studio.StudioRepository;

import java.util.HashSet;
import java.util.Set;

public class StudioRepositoryImpli implements StudioRepository {
    private static StudioRepository studioRepository = null;
    private Set<Studio> studioDB;

    private StudioRepositoryImpli() {
        this.studioDB = new HashSet<>();
    }

    private Studio findClass(String studioId) {
        return this.studioDB.stream()
                .filter(studio -> studio.getId().trim().equals(studioId))
                .findAny()
                .orElse(null);
    }

    public static StudioRepository studioRepository() {
        if (studioRepository == null) studioRepository = new StudioRepositoryImpli();
        return studioRepository;
    }

    @Override
    public Studio create(Studio studio) {
        this.studioDB.add(studio);
        return studio;
    }


    @Override
    public Studio read(String studioId) {
        Studio studio = findClass(studioId);
        return studio;
    }


    @Override
    public Studio update(Studio studio) {
        Studio toDelete = findClass(studio.getId());
        if(toDelete != null) {
            this.studioDB.remove(toDelete);
            return create(studio);
        }
        return null;
    }


    @Override
    public void delete(String studioId) {
        Studio studio = findClass(studioId);
        if (studio != null) this.studioDB.remove(studio);
    }


    @Override
    public Set<Studio> getAll() {
        return this.studioDB;
    }
}
