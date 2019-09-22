package cput.ac.za.services.staff.impli;

import cput.ac.za.domain.staff.HelpDesk;
import cput.ac.za.repositories.staff.HelpDeskRepository;
import cput.ac.za.repositories.staff.impli.HelpDeskRepositoryImpli;
import cput.ac.za.services.staff.HelpDeskServices;

import java.util.HashSet;
import java.util.Set;

public class HelpDeskServicesImpli implements HelpDeskServices {

    private HelpDeskRepository staffRepository;
    private static HelpDeskServices staffService = null;

    private HelpDeskServicesImpli() {
        this.staffRepository = HelpDeskRepositoryImpli.staffRepository();
    }

    public HelpDeskServices getsHelpDeskService() {
        if (staffService == null) staffService = new HelpDeskServicesImpli();
        return staffService;
    }

    @Override
    public HelpDesk create(HelpDesk d) {
        return this.staffRepository.create(d);
    }

    @Override
    public HelpDesk read(String staffId) {
        return this.staffRepository.read(staffId);
    }

    @Override
    public HelpDesk update(HelpDesk helpDesk) {
        return this.staffRepository.update(helpDesk);
    }

    @Override
    public void delete(String staffId) {
        this.staffRepository.delete(staffId);
    }

    @Override
    public Set<HelpDesk> getAll() { return this.staffRepository.getAll();
    }
}
