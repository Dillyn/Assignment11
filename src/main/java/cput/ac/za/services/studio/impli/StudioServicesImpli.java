package cput.ac.za.services.studio.impli;

import cput.ac.za.domain.studio.Studio;
import cput.ac.za.repositories.studio.StudioRepository;
import cput.ac.za.repositories.studio.impli.StudioRepositoryImpli;
import cput.ac.za.services.studio.StudioServices;

import java.util.HashSet;
import java.util.Set;

public class StudioServicesImpli implements StudioServices {

    private StudioRepository studioRepository;
    private static StudioServices StudioService = null;

    private StudioServicesImpli() {
        this.studioRepository = StudioRepositoryImpli.studioRepository();
    }

    public StudioServices getsStudioService() {
        if (StudioService == null) StudioService = new StudioServicesImpli();
        return StudioService;
    }

    @Override
    public Studio create(Studio d) {
        return this.studioRepository.create(d);
    }

    @Override
    public Studio read(String studioId) {
        return this.studioRepository.read(studioId);
    }

    @Override
    public Studio update(Studio studio) {
        return this.studioRepository.update(studio);
    }

    @Override
    public void delete(String studioId) {
        this.studioRepository.delete(studioId);
    }

    @Override
    public Set<Studio> getAll() { return this.studioRepository.getAll();
    }
}
